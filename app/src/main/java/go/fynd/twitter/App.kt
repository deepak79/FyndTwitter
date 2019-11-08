package go.fynd.twitter

import android.app.Activity
import android.app.Application
import android.util.Log
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import go.fynd.twitter.di.component.DaggerAppComponent
import go.fynd.twitter.di.module.NetworkModule
import javax.inject.Inject


class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        initializeTwitter()
        DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule)
            .build()
            .inject(this)
    }

    private fun initializeTwitter() {
        val config = TwitterConfig.Builder(this)
            .logger(DefaultLogger(Log.DEBUG))
            .twitterAuthConfig(
                TwitterAuthConfig(
                    getString(R.string.twitter_api_key),
                    getString(R.string.twitter_api_secret)
                )
            )
            .debug(true)
            .build()
        Twitter.initialize(config)
    }
}
