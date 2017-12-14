package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjk.tableview.TableView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.BaseFragment;

/**
 * Created by zyn on 2017/12/14.
 */

public class Tab1 extends BaseFragment {
    @BindView(R.id.table_layout)
    TableView tableView;

    Unbinder unbinder;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.activity_tabblzg, null);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }
}
