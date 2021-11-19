package com.gewudi.keyboard_android.module.user.infoupdate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.base.list.XRecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.UserUpdateBean
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.constant.UserUpdateType
import com.gewudi.keyboard_android.databinding.FragmentUserUpdateBinding
import com.gewudi.keyboard_android.module.login.UserRegisterFragment

class UserInfoUpdateFragment : BaseFragment<FragmentUserUpdateBinding>(
    FragmentUserUpdateBinding::inflate) {

    private val viewModel: UserInfoUpdateViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val fragmentId = this.id
        viewBinding.rvList.init(
            XRecyclerView.Config()
                .setPullRefreshEnable(false)
                .setPullUploadMoreEnable(false)
                .setViewModel(viewModel)
                .setOnItemClickListener(object : XRecyclerView.OnItemClickListener {
                    override fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long) {
                        var userUpdate: UserUpdateBean = viewData.value as UserUpdateBean
                        userUpdate.let {
                            val bundle = Bundle()
                            bundle.putString("key", it.title)
                            bundle.putString("value",it.value)
                            when(it.type){
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

                            parentFragmentManager.beginTransaction()
                                .add(fragmentId, UserInfoChangeFragment())
                                .addToBackStack(null)
                                .commit()

                        }
                    }
                })
        )

    }

    @PageName
    override fun getPageName() = PageName.USER_INFO_UPDATE

}