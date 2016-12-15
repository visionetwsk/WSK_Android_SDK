package com.example.test;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.visionet.wskcss.WskCS;
import com.visionet.wskcss.bean.UserInfo;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		WskCS.init( this,"dmlzaW9uZXQ6TW9iaWxlQ2hhdFRlc3Qx");
//		 WskCsUIConfig config = new WskCsUIConfig();
//	        config.setBackIconDrweableId(R.drawable.selector_test11);
//	        WskCS.configUI(config);
		UserInfo userInfo = new UserInfo(22+"");
        userInfo.setCustomerName( "zhenghai" );
        userInfo.setEmail( "www.zhenghai@visionet.com.cn" );
        userInfo.setGender( 1);
        userInfo.setAddress( "上海延安西路1146号" );
        userInfo.setBirthday( "1998-03-03" );
        userInfo.setHeadimgurl( "http://avatar.csdn.net/E/8/0/1_oyangyujun.jpg" );
        WskCS.init( this,"dmlzaW9uZXQ6TW9iaWxlQ2hhdFRlc3Qx",userInfo );
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void toWskcss(View view){
		WskCS.toWSKCS(this,"http://baidu.com","百度测试一下看看");
	}
}
