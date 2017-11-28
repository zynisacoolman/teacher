package cn.jucheng.www.hulisiwei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

/**
 * Created by admin on 公元2017-11-28.
 */

public class explistBLLBAdapter extends BaseExpandableListAdapter
{
    Context context;
    String[] father;
    String[][] son;

    public explistBLLBAdapter(Context context,String[] father,String[][] son){
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
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
