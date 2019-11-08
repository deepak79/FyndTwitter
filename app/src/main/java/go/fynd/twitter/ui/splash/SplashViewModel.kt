package go.fynd.twitter.ui.splash

import go.fynd.twitter.data.DataManager
import go.fynd.twitter.ui.base.BaseViewModel
import go.fynd.twitter.utils.rx.SchedulerProvider


class SplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<SplashNavigator>(dataManager, schedulerProvider) {

    private fun handleError(error: String) {
        setIsLoading(false)
        navigator.onHandleError(error)
    }
}
