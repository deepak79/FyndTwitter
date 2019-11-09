package go.fynd.twitter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import go.fynd.twitter.data.DataManager
import go.fynd.twitter.ui.home.HomeVM
import go.fynd.twitter.ui.login.TwitterLoginVM
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
            modelClass.isAssignableFrom(TwitterLoginVM::class.java) -> TwitterLoginVM(
                dataManager,
                schedulerProvider
            ) as T
            modelClass.isAssignableFrom(HomeVM::class.java) -> HomeVM(
                dataManager,
                schedulerProvider
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}