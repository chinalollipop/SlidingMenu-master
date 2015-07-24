package com.jxc.fargment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.jxc.ui.MainActivity;
import com.jxc.ui.MenuAdapter;
import com.jxc.ui.R;


@SuppressLint("NewApi")
public class MenuFragment extends Fragment {
	private final String tag = this.getClass().getName();
	private ListView menu_lv = null;
	private MenuAdapter menuAdapter = null;
	private Activity mContext = null;
	private Bundle bundle;
	private LotteryFragment LotteryFragment = null;
	private BettingRecordsFragment BettingRecordsFragment = null;
	private ChaseNumberRecordsFragment ChaseNumberRecordsFragment = null;
	private LotteryNumbersFragment LotteryNumbersFragment = null;
	private MsgFragment MsgFragment = null;
	private SystemMessageFragment SystemMessageFragment = null;
	private NoviceTutorialsFragment NoviceTutorialsFragment = null;
	private SetFragment SetFragment = null;
	public MenuFragment(Activity mContext,Bundle bundle) {
		this.mContext = mContext;
		this.bundle = bundle;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//bundle = savedInstanceState;
		View menuView = inflater.inflate(R.layout.menu_layout, null);
		menu_lv = (ListView) menuView.findViewById(R.id.menu_lv);
		menuAdapter = new MenuAdapter(mContext);
		menu_lv.setAdapter(menuAdapter);
		menu_lv.setOnItemClickListener(itemListener);
		return menuView;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		Log.d("", "outState");
		super.onSaveInstanceState(outState);
	}

	public OnItemClickListener itemListener = new OnItemClickListener() {
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			// TODO Auto-generated method stub
			((MainActivity)mContext).getSlidingMenu().toggle();
			Toast.makeText(mContext, menuAdapter.menuStr[position], Toast.LENGTH_SHORT).show();
			FragmentTransaction ft = ((MainActivity)mContext).getFragmentManager().beginTransaction();
			
			switch(position){
			case 0:
				if(LotteryFragment==null){
					LotteryFragment = new LotteryFragment(mContext,MenuFragment.this);
					//((MainActivity)mContext).getFragmentManager().putFragment(bundle, "LotteryFragment", myFragment);
				}
				//myFragment = mContext.getFragmentManager().getFragment(bundle, "LotteryFragment");
				ft.replace(R.id.main_rl, LotteryFragment);
				break;
			case 1:
				if(BettingRecordsFragment==null){
					BettingRecordsFragment = new BettingRecordsFragment(mContext);
				}
				ft.replace(R.id.main_rl, BettingRecordsFragment);
				break;
			case 2:
				if(ChaseNumberRecordsFragment==null){
					ChaseNumberRecordsFragment = new ChaseNumberRecordsFragment(mContext);
				}
				ft.replace(R.id.main_rl, ChaseNumberRecordsFragment);
				break;
			case 3:
				if(LotteryNumbersFragment==null){
					LotteryNumbersFragment = new LotteryNumbersFragment(mContext);
				}
				ft.replace(R.id.main_rl,LotteryNumbersFragment );
				break;
			case 4:
				if(MsgFragment==null){
					MsgFragment = new MsgFragment(mContext);
				}
				ft.replace(R.id.main_rl, new MsgFragment(mContext));
				break;
			case 5:
				if(SystemMessageFragment== null){
					SystemMessageFragment =  new SystemMessageFragment(mContext);
				}
				ft.replace(R.id.main_rl,SystemMessageFragment);
				break;
			case 6:
				if(NoviceTutorialsFragment== null){
					NoviceTutorialsFragment = new NoviceTutorialsFragment(mContext);
				}
				ft.replace(R.id.main_rl, NoviceTutorialsFragment);
				break;
			case 7:
				if(SetFragment == null){
					SetFragment = new SetFragment(mContext);	
				}
				ft.replace(R.id.main_rl, SetFragment);
				break;
			}
			ft.commit();
		}
	};

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		menuAdapter.release();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
}
