package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import android.util.Log;
import android.widget.ListView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.adapter.ItemZtzgAdapter;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.interfaca.MessageEventblzg;

/**
 * Created by zyn on 2017/12/14.
 */
//状态转归
public class Tabztzg extends BaseFragment {
    @BindView(R.id.lstzg)
    ListView lst ;
    @Override
    public int getID(){
        return R.layout.fragment_blzg_tab2;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEventblzg evnt) {
        Log.v("不执行","没有错误信息");
        if(evnt.getType() == 2){
            lst.setAdapter(new ItemZtzgAdapter(getActivity(),evnt.getAl()));
        }
    }
}
