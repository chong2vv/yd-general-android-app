package com.gewudi.keyboard_android.module.user

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gewudi.keyboard_android.base.BaseActivity
import com.gewudi.keyboard_android.base.list.XRecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.UserUpdateBean
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.constant.UserListType
import com.gewudi.keyboard_android.constant.UserUpdateType
import com.gewudi.keyboard_android.databinding.ActivityUserListBinding
import com.gewudi.keyboard_android.module.user.infoupdate.UserInfoChangeFragment
import com.gewudi.keyboard_android.widget.NavigationView

class UserListActivity : BaseActivity<ActivityUserListBinding>(ActivityUserListBinding::inflate) {

    private val viewModel: UserListViewModel by viewModels()
    private var type: Int = UserListType.USER_LIKE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        initView()
    }

    private fun initView() {
        type = intent.getIntExtra("Type",UserListType.USER_LIKE)
        when(type){
            UserListType.USER_LIKE ->{
                viewBinding.navigationBar.setParameter(
                    NavigationView.ParameterBuilder()
                        .setShowBack(true)
                        .setShowTitle(true)
                        .setTitle("我关注的")
                )
            }
            UserListType.USER_FANS ->{
                viewBinding.navigationBar.setParameter(
                    NavigationView.ParameterBuilder()
                        .setShowBack(true)
                        .setShowTitle(true)
                        .setTitle("我的粉丝")
                )
            }
        }
        viewModel.user_list_type = type

        viewBinding.rvList.init(
            XRecyclerView.Config()
                .setViewModel(viewModel)
                .setOnItemClickListener(object : XRecyclerView.OnItemClickListener {
                    override fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long) {

                    }
                })
        )
    }

    @PageName
    override fun getPageName() = PageName.USER_LIST
}