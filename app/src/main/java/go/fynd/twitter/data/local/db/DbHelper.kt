package go.fynd.twitter.data.local.db

import go.fynd.twitter.model.UserBean
import go.fynd.twitter.model.tweet.TweetsBean
import io.reactivex.Completable
import io.reactivex.Maybe

interface DbHelper {
    fun getLoggedInUser(): Maybe<UserBean>

    fun deleteLoggedInUser(userBean: UserBean): Completable

    fun addUser(mUserBean: UserBean): Completable

    fun getAllLocalTweets(): Maybe<MutableList<TweetsBean>?>

    fun addTweets(list: MutableList<TweetsBean>?):Completable

    fun deleteLocalTweets(list: MutableList<TweetsBean>):Completable
}