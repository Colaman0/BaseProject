package com.lsj.colaman.quickproject.common.imp

import android.content.Context

/**
 * <pre>
 *     author : kyle
 *     time   : 2019/6/8
 *     desc   : 权限
 * </pre>
 */
interface IPermissions {

    /**
     *  检查是否拥有该权限
     */
    fun checkHasPermissions(context: Context, vararg permission: String): Boolean

    /**
     *  检查是否拥有该权限组
     */
    fun checkHasPermissions(context: Context, vararg permission: Array<String>): Boolean


    /**
     *  请求该权限，并且通过回调处理结果
     */
    fun requestPermissions(context: Context, vararg permission: Array<String>,
                           successCallback: (() -> Unit?)? = null,
                           failedCallback: (() -> Unit?)? = null)

    /**
     *  请求该权限，并且通过回调处理结果
     */
    fun requestPermissions(context: Context, vararg permission: String,
                           successCallback: (() -> Unit?)? = null,
                           failedCallback: (() -> Unit?)? = null)


    fun getGotoSettingDialog(context: Context, vararg permission: String,
                             successCallback: (() -> Unit?)? = null,
                             failedCallback: (() -> Unit?)? = null)

    /**
     *  跳转到应用设置页面去打开权限
     */
    fun gotoSetting(context: Context, vararg permission: String,
                    successCallback: (() -> Unit?)? = null,
                    failedCallback: (() -> Unit?)? = null)

}