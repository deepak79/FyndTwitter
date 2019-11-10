package go.fynd.twitter.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import go.fynd.twitter.model.tweet.TweetsBean
import io.reactivex.Maybe

@Dao
interface TweetsDao {
    @Query("SELECT * FROM TweetsBean")
    fun getAllLocalTweets(): Maybe<List<TweetsBean>>

    @Insert
    fun addTweets(list: List<TweetsBean>)

    @Delete
    fun deleteLocalTweets(list: List<TweetsBean>)

    @Query("DELETE FROM TweetsBean")
    fun nukeTable()
}