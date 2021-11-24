package com.gewudi.keyboard_android.bean

/**
* 文章数据
*/
data class FeedBean(
     //文章id
     var article_id: Long?,
     //文章类型 1=文本图片 2=视频
     var type: Int?,
     //标题
     var title: String?,
     //标签
     var tag: String?,
     //文章内图片
     var picurls: MutableList<String>?,
     //内容
     var text: String?,
     //视频地址
     var video_url: String?,
     //发帖人uid
     var uid: Long?,
     //点赞数
     var like_count: Int?,
     //观看数
     var view_count: Int?,
     //评论数
     var comment_count: Int?,
     //收藏数
     var collect_count: Int?,
     //创建时间戳
     var created_at: Long?,
     //封面图
     var cover_image: String?,
     //是否开启电销
     var is_open_shop: Boolean
) {
     constructor() : this(0,0,"","",null,"","",0,0,0,0, 0,0,"", false){

     }

}
