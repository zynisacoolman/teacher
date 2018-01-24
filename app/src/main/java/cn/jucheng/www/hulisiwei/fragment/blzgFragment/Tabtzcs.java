package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.interfaca.MessageEventblzg;

/**
 * Created by zyn on 2018/1/8.
 */
//体征参数
public class Tabtzcs extends BaseFragment {
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_5)
    TextView tv5;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_4)
    TextView tv4;
    @BindView(R.id.tv_6)
    TextView tv6;

    @Override
    protected int getID() {
        return R.layout.fragment_blzg_tab3;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEventblzg evnt) {
        if (evnt.getType() == 3) {
            tv1.setText(evnt.getAl().get(0).toString());
            tv2.setText(evnt.getAl().get(1).toString());
            tv3.setText(evnt.getAl().get(2).toString());
            tv4.setText(evnt.getAl().get(3).toString());
            tv5.setText(evnt.getAl().get(4).toString());
            tv6.setText(evnt.getAl().get(5).toString());
        }
    }
}
