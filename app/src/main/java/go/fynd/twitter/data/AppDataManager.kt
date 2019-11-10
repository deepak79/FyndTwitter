package go.fynd.twitter.data

import go.fynd.twitter.data.local.db.DbHelper
import go.fynd.twitter.data.prefs.PrefsHelper
import go.fynd.twitter.model.UserBean
import go.fynd.twitter.model.tweet.TweetsBean
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(
    private val mDbHelper: DbHelper,
    private val mPrefsHelper: PrefsHelper
) : DataManager {

    override fun getLoggedInUser(): Maybe<UserBean> {
        return mDbHelper.getLoggedInUser()
    }

    override fun deleteLoggedInUser(userBean: UserBean): Completable {
        return mDbHelper.deleteLoggedInUser(userBean)
    }

    override fun addUser(mUserBean: UserBean): Completable {
        return mDbHelper.addUser(mUserBean)
    }

    override fun setConsumerKey(token: String) {
        mPrefsHelper.setConsumerKey(token)
    }

    override fun getConsumerKey(): String {
        return mPrefsHelper.getConsumerKey()
    }

    override fun setConsumerSecret(secretKey: String) {
        mPrefsHelper.setConsumerSecret(secretKey)
    }

    override fun getConsumerSecret(): String {
        return mPrefsHelper.getConsumerSecret()
    }

    override fun setUserAccessToken(token: String) {
        mPrefsHelper.setUserAccessToken(token)
    }

    override fun getUserAccessToken(): String {
        return mPrefsHelper.getUserAccessToken()
    }

    override fun setUserSecretKey(secretKey: String) {
        mPrefsHelper.setUserSecretKey(secretKey)
    }

    override fun getUserSecretKey(): String {
        return mPrefsHelper.getUserSecretKey()
    }

    override fun getAllLocalTweets(): Maybe<MutableList<TweetsBean>?> {
        return mDbHelper.getAllLocalTweets()
    }

    override fun addTweets(list: MutableList<TweetsBean>?): Completable {
        return mDbHelper.addTweets(list)
    }

    override fun deleteLocalTweets(list: MutableList<TweetsBean>): Completable {
        return mDbHelper.deleteLocalTweets(list)
    }
}
