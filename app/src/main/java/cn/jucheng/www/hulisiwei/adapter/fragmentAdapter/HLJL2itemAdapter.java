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
 * Created by zyn on 2018/1/18.
 */

public class HLJL2itemAdapter extends BaseAdapter {
    Context myContext;
    int page ;
    public HLJL2itemAdapter(Context context,int mpage) {
        myContext = context;
        page =mpage;
    }


    @Override
    public int getCount() {
        return UserMessage.YBhljlDan.size()-13*page>13?13:UserMessage.YBhljlDan.size()-13*page;
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
        ViewHolder vh ;
        if (convertView == null) {
            convertView = View.inflate(myContext, R.layout.item_ybhljl, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        vh.ftRq.setText(UserMessage.YBhljlDan.get(position+13*page).get(0));
        vh.ftSj.setText(UserMessage.YBhljlDan.get(position+13*page).get(1));
        vh.ftTw.setText(UserMessage.YBhljlDan.get(position+13*page).get(2));
        vh.ftMb.setText(UserMessage.YBhljlDan.get(position+13*page).get(3));
        vh.ftHx.setText(UserMessage.YBhljlDan.get(position+13*page).get(4));
        vh.ftXy.setText(UserMessage.YBhljlDan.get(position+13*page).get(5));
        vh.ftXybhd.setText(UserMessage.YBhljlDan.get(position+13*page).get(6));
        vh.ftLeft.setText(UserMessage.YBhljlDan.get(position+13*page).get(7));
        vh.ftRight.setText(UserMessage.YBhljlDan.get(position+13*page).get(8));
        vh.ftBqgc.setText(UserMessage.YBhljlDan.get(position+13*page).get(9));
        vh.ftSign.setText(UserMessage.YBhljlDan.get(position+13*page).get(10));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.ft_rq)
        FitHeightTextView ftRq;
        @BindView(R.id.ft_sj)
        FitHeightTextView ftSj;
        @BindView(R.id.ft_tw)
        FitHeightTextView ftTw;
        @BindView(R.id.ft_mb)
        FitHeightTextView ftMb;
        @BindView(R.id.ft_hx)
        FitHeightTextView ftHx;
        @BindView(R.id.ft_xy)
        FitHeightTextView ftXy;
        @BindView(R.id.ft_xybhd)
        FitHeightTextView ftXybhd;
        @BindView(R.id.ft_left)
        FitHeightTextView ftLeft;
        @BindView(R.id.ft_right)
        FitHeightTextView ftRight;
        @BindView(R.id.ft_bqgc)
        FitHeightTextView ftBqgc;
        @BindView(R.id.ft_sign)
        FitHeightTextView ftSign;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
