package cn.jucheng.www.hulisiwei;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import cn.jucheng.www.hulisiwei.global.AppManager;

public class MainActivity extends MyBaseActivity {
	@SuppressLint("HandlerLeak")
	private Handler mhandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			onIn();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_);
		// 显示版本号
		TextView tvVersion = (TextView) findViewById(R.id.txtVersion);
		tvVersion.setText(getVersion(this));
		// 2秒钟后进入系统
		mhandler.sendEmptyMessageDelayed(1, 2000);
		// 得到屏幕宽高维度信息：构造函数DisplayMetrics 不需要传递任何参数；
		// 调用getWindowManager()之后，会取得现有Activity 的Handle
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		AppManager.getAppManager().width = dm.widthPixels;
	}

	private String getVersion(Context c) {
		String versionName = "";// 版本号
		try {
			PackageManager pm = c.getPackageManager();
			PackageInfo pi = pm.getPackageInfo("cn.jucheng.www.hulisiwei", 0);
			versionName = pi.versionName;// 获取在AndroidManifest.xml中配置的版本号
		} catch (Exception e) {
			versionName = "";
			e.printStackTrace();
		}
		return versionName;
	}

	/** 进入系统 */
	private void onIn() {
//		Intent intent = new Intent(this, LoginActivity.class);
		Intent intent = new Intent(this, LoginActivity.class);
		intent.putExtra("isUsbLianJie", false);
		startActivity(intent);
		this.finish();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onSettings(View v) {
		super.onSettings(v);
	}

	@Override
	public void onReturn(View v) {
		super.onReturn(v);
	}

	@Override
	public void exc() {

	}

	@Override
	protected void HandlerMessage(Message msg) {
	}

}
