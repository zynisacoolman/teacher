package cn.jucheng.www.hulisiwei;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.www.hulisiwei.global.AppManager;
import cn.jucheng.www.hulisiwei.widget.MyMessage;

@SuppressLint("UseValueOf")
public class LoginActivity extends MyBaseActivity {
	private EditText etXianShi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		etXianShi = (EditText) findViewById(R.id.etXianShi);
	}

	public void onDengLu(View v) {
		AppManager.getAppManager().xingMing = ((EditText) findViewById(R.id.etXingMing))
				.getText().toString();
		AppManager.getAppManager().xueHao = ((EditText) findViewById(R.id.etXueHao))
				.getText().toString();
		// Intent intent = new Intent(this, MainList1Activity.class);
		// startActivity(intent);
		// this.finish();
	}

	public void onTest(View v) {
		switch (v.getId()) {
		case R.id.btnFSBingLiMingCheng:
			String etLeiXing = ((EditText) findViewById(R.id.etBingLiLeiXing))
					.getText().toString();
			if (TextUtils.isEmpty(etLeiXing)) {
				etLeiXing = "1";
			}
			String etBingLi = ((EditText) findViewById(R.id.etBingLiMingCheng))
					.getText().toString();
			if (TextUtils.isEmpty(etBingLi)) {
				etBingLi = "病例一";
			}
			try {
				MyMessage.sendMessage(MyMessage.getMsgBinglimingcheng(
						new Integer(etLeiXing), etBingLi));
				etXianShi.setText(MyMessage.getMsgBinglimingcheng(new Integer(
						etLeiXing), etBingLi));
			} catch (Exception e) {
				MyToast.showToast(this, "请检查输入内容");
			}
			break;
		case R.id.btnFSXianShiPingJia:
			String etPingJia = ((EditText) findViewById(R.id.etPingJia))
					.getText().toString();
			if (TextUtils.isEmpty(etPingJia)) {
				etPingJia = "评价内容";
			}
			try {
				MyMessage.sendMessage(MyMessage
						.getMsgXianshipingjia_xianShi(etPingJia));
				etXianShi.setText(MyMessage
						.getMsgXianshipingjia_xianShi(etPingJia));
			} catch (Exception e) {
				MyToast.showToast(this, "请检查输入内容");
			}
			break;
		case R.id.btnFSXianShiPingJia2:
			MyMessage.sendMessage(MyMessage.getMsgXianshipingjia_buXianShi());
			etXianShi.setText(MyMessage.getMsgXianshipingjia_buXianShi());
			break;
		case R.id.btnFSBingQingBianHua:
			String etZhuangTaiId = ((EditText) findViewById(R.id.etZhuangTaiId))
					.getText().toString();
			if (TextUtils.isEmpty(etZhuangTaiId)) {
				etZhuangTaiId = "1";
			}
			try {
				MyMessage.sendMessage(MyMessage
						.getMsgJiaoshiquerenbingqingbianhua(new Integer(
								etZhuangTaiId)));
				etXianShi.setText(MyMessage
						.getMsgJiaoshiquerenbingqingbianhua(new Integer(
								etZhuangTaiId)));
			} catch (Exception e) {
				MyToast.showToast(this, "请检查输入内容");
			}
			break;
		case R.id.btnFSXunLianZhuangTaiJieShou:
			String etXunLianZhuangTai = ((EditText) findViewById(R.id.etXunLianZhuangTai))
					.getText().toString();
			if (TextUtils.isEmpty(etXunLianZhuangTai)) {
				etZhuangTaiId = "1";
			}
			try {
				MyMessage
						.sendMessage(MyMessage
								.getMsgXunlianzhuangtai(new Integer(
										etXunLianZhuangTai)));
				etXianShi.setText(MyMessage.getMsgXunlianzhuangtai(new Integer(
						etXunLianZhuangTai)));
			} catch (Exception e) {
				MyToast.showToast(this, "请检查输入内容");
			}
			break;
		case R.id.btnFSJiaoShiTiShi:
			String etJiaoShiTiShi = ((EditText) findViewById(R.id.etJiaoShiTiShi))
					.getText().toString();
			if (TextUtils.isEmpty(etJiaoShiTiShi)) {
				etJiaoShiTiShi = "1";
			}
			try {
				MyMessage.sendMessage(MyMessage
						.getMsgJiaoshitishi(etJiaoShiTiShi));
				etXianShi.setText(MyMessage.getMsgJiaoshitishi(etJiaoShiTiShi));
			} catch (Exception e) {
				MyToast.showToast(this, "请检查输入内容");
			}
			break;
		case R.id.btnFSSuoYaoXueShengJiZhuangTai:
			MyMessage.sendMessage(MyMessage.getMsgSuoyaoxueshengjizhuangtai());
			etXianShi.setText(MyMessage.getMsgSuoyaoxueshengjizhuangtai());
			break;
		case R.id.btnFSXunLianZhuangTai:
			String etZhuangTai = ((EditText) findViewById(R.id.etZhuangTai))
					.getText().toString();
			if (TextUtils.isEmpty(etZhuangTai)) {
				etZhuangTaiId = "1";
			}
			String etLeiXing1 = ((EditText) findViewById(R.id.etBingLiLeiXing1))
					.getText().toString();
			if (TextUtils.isEmpty(etLeiXing1)) {
				etLeiXing1 = "1";
			}
			String etBingLi1 = ((EditText) findViewById(R.id.etBingLiMingCheng1))
					.getText().toString();
			if (TextUtils.isEmpty(etBingLi1)) {
				etBingLi1 = "病例一";
			}
			try {
				MyMessage.sendMessage(MyMessage
						.getMsgJiaoshijixunlianzhuangtai(new Integer(
								etZhuangTai), new Integer(etLeiXing1),
								etBingLi1));
				etXianShi.setText(MyMessage.getMsgJiaoshijixunlianzhuangtai(
						new Integer(etZhuangTai), new Integer(etLeiXing1),
						etBingLi1));
			} catch (Exception e) {
				MyToast.showToast(this, "请检查输入内容");
			}
			break;
		// case R.id.btnJSBiaoDan:
		// testReciveMsg(MyMessage.getMsgTestBiaodan(15, 1, 1, 1, "内容"));
		// etXianShi.setText(MyMessage.getMsgTestBiaodan(15, 1, 1, 1, "内容"));
		// // testReciveMsg(MyMessage.getMsgTestBiaodan(15, 1, 1, 1, "1"));
		// break;
		// case R.id.btnJSBingRenWanDaiXinXi:
		// testReciveMsg(MyMessage.getMsgTestBingrenwandaixinxi("姓名", "性别",
		// "13", "12345", "23", "科室", "无过敏史", "诊断"));
		// etXianShi.setText(MyMessage.getMsgTestBingrenwandaixinxi("姓名",
		// "性别", "13", "12345", "23", "科室", "无过敏史", "诊断"));
		// // testReciveMsg(MyMessage.getMsgTestBingrenwandaixinxi("1", "1",
		// // "1",
		// // "1", "1", "1", "1", "1"));
		// break;
		// case R.id.btnJSGengGaiYiZhuZhuangTai:
		// testReciveMsg(MyMessage.getMsgTestGenggaiyizhuzhuangtai(1, 1, 5));
		// etXianShi.setText(MyMessage
		// .getMsgTestGenggaiyizhuzhuangtai(1, 1, 5));
		// break;
		// case R.id.btnJSJiaoZhengSheBeiShiJian:
		// testReciveMsg(MyMessage.getMsgTestJiaozhengshebeishijian(2017, 10,
		// 10, 5, 20, 20));
		// etXianShi.setText(MyMessage.getMsgTestJiaozhengshebeishijian(2017,
		// 10, 10, 5, 20, 20));
		// break;
		// case R.id.btnJSSheBeiZhuangTaiA0:
		// testReciveMsg(MyMessage.getMsgTestShebeizhuangtaiA0(1, 1));
		// etXianShi.setText(MyMessage.getMsgTestShebeizhuangtaiA0(1, 1));
		// break;
		// case R.id.btnJSSheBeiZhuangTaiAD:
		// testReciveMsg(MyMessage.getMsgTestShebeizhuangtaiAd(1, 1));
		// etXianShi.setText(MyMessage.getMsgTestShebeizhuangtaiAd(1, 1));
		// break;
		default:
			break;
		}
	}

	@Override
	protected void HandlerMessage(Message msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exc() {
		// TODO Auto-generated method stub

	}
}
