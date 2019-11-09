package go.fynd.twitter.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import go.fynd.twitter.model.UserBean
import io.reactivex.Maybe

@Dao
interface UsersDao {
    @Query("SELECT * FROM UserBean")
    fun getLoggedInUser(): Maybe<UserBean>

    @Insert
    fun addUser(user: UserBean)

    @Delete
    fun deleteLoggedInUser(user: UserBean)

    @Query("DELETE FROM UserBean")
    fun nukeTable()
}