package com.gewudi.keyboard_android.constant

import androidx.annotation.IntDef

/**
 * 消息类型
 * @author wangyuandong
 * @date  2021/11/25
 */
@IntDef(MessageType.MESSAGE_TYPE_LIKE, MessageType.MESSAGE_TYPE_COMMENT)
@Retention(AnnotationRetention.SOURCE)
annotation class MessageType {
    companion object {
        // 点赞消息
        const val MESSAGE_TYPE_LIKE = 1
        // 评论消息
        const val MESSAGE_TYPE_COMMENT = 2
    }
}
