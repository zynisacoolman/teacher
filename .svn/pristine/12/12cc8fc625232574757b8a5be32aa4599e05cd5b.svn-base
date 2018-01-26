package cn.jucheng.www.hulisiwei.customcontrols;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.jucheng.www.hulisiwei.R;

/**
 * 项目名称：OSP_Teacher 类名称：BLzgView 类描述：病例转归图的效果 创建人：Android 创建时间：2017年8月24日
 * 下午3:17:38 修改人：Android 修改时间：2017年8月24日 下午3:17:38 修改备注：
 *
 * @version
 */
public class ItemBlzgView extends RelativeLayout {
    private Button blzg_btn;
    private TextView blzg_title_tv;

    public ItemBlzgView(Context context) {
        this(context,null);
    }

    public ItemBlzgView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_blzg, this, true);
        blzg_title_tv=(TextView) findViewById(R.id.tv_title);
        blzg_btn=(Button) findViewById(R.id.btn_item);
    }
    public void setTitleText(String tString){
        blzg_title_tv.setText(tString);
    }
    public void setBtnClickListener(OnClickListener onClickListener){
        if (onClickListener!=null) {
            blzg_btn.setOnClickListener(onClickListener);
        }
    }
    public void setBtnBackground(Drawable background){
        blzg_btn.setBackground(background);
    }
    //更改btn背景

    //如果需要其他的需求再接着写
}
