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
import cn.jucheng.www.hulisiwei.utils.CommUtils;

/**
 * Created by zyn on 2017/12/18.
 */

public class YZDLongFragmentLEFTitemAdapter extends BaseAdapter {
    Context context;
    List<List<String>> lists;//所有数据

    List<String> listitem;//每一项的数据
    int page;//定义页数,第几页显示第几页的内容

    public YZDLongFragmentLEFTitemAdapter(Context mcontext, List<List<String>> al,int mpage) {
        context = mcontext;
        lists=al;
        page=mpage;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.yzd_long_left_item, parent);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        listitem=lists.get(position);
        vh.fvData.setText( CommUtils.getListString(listitem, 0));
        vh.fvTime.setText(CommUtils.getListString(listitem, 1));
        vh.fvYsqm.setText(CommUtils.getListString(listitem, 2));
        vh.fvYz.setText(CommUtils.getListString(listitem, 3));
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.fv_data)
        FitHeightTextView fvData;
        @BindView(R.id.fv_time)
        FitHeightTextView fvTime;
        @BindView(R.id.fv_yz)
        FitHeightTextView fvYz;
        @BindView(R.id.fv_ysqm)
        FitHeightTextView fvYsqm;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
