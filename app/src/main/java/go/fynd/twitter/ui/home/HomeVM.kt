package go.fynd.twitter.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import go.fynd.twitter.data.DataManager
import go.fynd.twitter.data.remote.ApiHelper
import go.fynd.twitter.model.tweet.TweetsBean
import go.fynd.twitter.ui.base.BaseViewModel
import go.fynd.twitter.utils.AppConstants.Companion.MAX_COUNT
import go.fynd.twitter.utils.rx.SchedulerProvider


class HomeVM(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<HomeNavigator>(dataManager, schedulerProvider) {

    var mListTweetBeanLiveData: MutableLiveData<MutableList<TweetsBean>?> = MutableLiveData()
    var mLocalListTweetBeanLiveData: MutableLiveData<MutableList<TweetsBean>?> = MutableLiveData()

    fun getTweets(nextPage: Int, isDataAvailable: Boolean) {
        setIsLoading(true)
        if (isDataAvailable) {
            compositeDisposable.add(
                ApiHelper.create().getTweets(nextPage.toString(), MAX_COUNT)
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
        } else {
            compositeDisposable.add(
                dataManager.getAllLocalTweets()
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .doOnEvent { data, throwable ->
                        if (data == null && throwable == null) {
                            setIsLoading(false)
                            mLocalListTweetBeanLiveData.postValue(null)
                        }
                    }
                    .subscribe({ tweets ->
                        setIsLoading(false)
                        if (tweets != null) {
                            mLocalListTweetBeanLiveData.postValue(tweets)
                        } else {
                            mLocalListTweetBeanLiveData.postValue(null)
                        }
                    }, { throwable ->
                        navigator.onHandleError(throwable.message!!)
                    })
            )
        }
    }

    fun addTweets(list: MutableList<TweetsBean>?) {
        setIsLoading(true)
        compositeDisposable.add(
            dataManager.addTweets(list)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    setIsLoading(false)
                }, { throwable ->
                    Log.e("@@@", "" + throwable.message)
                    navigator.onHandleError(throwable.message!!)
                })
        )
    }
}
