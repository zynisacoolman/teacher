package cn.jucheng.www.hulisiwei.widget;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import cn.jucheng.jclibs.socket.MyGlobal;
import cn.jucheng.jclibs.socket.WorkService;
import cn.jucheng.jclibs.tools.DataUtils;
import cn.jucheng.jclibs.tools.MyLog;

public class MyMessage {
	private static final String TAG = "MyMessage";
	// TODO 常量
	/** 1、系统标识 */
	public static final String D_XITONGBIAOSHI = "4F";
	/** 2-1设备标识 */
	public static final String D_BANBENHAO = "0100";
	/** 2-2对方，和我们通信的那一方 */
	public static final String D_SHEBEI_DUIFANG = "6831";
	/** 3、本程序 */
	public static final String D_SHEBEI_RUANJIAN = "6830";
	/** 4-1命令字-备案 */
	public static final int MLZ_BEIAN = 0x00A6;
	/** 4-2命令字-心跳检测 */
	public static final int MLZ_XINTIAOJIANCE = 0x00A5;
	/** 4-3命令字-设备时间 */
	public static final int MLZ_SBSJ = 0x01A0;
	/** 4-4、命令字-病例名 */
	public static final int MLZ_BLM = 0x0E10;
	/** 5、命令字-状态改变命令 */
	public static final int MLZ_ZTGB = 0x0E11;
	/** 6、命令字-学会操作信息命令 */
	public static final int MLZ_XSCZ = 0x0E12;
	/** 7、命令字-评价学生*/
	public static final int MLZ_PJXS = 0X0E13;
	/** 8、命令字-学生通知教师病情变化 */
	public static final int MLZ_XSTZJS = 0x0E14;
	/** 9、命令字-教师确认病情变化 */
	public static final int MLZ_JZQRBQ = 0x0E15;
	/** 10、命令字-快进 */
	public static final int MLZ_KJ = 0x0E16;
	/** 11、命令字-训练状态接受 */
	public static final int MLZ_XLJS = 0x0E17;
	/** 12、命令字-转抄医嘱 */
	public static final int MLZ_ZCYZ = 0x0E18;
	/** 13、命令字-校正训练总时间 */
	public static final int MLZ_JZZSJ = 0x0E1C;
	/** 14、命令字-教师提示 */
	public static final int MLZ_JSTS = 0x0E1E;
	/** 15、命令字- 学生填写的各种表单 */
	public static final int MLZ_GZBD = 0x0E1F;
	/** 16、命令字-设备状态以及电量 */
	public static final int MLZ_DIANLIANG = 0x00A0;
	/** 17、收应答设备状态命令字 */
	public static final int MLZ_SHOUYINGDASB = 0xAD;
	/** 19、索要学生机状态*/
	public static final int MLZ_SYXSJZT = 0x0E20;
	/** 20、主动发送当前教师机的训练状态*/
	public static final int MLZ_FSSLZT = 0x0E21;
	// TODO 发送的数据
	/** 心跳检测 */
	private static final String MSG_XINTIAOJIANCE = "4F6830 0100 016831 0000000000000000000000000000 00A5 0000 00";
	/** 设备备案 */
	private static final String MSG_BEIAN = "4F6830 0100 016831 0000000000000000000000000000 00A6 0000 00";
	/** 发送病例名称 */
	private static final String MSG_BINGLIMINGCHENG = "4F6830 0100 016831 0000000000000000000000000000 0E10 %04x %02x%02x%04x %04x";
	/** 7显示评价 */
	private static final String MSG_XIANSHIPINGJIA = "4F6830 0100 016831 0000000000000000000000000000 0E13 %04x %02x %04x";
	/** 不显示评价 */
	private static final String MSG_XIANSHIPINGJIA_BUXIANSHI = "4F6830 0100 016831 0000000000000000000000000000 0E13 %02x %02x 00";
	/** 教师确认病情变化 */
	private static final String MSG_JIAOSHIQUERENBINGQINGBIANHUA = "4F6830 0100 016831 0000000000000000000000000000 0E15 0002 %04x 00";
	/** 快进 */
	private static final String MSG_KUAIJIN = "4F6830 0100 016831 0000000000000000000000000000 0E16 0001 %02x 00";
	/** 训练状态接受 */
	private static final String MSG_XUNLIANZHUANGTAI = "4F6830 0100 016831 0000000000000000000000000000 0E17 0001 %02x 00";
	/** 教师提示 */
	private static final String MSG_JIAOSHITISHI = "4F6830 0100 016831 0000000000000000000000000000 0E1E %04x %04x";
	/** 索要当前学生机状态 */
	private static final String MSG_SUOYAOXUESHENGJIZHUANGTAI = "4F6830 0100 016831 0000000000000000000000000000 0E20 0000  00";
	/** 主动发送当前教师机的训练状态 */
	private static final String MSG_JIAOSHIJIXUNLIANZHUANGTAI = "4F6830 0100 016831 0000000000000000000000000000 0E21 %04x %02x%02x%02x%04x %04x";
	/**设备状态以及电量*/
	private static final String MSG_SHEBEIDIANLIANG = "4F6830 0100 016831 0000000000000000000000000000 0E22 ";
	// TODO 用于测试的接收的数据
	/** 校正设备时间 */
	private static final String MSG_TEST_JIAOZHENGSHEBEISHIJIAN = "4F6831 0100 016830 0000000000000000000000000000 01A0 0007 %04x%02x%02x%02x%02x%02x 00";
	/** 状态改变 */
	private static final String MSG_TEST_ZHUANGTAIGAIBIAN = "4F6831 0100 016830 0000000000000000000000000000 0E11 0002 %04x 00";
	/** 学生操作信息描述 */
	private static final String MSG_TEST_XUESHENGCAOZUOXINXI = "4F6831 0100 016830 0000000000000000000000000000 0E12 %04x %02x %04x %02x%02x%02x %02x %04x %02x %02x %04x";
	/** 学生通知教师病情变化 */
	private static final String MSG_TEST_BINGQINGBIANHUA = "4F6831 0100 016830 0000000000000000000000000000 0E14 %04x %04x %04x";
	/** 训练状态接收 */
	private static final String MSG_TEST_XUNLIANGZHUANGTAI = "4F6831 0100 016830 0000000000000000000000000000 0E17 0001 %02x 00";
	/** 转抄医嘱 */
	private static final String MSG_TEST_ZHAUNCHAOYIZHU = "4F6831 0100 016830 0000000000000000000000000000 0E18 %04x %02x %04x %04x ";
	/** 校正训练总时间 */
	private static final String MSG_TEST_JIAOZHENGXUNLIANZONGSHIJIAN = "4F6831 0100 016830 0000000000000000000000000000 0E1C 0006 %02x %02x %02x %02x %02x %02x 00";
	/** 学生填写的各种表单 */
	private static final String MSG_TEST_BIAODAN = "4F6831 0100 016830 0000000000000000000000000000 0E1F %04x";
	/** 回复索要当前学生机状态 */
	private static final String MSG_TEST_HUIFUSUOYAOXUESHENGJIZHUANGTAI = "4F6831 0100 016830 0000000000000000000000000000 0E20 0001 %02x 00";

	/**
	 * @return the msgXintiaojiance
	 */
	public static String getMsgXintiaojiance() {
		return MSG_XINTIAOJIANCE;
	}

	/**
	 * @return the msgBeian
	 */
	public static String getMsgBeian() {
		return MSG_BEIAN;
	}

	public static String getMsgBinglimingcheng(int bingLiType, String bingLiName) {
		String bingLiName2 = HexadecimalConver.getHexResult(bingLiName);
		int bingLiNameLen = bingLiName2.length() / 2;
		return String.format(MSG_BINGLIMINGCHENG, bingLiNameLen + 4, 1,
				bingLiType, bingLiNameLen) + bingLiName2 + " 00";
	}

	public static String getMsgXianshipingjia_xianShi(String pingJia) {
		String pingJia2 = HexadecimalConver.getHexResult(pingJia);
		int pingJiaLen = pingJia2.length() / 2;
		return String.format(MSG_XIANSHIPINGJIA, pingJiaLen + 3, 1, pingJiaLen)
				+ pingJia2 + " 00";
	}

	public static String getMsgXianshipingjia_buXianShi() {
		return String.format(MSG_XIANSHIPINGJIA_BUXIANSHI, 2);
	}

	public static String getMsgJiaoshiquerenbingqingbianhua(int zhuangTaiId) {
		return String.format(MSG_JIAOSHIQUERENBINGQINGBIANHUA, zhuangTaiId);
	}

	public static String getMsgKuaijin(int kuaiJinBeiSu) {
		return String.format(MSG_KUAIJIN, kuaiJinBeiSu);
	}

	public static String getMsgXunlianzhuangtai(int zhuangTai) {
		return String.format(MSG_XUNLIANZHUANGTAI, zhuangTai);
	}

	public static String getMsgJiaoshitishi(String tiShi) {
		String tiShi2 = HexadecimalConver.getHexResult(tiShi);
		int tiShiLen = tiShi2.length() / 2;
		return String.format(MSG_JIAOSHITISHI, tiShiLen + 2, tiShiLen) + tiShi2
				+ " 00";
	}

	public static String getMsgSuoyaoxueshengjizhuangtai() {
		return MSG_SUOYAOXUESHENGJIZHUANGTAI;
	}

	public static String getMsgJiaoshijixunlianzhuangtai(int zhuangTai,
			int bingLiType, String bingLiName) {
		String bingLiName2 = HexadecimalConver.getHexResult(bingLiName);
		int bingLiNameLen = bingLiName2.length() / 2;
		return String.format(MSG_JIAOSHIJIXUNLIANZHUANGTAI, bingLiNameLen + 5,
				zhuangTai, 1, bingLiType, bingLiNameLen) + bingLiName2 + " 00";
	}

	public static String getMsgTestJiaozhengshebeishijian(int nian, int yue,
			int ri, int shi, int fen, int miao) {
		return String.format(MSG_TEST_JIAOZHENGSHEBEISHIJIAN, nian, yue, ri,
				shi, fen, miao);
	}

	public static String getMsgTestZhuangtaigaibian(int zhuangTaiId) {
		return String.format(MSG_TEST_ZHUANGTAIGAIBIAN, zhuangTaiId);
	}

	public static String getMsgTestXueshengcaozuoxinxi(int yiZhuZhuangTai,
			int zhuangTaiId, int shi, int fen, int miao, int yiZhuLieXing,
			int yiZhuHangHao, int caoZuoType, int caoZuoTypeNeiRong,
			String caoZuo) {// 11
		String caoZuo2 = HexadecimalConver.getHexResult(caoZuo);
		int caoZuoLen = caoZuo2.length() / 2;
		return String.format(MSG_TEST_XUESHENGCAOZUOXINXI, caoZuoLen + 13,
				yiZhuZhuangTai, zhuangTaiId, shi, fen, miao, yiZhuLieXing,
				yiZhuHangHao, caoZuoType, caoZuoTypeNeiRong, caoZuoLen)
				+ caoZuo2 + " 00";
	}

	public static String getMsgTestBingqingbianhua(int zhuangTaiId,
			String bingQing) {
		String bingQing2 = HexadecimalConver.getHexResult(bingQing);
		int bingQingLen = bingQing2.length() / 2;
		return String.format(MSG_TEST_BINGQINGBIANHUA, bingQingLen + 4,
				zhuangTaiId, bingQingLen) + bingQing2 + " 00";
	}

	public static String getMsgTestXunliangzhuangtai(int zhuangTai) {
		return String.format(MSG_TEST_XUNLIANGZHUANGTAI, zhuangTai);
	}

	public static String getMsgTestZhaunchaoyizhu(int yiZhuType,
			int yiZhuHangHao, String huShiXingMing) {
		String huShiXingMing2 = HexadecimalConver.getHexResult(huShiXingMing);
		int huShiXingMingLen = huShiXingMing2.length() / 2;
		return String.format(MSG_TEST_ZHAUNCHAOYIZHU, huShiXingMingLen + 5,
				yiZhuType, yiZhuHangHao, huShiXingMingLen)
				+ huShiXingMing2
				+ " 00";
	}

	public static String getMsgTestJiaozhengxunlianzongshijian(int shi,
			int fen, int miao, int shi1, int fen1, int miao1) {
		return String.format(MSG_TEST_JIAOZHENGXUNLIANZONGSHIJIAN, shi, fen,
				miao, shi1, fen1, miao1);
	}

	public static String getMsgTestBiaodan(int biaoDanType, String biaoDanNeiRen) {
		return String.format(MSG_TEST_BIAODAN, biaoDanNeiRen.length() / 2, 1);
	}

	public static String getMsgTestHuifusuoyaoxueshengjizhuangtai(int zhuangTai) {
		return String
				.format(MSG_TEST_HUIFUSUOYAOXUESHENGJIZHUANGTAI, zhuangTai);
	}

	public static void sendMessage(String msg) {
		msg = msg.replace(" ", "");
		byte[] buf = DataUtils.HexStringToBytes(msg);
		// MyLog.d(TAG, "发送消息:" + msg);
		if (WorkService.workThread != null
				&& WorkService.workThread.isConnected()) {
			Bundle data = new Bundle();
			data.putByteArray(MyGlobal.BYTESPARA1, buf);
			data.putInt(MyGlobal.INTPARA1, 0);
			data.putInt(MyGlobal.INTPARA2, buf.length);
			WorkService.workThread.handleCmd(MyGlobal.CMD_WRITE, data);
		} else {
			MyLog.e(TAG, "发送消息时未连接");
		}
	}

	public static void sendMessage(final String msg, long delay) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				sendMessage(msg);
			}
		}, delay);
	}

}
