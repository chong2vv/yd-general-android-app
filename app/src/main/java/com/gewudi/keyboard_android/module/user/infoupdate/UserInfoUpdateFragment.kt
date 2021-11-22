package com.gewudi.keyboard_android.module.user.infoupdate

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ImageUtils
import com.gewudi.keyboard_android.base.BaseFragment
import com.gewudi.keyboard_android.base.list.XRecyclerView
import com.gewudi.keyboard_android.base.list.base.BaseViewData
import com.gewudi.keyboard_android.bean.UserUpdateBean
import com.gewudi.keyboard_android.constant.EventName
import com.gewudi.keyboard_android.constant.PageName
import com.gewudi.keyboard_android.constant.UserUpdateType
import com.gewudi.keyboard_android.databinding.FragmentUserUpdateBinding
import com.gewudi.keyboard_android.eventbus.XEventBus
import com.gewudi.keyboard_android.module.login.UserRegisterFragment
import com.gewudi.keyboard_android.util.GlideEngine
import com.gewudi.keyboard_android.util.setImageUrl
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType

import com.lxj.xpopup.XPopup
import com.luck.picture.lib.entity.LocalMedia

import com.luck.picture.lib.listener.OnResultCallbackListener

import com.lxj.xpopupext.listener.TimePickerListener

import com.lxj.xpopupext.popup.TimePickerPopup
import java.util.*

import com.lxj.xpopupext.listener.CityPickerListener

import com.lxj.xpopupext.popup.CityPickerPopup





class UserInfoUpdateFragment : BaseFragment<FragmentUserUpdateBinding>(
    FragmentUserUpdateBinding::inflate) {

    private val viewModel: UserInfoUpdateViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val fragmentId = this.id

        viewBinding.userFaceCard.setOnClickListener {
            XPopup.Builder(context)
                .isDarkTheme(true)
                .hasShadowBg(true)
                .isViewMode(true)
                //.enableDrag(false)
                //.hasBlurBg(true)
                //.isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
                .asBottomList(
                    "选择图片方式:", arrayOf("手机拍照", "相册选择")
                ) { position, text ->
                    run {
                        when(position){
                            0 -> chooseImageForCamera()
                            1 -> chooseImageForPhotoAlbum()
                            else -> {

                            }
                        }
                    }
                }.show()
        }

        XEventBus.observe(viewLifecycleOwner, EventName.LOGIN) { message: Long ->
            viewModel.loadData(false,true,0)
        }

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
                                    //地址则当前页面直接弹出地址选择器
                                    showAddressChoose()
                                    return
                                }
                                UserUpdateType.USER_AGE -> {
                                    //年龄则当前页面直接弹出时间选择器
                                    showDateChoose()
                                    return
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
                                .replace(fragmentId, fragment)
                                .addToBackStack(null)
                                .commit()

                        }
                    }
                })
        )

    }

    fun showDateChoose() {
        val date: Calendar = Calendar.getInstance()
        date.set(2000, 5, 1)
        val date2: Calendar = Calendar.getInstance()
        date2.set(2020, 5, 1)
        val popup =
            activity?.let {
                TimePickerPopup(it) //                        .setDefaultDate(date)  //设置默认选中日期
                    //                        .setYearRange(1990, 1999) //设置年份范围
                    //                        .setDateRange(date, date2) //设置日期范围
                    .setTimePickerListener(object : TimePickerListener {
                        override fun onTimeChanged(date: Date?) {
                            //时间改变
                        }

                        override fun onTimeConfirm(date: Date, view: View?) {
                            //点击确认时间
                            Toast.makeText(
                                it,
                                "选择的时间：" + date.toLocaleString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
            }

        XPopup.Builder(activity)
            .asCustom(popup)
            .show()
    }

    fun showAddressChoose() {
        val popup = activity?.let { CityPickerPopup(it) }
        popup?.setCityPickerListener(object : CityPickerListener {
            override fun onCityConfirm(province: String, city: String, area: String, v: View) {
                Log.e("tag", "$province - $city - $area")
                Toast.makeText(activity, "$province - $city - $area", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onCityChange(province: String, city: String, area: String) {
                Log.e("tag", "$province - $city - $area")
                Toast.makeText(activity, "$province - $city - $area", Toast.LENGTH_SHORT)
                    .show()
            }
        })
        XPopup.Builder(activity)
            .asCustom(popup)
            .show()
    }


    fun chooseImageForCamera() {
        PictureSelector.create(this)
            .openCamera(PictureMimeType.ofImage())
            .imageEngine(GlideEngine.createGlideEngine())
            .selectionMode(PictureConfig.SINGLE)
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                }

                override fun onCancel() {
                    // 取消
                }
            })
    }

    fun chooseImageForPhotoAlbum() {
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofImage())
            .imageEngine(GlideEngine.createGlideEngine())
            .selectionMode(PictureConfig.SINGLE)
            .isEnableCrop(true)
            .cropImageWideHigh(100,100)
            .withAspectRatio(1,1)
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                    print("回调啦~~~~")
                    val picModel = result[0]
                    picModel.let {
                        viewBinding.userFaceImage.setImageBitmap(ImageUtils.getBitmap(it?.realPath))
                    }
                }

                override fun onCancel() {
                    // 取消
                    print("回调啦~~~~")
                }
            })
    }

    @PageName
    override fun getPageName() = PageName.USER_INFO_UPDATE

}