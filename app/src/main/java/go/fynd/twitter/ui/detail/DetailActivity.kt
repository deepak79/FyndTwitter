package go.fynd.twitter.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import go.fynd.twitter.BR
import go.fynd.twitter.R
import go.fynd.twitter.ViewModelProviderFactory
import go.fynd.twitter.databinding.ActivityDetailBinding
import go.fynd.twitter.model.UserBean
import go.fynd.twitter.ui.base.BaseActivity
import go.fynd.twitter.utils.CommonUtils
import javax.inject.Inject


class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>(), DetailNavigator,
    HasSupportFragmentInjector {

    override val viewModel: DetailViewModel
        get() = ViewModelProviders.of(this, factory).get(DetailViewModel::class.java)
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var binding: ActivityDetailBinding? = null
    lateinit var mUserBean: UserBean
    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = viewDataBinding
        viewModel.navigator = this
        if (intent?.getParcelableExtra<UserBean>("data") != null) {
            mUserBean = intent?.getParcelableExtra<UserBean>("data")!!
            setUp()
        } else {
            onHandleError("Failed to get data!!")
            finish()
        }
    }

    fun setUp() {
        Picasso.get()
            .load(mUserBean.avatarUrl)
            .placeholder(R.drawable.ic_github)
            .into(binding?.imgUser)
        binding?.tvUserName?.text = mUserBean.login
    }

    override fun onHandleError(error: String) {
        CommonUtils.makeText(this, error)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    override fun onDelete(mUserBean: UserBean) {
        viewModel.deleteUser(mUserBean)
    }

    override fun onDeleteClicked() {
        onDelete(mUserBean)
    }

    override fun onDeleted() {
        finish()
    }
}
