package com.gewudi.keyboard_android.module.user.infoupdate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.FragmentUserInfoChangeBinding



class UserInfoChangeFragment : BaseFragment<FragmentUserInfoChangeBinding>(FragmentUserInfoChangeBinding::inflate) {
    private val viewModel: UserInfoChangeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewModel.userLiveData.observe(viewLifecycleOwner) {

        }

    }

    @PageName
    override fun getPageName() = PageName.USER_INFO_CHANGE

}