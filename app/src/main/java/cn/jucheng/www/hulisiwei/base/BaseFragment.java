package cn.jucheng.www.hulisiwei.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by w on 2017-11-22.
 */

public abstract class BaseFragment extends Fragment {
    private View view;
    private Activity mActivity;
    private Unbinder unbinder;
    //casejson地址
    protected static String BLPath2 = Environment.getExternalStorageDirectory() +
            File.separator +
            "jucheng" + File.separator +
            "hulisiwei" + File.separator+
            "case.json";

    //获取布局文件

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
    /**
     * 获得全局的，防止使用getActivity()为空
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getID(), container,false);
        EventBus.getDefault().register(this);//在当前界面注册一个订阅者
        return view;
    }


    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();

    }
    protected abstract int getID();

}
