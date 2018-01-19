package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import android.widget.ListView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.adapter.AdapterblzgTab1;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.interfaca.MessageEventblzg;

/**
 * Created by zyn on 2018/1/8.
 */
//医嘱列表
public class Tabyzlb extends BaseFragment {
    @BindView(R.id.tab1_yzlb)
    ListView lst;
    @Override
    protected int getID() {
        return R.layout.fragment_blzg_tab1;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEventblzg evnt) {
        if(evnt.getType()==1){
            lst.setAdapter(new AdapterblzgTab1(getActivity(),evnt.getAl()));
        }
    }
}
