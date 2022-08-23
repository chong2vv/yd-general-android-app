package com.wyd.yd_app.persistence.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wyd.yd_app.bean.User

@Dao
interface UserDao {
    // 查找本地所有用户
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    // 查找指定uid群用户
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: LongArray): List<User>

    //查找指定单一用户
    @Query("SELECT * FROM user WHERE uid LIKE :uid LIMIT 1")
    suspend fun findByUid(uid: Long): User

    //批量更新（创建）用户
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: List<User>)

    //单一更新用户
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    //删除用户
    @Delete
    suspend fun delete(user: User)

}