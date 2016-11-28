package com.example.test;


import com.visionet.wskcss.WskCS;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WskCS.init( this,"dmlzaW9uZXQ6TW9iaWxlQ2hhdFRlc3Qx");

		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void toWskcss(View view){
		WskCS.toWSKCS(this);
	}
}
