package com.gewudi.keyboard_android.bean

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

// 多个主键
// @Entity(tableName = "user", primaryKeys = ["first_name", "last_name"])
// 定义表名称，SQLite 中的表名称不区分大小写
@Entity(tableName = "user")
data class User(
    // 主键分配自动ID
    @PrimaryKey var uid: Long?,
    @ColumnInfo var oid: String?,
    @ColumnInfo var oid_type: Int?,
    @ColumnInfo var username: String?,
    @ColumnInfo var user_profile_pic: String?,
    @ColumnInfo var gender: Int?,
    @ColumnInfo var age: Int?,
    @ColumnInfo var is_exist: Boolean?,
    @ColumnInfo var created_at: Long?,
    @ColumnInfo var user_tag: String?,
    @ColumnInfo var level_value: Long?,
    @ColumnInfo var address: String?,
    @ColumnInfo var level: Int?,
    @ColumnInfo var user_type: Int?,
    @ColumnInfo var password: String?,
    @ColumnInfo var user_phone: String?,
    @ColumnInfo var is_open_shop: Int?,
    @ColumnInfo var user_desc: String?,
    @ColumnInfo var focus_count:Int,
    @ColumnInfo var like_count:Int,
    @ColumnInfo var fans_count:Int,


) {
    constructor() : this(0, "", 0, "","",0,0,
        true, 0,"",0,"",0,0,"","",0,"",0,0,0
    ) {

    }
}