package go.fynd.twitter.ui.login

import androidx.lifecycle.MutableLiveData
import go.fynd.twitter.data.DataManager
import go.fynd.twitter.model.TweetBean
import go.fynd.twitter.model.UserBean
import go.fynd.twitter.ui.base.BaseViewModel
import go.fynd.twitter.utils.rx.SchedulerProvider


class TwitterLoginVM(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<TwitterLoginNavigator>(dataManager, schedulerProvider) {

    var mUserBeanLiveData: MutableLiveData<UserBean> = MutableLiveData()
    var mListTweetBeanLiveData: MutableLiveData<List<TweetBean>> = MutableLiveData()

    fun init(consumerKey: String, consumerSecret: String) {
        dataManager.setConsumerKey(consumerKey)
        dataManager.setConsumerSecret(consumerSecret)
    }

    fun addUser(userBean: UserBean) {
        setIsLoading(true)
        compositeDisposable.add(
            dataManager.addUser(userBean)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    setIsLoading(false)
                    getLoggedInUser()
                }, { throwable ->
                    navigator.onHandleError(throwable.message!!)
                })
        )
    }

    fun getLoggedInUser() {
        setIsLoading(true)
        compositeDisposable.add(
            dataManager.getLoggedInUser()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnEvent { data, throwable ->
                    if (data == null && throwable == null) {
                        setIsLoading(false)
                        mUserBeanLiveData.postValue(null)
                    }
                }
                .subscribe({ user ->
                    setIsLoading(false)
                    if (user != null) {
                        dataManager.setUserAccessToken(user.mAccessToken!!)
                        dataManager.setUserSecretKey(user.mSecretKey!!)
                        mUserBeanLiveData.postValue(user)
                        navigator.onHandleError("You have been successfully logged in!")
                    } else {
                        mUserBeanLiveData.postValue(null)
                    }
                }, { throwable ->
                    navigator.onHandleError(throwable.message!!)
                })
        )
    }

    fun getTweets() {
        setIsLoading(true)
        compositeDisposable.add(
            dataManager.getTweets()
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
