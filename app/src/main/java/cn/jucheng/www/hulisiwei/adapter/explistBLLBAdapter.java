package cn.jucheng.www.hulisiwei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.jucheng.www.hulisiwei.BllbActivity;
import cn.jucheng.www.hulisiwei.MainActivity;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;

/**
 * Created by admin on 公元2017-11-28.
 */

public class explistBLLBAdapter extends BaseExpandableListAdapter
{
    Context context;
    String[] father;
    String[][] son;

    public  explistBLLBAdapter(Context context,String[] father,String[][] son){
        this.father=father;
        this.son=son;
        this.context=context;
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
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View mview = null;
        Groupviewholder vh=null;
        if(view ==null){
            mview=View.inflate(context, R.layout.item_bllb_father,viewGroup);
            vh=new Groupviewholder();
            vh.iv=(ImageView)view.findViewById(R.id.iv_bllb_item);
            vh.tv=(FitHeightTextView)view.findViewById(R.id.fhtv_bllb_item);
            vh.ll=(LinearLayout)view.findViewById(R.id.ll_item_bllb);
            mview.setTag(vh);
        }else {
            mview = view;
        }
        vh.tv.setText(father[i-1]);
        if(son[i-1].length==0){
            vh.iv.setVisibility(View.INVISIBLE);
        }else {
            vh.iv.setVisibility(View.VISIBLE);
        }
        if(b){
            vh.iv.setImageResource(R.drawable.btn_zk);
        }else{
            vh.iv.setImageResource(R.drawable.btn_ss);
        }
        return mview;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewholder cvh=null;
        View mView =null;
        if(view ==null){
            mView = View.inflate(context,R.layout.item_bllb_son,viewGroup);
            cvh.tv=(FitHeightTextView)view.findViewById(R.id.fhtv_bllb_item) ;
            cvh.ll=(LinearLayout) view.findViewById(R.id.ll_item_bllb);
            mView.setTag(cvh);
        }else{
            mView =view;
        }
        if(b){
            cvh.ll.setBackgroundResource(R.drawable.bllb_xz_bg);
        }
        return mView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    //设置 groupViewholder
    static class Groupviewholder{
        FitHeightTextView tv ;
        LinearLayout ll;
        ImageView iv ;
    }
    static class ChildViewholder{
        FitHeightTextView tv;
        LinearLayout ll;
    }
}
