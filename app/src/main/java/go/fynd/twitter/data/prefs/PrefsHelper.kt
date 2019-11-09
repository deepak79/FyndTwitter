package go.fynd.twitter.data.prefs

interface PrefsHelper {
    fun setConsumerKey(token: String)
    fun getConsumerKey(): String
    fun setConsumerSecret(secretKey: String)
    fun getConsumerSecret(): String
    fun setUserAccessToken(token: String)
    fun getUserAccessToken(): String
    fun setUserSecretKey(secretKey: String)
    fun getUserSecretKey(): String
}