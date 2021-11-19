package com.gewudi.keyboard_android.module.user.infoupdate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.databinding.FragmentUserInfoChangeBinding



class UserInfoChangeFragment : BaseFragment<FragmentUserInfoChangeBinding>(FragmentUserInfoChangeBinding::inflate) {
    private val viewModel: UserInfoChangeViewModel by viewModels()

    private var fileName:String? = ""
    private var titleName:String? = ""
    private var userValue:String? = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fileName = savedInstanceState?.getString("field_key")
        titleName = savedInstanceState?.getString("key")
        userValue = savedInstanceState?.getString("value")

        initView()
    }

    private fun initView() {
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            val user = it.getOrNull()
            user.let {
                parentFragmentManager.beginTransaction()
                    .remove(this)
                    .commit()
            }
        }

        viewBinding.titleView.text = titleName

        viewBinding.ifBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }

        viewBinding.ifSave.setOnClickListener {
            val value = viewBinding.contentInputView.text
            fileName?.let { it1 -> viewModel.userInfoUpdate(it1, value.toString()) }
        }

    }

    @PageName
    override fun getPageName() = PageName.USER_INFO_CHANGE

}