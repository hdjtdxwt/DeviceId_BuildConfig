package com.epsit.myapplication.common;

/**
 * 应用程序里的一些常量
 */

public class AppConstant {

    public static final String SPFILENAME = "robot_info";
    /**
     * 语音对话聊天时，是否要保存用户说的语音文件
     */
    public static final String SP_VOICEFILE_SAVE = "voicefile_save";
    /**
     * 登陆的类型参数，login方法的第一个参数
     */
    public static final String loginType = "client_credential";
    /**
     * sharedpreferences文件保存robot信息的文件的名称
     */
    public static final String SP_ROBOTINFO_FNAME = "robot";
    /**
     * sharedpreferences文件保存robot信息的文件的名称
     */
    public static final String SP_HASEXIT = "has_exit";
    /**
     * 存到sharedpreferences里的机器人的唯一id,相当于登陆的用户名
     */
    public static final String SP_ROBOTID = "robot_id";
    /**
     * 存到sharedpreferences里的访问后台的token值
     */
    public static final String SP_ACCESS_TOKEN = "access_token";


    /**
     * 机构名称
     */
    public static final String SP_ORGANIZATION_NAME="organization_mame";

    /**
     * 上班
     */
    public static final String SP_GO_TO_WROK="gotowork";

    /**
     * 下班冲电
     */
    public static final String SP_GO_OFF_WROK="geoffwork";



    /**
     * 数字和功能的对应关系：
     1	标准功能
     2	机器人自带闲聊库
     3	闲时播放视频或图片
     4	界面放大缩小
     5	无命中默认回复
     6	小易二号闲时跳舞
     */
    public static final String SP_FUNCTIONS = "apk_functions";


    public static final int MSG_ONLINE_MODE = 1; //在线语音识别模式
    public static final int MSG_OFFLINE_MODE = 0; //离线语音模式

}
