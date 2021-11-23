package com.gewudi.keyboard_android.module.user.infoupdate

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.FragmentUserInfoChangeBinding
import com.gewudi.keyboard_android.eventbus.XEventBus


class UserInfoChangeFragment : BaseFragment<FragmentUserInfoChangeBinding>(FragmentUserInfoChangeBinding::inflate) {
    private val viewModel: UserInfoChangeViewModel by viewModels()

    private var fileName:String? = ""
    private var titleName:String? = ""
    private var userValue:String? = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fileName = arguments?.getString("field_key")
        titleName = arguments?.getString("key")
        userValue = arguments?.getString("value")

        initView()
    }

    private fun initView() {

        viewBinding.titleView.text = titleName
        viewBinding.contentInputView.setText(userValue)

        viewBinding.ifBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(this.id, UserInfoUpdateFragment())
                .addToBackStack(null)
                .commit()
        }

        viewBinding.ifSave.setOnClickListener {
            val value = viewBinding.contentInputView.text
            fileName?.let { it1 -> viewModel.userInfoUpdate(it1, value.toString()) }
        }

        /**
         * 更新成功回调
         */
        viewModel.userLiveData.observe(viewLifecycleOwner) {

            if (it.isFailure) {
                Toast.makeText(context, "更新用户信息失败", Toast.LENGTH_SHORT).show()
            }else{
                var user = it.getOrNull()
                user?.let {
                    XEventBus.post(EventName.USER_UPDATE, user.uid)
                    parentFragmentManager.beginTransaction()
                        .replace(this.id, UserInfoUpdateFragment())
                        .addToBackStack(null)
                        .commit()
                }
            }
        }

    }

    @PageName
    override fun getPageName() = PageName.USER_INFO_CHANGE

}