package go.fynd.twitter.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import go.fynd.twitter.BR
import go.fynd.twitter.R
import go.fynd.twitter.ViewModelProviderFactory
import go.fynd.twitter.databinding.ActivityHomeBinding
import go.fynd.twitter.ui.base.BaseActivity
import go.fynd.twitter.utils.CommonUtils
import javax.inject.Inject


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeVM>(),
    HomeNavigator,
    HasSupportFragmentInjector,
    View.OnClickListener {


    override val viewModel: HomeVM
        get() = ViewModelProviders.of(this, factory).get(HomeVM::class.java)
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var binding: ActivityHomeBinding? = null
    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_home
    private var PAGE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewDataBinding
        viewModel.navigator = this
        supportActionBar?.hide()
        setListeners()
        observeTweets()
        viewModel.getTweets(PAGE)
    }

    private fun setListeners() {
        //binding!!.btnLogin.setOnClickListener(this)
    }

    private fun observeTweets() {
        viewModel.mListTweetBeanLiveData.observe(this, Observer {
            if (it != null) {
                for (i in 0 until it.size) {
                    Log.e("@@@@", it[i].text)
                }
            } else {
                showMessage("Please login to continue")
            }
        })
    }

    override fun onHandleError(error: String) {
        CommonUtils.makeText(this, error)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_login -> {

            }
        }
    }
}