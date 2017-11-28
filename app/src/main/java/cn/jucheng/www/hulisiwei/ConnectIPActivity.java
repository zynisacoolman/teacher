package cn.jucheng.www.hulisiwei;

import java.lang.ref.WeakReference;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import cn.jucheng.jclibs.socket.MyGlobal;
import cn.jucheng.jclibs.socket.WorkService;
import cn.jucheng.jclibs.tools.IPString;
import cn.jucheng.jclibs.tools.MyToast;

public class ConnectIPActivity extends MyBaseActivity implements
		OnClickListener {

	private static Handler mHandler = null;
	@SuppressWarnings("unused")
	private static String TAG = "ConnectIPActivity";
	private EditText inputIp, inputPort;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_connectip);

		findViewById(R.id.buttonConnectIP).setOnClickListener(this);
		inputIp = (EditText) findViewById(R.id.editTextInputIp);
		inputPort = (EditText) findViewById(R.id.editTextInputPort);
		dialog = new ProgressDialog(this);

		mHandler = new MHandler(this);
		WorkService.addHandler(mHandler);

		inputIp.setText(datas.getData(MyGlobal.PREFERENCES_IPADDRESS, ""));
		inputPort.setText(""
				+ datas.getIntData(MyGlobal.PREFERENCES_PORTNUMBER, 9100));
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		WorkService.delHandler(mHandler);
		mHandler = null;
	}

	public void onClick(View arg0) {
		if (arg0.getId() == R.id.buttonConnectIP) {
			boolean valid = false;
			int port = 9100;
			String ip = "";
			try {
				ip = inputIp.getText().toString();
				if (null == IPString.IsIPValid(ip))
					throw new Exception("不合法的IP地址！");
				port = Integer.parseInt(inputPort.getText().toString());
				valid = true;
			} catch (NumberFormatException e) {
				MyToast.showToast(this, "不合法的端口号！");
				// MyLog.e(TAG, "onClick() error1 " + e.getMessage());
				valid = false;
			} catch (Exception e) {
				// MyLog.e(TAG, "onClick() error2 " + e.getMessage());
				MyToast.showToast(this, "不合法的IP地址！");
				valid = false;
			}
			if (valid) {
				datas.setData(MyGlobal.PREFERENCES_IPADDRESS, ip);
				datas.setData(MyGlobal.PREFERENCES_PORTNUMBER, port);
				dialog.setMessage(MyGlobal.toast_connecting + " " + ip + ":"
						+ port);
				dialog.setIndeterminate(true);
				dialog.setCancelable(false);
				dialog.show();
				WorkService.workThread.connectNet(ip, port);
			}
		}
	}

	private static class MHandler extends Handler {

		private WeakReference<ConnectIPActivity> mActivity;

		public MHandler(ConnectIPActivity activity) {
			mActivity = new WeakReference<ConnectIPActivity>(activity);
		}

		@Override
		public void handleMessage(Message msg) {
			ConnectIPActivity theActivity = mActivity.get();
			switch (msg.what) {
			case MyGlobal.MSG_WORKTHREAD_SEND_CONNECTNETRESULT: {
				int result = msg.arg1;
				MyToast.showToast(theActivity,
						(result == 1) ? MyGlobal.toast_success
								: MyGlobal.toast_fail);
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