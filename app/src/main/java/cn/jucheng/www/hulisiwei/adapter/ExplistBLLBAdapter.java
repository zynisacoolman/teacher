package cn.jucheng.www.hulisiwei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.interfaca.OnBllbSonClickListener;

/**
 * Created by admin on 公元2017-11-28.
 */

public class ExplistBLLBAdapter extends BaseExpandableListAdapter {
    Context context;
    String[] father;
    String[][] son;
    OnBllbSonClickListener onBllbSonClickListener;
    private int[] selectedItem;

    public ExplistBLLBAdapter(Context context, String[] father, String[][] son, OnBllbSonClickListener onBllbSonClickListener) {
        this.father = father;
        this.son = son;
        this.context = context;
        this.selectedItem = new int[]{-1, -1};
        this.onBllbSonClickListener=onBllbSonClickListener;
    }

    //获取分组数量
    @Override
    public int getGroupCount() {
        return father.length;
    }

    //获取指定分组数据
    @Override
    public int getChildrenCount(int i) {
        return son[i].length;
    }

    //获取指定分组数据
    @Override
    public Object getGroup(int i) {
        return father[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return i1;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        View mview = view;
        Groupviewholder vh = null;
        if (view == null) {
            mview = View.inflate(context, R.layout.item_bllb_father, null);
            vh = new Groupviewholder();
            vh.iv = (ImageView) mview.findViewById(R.id.iv_bllb_item);
            vh.tv = (TextView) mview.findViewById(R.id.fhtv_bllb_item);
            vh.ll = (LinearLayout) mview.findViewById(R.id.ll_item_bllb);
            mview.setTag(vh);
        } else {
            vh = (Groupviewholder) view.getTag();
        }
        vh.tv.setText(father[groupPosition]);
        if (son[groupPosition].length == 0) {
            vh.iv.setVisibility(View.INVISIBLE);
        } else {
            vh.iv.setVisibility(View.VISIBLE);
        }
        if (b) {
            vh.iv.setImageResource(R.drawable.btn_zk);
        } else {
            vh.iv.setImageResource(R.drawable.btn_ss);
        }
        return mview;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        ChildViewholder cvh;
        if (view == null) {
            view = View.inflate(context, R.layout.item_bllb_son, null);
            cvh = new ChildViewholder(view);
            cvh.llItemBllb.setOnClickListener(cvh);
            view.setTag(cvh);
        } else {
            cvh = (ChildViewholder) view.getTag();
        }
        //设置son item的 文本
        cvh.fhtvBllbItem.setText(son[groupPosition][childPosition]);
        //在viewholder中记录当前子选项
        cvh.childPosition = childPosition;
        cvh.groupPosition = groupPosition;
        if (selectedItem[0] == groupPosition && selectedItem[1] == childPosition) {  //判断当前条目是否被选中
//            cvh.llItemBllb.setSelected(true);
            cvh.llItemBllb.setBackgroundResource(R.drawable.bllb_xz_bg);
        } else {
//            cvh.llItemBllb.setSelected(false);
            cvh.llItemBllb.setBackgroundResource(R.color.bg_bgcolor2);
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    //设置 groupViewholder
    static class Groupviewholder {
        TextView tv;
        LinearLayout ll;
        ImageView iv;
    }

    class ChildViewholder implements View.OnClickListener {
        @BindView(R.id.fhtv_bllb_item)
        TextView fhtvBllbItem;
        @BindView(R.id.ll_item_bllb)
        LinearLayout llItemBllb;
        public ChildViewholder(View v) {
            ButterKnife.bind(this,v);
        }

        public int groupPosition;
        public int childPosition;

        @Override
        public void onClick(View v) {
            selectedItem = new int[]{groupPosition, childPosition}; //将被选中的条目记录到adapter中
            notifyDataSetChanged();  //刷新adapter 内部数据，从而使界面改变
            onBllbSonClickListener.onbllbSonClickListener(groupPosition,childPosition);
        }
    }
}
