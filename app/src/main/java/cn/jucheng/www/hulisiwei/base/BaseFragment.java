package cn.jucheng.www.hulisiwei.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by w on 2017-11-22.
 */

public abstract class BaseFragment extends Fragment {
    private View view;
    private Activity mActivity;
    //获取布局文件
    public abstract int getID();
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
    /**
     * 获得全局的，防止使用getActivity()为空
     * @param context
     */
    @Nullable
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getID(), container,false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);//在当前界面注册一个订阅者
        return view;
    }


    @Override
    public void onDestroyView(){
        ButterKnife.bind(this,view).unbind();
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

}
