package go.fynd.twitter.data.local.db

import io.reactivex.Completable
import io.reactivex.Maybe
import go.fynd.twitter.model.UserBean

interface DbHelper {
    fun getAllUsers(): Maybe<List<UserBean>>

    fun deleteUser(userBean: UserBean): Completable

    fun addUsers(listUserBean: List<UserBean>): Completable

    fun addUser(mUserBean: UserBean): Completable
}