package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.BlxqActivity;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.adapter.fragmentAdapter.YZDLongFragmentAdapter;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.base.MyList;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;

/**
 * Created by zyn on 2017/12/16.
 * 临时医嘱单
 */

public class YzdLongFragment extends BaseFragment implements AbsListView.OnScrollListener {
    @BindView(R.id.fragment_fitlist)
    MyList tempyzd;
    protected final String TAG="YzdLongFragment";
    private View view;
    /**
     * 数据源
     */
    YZDLongFragmentAdapter adapter;
    Unbinder unbinder;
    int pages=1;


    @Override
    public int getID() {
        return R.id.fragment_fitlist;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fitlist, null);
        getPage();
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        adapter=new YZDLongFragmentAdapter(getActivity(),pages);
        tempyzd.setAdapter(adapter);
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
            case 4://4是表单信息
                OnformDateUpdate(message);
                break;
            case 5://转抄医嘱
                OnZhuanchao(message);
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
        int lenth = Integer.parseInt(SubStringUtils.substring(string,48,52),16);//有效位长度
        int formtype = Integer.parseInt(SubStringUtils.substring(string,52,54),16);
        int opratype = Integer.parseInt(SubStringUtils.substring(string,54,56),16);
        int page = Integer.parseInt(SubStringUtils.substring(string,56,60),16);
        int line = Integer.parseInt(SubStringUtils.substring(string,60,64),16);
        String json = HexadecimalConver.decode(SubStringUtils.substring(string,64,64+(lenth-6)*2));
        List<String> specialList = CommUtils.getJson(json, "changqiyizhu");
        Log.d(TAG, "OnformDateUpdate: "+json);
        //长期医嘱
        if(formtype==2){
            switch (opratype){
                case 1:
                    if(UserMessage.YZDlongstart.size()==line)
                        UserMessage.YZDlongstart.set(line-1,specialList);
                    else
                        UserMessage.YZDlongstart.add(specialList);
                    break;
                case 2:
                    if(UserMessage.YZDlongstop.size()==line)
                        UserMessage.YZDlongstop.set(line-1,specialList);
                    else
                        UserMessage.YZDlongstop.add(specialList);
                    break;
            }
        }
    }
    public void OnformHeadUpdate(String string) {
        int bdt=Integer.parseInt(SubStringUtils.substring(string,48,52),16);
        String jsont= HexadecimalConver.decode(
                SubStringUtils.substring(string,52,52+bdt*2));
        UserMessage.fragmentHead=CommUtils.getJson(jsont,"baseinfo");
        adapter.notifyDataSetChanged();

    }
    public void OnZhuanchao(String string) {
        //医嘱类型
        int formtyp=Integer.parseInt(SubStringUtils.substring(string,52,54),16);
        //页号
        int pagenum=Integer.parseInt(SubStringUtils.substring(string,54,58),16);
        //行号
        int linenum=Integer.parseInt(SubStringUtils.substring(string,58,62),16);
        //护士名字长度
        int namelenth=Integer.parseInt(SubStringUtils.substring(string,62,66),16);
        //护士名字
        String hsname=HexadecimalConver.decode(SubStringUtils.substring(string,66,namelenth*2+66));
        //转录时间字符串的长度
        int timelenth=Integer.parseInt(SubStringUtils.substring(string,namelenth*2+66,namelenth*2+70));
        //转录时间
        String timezl=HexadecimalConver.decode(
                SubStringUtils.substring(string,namelenth*2+70,namelenth*2+70+timelenth*2));
        List<String> speciallist=new ArrayList<>();
        speciallist.add(0,hsname);
        if(formtyp==2){
            if(UserMessage.YZDlonghssign.size()==linenum){
                UserMessage.YZDlonghssign.set(linenum,speciallist);
            }else{
                UserMessage.YZDlonghssign.add(speciallist);
            }
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
