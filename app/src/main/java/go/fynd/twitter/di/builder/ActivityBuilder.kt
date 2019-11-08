package go.fynd.twitter.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import go.fynd.twitter.ui.detail.DetailActivity
import go.fynd.twitter.ui.login.TwitterLoginActivity
import go.fynd.twitter.ui.main.adapter.UserModule
import go.fynd.twitter.ui.main.MainActivity
import go.fynd.twitter.ui.splash.SplashActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector
    abstract fun bindTwitterLoginActivity(): TwitterLoginActivity
}
