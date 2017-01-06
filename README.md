# 微上客 Android SDK

##简介

>微尚客 Android SDK 是一个 Android 端客服系统访客解决方案，既包含了客服聊天逻辑管理，也提供了聊天界面，开发者可方便的将客服功能集成到自己的 APP 中。

##快速集成
###1.添加 SDK 到项目中。

####Android Studio: 

> 在工程 build.gradle 文件中添加依赖：

```gradle
compile 'com.visionet:wskcss:1.0.2'
```

> 请将1.0.2替换为此徽章后面的版本号<a href='https://bintray.com/visionetwsk/wskcss/wsk_sdk/_latestVersion'><img src='https://api.bintray.com/packages/visionetwsk/wskcss/wsk_sdk/images/download.svg'></a>


####Eclipse: 

>先下载 WSK_Android_SDK_forEclipse，然后解压缩，将得到的 WskSDK 文件夹作为库工程模块导入到你的工程中，并添加模块依赖。然后将 AndroidManifest 文件中的内容拷贝到你的主工程的 manifest 文件中，将 assets 文件夹的内容拷贝你的主工程的 assets 目录中。

###2.WskCs.init();
>微尚客SDK初始化

>根据需求可选(三选一)：
####a.在你的 Application 类的 onCreate 函数中调用：
```java
  WskCs.init(context,appKey);
```
####b.在你的业务系统登录后调用：
```java
  WskCs.init(context,userId,nickName,appKey);
```
####c.在你的业务系统登录后调用：
```java
  UserInfo userInfo = new UserInfo(userId);
  WskCS.init( context,appkey,userInfo );
  WskCs.init(context,appKey,userInfo);
```
#####可配置项：

```java
public class UserInfo {
   /**
    * 用户昵称对应nickName
    */
    private String customerName;

    /**
     * 性别(男：1；女：2)
     */
    private int gender;

    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 职位
     */
    private String title;

    /**
     * 单位
     */
    private String department;

    /**
     * 头像
     */
    private String headimgurl;

    /**
     * 生日(yyyy-MM-dd)
     */
    private String birthday;

    /**
     * 备注
     */
    private String remark;
    
  }
```


* userId为你的业务系统中的的唯一标示，可以用id，账号等，用来保证不同手机客户端的与客服交流的数据同步
* nickName为你的业务平台系统中的用户名，用来在客服平台展示访客的名称
* appKey用来区分微尚客集成客户端，在微尚客平台的 **App SDK设置** 中可以找到
* userInfo用户信息

### 4.registerReceiver WskCSPushBR
> 继承接收微尚客客服消息推送的广播
```java
public class MyWskCSPushBR extends WskCSPushBR{
  /**
   * 接收到消息
   * @param push
   */
  @Override
  public void onReceiverPush(Context context,ReceivePush push) {
    //此处可以用来弹出通知Notification，显示未读消息数量等操作
  }
  /**
   * 收到离线消息集合
   * param pushs
   */
  @Override
  public void onReceiverOffLinePushs(Context context,List<ReceivePush> pushs) {
    //此处可以用来弹出通知Notification，显示未读消息数量等操作
  }
}
```
 
#### a.可以通过代码注册

```java
IntentFilter filter = new IntentFilter( WskCSPushBR.ACTION_PUSH );
filter.setPriority( 990 );//此处小于1000,当处于联系客服界面时候将不会收到广播
registerReceiver(wskCSPushBR,filter);
```
 
#### b.AndroidManifest进行注册

```xml
<receiver android:name=".MyWskCSPushBR" >
  <intent-filter android:priority="990"><!--此处小于1000,当处于联系客服界面时候将不会收到广播-->
    <action android:name="com.visionet.wskcss.ACTION_MESSAGE_PUSH"></action>
  </intent-filter>
</receiver>

```

### 4. WskCS.toWSKCS();
> 跳转至客服界面(二选一)：
```java
    WskCS.toWSKCS( context);
```

```java
    /**
     * 自动发送一个链接
     * @param link 链接地址（跳转的url）
     * @param linkDesc 链接描述（展示的信息）
     */
    WskCS.toWSKCS( context,link,linkDesc);
```


### 5. WskCS.stopReceiverPushService();
> 停止接收客服消息的推送服务，注意当进入联系客服界面将服务将自动开启

```java

    /**
     * 停止接收推送服务，一般在业务系统退出登录后调用
     * @param saveOffLinePush 停止后所有消息是否保存为离线消息，离线消息在重连后会发送
     */
     public static void stopReceiverPushService(boolean saveOffLinePush){
        ...
    }
    
```
 
###扩展功能:
* 微尚客SDK的UI配置，如不需要可以不调用

####在初始化后调用：
```java
  WskCsConfig config = new WskCsConfig();
  WskCs.configUi(config);
```
####可配置项：
```java

public class WskCsConfig {
    /**
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
* 监听url消息的点击事件，在 WskCS.toWSKCS()后调用;
```java
    WskCS.setUrlMsgClickListener( new WskCS.UrlMsgClickListener() {
    /**
    * 链接类型的消息点击
    * @param url 连接消息的url
    * @return 当符合条件返回正确处理返回true,不符合条件的返回false将通过webview加载.
    */
    @Override
    public boolean handlerUrlClick(Context context,String url) {
      if(url!=null&&url.contains(?)){
        ...
        return true;
      }
      return false; 
    } );
 ```
