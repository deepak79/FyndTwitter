package go.fynd.twitter.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import go.fynd.twitter.model.UserBean
import twitter4j.User

object Converter {
    @TypeConverter
    @JvmStatic
    fun stringToJSON(value: String): JSONObject {
        return Gson().fromJson(value, object : TypeToken<JSONObject>() {

        }.type)
    }

    @TypeConverter
    @JvmStatic
    fun JSONToString(list: JSONObject): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    @JvmStatic
    fun stringToUserBean(json: String): UserBean {
        val gson = Gson()
        val type = object : TypeToken<UserBean>() {

        }.type
        return gson.fromJson<UserBean>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun userBeanToString(list: UserBean): String {
        val gson = Gson()
        val type = object : TypeToken<UserBean>() {

        }.type
        return gson.toJson(list, type)
    }
}

