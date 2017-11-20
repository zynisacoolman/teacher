package cn.jucheng.www.hulisiwei.decoding;

import android.annotation.SuppressLint;
import android.os.Handler;
import cn.jucheng.jclibs.tools.DataUtils;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.MyBaseActivity;
import cn.jucheng.www.hulisiwei.widget.MyMessage;

@SuppressLint("DefaultLocale")
public class DecodingLibrary {
	@SuppressWarnings("unused")
	private static final String TAG = "DecodingLibrary";
	/** 用于存放接收数据变量，只要接收了数据就放到此变量中 */
	private static StringBuffer sbMsg = new StringBuffer();
	/** 是否正在处理数据 */
	private boolean isChuLiing = false;
	/** 协议最小长度 */
	private int lenMin = 60;
	private Handler hd;

	public DecodingLibrary(Handler hd) {
		this.hd = hd;
	}

	/** 接收新数据，每从接收到新数据就处理 */
	public void newDataChuLi(byte[] buffer, int len) {
		StringBuilder newMsg = DataUtils.BytesToHexStr(buffer, 0, len);
		sbMsg.append(newMsg);
		// MyLog.d(TAG, "接收的数据：" // + i + " "
		// // + isChuLiing + " len: " + len + " "
		// + newMsg.toString());
		if (!isChuLiing) {
			isComplete();
		}
	}

	/** 检查数据完整性 */
	private void isComplete() {
		isChuLiing = true;
		int i = isContinue(sbMsg, -1, 0);
		boolean xunhuan = false;
		if (sbMsg.length() >= lenMin && i > -1) {
			xunhuan = true;
		}
		while (xunhuan) {
			// MyLog.d(TAG, "tancexinfei 解析开始");
			if (sbMsg.length() - i >= lenMin) {// 最小长度27字节
				if (check(sbMsg, i)) {// 是否满足协议头要求
					// MyLog.d(TAG, "check tongguo");
					// 解析命令字
					int mingLingZi = Integer
							.parseInt(SubStringUtils.substring(sbMsg, i + 44,
									i + 48), 16);
					switch (mingLingZi) {
					// case MyMessage.MLZ_ANYA: {// 按压
					// shendu = Integer
					// .parseInt(SubStringUtils.substring(sbMsg,
					// i + 52, i + 54), 16);
					// weizhi = Integer
					// .parseInt(SubStringUtils.substring(sbMsg,
					// i + 54, i + 56), 16);
					// // isShouZhangLiKai = Integer
					// // .parseInt(SubStringUtils.substring(sbMsg,
					// // i + 56, i + 58), 16) == 0;
					// // MyLog.d(TAG, "tancexinfei 按压shendu：" + shendu);
					// // sendAnYaValue();
					// break;
					// }
					 default:// 其他未在定义中的指令
					 // MyLog.d(TAG, "其他未定义的指令？？" + sbMsg);
					 break;
					}
					i = isContinue(sbMsg, i, i + lenMin);
					if (i == -1) {
						isChuLiing = false;
						return;
					} else {
						continue;
					}
				} else {
					// MyLog.d(TAG, "weitongguo");
					i = isContinue(sbMsg, i, i + 2);
					if (i == -1) {
						isChuLiing = false;
						return;
					} else {
						continue;
					}
				}
			} else {
				// System.out.println("长度不够26");
				// 不够26字节的不能clear,现在的不完整可能跟后面的能组成一个完整的协议
				xunhuan = false;
			}
		} // while end
		isChuLiing = false;
	}



	/** 是否满足协议头要求 */
	private boolean check(StringBuffer sbMsg1, int i) {
		boolean flag = false;
		String tou = SubStringUtils.substring(sbMsg1, i + 0, i + 2)
				.toUpperCase();
		String banBen = SubStringUtils.substring(sbMsg1, i + 6, i + 10);
		if (MyMessage.D_XITONGBIAOSHI.contains(tou)
				&& MyMessage.D_BANBENHAO.contains(banBen)) {// 头和版本号是否满足协议要求
			String muBiaoSheBei = SubStringUtils.substring(sbMsg1, i + 12,
					i + 44).toUpperCase();
			if (muBiaoSheBei.contains(MyMessage.D_SHEBEI_RUANJIAN)) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 根据当前解析位置判断是否后续还有解析内容，返回0表示还有解析内容从0开始解析，返回-1无可解析内容。
	 * 
	 * @param i
	 *            当前处理的位置，-1表示未开始处理
	 * @return 返回继续处理的位置，-1表示没有数据要处理
	 */
	private int isContinue(StringBuffer sbMsg1, int i, int yiChuLiLen) {
		int isXunHuan = sbMsg1.indexOf(MyMessage.D_XITONGBIAOSHI, i == -1 ? 0
				: yiChuLiLen);
		if (isXunHuan == -1) {
			// 输出未处理的不满足条件的数据，用于测试
			// if (yiChuLiLen < sbMsg1.length()) {
			// MyLog.d(TAG, "未处理的数据1:" + yiChuLiLen + "<" + sbMsg.length()
			// + " " + SubStringUtils.substring(sbMsg1, yiChuLiLen));
			// }
			sbMsg1.delete(0, yiChuLiLen);
			return -1;
		} else {
			// 输出未处理的不满足条件的数据，用于测试
			// if (yiChuLiLen < isXunHuan) {
			// MyLog.d(TAG,
			// "未处理的数据2:"
			// + yiChuLiLen
			// + "<"
			// + isXunHuan
			// + " "
			// + SubStringUtils.substring(sbMsg1, yiChuLiLen,
			// isXunHuan));
			// }
			sbMsg1.delete(0, isXunHuan);
			return 0;
		}
	}

	public void initData() {
	}
}