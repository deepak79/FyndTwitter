package go.fynd.twitter.data.remote

import io.reactivex.Single
import go.fynd.twitter.model.UserBean
import retrofit2.http.GET

interface ApiHelper {
    @GET("/users")
    fun getAllUsersNW(): Single<List<UserBean>>
}