package cn.jucheng.www.hulisiwei;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jucheng.jclibs.socket.MyGlobal;
import cn.jucheng.jclibs.socket.WorkService;
import cn.jucheng.jclibs.tools.IPString;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightEditText;


/**
 * 连接网络设备
 */
public class ConnectIPActivity extends MyBaseActivity {

	private static Handler mHandler = null;
	@SuppressWarnings("unused")
	private static String TAG = "ConnectIPActivity";
	/**
	 * ip
	 */
	@BindView(R.id.editTextInputIp)
	FitHeightEditText inputIp;
	/**
	 *
	 */
	@BindView(R.id.editTextInputPort)
	FitHeightEditText inputPort;
	/**
	 *
	 */
	@BindView(R.id.relativeLayout1)
	LinearLayout relativeLayout1;

	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_connectip);
		ButterKnife.bind(this);

		dialog = new ProgressDialog(this);

		mHandler = new MHandler(this);
		WorkService.addHandler(mHandler);

		inputIp.setText(datas.getData(MyGlobal.PREFERENCES_IPADDRESS, ""));
		inputPort.setText(""
				+ datas.getIntData(MyGlobal.PREFERENCES_PORTNUMBER, 9100));

		hideSoftKeyBoard();
	}

	/**
	 * 关闭软键盘
	 */
	public void hideSoftKeyBoard() {
		InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		// 强制隐藏软键盘
		manager.hideSoftInputFromWindow(inputPort.getWindowToken(), 0);
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

	@OnClick({R.id.back_network, R.id.buttonConnectIP})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.back_network://返回
				finish();
				break;
			case R.id.buttonConnectIP://连接
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
					valid = false;
				} catch (Exception e) {
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
				break;
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