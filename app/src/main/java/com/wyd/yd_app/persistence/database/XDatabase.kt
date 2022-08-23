package com.wyd.yd_app.persistence.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wyd.yd_app.bean.User
import com.wyd.yd_app.persistence.database.dao.UserDao

@Database(entities = [User::class], version = 2)
abstract class XDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private val db: XDatabase by lazy {
            Room.databaseBuilder(
                com.wyd.yd_app.XArchApplication.instance,
                XDatabase::class.java, "database-name"
            ).build()
        }

        fun userDao(): UserDao {
            return db.userDao()
        }
    }

}