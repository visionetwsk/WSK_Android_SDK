# 微尚客 Android SDK

##简介

>微尚客 Android SDK 是一个 Android 端客服系统访客解决方案，既包含了客服聊天逻辑管理，也提供了聊天界面，开发者可方便的将客服功能集成到自己的 APP 中。

##快速集成
###1.添加 SDK 到项目中。

####Android Studio: 

> 在工程 build.gradle 文件中添加依赖：

```gradle
compile 'com.visionet.wskcss:wskcss:1.0.2'
```

> 请将1.0.2替换为此徽章后面的版本号<a href='https://bintray.com/wsk/wskcs/wsk_sdk/_latestVersion'><img src='https://api.bintray.com/packages/wsk/wskcs/wsk_sdk/images/download.svg'></a>


####Eclipse: 

>先下载 WSK_Android_SDK_forEclipse，然后解压缩，将得到的 WskSDK 文件夹作为库工程模块导入到你的工程中，并添加模块依赖。然后将 AndroidManifest 文件中的内容拷贝到你的主工程的 manifest 文件中，将 assets 文件夹的内容拷贝你的主工程的 assets 目录中。

###2.WskCs.init();
>微尚客SDK初始化

>根据需求可选：
####a.在你的 Application 类的 onCreate 函数中调用：
```java
  WskCs.init(context,appKey);
```
####b.在你的业务系统登录后调用：
```java
  WskCs.init(context,userId,nickName,appKey);
```

* userId为你的业务系统中的的唯一标示，可以用id，账号等，用来保证不同手机客户端的与客服交流的数据同步
* nickName为你的业务平台系统中的用户名，用来在客服平台展示访客的名称
* appKey用来区分微尚客集成客户端，在微尚客平台的 **App SDK设置** 中可以找到

###3.WskCs.configUi();
>微尚客SDK的UI配置，如不需要可以不调用

####在初始化后调用：
```java
  WskCsConfig config = new WskCsConfig();
  WskCs.configUi(config);
```
####可配置项：
```java
/**
public class WskCsConfig {
     * 客户头像url优先
     */
    private String customerPhotoUrl;
    /**
     * 客户头像资源id
     */
    private int customerPhotoDraweableId;

    /**
     * 客户聊天气泡背景资源id
     */
    private int customerChatBgDraweableId;
    /**
     * 客服聊天气泡背景资源id
     */
    private int serviceChatBgDraweableId;

    /**
     * 客服聊天文字颜色color；
     */
    private Integer serviceTextColor;
    /**
     * 客户聊天文字颜色color；
     */
    private Integer customerTextColor;
    /**
     * 聊天窗口背景资源Id
     */
    private int backgroundDraweableId;
    /**
     * 聊天窗口背景颜色
     */
    private Integer backgroundColor ;
    /**
     * 展示时间颜色color；
     */
    private Integer dateTimeTextColor;

    /**
     * 提示文字颜色
     */
    private Integer promptTextColor;
    /**
     * 提示背景图片
     */
    private int promptBgDrawableId;

    /**
     * 加载进度条颜色
     */
    private Integer loadingColor;
    /**
     *发送进度条颜色
     */
    private Integer sendingColor;
    /**
     * titlebar背景颜色
     */
    private Integer titlebarBgColor;
    /**
     * 状态栏背景色
     */
    private Integer statusbarColor;
    /**
     * 返回键图标资源id
     */
    private int backIconDrweableId;

    /**
     * title右边text颜色
     */
    private Integer titleRightColor;

    /**
     * titleColor
     */
    private Integer titleColor;
    /**
     * titlebar下横线是否显示
     */
    private boolean showTitleLine;
 }
```
