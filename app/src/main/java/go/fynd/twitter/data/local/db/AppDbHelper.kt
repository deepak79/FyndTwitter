package go.fynd.twitter.data.local.db

import go.fynd.twitter.model.UserBean
import go.fynd.twitter.model.tweet.TweetsBean
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject
constructor(
    val mAppDatabase: AppDatabase
) : DbHelper {

    override fun getLoggedInUser(): Maybe<UserBean> {
        return mAppDatabase.usersDao().getLoggedInUser()
    }

    override fun deleteLoggedInUser(userBean: UserBean): Completable {
        return Completable.fromAction { mAppDatabase.usersDao().deleteLoggedInUser(userBean) }
    }

    override fun addUser(mUserBean: UserBean): Completable {
        return Completable.fromAction { mAppDatabase.usersDao().addUser(mUserBean) }
    }

    override fun getAllLocalTweets(): Maybe<List<TweetsBean>> {
        return mAppDatabase.tweetsDao().getAllLocalTweets()
    }

    override fun addTweets(list: List<TweetsBean>): Completable {
        return Completable.fromAction { mAppDatabase.tweetsDao().addTweets(list) }
    }

    override fun deleteLocalTweets(list: List<TweetsBean>): Completable {
        return Completable.fromAction { mAppDatabase.tweetsDao().deleteLocalTweets(list) }
    }
}