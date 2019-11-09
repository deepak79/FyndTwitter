package go.fynd.twitter.data.local.db

import io.reactivex.Completable
import io.reactivex.Maybe
import go.fynd.twitter.model.UserBean

interface DbHelper {
    fun getLoggedInUser(): Maybe<UserBean>

    fun deleteLoggedInUser(userBean: UserBean): Completable

    fun addUser(mUserBean: UserBean): Completable
}