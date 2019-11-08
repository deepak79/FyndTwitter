package go.fynd.twitter.data.remote

import go.fynd.twitter.BuildConfig.BASE_URL

class ApiEndPoint {
    companion object {
        val OK = 200
        val ENDPOINT_GET_ALL_USERS = BASE_URL + "users"
    }
}
