/**
* @Title: JXCApplication.java
* @Package com.jxc.ui
* @Description: TODO
* @author Daniel
* @version V1.0
*/
package com.jxc.ui;

import android.app.Application;
import android.content.res.Configuration;

public class JXCApplication extends Application {

	public static int accNumber=0;
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}

	/*@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
	}*/

}
