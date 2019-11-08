package go.fynd.twitter.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import go.fynd.twitter.data.Converter
import go.fynd.twitter.data.local.db.dao.UsersDao
import go.fynd.twitter.model.UserBean
import go.fynd.twitter.utils.AppConstants


@Database(
    entities = [UserBean::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        @Volatile
        private var INSTANCE : AppDatabase?=null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    AppConstants.DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    fun destroyInstance() {
        INSTANCE = null
    }

    abstract fun usersDao() : UsersDao
}