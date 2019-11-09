package go.fynd.twitter.data.local.db

import io.reactivex.Completable
import io.reactivex.Maybe
import go.fynd.twitter.model.UserBean
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
}