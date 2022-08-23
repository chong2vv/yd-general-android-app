package com.wyd.yd_app.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 多个主键
// @Entity(tableName = "user", primaryKeys = ["first_name", "last_name"])
// 定义表名称，SQLite 中的表名称不区分大小写
@Entity(tableName = "user")
data class User(
    // 主键分配自动ID uid
    @PrimaryKey var uid: Long?,
    // 第三方id
    @ColumnInfo var oid: String?,
    //注册类型 1=手机 2=微信 3=QQ
    @ColumnInfo var oid_type: Int?,
    //昵称
    @ColumnInfo var username: String?,
    //头像
    @ColumnInfo var user_profile_pic: String?,
    //性别 0为未知，1为男性，2为女性
    @ColumnInfo var gender: Int?,
    //年龄，生日时间戳
    @ColumnInfo var age: Int?,
    //是否注册
    @ColumnInfo var is_exist: Boolean?,
    //创建时间戳
    @ColumnInfo var created_at: Long?,
    //标签，英文“,”形式分隔，如：技术宅,肥宅,大胖子
    @ColumnInfo var user_tag: String?,
    //用户经验值
    @ColumnInfo var level_value: Long?,
    //地址
    @ColumnInfo var address: String?,
    //等级
    @ColumnInfo var level: Int?,
    //用户类型 0自然创建，1管理员
    @ColumnInfo var user_type: Int?,
    //密码
    @ColumnInfo var password: String?,
    //手机号
    @ColumnInfo var user_phone: String?,
    //是否是开店
    @ColumnInfo var is_open_shop: Int?,
    //描述
    @ColumnInfo var user_desc: String?,
    //该用户被关注数
    @ColumnInfo var focus_count:Int,
    //该用户被点赞数
    @ColumnInfo var like_count:Int,
    //该用户被粉丝数
    @ColumnInfo var fans_count:Int,


) {
    constructor() : this(0, "", 0, "","",0,0,
        true, 0,"",0,"",0,0,"","",0,"",0,0,0
    ) {

    }
}