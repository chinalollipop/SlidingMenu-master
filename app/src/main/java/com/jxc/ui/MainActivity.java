package com.jxc.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jxc.fargment.LotteryFragment;
import com.jxc.fargment.MenuFragment;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
@SuppressLint("NewApi")
public class MainActivity extends SlidingActivity {

	public FragmentTransaction fraTra = null;
	public MenuFragment menuFra = null;
	public LotteryFragment lotteryFragment = null;
	private Timer timer = null;
	private TimerTask timeTask = null;
	private boolean isExit = false;
	List<Fragment> mFragmentList;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//设置左边显示的正文
		setBehindContentView(R.layout.menu_layout); // 设置侧栏菜单页
		mFragmentList = new ArrayList<Fragment>();
		fraTra = this.getFragmentManager().beginTransaction();
		menuFra = new MenuFragment(this,savedInstanceState);
		lotteryFragment = new LotteryFragment(MainActivity.this,menuFra);
		fraTra.replace(R.id.menu_fl, menuFra);
		fraTra.replace(R.id.main_rl, lotteryFragment);
		fraTra.commit();
		//
		SlidingMenu sm = getSlidingMenu();	//或者侧栏滑动菜单
		sm.setMode(SlidingMenu.RIGHT);//设置右滑菜单
		//sm.setShadowWidth(15); // 阴影宽度
		sm.setBehindOffset(300); // 菜单与边框的距离
		sm.setShadowDrawable(R.drawable.shadow); // 滑动菜单渐变
		sm.setFadeDegree(0.35f);				//色度
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN); // 全屏滑动菜单
		timer = new Timer();
	}
	
	public void onFinsh(View v){
		fraTra = this.getFragmentManager().beginTransaction();
		fraTra.replace(R.id.main_rl, new LotteryFragment(MainActivity.this,menuFra));
		fraTra.commit();
	}
	
	
	@Override
	public void onBackPressed() {
		if (JXCApplication.accNumber == 0) {
			if (isExit) {
				finish();
			} else {
				isExit = true;
				Toast.makeText(getBaseContext(), "在按一次推出程序", Toast.LENGTH_SHORT)
						.show();
				timeTask = new TimerTask() {

					@Override
					public void run() {
						isExit = false;
					}
				};
				timer.schedule(timeTask, 2000);
			}
		} else {
			fraTra = this.getFragmentManager().beginTransaction();
			fraTra.replace(R.id.main_rl, lotteryFragment);
			fraTra.commit();
		}
		
	}

}
