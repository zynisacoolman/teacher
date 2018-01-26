package cn.jucheng.www.hulisiwei.adapter;

import android.app.Fragment;
import android.app.FragmentTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import cn.jucheng.www.hulisiwei.databean.blxqbean.Node;

/**
 * Created by zyn on 2017/12/8.
 */

public class FragmentListAdapter{
    private List<Fragment> fragments; // 一个tab页面对应一个Fragment
    private HashMap<Integer,Fragment>  hashmap;
    private TreeListViewAdapter lv;
    int fragmentContentid;
    int currentitem;
    private OnListviewExtraClickListener onListviewExtraClickChangedListener; // 用于让调用者在切换单子时候增加新的功能
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
                    Fragment fragment = hashmap.get(node.getId());
                    FragmentTransaction ft=fragmentManager.beginTransaction();
                    hashmap.get(currentitem).onPause();
                    //判断当前fragment是不是已经被添加
                    if (fragment.isAdded()) {
                        fragment.onResume(); // 启动已添加的fragment
                    } else {
                        ft.add(fragmentContentid, fragment);
                    }
                    showTab(node.getId());
                    ft.commit();
                    if(onListviewExtraClickChangedListener!=null){
                        onListviewExtraClickChangedListener.OnListviewExtraCheckedChanged(node,position);
                    }
                }else{
                    //不是叶子节点 不执行操作
                    return;
                }

            }
        });
    }

    public void setOnListviewExtraCheckedChangedListener(OnListviewExtraClickListener onListviewExtraCheckedChangedListener) {
        this.onListviewExtraClickChangedListener = onListviewExtraCheckedChangedListener;
    }
    /**
     * 切换tab
     *
     * @param idx
     */
    public void showTab(int idx) {
        if (hashmap.size() > 0) {
            Set<Integer> set = hashmap.keySet();
            //Fragment fragment =fragments.get(checkedId);
            FragmentTransaction ft = obtainFragmentTransaction(idx);
            for (Integer index : set) {
                Fragment fragment = hashmap.get(index);
                if (idx == index) {
                    ft.show(fragment);
                } else {
                    ft.hide(fragment);
                }
            }
            ft.commit();

        } else {
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                FragmentTransaction ft = fragmentManager.beginTransaction();

                if (idx == i) {
                    ft.show(fragment);
                } else {
                    ft.hide(fragment);
                }
                ft.commit();
            }
        }
        currentitem = idx; // 更新目标tab为当前tab
    }
    public Fragment getCurrentFragment() {
        return fragments.get(currentitem);
    }

    /**
     * 获取一个带动画的FragmentTransaction
     *
     * @return
     */
    private FragmentTransaction obtainFragmentTransaction(int i) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        // 设置切换动画
//        if(index > currentitem){
//            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
//        }else{
//            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
//        }
        return ft;
    }
    /**
     * 切换fragment额外功能功能接口
     */
    public interface OnListviewExtraClickListener {
        void OnListviewExtraCheckedChanged(Node node, int index);
    }
}
