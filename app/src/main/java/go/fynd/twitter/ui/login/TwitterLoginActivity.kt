package go.fynd.twitter.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import go.fynd.twitter.BR
import go.fynd.twitter.R
import go.fynd.twitter.ViewModelProviderFactory
import go.fynd.twitter.databinding.ActivityTwitterLoginBinding
import go.fynd.twitter.model.UserBean
import go.fynd.twitter.ui.base.BaseActivity
import go.fynd.twitter.ui.home.HomeActivity
import go.fynd.twitter.ui.webview.TwitterWebViewActivity
import go.fynd.twitter.utils.AppConstants.Companion.PERMISSIONS
import go.fynd.twitter.utils.CommonUtils
import go.fynd.twitter.utils.CustomInterceptor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken
import twitter4j.auth.RequestToken
import twitter4j.conf.ConfigurationBuilder
import javax.inject.Inject


class TwitterLoginActivity : BaseActivity<ActivityTwitterLoginBinding, TwitterLoginVM>(),
    TwitterLoginNavigator,
    HasSupportFragmentInjector,
    MultiplePermissionsListener, View.OnClickListener {


    override val viewModel: TwitterLoginVM
        get() = ViewModelProviders.of(this, factory).get(TwitterLoginVM::class.java)
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var binding: ActivityTwitterLoginBinding? = null
    private lateinit var TWITTER_CONSUMER_KEY: String
    private lateinit var TWITTER_CONSUMER_SECRET: String
    private lateinit var TWITTER_CALLBACK_URL: String
    private lateinit var URL_TWITTER_OAUTH_VERIFIER: String
    private lateinit var mTwitter: Twitter
    private lateinit var mRequestToken: RequestToken
    private val WEBVIEW_REQUEST_CODE = 10000
    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_twitter_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewDataBinding
        viewModel.navigator = this
        checkPermissions(PERMISSIONS)
        init()
        setListeners()
        observeIsLoggedIn()
        Handler().postDelayed({
            viewModel.getLoggedInUser()
        }, 1500)
        supportActionBar?.hide()
    }

    private fun setListeners() {
        binding!!.btnLogin.setOnClickListener(this)
    }

    private fun observeIsLoggedIn() {
        viewModel.mUserBeanLiveData.observe(this, Observer {
            if (it != null) {
                CustomInterceptor.setSignInterceptor(
                    TWITTER_CONSUMER_KEY,
                    TWITTER_CONSUMER_SECRET,
                    it.mAccessToken!!,
                    it.mSecretKey!!
                )
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                showHideSplash(false)
                showMessage("Please login to continue")
            }
        })
    }

    private fun showHideSplash(shouldShow: Boolean) {
        if (shouldShow) {
            binding!!.gpLogin.visibility = GONE
            binding!!.gpSplash.visibility = VISIBLE
        } else {
            binding!!.gpLogin.visibility = VISIBLE
            binding!!.gpSplash.visibility = GONE
        }
    }

    override fun onHandleError(error: String) {
        CommonUtils.makeText(this, error)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    private fun checkPermissions(permissions: Array<String>) {
        Dexter.withActivity(this)
            .withPermissions(*permissions)
            .withListener(this)
            .check()
    }

    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
        if (!report.areAllPermissionsGranted()) {
            onHandleError(resources.getString(R.string.permission))
            finish()
        }
    }

    override fun onPermissionRationaleShouldBeShown(
        permissions: List<PermissionRequest>,
        token: PermissionToken
    ) {
        checkPermissions(PERMISSIONS)
        onHandleError(resources.getString(R.string.permission))
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_login -> {
                if(isNetworkConnected){
                    showHideSplash(true)
                    doTwitterLogin()
                }else{
                    showMessage(getString(R.string.nointernet))
                }
            }
        }
    }

    private fun init() {
        TWITTER_CONSUMER_KEY = getString(R.string.twitter_api_key)
        TWITTER_CONSUMER_SECRET = getString(R.string.twitter_api_secret)
        TWITTER_CALLBACK_URL = getString(R.string.twitter_callback)
        URL_TWITTER_OAUTH_VERIFIER = getString(R.string.twitter_oauth_verifier)
        viewModel.init(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET)
    }

    private fun initTwitter(): Twitter {
        if (!this::mTwitter.isInitialized) {
            val builder = ConfigurationBuilder()
            builder.setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
            builder.setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
            val configuration = builder.build()
            val factory = TwitterFactory(configuration)
            mTwitter = factory.instance
        }
        return mTwitter
    }

    private fun doTwitterLogin() {
        GlobalScope.launch(Dispatchers.Main) {
            val ops = async(Dispatchers.IO) { initTwitter() }
            makeLogin(ops.await())
        }
    }

    private fun getAccessToken(verifier: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val accessToken = async(Dispatchers.IO) { getOAuthAccessToken(verifier) }
            showData(accessToken.await())
        }
    }

    private fun getOAuthAccessToken(verifier: String): AccessToken {
        return mTwitter.getOAuthAccessToken(mRequestToken, verifier)
    }

    private fun makeLogin(mTwitter: Twitter) {
        try {
            mRequestToken = mTwitter.getOAuthRequestToken(TWITTER_CALLBACK_URL)
            val intent = Intent(this, TwitterWebViewActivity::class.java)
            intent.putExtra(TwitterWebViewActivity.EXTRA_URL, mRequestToken.authenticationURL)
            startActivityForResult(intent, WEBVIEW_REQUEST_CODE)
        } catch (e: Exception) {
            showMessage(e.message)
        }
    }

    private fun showData(accessToken: AccessToken) {
        try {
            val user = mTwitter.showUser(mTwitter.id)
            CustomInterceptor.setSignInterceptor(
                TWITTER_CONSUMER_KEY,
                TWITTER_CONSUMER_SECRET,
                accessToken.token,
                accessToken.tokenSecret
            )
            viewModel.addUser(
                UserBean(
                    mUserId = user.id.toString(),
                    mAccessToken = accessToken.token,
                    mSecretKey = accessToken.tokenSecret,
                    mName = user.name,
                    mScreenName = user.screenName,
                    mEmail = user.email,
                    mProfileImage = user.profileImageURL,
                    mFollowersCount = user.followersCount
                )
            )
        } catch (e: Exception) {
            showMessage(e.message)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == WEBVIEW_REQUEST_CODE) {
            showHideSplash(false)
            try {
                if (data != null && data.extras != null && data.hasExtra(URL_TWITTER_OAUTH_VERIFIER)) {
                    getAccessToken(data.extras?.getString(URL_TWITTER_OAUTH_VERIFIER)!!)
                }
            } catch (
                e: java.lang.Exception
            ) {
                showMessage(e.message)
            }
        }
    }
}



