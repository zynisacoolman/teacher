package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.module.UserMessage;

/**
 * Created by zyn on 2017/12/18.
 */

public class YZDLongStartAdapter extends BaseAdapter {
    Context context;

    List<String> listitem;//每一项的数据
    int page;//定义页数,第几页显示第几页的内容

    public YZDLongStartAdapter(Context mcontext,  int mpage) {
        context = mcontext;
        page=mpage;
    }

    @Override
    public int getCount() {
        return UserMessage.YZDlongstart.size()-30*page>30?30:UserMessage.YZDlongstart.size()-30*page;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh ;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_yzdlong_start, parent);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        vh.fvData.setText(UserMessage.YZDlongstart.get(30*page+position).get(0));
        vh.fvTime.setText(UserMessage.YZDlongstart.get(30*page+position).get(1));
        vh.fvYsqm.setText(UserMessage.YZDlongstart.get(30*page+position).get(2));
        vh.fvYz.setText(UserMessage.YZDlongstart.get(30*page+position).get(3));
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.fv_data)
        FitHeightTextView fvData;
        @BindView(R.id.fv_time)
        FitHeightTextView fvTime;
        @BindView(R.id.fv_yz)
        FitHeightTextView fvYz;
        @BindView(R.id.fv_tsign)
        FitHeightTextView fvYsqm;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
