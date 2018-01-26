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

class YZDLonghsAdapter extends BaseAdapter {
    Context context;
    int page;
    public YZDLonghsAdapter(Context mcontext,int mpage) {
        context = mcontext;
        page=mpage;
    }

    @Override
    public int getCount() {
        return UserMessage.YZDlonghssign.size()-30*page>30?30:UserMessage.YZDlonghssign.size()-30*page;
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
            convertView = View.inflate(context, R.layout.item_yzdlong_middle, parent);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh=(ViewHolder) convertView.getTag();
        }
        vh.fvHssign.setText(UserMessage.YZDlonghssign.get(30*page+position).get(0));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.fv_hssign)
        FitHeightTextView fvHssign;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
