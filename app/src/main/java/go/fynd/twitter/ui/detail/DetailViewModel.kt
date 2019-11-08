package go.fynd.twitter.ui.detail

import go.fynd.twitter.data.DataManager
import go.fynd.twitter.model.UserBean
import go.fynd.twitter.ui.base.BaseViewModel
import go.fynd.twitter.utils.rx.SchedulerProvider


class DetailViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<DetailNavigator>(dataManager, schedulerProvider) {

    private fun handleError(error: Throwable?) {
        setIsLoading(false)
        navigator.onHandleError(error?.message!!)
    }

    fun onDeleteClicked(){
        navigator.onDeleteClicked()
    }

    fun deleteUser(mUserBean: UserBean){
        setIsLoading(true)
        compositeDisposable.add(
            dataManager.deleteUser(mUserBean)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    setIsLoading(false)
                    navigator.onHandleError("User has been deleted successfully!")
                    navigator.onDeleted()
                }, { throwable ->
                    navigator.onHandleError("Failed to delete user!!")
                })
        )
    }
}
