package cn.jucheng.www.hulisiwei.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
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





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getID(), container,false);
        unbinder= ButterKnife.bind(this,view);
        EventBus.getDefault().register(this);//在当前界面注册一个订阅者
        return view;
    }


    @Override
    public void onDestroyView(){
        unbinder.unbind();
        super.onDestroyView();
        EventBus.getDefault().unregister(this );

    }
    protected abstract int getID();

}
