package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.google.gson.JsonObject;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.BlxqActivity;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;

/**
 * Created by zyn on 2017/12/16.
 * 临时医嘱单
 */



public class Hljld1Fragment extends BaseFragment implements AbsListView.OnScrollListener {
    @BindView(R.id.h_name)
    FitHeightTextView h_name;
    @BindView(R.id.h_age)
    FitHeightTextView h_age;
    @BindView(R.id.h_bednumber)
    FitHeightTextView h_bednum;
    @BindView(R.id.h_division)
    FitHeightTextView h_division;
    @BindView(R.id.h_illrecordNum)
    FitHeightTextView h_illrecordNum;
    @BindView(R.id.h_sex)
    FitHeightTextView h_sex;


    //解析出来的json obj
    JsonObject obj;

    protected final String TAG="护理记录单首页";
    private View view;
    /**
     * 数据源
     */
    Unbinder unbinder;
    int pages=1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.adapter_fragmenthljld, null);
        getPage();
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        //解析jsonobj
        obj=CommUtils.getcaseJSON(BLPath2);
        setHead();
        return view;
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {
        int msgType = evnt.getIsMessage();
        String message_str = evnt.getMessage();
        setBiaodanMessage(message_str,msgType);
    }
    /**
     * 解析表单信息
     *
     * @param message
     */
    public void setBiaodanMessage(String message,int messageType) {
        switch (messageType){
            case 1://1是表单头部信息
                setBiaodanHead(message);
                break;
            default:
                break;
        }
    }
    public void setBiaodanHead(String string) {
            int bdt=Integer.parseInt(SubStringUtils.substring(string,48,52),16);
            String jsont= HexadecimalConver.decode(
                    SubStringUtils.substring(string,52,52+bdt*2));
            UserMessage.fragmentHead=CommUtils.getJson(jsont,"baseinfo");
            setHead();
    }
    public void setHead(){
        h_name.setText(UserMessage.fragmentHead.get(0));
        h_sex.setText(UserMessage.fragmentHead.get(1));
        h_age.setText(UserMessage.fragmentHead.get(2));
        h_division.setText(UserMessage.fragmentHead.get(3));
        h_bednum.setText(UserMessage.fragmentHead.get(4));
        h_illrecordNum.setText(UserMessage.fragmentHead.get(5));
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
