package com.wyd.yd_app.base.list.base

/**
 * 将具体数据类型再套一层BaseViewData以实现更多Item布局类型
 * 重写equals和hashCode是为后面的DiffUtil作准备
 */
open class BaseViewData<T>(var value: T) {

    override fun equals(other: Any?): Boolean {
        if (other is BaseViewData<*>) {
            return value?.equals(other.value) ?: false
        }
        return false
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }
}
