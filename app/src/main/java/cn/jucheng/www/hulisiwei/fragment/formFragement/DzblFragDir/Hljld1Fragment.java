package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.BlxqActivity;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.adapter.fragmentAdapter.YZDLongFragmentAdapter;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;

/**
 * Created by zyn on 2017/12/16.
 * 临时医嘱单
 */

public class Hljld1Fragment extends BaseFragment implements AbsListView.OnScrollListener {

    protected final String TAG="护理记录单首页";
    private View view;
    /**
     * 数据源
     */
    YZDLongFragmentAdapter adapter;
    Unbinder unbinder;
    int pages=1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.adapter_fragmenthljld, null);
        getPage();
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        adapter=new YZDLongFragmentAdapter(getActivity(),pages);
//        OnformDateUpdate(message);
        return view;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {
        int msgType = evnt.getIsMessage();
        String message_str = evnt.getMessage();
        setBiaodanMessage(message_str,msgType);
        adapter.notifyDataSetChanged();
    }
    /**
     * 解析表单信息
     *
     * @param message
     */
    public void setBiaodanMessage(String message,int messageType) {
        switch (messageType){
            case 1://1是表单头部信息
                OnformHeadUpdate(message);
                break;

            default:
                break;
        }
    }

    /**
     * 计算页数
     */
    public void getPage() {
        int a = UserMessage.YZDtempleft.size() / 18;
        if (UserMessage.YZDtempleft.size() > 18) {
            pages = pages + a;
        }
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        String number = (firstVisibleItem+1)+"/" + pages;
        BlxqActivity.setPageNumber(number);
    }

    public void OnformDateUpdate(String string) {

    }
    public void OnformHeadUpdate(String string) {
        int bdt=Integer.parseInt(SubStringUtils.substring(string,48,52),16);
        String jsont= HexadecimalConver.decode(
                SubStringUtils.substring(string,52,52+bdt*2));
        UserMessage.fragmentHead=CommUtils.getJson(jsont,"baseinfo");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getID() {
        return 0;
    }
}
