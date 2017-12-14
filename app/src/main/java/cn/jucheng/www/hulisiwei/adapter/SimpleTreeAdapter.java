package cn.jucheng.www.hulisiwei.adapter;

/**
 * Created by zyn on 2017/12/6.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.databean.blxqbean.Node;


public class SimpleTreeAdapter<T> extends TreeListViewAdapter<T>
{

    public SimpleTreeAdapter(ListView mTree, Context context, List<T> datas,
                             int defaultExpandLevel) throws IllegalArgumentException,
            IllegalAccessException
    {
        super(mTree, context, datas, defaultExpandLevel);
    }

    @Override
    public View getConvertView(Node node , int position, View convertView, ViewGroup parent)
    {

        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.item_bllb_father, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) convertView
                    .findViewById(R.id.iv_bllb_item);
            viewHolder.label = (TextView) convertView
                    .findViewById(R.id.fhtv_bllb_item);
            convertView.setTag(viewHolder);

        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (node.getIcon() == -1)
        {
            viewHolder.icon.setVisibility(View.INVISIBLE);
        } else
        {
            viewHolder.icon.setVisibility(View.VISIBLE);
            viewHolder.icon.setImageResource(node.getIcon());
        }
        viewHolder.label.setText(node.getName());

        return convertView;
    }

    private final class ViewHolder
    {
        ImageView icon;
        TextView label;
    }

}
