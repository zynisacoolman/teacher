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

public class YZDTempLeftListItem extends BaseAdapter {
    //page是第几页
    int page;
    Context context;

    public YZDTempLeftListItem(Context mcontext, int mpage) {
        context = mcontext;
        page = mpage;
    }

    @Override
    public int getCount() {
        return UserMessage.YZDtempleft.size()-page*31>31?31:UserMessage.YZDtempleft.size()-page*31;
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
            convertView = View.inflate(context, R.layout.item_yzdlong_start, parent);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder) convertView.getTag();
        }
        //positon是根据表格纵向数量和页数来确定的
        int positions=page*31+position;
            vh.fvData.setText(UserMessage.YZDtempleft.get(positions).get(0));
            vh.fvTime.setText(UserMessage.YZDtempleft.get(positions).get(1));
            vh.fvYz.setText(UserMessage.YZDtempleft.get(positions).get(2));
            vh.fvTsign.setText(UserMessage.YZDtempleft.get(positions).get(3));
        return convertView;
    }
    static class ViewHolder {
        @BindView(R.id.fv_data)
        FitHeightTextView fvData;
        @BindView(R.id.fv_time)
        FitHeightTextView fvTime;
        @BindView(R.id.fv_yz)
        FitHeightTextView fvYz;
        @BindView(R.id.fv_tsign)
        FitHeightTextView fvTsign;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
