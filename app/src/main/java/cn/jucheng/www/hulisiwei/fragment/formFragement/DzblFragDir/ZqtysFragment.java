package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
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


public class ZqtysFragment extends BaseFragment implements AbsListView.OnScrollListener {
    @BindView(R.id.h_name)
    TextView h_name;
    @BindView(R.id.h_age)
    TextView h_age;
    @BindView(R.id.h_bednumber)
    TextView h_bednum;
    @BindView(R.id.h_division)
    TextView h_division;
    @BindView(R.id.h_illrecordNum)
    TextView h_illrecordNum;
    @BindView(R.id.h_sex)
    TextView h_sex;


    protected final String TAG = "护理记录单首页";
    private LinearLayout linearLayout;
    /**
     * 数据源
     */
    Unbinder unbinder;
    int pages = 1;
    int valideCounts=0;
    List<String> specialList;//来临时存储数据
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        linearLayout = (LinearLayout)view.findViewById(R.id.ll_zqtys);
        if(!"".equals(UserMessage.headmsg)){
            setBiaodanHead(UserMessage.headmsg);
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {
        int msgType = evnt.getIsMessage();
        String message_str = evnt.getMessage();
        setBiaodanMessage(message_str, msgType);
    }
    private void setWidget(ViewGroup viewGroup,List<String> list) {
        if (viewGroup == null) {
            return;
        }

        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof FitHeightTextView ||view instanceof CheckBox) { // 若是Button记录下

                if(view instanceof FitHeightTextView){
                    FitHeightTextView newDtv = (FitHeightTextView) view;
                    newDtv.setText(list.get(valideCounts));
                    Log.v("red",newDtv.getText()+"");
                }else{
                    CheckBox newCkb = (CheckBox) view;
                    newCkb.setChecked(list.get(valideCounts).equals("0"));
                }
                if(valideCounts<list.size()-1){
                    valideCounts++;
                }

            } else if (view instanceof ViewGroup) {
                // 若是布局控件（LinearLayout或RelativeLayout）,继续查询子View
                setWidget((ViewGroup) view,list);
            }
        }
    }

    /**
     * 解析表单信息
     *
     * @param message
     */
    public void setBiaodanMessage(String message, int messageType) {
        switch (messageType) {
            case 1://1是表单头部信息
                UserMessage.headmsg = message;
                setBiaodanHead(message);
                break;
            case 4://表单信息
                setBiaodan(message);
                break;
            default:
                break;
        }
    }
    public void setBiaodan(String message){
        int biaoDanType = Integer
                .parseInt(SubStringUtils.substring(message,
                        52, 54), 16);

        int validLenth=Integer.parseInt(SubStringUtils.substring(message,48,52),16);
        //行号占用两个字节，列号占用两个字节
        String json = HexadecimalConver.decode(SubStringUtils.substring(message,54,54+(validLenth-1)*2));
        if(biaoDanType ==6){
            specialList  = CommUtils.getJson(json, "shuxuezhiqingtongyishu");
            setWidget(linearLayout,specialList);
        }

    }

    public void setBiaodanHead(String string) {
        int bdt = Integer.parseInt(SubStringUtils.substring(string, 48, 52), 16);
        String jsont = HexadecimalConver.decode(
                SubStringUtils.substring(string, 52, 52 + bdt * 2));
        UserMessage.fragmentHead = CommUtils.getJson(jsont, "baseinfo");
        setHead();
    }

    public void setHead() {
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


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        String number = (firstVisibleItem + 1) + "/" + pages;
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
        return R.layout.adapter_fragmentzqtys;
    }
}
