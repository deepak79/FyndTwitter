package go.fynd.twitter.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Maybe
import go.fynd.twitter.model.UserBean

@Dao
interface UsersDao {
    @Query("SELECT * FROM UserBean")
    fun getAllUsers(): Maybe<List<UserBean>>

    @Insert
    fun addUsers(users: List<UserBean>)

    @Insert
    fun addUser(user: UserBean)

    @Delete
    fun deleteUser(user :UserBean)

    @Query("DELETE FROM UserBean")
    fun nukeTable()
}