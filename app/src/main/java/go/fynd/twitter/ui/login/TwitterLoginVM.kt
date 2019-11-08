package go.fynd.twitter.ui.login

import go.fynd.twitter.data.DataManager
import go.fynd.twitter.ui.base.BaseViewModel
import go.fynd.twitter.utils.rx.SchedulerProvider


class TwitterLoginVM(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<TwitterLoginNavigator>(dataManager, schedulerProvider) {
}
