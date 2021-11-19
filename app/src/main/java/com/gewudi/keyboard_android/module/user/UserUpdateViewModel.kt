package com.gewudi.keyboard_android.module.user


import androidx.lifecycle.viewModelScope
import com.gewudi.keyboard_android.base.BaseViewModel
import com.gewudi.keyboard_android.base.list.base.BaseRecyclerViewModel
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.User
import com.gewudi.keyboard_android.bean.UserUpdateBean
import com.gewudi.keyboard_android.constant.Key
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.constant.UserUpdateType
import com.gewudi.keyboard_android.item.UserUpdateItemViewData
import com.gewudi.keyboard_android.persistence.XKeyValue
import com.gewudi.keyboard_android.persistence.database.XDatabase
import kotlinx.coroutines.launch

class UserUpdateViewModel : BaseViewModel() {



    @PageName
    override fun getPageName() = PageName.USER_UPDATE

}