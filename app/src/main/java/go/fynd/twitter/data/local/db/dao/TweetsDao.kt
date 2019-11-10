package go.fynd.twitter.data.local.db.dao

import androidx.room.*
import go.fynd.twitter.model.tweet.TweetsBean
import io.reactivex.Maybe

@Dao
interface TweetsDao {
    @Query("SELECT * FROM TweetsBean")
    fun getAllLocalTweets(): Maybe<MutableList<TweetsBean>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTweets(list: MutableList<TweetsBean>?)

    @Delete
    fun deleteLocalTweets(list: MutableList<TweetsBean>?)

    @Query("DELETE FROM TweetsBean")
    fun nukeTable()
}