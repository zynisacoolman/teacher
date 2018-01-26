package cn.jucheng.www.hulisiwei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jucheng.www.hulisiwei.R;

/**
 * Created by zyn on 2018/1/15.
 */

public class AdapterblzgTab1 extends BaseAdapter {
    ArrayList arrayList;
    Context context;
    private LayoutInflater mInflater;


    public AdapterblzgTab1(Context ct, ArrayList al) {
        arrayList = al;
        context = ct;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        arrayList.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
//            convertView = View.inflate(context, R.layout.lstitem_blzg_tab1, parent);
            convertView = mInflater.inflate(R.layout.lstitem_blzg_tab1, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }
        vh=(ViewHolder)convertView.getTag();
        vh.index.setText(String.format("%s",position+1));
        vh.yznr.setText(arrayList.get(position).toString());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.index)
        TextView index;
        @BindView(R.id.yznr)
        TextView yznr;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
