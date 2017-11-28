package cn.jucheng.www.hulisiwei;

import java.lang.ref.WeakReference;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import cn.jucheng.jclibs.socket.MyGlobal;
import cn.jucheng.jclibs.socket.WorkService;
import cn.jucheng.jclibs.tools.MyToast;

public class SearchBTActivity extends MyBaseActivity implements OnClickListener {

	private LinearLayout linearlayoutdevices;
	private ProgressBar progressBarSearchStatus;
	private ProgressDialog dialog;

	private BroadcastReceiver broadcastReceiver = null;
	private IntentFilter intentFilter = null;

	private static Handler mHandler = null;
	private static String TAG = "SearchBTActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_searchbt);

		findViewById(R.id.buttonSearch).setOnClickListener(this);
		progressBarSearchStatus = (ProgressBar) findViewById(R.id.progressBarSearchStatus);
		linearlayoutdevices = (LinearLayout) findViewById(R.id.linearlayoutdevices);
		dialog = new ProgressDialog(this);

		initBroadcast();

		mHandler = new MHandler(this);
		WorkService.addHandler(mHandler);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		WorkService.delHandler(mHandler);
		mHandler = null;
		uninitBroadcast();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == R.id.buttonSearch) {
			BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
			if (null == adapter) {
				finish();
				return;
			}

			if (!adapter.isEnabled()) {
				if (adapter.enable()) {
					while (!adapter.isEnabled())
						;
					Log.v(TAG, "Enable BluetoothAdapter");
				} else {
					finish();
					return;
				}
			}

			adapter.cancelDiscovery();
			linearlayoutdevices.removeAllViews();
			adapter.startDiscovery();
		}
	}

	private void initBroadcast() {
		broadcastReceiver = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				String action = intent.getAction();
				BluetoothDevice device = intent
						.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

				if (BluetoothDevice.ACTION_FOUND.equals(action)) {
					if (device == null)
						return;
					final String address = device.getAddress();
					String name = device.getName();
					if (name == null)
						name = "BT";
					else if (name.equals(address))
						name = "BT";
					Button button = new Button(context);
					button.setBackgroundResource(R.drawable.s_btn1);
					button.setTextAppearance(context, R.dimen.text_size16);
					button.setTextColor(getResources().getColor(
							R.color.tvSheZhi_lan));

					button.setHeight(getResources().getDimensionPixelSize(
							R.dimen.search_bta_item_btn_height));
					button.setGravity(Gravity.CENTER);
					button.setText("   " + name + ": " + address);
					button.setTextSize(20);
					button.setGravity(android.view.Gravity.CENTER_VERTICAL
							| Gravity.LEFT);

					button.setOnClickListener(new OnClickListener() {

						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							// 只有没有连接且没有在用，这个才能改变状�??
							dialog.setMessage(MyGlobal.toast_connecting + " "
									+ address);
							dialog.setIndeterminate(true);
							dialog.setCancelable(false);
							dialog.show();
							WorkService.workThread.connectBt(address);
						}
					});
					linearlayoutdevices.addView(button);
				} else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED
						.equals(action)) {
					progressBarSearchStatus.setIndeterminate(true);
				} else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED
						.equals(action)) {
					progressBarSearchStatus.setIndeterminate(false);
				}
			}
		};
		intentFilter = new IntentFilter();
		intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
		intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
		intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		registerReceiver(broadcastReceiver, intentFilter);
	}

	private void uninitBroadcast() {
		if (broadcastReceiver != null)
			unregisterReceiver(broadcastReceiver);
	}

	private static class MHandler extends Handler {

		private WeakReference<SearchBTActivity> mActivity;

		private MHandler(SearchBTActivity activity) {
			mActivity = new WeakReference<SearchBTActivity>(activity);
		}

		@Override
		public void handleMessage(Message msg) {
			SearchBTActivity theActivity = mActivity.get();
			switch (msg.what) {
			case MyGlobal.MSG_WORKTHREAD_SEND_CONNECTBTRESULT: {
				int result = msg.arg1;
				MyToast.showToast(theActivity,
						(result == 1) ? MyGlobal.toast_success
								: MyGlobal.toast_fail);
				Log.v(TAG, "Connect Result: " + result);
				theActivity.dialog.cancel();
				break;
			}
			}
		}
	}

	@Override
	public void exc() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void HandlerMessage(Message msg) {
	}

}
