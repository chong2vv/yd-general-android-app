package com.gewudi.keyboard_android.module.user

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.R
import com.gewudi.keyboard_android.base.BaseActivity
import com.gewudi.keyboard_android.base.list.XRecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.UserUpdateBean
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.constant.UserUpdateType
import com.gewudi.keyboard_android.databinding.ActivityUserUpdateBinding
import com.gewudi.keyboard_android.module.login.UserLoginFragment
import com.gewudi.keyboard_android.module.user.infoupdate.UserInfoChangeFragment


class UserUpdateActivity : BaseActivity<ActivityUserUpdateBinding>(ActivityUserUpdateBinding::inflate) {

    private val viewModel: UserUpdateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        initView()
    }

    private fun initView() {
        viewBinding.rvList.init(
            XRecyclerView.Config()
                .setPullRefreshEnable(false)
                .setPullUploadMoreEnable(false)
                .setViewModel(viewModel)
                .setOnItemClickListener(object : XRecyclerView.OnItemClickListener {
                    override fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long) {
                        var userUpdate:UserUpdateBean = viewData.value as UserUpdateBean
                        userUpdate.let {
                            val bundle = Bundle()
                            bundle.putString("key", it.title)
                            bundle.putString("value",it.value)
                            when(userUpdate.type){
                                UserUpdateType.USER_NAME -> {
                                    bundle.putString("field_key","username")
                                }
                                UserUpdateType.USER_DESC -> {
                                    bundle.putString("field_key","user_desc")
                                }
                                UserUpdateType.USER_ADDRESS -> {
                                    bundle.putString("field_key","address")
                                }
                                UserUpdateType.USER_AGE -> {
                                    bundle.putString("field_key","age")
                                }
                                UserUpdateType.USER_GENDER -> {
                                    bundle.putString("field_key","gender")
                                }
                                UserUpdateType.USER_TAG -> {
                                    bundle.putString("field_key","user_tag")
                                }

                            }
                            val fragment = UserInfoChangeFragment()
                            fragment.arguments = bundle
                            supportFragmentManager.beginTransaction().replace(viewBinding.fragmentContainer.id,
                                fragment
                            ).commit()
                        }
                    }
                })
        )
    }

    @PageName
    override fun getPageName() = PageName.USER_UPDATE
}