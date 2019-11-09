package go.fynd.twitter.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import go.fynd.twitter.ui.home.HomeActivity
import go.fynd.twitter.ui.login.TwitterLoginActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindTwitterLoginActivity(): TwitterLoginActivity

    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity
}
