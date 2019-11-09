package go.fynd.twitter.ui.home

import androidx.lifecycle.MutableLiveData
import go.fynd.twitter.data.DataManager
import go.fynd.twitter.data.remote.ApiHelper
import go.fynd.twitter.model.TweetBean
import go.fynd.twitter.ui.base.BaseViewModel
import go.fynd.twitter.utils.rx.SchedulerProvider


class HomeVM(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<HomeNavigator>(dataManager, schedulerProvider) {

    var mListTweetBeanLiveData: MutableLiveData<List<TweetBean>> = MutableLiveData()

    fun getTweets() {
        setIsLoading(true)
        compositeDisposable.add(
            ApiHelper.create().getTweets()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnEvent { data, throwable ->
                    if (data == null && throwable == null) {
                        setIsLoading(false)
                        mListTweetBeanLiveData.postValue(null)
                    }
                }
                .subscribe({ tweets ->
                    setIsLoading(false)
                    if (tweets != null) {
                        mListTweetBeanLiveData.postValue(tweets)
                    } else {
                        mListTweetBeanLiveData.postValue(null)
                    }
                }, { throwable ->
                    navigator.onHandleError(throwable.message!!)
                })
        )
    }
}
