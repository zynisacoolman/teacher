package cn.jucheng.www.hulisiwei;

import java.lang.ref.WeakReference;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import cn.jucheng.jclibs.socket.MyGlobal;
import cn.jucheng.jclibs.socket.WorkService;
import cn.jucheng.rwbt.BTHeartBeatThread;
import cn.jucheng.rwusb1.USBHeartBeatThread;
import cn.jucheng.rwwifi.NETHeartBeatThread;
import cn.jucheng.www.hulisiwei.widget.MyGlobal1;

public class ConnectionSettingsActivity extends MyBaseActivity implements
		OnClickListener {
	@SuppressWarnings("unused")
	private static final String TAG = "ConnectionSettingsActivity";
	private static MHandler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_settings);
		initView();
		mHandler = new MHandler(this);
		WorkService.addHandler(mHandler);
	}

	private void initView() {
		if (!datas.getBoolData(MyGlobal1.C_SHEBEI_LANYA)) {
			findViewById(R.id.btConnectPrinterPaired).setVisibility(
					View.INVISIBLE);
			findViewById(R.id.btConnectPrinterSearched).setVisibility(
					View.INVISIBLE);
		}
		if (!datas.getBoolData(MyGlobal1.C_SHEBEI_WIFI)) {
			findViewById(R.id.btConnectIP).setVisibility(View.INVISIBLE);
		}
		if (!datas.getBoolData(MyGlobal1.C_SHEBEI_USB)) {
			findViewById(R.id.btConnectUSB).setVisibility(View.INVISIBLE);
		}
		findViewById(R.id.btConnectPrinterPaired).setOnClickListener(this);
		findViewById(R.id.btConnectPrinterSearched).setOnClickListener(this);
		findViewById(R.id.btConnectIP).setOnClickListener(this);
		findViewById(R.id.btConnectUSB).setOnClickListener(this);
		findViewById(R.id.btnClose1).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// if (v.getId() == R.id.btConnectPrinterMac) {
		// MyLog.d(TAG, "btConnectPrinterMac");
		// startActivity(new Intent(this, ConnectBTMacActivity.class));
		// } else
		if (v.getId() == R.id.btConnectPrinterPaired) {
			// MyLog.d(TAG, "ConnectBTPairedActivity");
			startActivity(new Intent(this, ConnectBTPairedActivity.class));
		} else if (v.getId() == R.id.btConnectPrinterSearched) {
			// MyLog.d(TAG, "SearchBTActivity");
			startActivity(new Intent(this, SearchBTActivity.class));
		} else if (v.getId() == R.id.btConnectIP) {
			// MyLog.d(TAG, "ConnectIPActivity");
			startActivity(new Intent(this, ConnectIPActivity.class));
		} else if (v.getId() == R.id.btConnectUSB) {
			datas.setData(MyGlobal.PREFERENCES_LASTCONNECTED_TYPE,
					MyGlobal.CONNECTTYPE_USB);
			SettingsActivity.checkDeviceConnection1(this);		
		} else if (v.getId() == R.id.btnClose1) {
			this.finish();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private static class MHandler extends Handler {

		@SuppressWarnings("unused")
		private WeakReference<ConnectionSettingsActivity> mActivity;

		private MHandler(ConnectionSettingsActivity connectSettingsActivity) {
			mActivity = new WeakReference<ConnectionSettingsActivity>(
					connectSettingsActivity);
		}

		@Override
		public void handleMessage(Message msg) {
			// ConnectionSettingsActivity theActivity = mActivity.get();
			switch (msg.what) {
			case MyGlobal.MSG_ALLTHREAD_READY: {
				break;
			}
			case BTHeartBeatThread.MSG_BTHEARTBEATTHREAD_UPDATESTATUS:
			case NETHeartBeatThread.MSG_NETHEARTBEATTHREAD_UPDATESTATUS:
			case USBHeartBeatThread.MSG_USBHEARTBEATTHREAD_UPDATESTATUS: {
				int statusOK = msg.arg1;
				// int status = msg.arg2;
				// MyLog.v(TAG,
				// "statusOK: " + statusOK + " status: "
				// + DataUtils.byteToStr((byte) status));
				// theActivity.progressBar.setIndeterminate(false);
				if (statusOK == 1) {
					// theActivity.progressBar.setProgress(100);
				} else {
					// theActivity.progressBar.setProgress(0);
				}
				break;
			}
			case MyGlobal.CMD_POS_PRINTPICTURERESULT:
			case MyGlobal.CMD_POS_WRITE_BT_FLOWCONTROL_RESULT: {
				// int result = msg.arg1;
				// MyLog.v(TAG, "Result: " + result);
				break;
			}
			}
		}
	}

	@Override
	public void exc() {

	}

	@Override
	protected void HandlerMessage(Message msg) {
	}

}
