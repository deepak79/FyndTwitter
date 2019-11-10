package go.fynd.twitter.data.remote

import go.fynd.twitter.BuildConfig
import go.fynd.twitter.model.tweet.TweetsBean
import go.fynd.twitter.utils.CustomInterceptor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {
    @GET("/1.1/statuses/home_timeline.json")
    fun getTweets(
        @Query("page") page: String
        , @Query("count") count: String
    ): Single<List<TweetsBean>>

    companion object {
        fun create(): ApiHelper {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(CustomInterceptor.mSingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client)
                .build()
            return retrofit.create(ApiHelper::class.java)
        }
    }
}