package com.gewudi.keyboard_android.bean

data class FeedBean(
     var article_id: Long?,
     var type: Int?,
     var title: String?,
     var tag: String?,
     var picurls: MutableList<String>?,
     var text: String?,
     var video_url: String?,
     var uid: Long?,
     var like_count: Int?,
     var view_count: Int?,
     var comment_count: Int?,
     var collect_count: Int?,
     var created_at: Long?,
     var cover_image: String?,
) {
     constructor() : this(0,0,"","",null,"","",0,0,0,0, 0,0,""){

     }

}
