package cn.jucheng.www.hulisiwei.customcontrols;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import cn.jucheng.www.hulisiwei.R;

public class MyDialog extends Dialog {

	public MyDialog(Context context, int theme) {
		super(context, theme);
	}

	public static MyDialog makeDialog(Context context, String msg,
			boolean cancelable) {
		MyDialog pd1 = new MyDialog(context, R.style.progress_dialog);
		pd1.setCancelable(cancelable);
		pd1.setContentView(R.layout.dialog);
		pd1.getWindow().setBackgroundDrawableResource(
				android.R.color.transparent);
		((TextView) pd1.findViewById(R.id.id_tv_loadingmsg)).setText(msg);
		return pd1;
	}
}
