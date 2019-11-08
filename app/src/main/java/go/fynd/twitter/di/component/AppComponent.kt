package go.fynd.twitter.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import go.fynd.twitter.App
import go.fynd.twitter.di.builder.ActivityBuilder
import go.fynd.twitter.di.module.AppModule
import go.fynd.twitter.di.module.NetworkModule

import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class,NetworkModule::class])
interface AppComponent {
    fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponent
    }
}
