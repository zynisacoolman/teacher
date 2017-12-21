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
 * Created by zyn on 2017/12/20.
 */

public class YZDLongStopAdapter extends BaseAdapter {
    Context context;
    int page;
    public YZDLongStopAdapter(Context mcontext,int mpage) {
        context = mcontext;
        page=mpage;

    }

    @Override
    public int getCount() {
        return UserMessage.YZDlongstop.size()-30*page>30?30:UserMessage.YZDlongstart.size()-30*page;
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
            convertView = View.inflate(context, R.layout.item_yzdlong_stop, null);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder) convertView.getTag();
        }
        vh.fvData.setText(UserMessage.YZDlongstop.get(30*page+position).get(0));
        vh.fvTime.setText(UserMessage.YZDlongstop.get(30*page+position).get(1));
        vh.fvYssign.setText(UserMessage.YZDlongstop.get(30*page+position).get(2));
        vh.fvHssign.setText(UserMessage.YZDlongstop.get(30*page+position).get(3));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.fv_data)
        FitHeightTextView fvData;
        @BindView(R.id.fv_time)
        FitHeightTextView fvTime;
        @BindView(R.id.fv_yssign)
        FitHeightTextView fvYssign;
        @BindView(R.id.fv_hssign)
        FitHeightTextView fvHssign;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
