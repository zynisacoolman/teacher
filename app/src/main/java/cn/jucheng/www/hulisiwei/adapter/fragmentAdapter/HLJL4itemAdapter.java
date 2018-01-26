package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.module.UserMessage;

/**
 * Created by zyn on 2018/1/19.
 */

public class HLJL4itemAdapter extends BaseAdapter {
    Context context;
    int page;

    public HLJL4itemAdapter(Context mcontext ,int mpage){
        context = mcontext;
        page = mpage;
    }
    @Override
    public int getCount() {
        return UserMessage.YchljlDan.size() - 8 * page > 8 ? 8 : UserMessage.YchljlDan.size() - 8 * page;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_ychl, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.日期.setText(UserMessage.YchljlDan.get(position + 8 * page).get(0));
        vh.压疮级别.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(1));
        vh.压疮部位.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(2));
        vh.长.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(3));
        vh.宽.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(4));
        vh.深.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(5));
        vh.日期.setText(UserMessage.YchljlDan.get(position + 8 * page).get(0));
        vh.压疮级别.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(1));
        vh.压疮部位.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(2));
        vh.长.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(3));
        vh.宽.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(4));
        vh.深.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(5));
        vh.水疱.setText(UserMessage.YchljlDan.get(position + 8 * page).get(0));
        vh.黑色.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(1));
        vh.黄色.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(2));
        vh.红色.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(3));
        vh.粉色.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(4));
        vh.无.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(5));
        vh.少.setText(UserMessage.YchljlDan.get(position + 8 * page).get(0));
        vh.多.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(1));
        vh.水状.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(2));
        vh.血性.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(3));
        vh.浓性.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(4));
        vh.发臭.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(5));
        vh.红斑.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(3));
        vh.坏死.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(4));
        vh.水肿.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(5));
        vh.浸润.setText(UserMessage.YchljlDan.get(position + 8 * page).get(0));
        vh.收缩.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(1));
        vh.红疹.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(2));
        vh.处理方式.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(3));
        vh.签名.setText(UserMessage.YBhljlDan.get(position + 8 * page).get(4));
        return convertView;
    }
    static class ViewHolder {
        @BindView(R.id.日期)
        FitHeightTextView 日期;
        @BindView(R.id.压疮级别)
        FitHeightTextView 压疮级别;
        @BindView(R.id.压疮部位)
        FitHeightTextView 压疮部位;
        @BindView(R.id.长)
        FitHeightTextView 长;
        @BindView(R.id.宽)
        FitHeightTextView 宽;
        @BindView(R.id.深)
        FitHeightTextView 深;
        @BindView(R.id.水疱)
        FitHeightTextView 水疱;
        @BindView(R.id.黑色)
        FitHeightTextView 黑色;
        @BindView(R.id.黄色)
        FitHeightTextView 黄色;
        @BindView(R.id.红色)
        FitHeightTextView 红色;
        @BindView(R.id.粉色)
        FitHeightTextView 粉色;
        @BindView(R.id.无)
        FitHeightTextView 无;
        @BindView(R.id.少)
        FitHeightTextView 少;
        @BindView(R.id.多)
        FitHeightTextView 多;
        @BindView(R.id.水状)
        FitHeightTextView 水状;
        @BindView(R.id.血性)
        FitHeightTextView 血性;
        @BindView(R.id.浓性)
        FitHeightTextView 浓性;
        @BindView(R.id.发臭)
        FitHeightTextView 发臭;
        @BindView(R.id.红斑)
        FitHeightTextView 红斑;
        @BindView(R.id.坏死)
        FitHeightTextView 坏死;
        @BindView(R.id.水肿)
        FitHeightTextView 水肿;
        @BindView(R.id.浸润)
        FitHeightTextView 浸润;
        @BindView(R.id.收缩)
        FitHeightTextView 收缩;
        @BindView(R.id.红疹)
        FitHeightTextView 红疹;
        @BindView(R.id.处理方式)
        FitHeightTextView 处理方式;
        @BindView(R.id.签名)
        FitHeightTextView 签名;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
