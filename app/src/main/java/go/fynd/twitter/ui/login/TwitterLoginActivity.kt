package go.fynd.twitter.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.internal.TwitterApi
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import go.fynd.twitter.BR
import go.fynd.twitter.R
import go.fynd.twitter.ViewModelProviderFactory
import go.fynd.twitter.databinding.ActivityTwitterLoginBinding
import go.fynd.twitter.ui.base.BaseActivity
import go.fynd.twitter.utils.AppConstants.Companion.PERMISSIONS
import go.fynd.twitter.utils.CommonUtils
import javax.inject.Inject


class TwitterLoginActivity : BaseActivity<ActivityTwitterLoginBinding, TwitterLoginVM>(),
    TwitterLoginNavigator,
    HasSupportFragmentInjector,
    MultiplePermissionsListener {

    override val viewModel: TwitterLoginVM
        get() = ViewModelProviders.of(this, factory).get(TwitterLoginVM::class.java)
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var binding: ActivityTwitterLoginBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_twitter_login


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewDataBinding
        viewModel.navigator = this
        checkPermissions(PERMISSIONS)

        Handler().postDelayed({
            binding!!.gpLogin.visibility = VISIBLE
            binding!!.gpSplash.visibility = GONE
        },1000)
        supportActionBar?.hide()
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
}
