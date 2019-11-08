package go.fynd.twitter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import go.fynd.twitter.data.DataManager
import go.fynd.twitter.ui.detail.DetailViewModel
import go.fynd.twitter.ui.login.TwitterLoginVM
import go.fynd.twitter.ui.main.MainViewModel
import go.fynd.twitter.ui.splash.SplashViewModel
import go.fynd.twitter.utils.rx.SchedulerProvider

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject
constructor(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return when {
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(
                dataManager,
                schedulerProvider
            ) as T
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(
                dataManager,
                schedulerProvider
            ) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(
                dataManager,
                schedulerProvider
            ) as T
            modelClass.isAssignableFrom(TwitterLoginVM::class.java) -> TwitterLoginVM(
                dataManager,
                schedulerProvider
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}