package com.jxc.ui;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter {
	public String[] menuStr = { "彩种选择", "投注记录", "追号记录", "开奖号码" ,"站内短信","系统公告","新手帮助","设置"};
	public int[] viewId = { R.drawable.lottery_state, R.drawable.betting_records_state,
			R.drawable.chase_number_records_state, R.drawable.lottery_numbers_state,R.drawable.sms_state,
			R.drawable.system_message_state,R.drawable.novice_tutorials_state,R.drawable.set_state,
	};
	public LayoutInflater inflater = null;

	public MenuAdapter(Context context) {
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuStr.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return menuStr[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	class Holder {
		ImageView items_iv;
		TextView items_tv;
		TextView items_message;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.menu_items, null);
			holder = new Holder();
			holder.items_iv = (ImageView) convertView
					.findViewById(R.id.items_iv);
			holder.items_tv = (TextView) convertView
					.findViewById(R.id.items_tv);
			holder.items_message = (TextView) convertView
					.findViewById(R.id.items_btn_message);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		if(position==4){
			holder.items_message.setVisibility(View.VISIBLE);
		}else{
			holder.items_message.setVisibility(View.GONE);
		}
		holder.items_iv.setBackgroundResource(viewId[position]);
		holder.items_tv.setText(menuStr[position]);
		return convertView;
	}
	//释放控件
	public void release() {
		menuStr = null;
		viewId = null;
		inflater = null;
	}
}
