package com.jxc.fargment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jxc.ui.JXCApplication;
import com.jxc.ui.MainActivity;
import com.jxc.ui.R;


@SuppressLint("NewApi")
public class SystemMessageFragment extends Fragment {
	public final String tag = this.getClass().getName();
	private Context text = null;

	public SystemMessageFragment(Context text) {
		this.text = text;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// inflater the layout
		JXCApplication.accNumber = 5;
		View view = inflater.inflate(R.layout.fragment_system_message, null);
		Button btn_my_lottery = (Button) view.findViewById(R.id.btn_my_lottery);
		
		btn_my_lottery.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((MainActivity)getActivity()).getSlidingMenu().toggle();
			}
		});
		TextView textView = (TextView) view.findViewById(R.id.content_tv);
		/*if (!TextUtils.isEmpty(text)) {
			textView.setText(text);
		}*/
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

}
