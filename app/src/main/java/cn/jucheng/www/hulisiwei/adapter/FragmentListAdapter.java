package cn.jucheng.www.hulisiwei.adapter;

import android.app.Fragment;
import android.app.FragmentTransaction;

import java.util.HashMap;

import cn.jucheng.www.hulisiwei.databean.blxqbean.Node;

/**
 * Created by zyn on 2017/12/8.
 */

public class FragmentListAdapter{

    private HashMap<Integer,Fragment>  hashmap;
    private TreeListViewAdapter lv;
    int fragmentContentid;
    int currentitem;
    private OnListviewExtraCheckedChangedListener onListviewExtraCheckedChangedListener; // 用于让调用者在切换单子时候增加新的功能
    private android.app.FragmentManager fragmentManager;//Fragment 管理

    public FragmentListAdapter(android.app.FragmentManager manager,
                               TreeListViewAdapter lv,//左边listview
                               HashMap<Integer,Fragment> map,//存放fragment的map
                               int fragmentContentId,//放fragment的控件id
                               int index){//当前显示fragment id
        this.hashmap = map;
        this.lv = lv;
        this.fragmentContentid = fragmentContentId;
        this.fragmentManager = manager;
        this.currentitem=index;
        // 显示index对应的Fragment
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(fragmentContentId, hashmap.get(index));
        ft.commit();
        //currentitem是当前fragment的编号，放在构造函数中初始化
        currentitem = index;
        lv.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
            @Override
            public void onClick(Node node, int position) {
                //判断是否为叶子节点
                if(node.isLeaf()){
//                    打开position位置的fragment
                    Fragment fragment = hashmap.get(position);
                    FragmentTransaction ft=fragmentManager.beginTransaction();
                    hashmap.get(currentitem).onPause();
                    //判断当前fragment是不是已经被添加
                    if (fragment.isAdded()) {
                        fragment.onResume(); // 启动目标tab的onResume()
                    } else {
                        ft.add(fragmentContentid, fragment);
                    }
                    ft.show(fragment);
                    ft.commit();
                    if(onListviewExtraCheckedChangedListener==null)
                        onListviewExtraCheckedChangedListener.OnListviewExtraCheckedChanged(node,position);
                }else{
                    //不是叶子节点 不执行操作
                    return;
                }

            }
        });
    }



    /**
     * 切换fragment额外功能功能接口
     */
    public interface OnListviewExtraCheckedChangedListener {
        public void OnListviewExtraCheckedChanged(Node node, int index);
    }
}
