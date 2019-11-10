package go.fynd.twitter.ui.home

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import go.fynd.twitter.BR
import go.fynd.twitter.R
import go.fynd.twitter.ViewModelProviderFactory
import go.fynd.twitter.databinding.ActivityHomeBinding
import go.fynd.twitter.ui.base.BaseActivity
import go.fynd.twitter.ui.home.adapter.TimeLineAdapter
import go.fynd.twitter.utils.CommonUtils
import go.fynd.twitter.utils.PaginationListener
import go.fynd.twitter.utils.setDivider
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
    private var isDataLoading = false
    lateinit var mTimeLineAdapter: TimeLineAdapter
    lateinit var toolbar :Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewDataBinding
        viewModel.navigator = this
        supportActionBar?.hide()
        binding = viewDataBinding
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        observeTweets()
        observeLocalTweets()
        setRecyclerview()
        viewModel.getTweets(PAGE, isNetworkConnected)
        mTimeLineAdapter.addLoading()
    }

    fun setRecyclerview() {
        val layoutManager = LinearLayoutManager(this)
        mTimeLineAdapter = TimeLineAdapter(mutableListOf())
        binding!!.rvTimeline.setHasFixedSize(true)
        binding!!.rvTimeline.layoutManager = layoutManager
        binding!!.rvTimeline.addOnScrollListener(object :
            PaginationListener(layoutManager) {
            override val isLoading: Boolean
                get() = isDataLoading

            override fun loadMoreItems() {
                PAGE += 1
                viewModel.getTweets(PAGE, isNetworkConnected)
            }
        })
        binding!!.rvTimeline.setDivider(R.drawable.recyclerview_divider)
        binding!!.rvTimeline.adapter = mTimeLineAdapter
    }

    private fun observeTweets() {
        viewModel.mListTweetBeanLiveData.observe(this, Observer {
            if (it != null) {
                viewModel.addTweets(it)
                binding!!.tvMesssage.visibility = GONE
                binding!!.rvTimeline.visibility = VISIBLE
                mTimeLineAdapter.addItems(it)
                isDataLoading = false
            } else {
                binding!!.tvMesssage.text = "No tweets to show"
                binding!!.tvMesssage.visibility = VISIBLE
                binding!!.rvTimeline.visibility = GONE
            }
        })
    }

    private fun observeLocalTweets() {
        viewModel.mLocalListTweetBeanLiveData.observe(this, Observer {
            if (it != null) {
                binding!!.tvMesssage.visibility = GONE
                binding!!.rvTimeline.visibility = VISIBLE
                mTimeLineAdapter.addAll(it)
                isDataLoading = false
            } else {
                binding!!.tvMesssage.text = "No tweets to show"
                binding!!.tvMesssage.visibility = VISIBLE
                binding!!.rvTimeline.visibility = GONE
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