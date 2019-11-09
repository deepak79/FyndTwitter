package go.fynd.twitter.data.remote

import go.fynd.twitter.model.TweetBean
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiHelper {
    @GET("/1.1/statuses/home_timeline.json")
    fun getTweets(): Single<List<TweetBean>>
}