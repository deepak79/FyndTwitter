package go.fynd.twitter.data

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import go.fynd.twitter.data.local.db.DbHelper
import go.fynd.twitter.data.remote.ApiHelper
import go.fynd.twitter.model.UserBean
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(
    private val mDbHelper: DbHelper,
    private val mApiHelper: ApiHelper
) : DataManager {

    override fun getAllUsers(): Maybe<List<UserBean>> {
        return mDbHelper.getAllUsers()
    }

    override fun deleteUser(userBean: UserBean): Completable {
        return mDbHelper.deleteUser(userBean)
    }

    override fun addUsers(listUserBean: List<UserBean>): Completable {
        return mDbHelper.addUsers(listUserBean)
    }

    override fun getAllUsersNW(): Single<List<UserBean>> {
        return mApiHelper.getAllUsersNW()
    }

    override fun addUser(mUserBean: UserBean): Completable {
        return mDbHelper.addUser(mUserBean)
    }
}
