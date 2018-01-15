package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjk.tableview.TableView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.interfaca.MessageEventblzg;

/**
 * Created by zyn on 2017/12/14.
 */

public class Tabztzg extends BaseFragment {
    @BindView(R.id.tableview)
    TableView tableView;

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.activity_tabblzg, null);
        return view;
    }
    @Override
    public int getID(){
        return R.layout.activity_tabblzg;
    }

    @Override

    public void onDestroyView() {
        super.onDestroyView();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEventblzg evnt) {
        if(evnt.getType() == 2){
            tableView.setHeaderElevation(0);
//            tableView.setTableAdapter();
        }
    }

    private void listShift() {
    }
}
