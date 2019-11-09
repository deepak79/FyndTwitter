package go.fynd.twitter.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import go.fynd.twitter.data.AppDataManager
import go.fynd.twitter.data.DataManager
import go.fynd.twitter.data.local.db.AppDatabase
import go.fynd.twitter.data.local.db.AppDbHelper
import go.fynd.twitter.data.local.db.DbHelper
import go.fynd.twitter.data.prefs.AppPreferencesHelper
import go.fynd.twitter.data.prefs.PrefsHelper
import go.fynd.twitter.di.DatabaseInfo
import go.fynd.twitter.di.PreferenceInfo
import go.fynd.twitter.utils.AppConstants
import go.fynd.twitter.utils.rx.AppSchedulerProvider
import go.fynd.twitter.utils.rx.SchedulerProvider
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .build()
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PrefsHelper {
        return appPreferencesHelper
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }
}