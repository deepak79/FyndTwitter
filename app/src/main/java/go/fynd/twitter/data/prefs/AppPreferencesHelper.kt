package go.fynd.twitter.data.prefs

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import go.fynd.twitter.di.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@SuppressLint("ApplySharedPref")
class AppPreferencesHelper @Inject
constructor(context: Context, @PreferenceInfo prefFileName: String) : PrefsHelper {

    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun setConsumerKey(token: String) {
        mPrefs.edit().putString(PREF_KEY_CONSUMER_KEY, token).commit()
    }

    override fun getConsumerKey(): String {
        return mPrefs.getString(PREF_KEY_CONSUMER_KEY, "")!!
    }

    override fun setConsumerSecret(secretKey: String) {
        mPrefs.edit().putString(PREF_KEY_CONSUMER_SECRET, secretKey).commit()
    }

    override fun getConsumerSecret(): String {
        return mPrefs.getString(PREF_KEY_CONSUMER_SECRET, "")!!
    }

    override fun setUserAccessToken(token: String) {
        mPrefs.edit().putString(PREF_KEY_USER_ACCESS_TOKEN, token).commit()
    }

    override fun getUserAccessToken(): String {
        return mPrefs.getString(PREF_KEY_USER_ACCESS_TOKEN, "")!!
    }

    override fun setUserSecretKey(secretKey: String) {
        mPrefs.edit().putString(PREF_KEY_USER_SECRET_KEY, secretKey).commit()
    }

    override fun getUserSecretKey(): String {
        return mPrefs.getString(PREF_KEY_USER_SECRET_KEY, "")!!
    }

    companion object {
        val PREF_KEY_ISLOGGEDIN= "ISLOGGEDIN"
        val PREF_KEY_USER_ACCESS_TOKEN = "USER_ACCESS_TOKEN"
        val PREF_KEY_USER_SECRET_KEY = "USER_SECRET_KEY"
        val PREF_KEY_CONSUMER_KEY = "CONSUMER_KEY"
        val PREF_KEY_CONSUMER_SECRET= "CONSUMER_SECRET"
    }
}