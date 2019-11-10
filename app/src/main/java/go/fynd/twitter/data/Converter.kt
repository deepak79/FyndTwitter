package go.fynd.twitter.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import go.fynd.twitter.model.UserBean
import go.fynd.twitter.model.tweet.TweetsBean
import go.fynd.twitter.model.tweet.User

object Converter {

    @TypeConverter
    @JvmStatic
    fun UserToString(list: User?): String? {
        val gson = Gson()
        val type = object : TypeToken<User?>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToUser(json: String?): User? {
        val gson = Gson()
        val type = object : TypeToken<User?>() {

        }.type
        return gson.fromJson<User?>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToUserBean(json: String?): UserBean {
        val gson = Gson()
        val type = object : TypeToken<UserBean>() {

        }.type
        return gson.fromJson<UserBean>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun userBeanToString(list: UserBean): String? {
        val gson = Gson()
        val type = object : TypeToken<UserBean>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListTweets(json: String?): List<TweetsBean>? {
        val gson = Gson()
        val type = object : TypeToken<List<TweetsBean>?>() {

        }.type
        return gson.fromJson<List<TweetsBean>?>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun listTweetsToString(list: List<TweetsBean>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<TweetsBean>?>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun anyToString(list: Any?): String? {
        val gson = Gson()
        val type = object : TypeToken<Any?>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToAny(json: String?): Any? {
        val gson = Gson()
        val type = object : TypeToken<Any?>() {

        }.type
        return gson.fromJson<Any?>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun ListanyToString(list: List<Any>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<Any?>?>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListAny(json: String?): List<Any?>? {
        val gson = Gson()
        val type = object : TypeToken<List<Any?>?>() {

        }.type
        return gson.fromJson<List<Any?>?>(json, type)
    }
}

