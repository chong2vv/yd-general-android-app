package com.gewudi.keyboard_android.persistence.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.persistence.database.dao.UserDao

@Database(entities = [User::class], version = 2)
abstract class XDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private val db: XDatabase by lazy {
            Room.databaseBuilder(
                com.gewudi.keyboard_android.XArchApplication.instance,
                XDatabase::class.java, "database-name"
            ).build()
        }

        fun userDao(): UserDao {
            return db.userDao()
        }
    }

}