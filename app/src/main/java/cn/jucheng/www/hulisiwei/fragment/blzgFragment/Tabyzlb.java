package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;

/**
 * Created by zyn on 2018/1/8.
 */

public class Tabyzlb extends BaseFragment {

    @Override
    protected int getID() {
        return R.layout.activity_about;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {


    }
}
