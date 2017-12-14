package cn.jucheng.www.hulisiwei.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * fragment加载类
 */
public class FragmentTabAdapter implements RadioGroup.OnCheckedChangeListener, OnClickListener {
    private List<Fragment> fragments; // 一个tab页面对应一个Fragment
    private RadioGroup rgs; // 用于切换tab
    private int fragmentContentId; // 放置Fragment区域的View的id

    private int currentTab; // 当前Tab页面索引

    private OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener; // 用于让调用者在切换tab时候增加新的功能
    private FragmentManager fragmentManager;//Fragment 管理
    private Map<Integer, Fragment> fragmentsMap = new HashMap<Integer, Fragment>();

    public FragmentTabAdapter(Fragment fragmentActivity, Map<Integer, Fragment> fragments,
                              int fragmentContentId, RadioGroup rgs, int index) {
        this.fragmentsMap = fragments;
        this.rgs = rgs;
        this.fragmentManager = fragmentActivity.getFragmentManager();
        this.fragmentContentId = fragmentContentId;

        if (index >= fragments.size()) {
            index = 0;
        }
        // 显示index对应的Fragment
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(fragmentContentId, fragments.get(index));
        ft.commit();

        rgs.setOnCheckedChangeListener(this);
    }


    public FragmentTabAdapter(FragmentManager manager, List<Fragment> fragments,
                              int fragmentContentId, RadioGroup rgs, int index) {
        this.fragments = fragments;
        this.rgs = rgs;
        this.fragmentContentId = fragmentContentId;
        this.fragmentManager = manager;
        // 显示index对应的Fragment
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if (index >= fragments.size()) {
            index = 0;
        }
        ft.add(fragmentContentId, fragments.get(index));
        ft.commit();
        currentTab = index;
        rgs.setOnCheckedChangeListener(this);

    }

    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (fragments.size() < 1 && fragmentsMap.size() > 0) {
            Fragment fragment = fragments.get(checkedId);
            FragmentTransaction ft = obtainFragmentTransaction(0);

            getCurrentFragment().onPause(); // 暂停当前tab

            if (fragment.isAdded()) {
                fragment.onResume(); // 启动目标tab的onResume()
            } else {
                ft.add(fragmentContentId, fragment);
            }
            showTab(checkedId); // 显示目标tab
            ft.commit();

            // 如果设置了切换tab额外功能功能接口
            if (null != onRgsExtraCheckedChangedListener) {
                onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(radioGroup, checkedId, checkedId);
            }
        } else {
            for (int i = 0; i < rgs.getChildCount(); i++) {
                Log.d("FragmentTabAdapter", rgs.getChildAt(i).getId() + "--SELECTEDID:" + checkedId);
                try {
                    if (rgs.getChildAt(i).getId() == checkedId && i != currentTab) {
                        Fragment fragment = fragments.get(i);
                        FragmentTransaction ft = obtainFragmentTransaction(i);

                        getCurrentFragment().onPause(); // 暂停当前tab

                        if (fragment.isAdded()) {
                            fragment.onResume(); // 启动目标tab的onResume()
                        } else {
                            ft.add(fragmentContentId, fragment);
                        }
                        showTab(i); // 显示目标tab
                        ft.commit();

                        // 如果设置了切换tab额外功能功能接口
                        if (null != onRgsExtraCheckedChangedListener) {
                            onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(radioGroup, checkedId, i);
                        }

                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 切换tab
     *
     * @param idx
     */
    public void showTab(int idx) {
        if (fragments.size() < 1 && fragmentsMap.size() > 0) {
            Set<Integer> set = fragmentsMap.keySet();
            //Fragment fragment =fragments.get(checkedId);
            FragmentTransaction ft = obtainFragmentTransaction(idx);
            for (Integer index : set) {
                Fragment fragment = fragmentsMap.get(index);
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
                FragmentTransaction ft = obtainFragmentTransaction(idx);

                if (idx == i) {
                    ft.show(fragment);
                } else {
                    ft.hide(fragment);
                }
                ft.commit();
            }
        }
        currentTab = idx; // 更新目标tab为当前tab
    }

    /**
     * 获取一个带动画的FragmentTransaction
     *
     * @param index
     * @return
     */
    private FragmentTransaction obtainFragmentTransaction(int index) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        // 设置切换动画
//        if(index > currentTab){
//            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
//        }else{
//            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
//        }
        return ft;
    }

    public int getCurrentTab() {
        return currentTab;
    }

    public Fragment getCurrentFragment() {
        return fragments.get(currentTab);
    }

    public OnRgsExtraCheckedChangedListener getOnRgsExtraCheckedChangedListener() {
        return onRgsExtraCheckedChangedListener;
    }

    public void setOnRgsExtraCheckedChangedListener(OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
    }

    /**
     * 切换tab额外功能功能接口
     */
    public interface OnRgsExtraCheckedChangedListener {
        public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index);
    }

    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }

}
