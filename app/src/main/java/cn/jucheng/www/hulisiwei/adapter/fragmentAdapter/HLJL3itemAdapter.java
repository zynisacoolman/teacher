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

public class HLJL3itemAdapter extends BaseAdapter {
    Context myContext;
    int page;

    public HLJL3itemAdapter(Context context, int mpage) {
        myContext = context;
        page = mpage;
    }


    @Override
    public int getCount() {
        return UserMessage.CryljlDan.size() - 29 * page > 29 ? 29 : UserMessage.CryljlDan.size() - 29 * page;
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
            convertView = View.inflate(myContext, R.layout.item_cryljl, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.ftSj.setText(UserMessage.YBhljlDan.get(position + 29 * page).get(0));
        vh.ftXm.setText(UserMessage.YBhljlDan.get(position + 29 * page).get(1));
        vh.ftSl.setText(UserMessage.YBhljlDan.get(position + 29 * page).get(2));
        vh.ftXm2.setText(UserMessage.YBhljlDan.get(position + 29 * page).get(3));
        vh.ftSl2.setText(UserMessage.YBhljlDan.get(position + 29 * page).get(4));
        vh.ftQm.setText(UserMessage.YBhljlDan.get(position + 29 * page).get(5));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.ft_sj)
        FitHeightTextView ftSj;
        @BindView(R.id.ft_xm)
        FitHeightTextView ftXm;
        @BindView(R.id.ft_sl)
        FitHeightTextView ftSl;
        @BindView(R.id.ft_xm2)
        FitHeightTextView ftXm2;
        @BindView(R.id.ft_sl2)
        FitHeightTextView ftSl2;
        @BindView(R.id.ft_qm)
        FitHeightTextView ftQm;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
