package go.fynd.twitter.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import go.fynd.twitter.model.UserBean
import go.fynd.twitter.model.tweet.*

object Converter {
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

    @TypeConverter
    @JvmStatic
    fun stringToListTweets(json: String): List<TweetsBean> {
        val gson = Gson()
        val type = object : TypeToken<List<TweetsBean>>() {

        }.type
        return gson.fromJson<List<TweetsBean>>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun listTweetsToString(list: List<TweetsBean>): String {
        val gson = Gson()
        val type = object : TypeToken<List<TweetsBean>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToAll(json: String): All {
        val gson = Gson()
        val type = object : TypeToken<All>() {

        }.type
        return gson.fromJson<All>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun allToString(list: All): String {
        val gson = Gson()
        val type = object : TypeToken<All>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListAll(json: String): List<All> {
        val gson = Gson()
        val type = object : TypeToken<List<All>>() {

        }.type
        return gson.fromJson<List<All>>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun ListAllToString(list: List<All>): String {
        val gson = Gson()
        val type = object : TypeToken<List<All>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToDescription(json: String): Description {
        val gson = Gson()
        val type = object : TypeToken<Description>() {

        }.type
        return gson.fromJson<Description>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun descriptionToString(list: Description): String {
        val gson = Gson()
        val type = object : TypeToken<Description>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToDescriptionX(json: String): DescriptionX {
        val gson = Gson()
        val type = object : TypeToken<DescriptionX>() {

        }.type
        return gson.fromJson<DescriptionX>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun descriptionXToString(list: DescriptionX): String {
        val gson = Gson()
        val type = object : TypeToken<DescriptionX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToEntities(json: String): Entities {
        val gson = Gson()
        val type = object : TypeToken<Entities>() {

        }.type
        return gson.fromJson<Entities>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun EntitiesToString(list: Entities): String {
        val gson = Gson()
        val type = object : TypeToken<Entities>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToEntitiesX(json: String): EntitiesX {
        val gson = Gson()
        val type = object : TypeToken<EntitiesX>() {

        }.type
        return gson.fromJson<EntitiesX>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun EntitiesXToString(list: EntitiesX): String {
        val gson = Gson()
        val type = object : TypeToken<EntitiesX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToEntitiesXX(json: String): EntitiesXX {
        val gson = Gson()
        val type = object : TypeToken<EntitiesXX>() {

        }.type
        return gson.fromJson<EntitiesXX>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun EntitiesXXToString(list: EntitiesXX): String {
        val gson = Gson()
        val type = object : TypeToken<EntitiesXX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToEntitiesXXX(json: String): EntitiesXXX {
        val gson = Gson()
        val type = object : TypeToken<EntitiesXXX>() {

        }.type
        return gson.fromJson<EntitiesXXX>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun EntitiesXXXToString(list: EntitiesXXX): String {
        val gson = Gson()
        val type = object : TypeToken<EntitiesXXX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToExtendedEntities(json: String): ExtendedEntities {
        val gson = Gson()
        val type = object : TypeToken<ExtendedEntities>() {

        }.type
        return gson.fromJson<ExtendedEntities>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun ExtendedEntitiesToString(list: ExtendedEntities): String {
        val gson = Gson()
        val type = object : TypeToken<ExtendedEntities>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToFeatures(json: String): Features {
        val gson = Gson()
        val type = object : TypeToken<Features>() {

        }.type
        return gson.fromJson<Features>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun FeaturesToString(list: Features): String {
        val gson = Gson()
        val type = object : TypeToken<Features>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToHashtag(json: String): List<Hashtag> {
        val gson = Gson()
        val type = object : TypeToken<List<Hashtag>>() {

        }.type
        return gson.fromJson<List<Hashtag>>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun HashtagToString(list: List<Hashtag>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Hashtag>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToLarge(json: String): Large {
        val gson = Gson()
        val type = object : TypeToken<Large>() {

        }.type
        return gson.fromJson<Large>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun LargeToString(list: Large): String {
        val gson = Gson()
        val type = object : TypeToken<Large>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToLargeX(json: String): LargeX {
        val gson = Gson()
        val type = object : TypeToken<LargeX>() {

        }.type
        return gson.fromJson<LargeX>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun LargeXToString(list: LargeX): String {
        val gson = Gson()
        val type = object : TypeToken<LargeX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToMedia(json: String): List<Media> {
        val gson = Gson()
        val type = object : TypeToken<List<Media>>() {

        }.type
        return gson.fromJson<List<Media>>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun MediaToString(list: List<Media>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Media>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun MediumToString(list: Medium): String {
        val gson = Gson()
        val type = object : TypeToken<Medium>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToMedium(json: String): Medium {
        val gson = Gson()
        val type = object : TypeToken<Medium>() {

        }.type
        return gson.fromJson<Medium>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun MediumXToString(list: MediumX): String {
        val gson = Gson()
        val type = object : TypeToken<MediumX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToMediumX(json: String): MediumX {
        val gson = Gson()
        val type = object : TypeToken<MediumX>() {

        }.type
        return gson.fromJson<MediumX>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun OrigToString(list: Orig): String {
        val gson = Gson()
        val type = object : TypeToken<Orig>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToOrig(json: String): Orig {
        val gson = Gson()
        val type = object : TypeToken<Orig>() {

        }.type
        return gson.fromJson<Orig>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun QuotedStatusToString(list: QuotedStatus): String {
        val gson = Gson()
        val type = object : TypeToken<QuotedStatus>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToQuotedStatus(json: String): QuotedStatus {
        val gson = Gson()
        val type = object : TypeToken<QuotedStatus>() {

        }.type
        return gson.fromJson<QuotedStatus>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun SizesToString(list: Sizes): String {
        val gson = Gson()
        val type = object : TypeToken<Sizes>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToSizes(json: String): Sizes {
        val gson = Gson()
        val type = object : TypeToken<Sizes>() {

        }.type
        return gson.fromJson<Sizes>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun SmallToString(list: Small): String {
        val gson = Gson()
        val type = object : TypeToken<Small>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToSmall(json: String): Small {
        val gson = Gson()
        val type = object : TypeToken<Small>() {

        }.type
        return gson.fromJson<Small>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun SmallXToString(list: SmallX): String {
        val gson = Gson()
        val type = object : TypeToken<SmallX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToSmallX(json: String): SmallX {
        val gson = Gson()
        val type = object : TypeToken<SmallX>() {

        }.type
        return gson.fromJson<SmallX>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListTag(json: String): List<Tag> {
        val gson = Gson()
        val type = object : TypeToken<List<Tag>>() {

        }.type
        return gson.fromJson<List<Tag>>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun listTagToString(list: List<Tag>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Tag>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun ThumbToString(list: Thumb): String {
        val gson = Gson()
        val type = object : TypeToken<Thumb>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToThumb(json: String): Thumb {
        val gson = Gson()
        val type = object : TypeToken<Thumb>() {

        }.type
        return gson.fromJson<Thumb>(json, type)
    }

    @TypeConverter
    @JvmStatic
    fun ListUrlToString(list: List<Url>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Url>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListUrl(json: String): List<Url> {
        val gson = Gson()
        val type = object : TypeToken<List<Url>>() {

        }.type
        return gson.fromJson<List<Url>>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun UrlXToString(list: UrlX): String {
        val gson = Gson()
        val type = object : TypeToken<UrlX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToUrlX(json: String): UrlX {
        val gson = Gson()
        val type = object : TypeToken<UrlX>() {

        }.type
        return gson.fromJson<UrlX>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun ListUrlXXToString(list: List<UrlXX>): String {
        val gson = Gson()
        val type = object : TypeToken<List<UrlXX>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListUrlXX(json: String): List<UrlXX> {
        val gson = Gson()
        val type = object : TypeToken<List<UrlXX>>() {

        }.type
        return gson.fromJson<List<UrlXX>>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun ListUrlXXXToString(list: List<UrlXXX>): String {
        val gson = Gson()
        val type = object : TypeToken<List<UrlXXX>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListUrlXXX(json: String): List<UrlXXX> {
        val gson = Gson()
        val type = object : TypeToken<List<UrlXXX>>() {

        }.type
        return gson.fromJson<List<UrlXXX>>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun UrlXXXXToString(list: UrlXXXX): String {
        val gson = Gson()
        val type = object : TypeToken<UrlXXXX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToUrlXXXX(json: String): UrlXXXX {
        val gson = Gson()
        val type = object : TypeToken<UrlXXXX>() {

        }.type
        return gson.fromJson<UrlXXXX>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun ListUrlXXXXXToString(list: List<UrlXXXXX>): String {
        val gson = Gson()
        val type = object : TypeToken<List<UrlXXXXX>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListUrlXXXXX(json: String): List<UrlXXXXX> {
        val gson = Gson()
        val type = object : TypeToken<List<UrlXXXXX>>() {

        }.type
        return gson.fromJson<List<UrlXXXXX>>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun UserToString(list: User): String {
        val gson = Gson()
        val type = object : TypeToken<User>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToUser(json: String): User {
        val gson = Gson()
        val type = object : TypeToken<User>() {

        }.type
        return gson.fromJson<User>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun ListUserMentionToString(list: List<UserMention>): String {
        val gson = Gson()
        val type = object : TypeToken<List<UserMention>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListUserMention(json: String): List<UserMention> {
        val gson = Gson()
        val type = object : TypeToken<List<UserMention>>() {

        }.type
        return gson.fromJson<List<UserMention>>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun UserXToString(list: UserX): String {
        val gson = Gson()
        val type = object : TypeToken<UserX>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToUserX(json: String): UserX {
        val gson = Gson()
        val type = object : TypeToken<UserX>() {

        }.type
        return gson.fromJson<UserX>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun anyToString(list: Any): String {
        val gson = Gson()
        val type = object : TypeToken<Any>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToAny(json: String): Any {
        val gson = Gson()
        val type = object : TypeToken<Any>() {

        }.type
        return gson.fromJson<Any>(json, type)
    }
    @TypeConverter
    @JvmStatic
    fun ListanyToString(list: List<Any>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Any>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    @JvmStatic
    fun stringToListAny(json: String): List<Any> {
        val gson = Gson()
        val type = object : TypeToken<List<Any>>() {

        }.type
        return gson.fromJson<List<Any>>(json, type)
    }
}

