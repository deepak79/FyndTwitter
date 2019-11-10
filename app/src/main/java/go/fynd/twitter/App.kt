package go.fynd.twitter

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import go.fynd.twitter.di.component.DaggerAppComponent
import javax.inject.Inject


class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        Fresco.initialize(this)
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

}
