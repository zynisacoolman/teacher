package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.os.Bundle;
import android.text.TextUtils;
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
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.BlxqActivity;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.adapter.fragmentAdapter.RYJLFragmentAdapter;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.base.MyList;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.utils.DateUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;
import cn.jucheng.www.hulisiwei.widget.MyGlobal1;
import cn.jucheng.www.hulisiwei.widget.MyShareUtils;

import static cn.jucheng.www.hulisiwei.module.UserMessage.twdResult;

/**
 * Created by zyn on 2017-11-22.
 * 入院记录
 */

public class RyjlFragment extends BaseFragment implements AbsListView.OnScrollListener {

    @BindView(R.id.fragment_fitlist)
    MyList twd;

    Unbinder unbinder;
    private View view;

    /**
     * 数据源
     */
    List<String> specailList = new ArrayList<>();
    RYJLFragmentAdapter adapter;

    public static MyShareUtils datas = null;//缓存数据
    int biaoDanType;//表单类型
    int pages = 1;//页数

    int validLenth;//字符串有效长度
    int formType;//体温单细分类 1.脉搏 2.体温 3.其他json类型数据
    @Override
    public int getID() {
        return R.layout.fragment_fitlist;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fitlist, null);
        unbinder= ButterKnife.bind(this,view);
        initView();
        initAdapter();
        return view;
    }


    /**
     * 加载数据
     */
    public void initView() {
        //获取表头信息
        if (datas == null) {
            datas = MyShareUtils.getInstances(getActivity());
            String header_message = datas.getData(MyGlobal1.ALLBIAODANMESSAGE);
            if (!TextUtils.isEmpty(header_message)) {
                setBiaodanHead(header_message);
            }
        }
        //获取表单信息
        if (!TextUtils.isEmpty(UserMessage.biaodan_message)) {
            setBiaodan(UserMessage.biaodan_message);
        }

        getPage();
    }

    /**
     * 初始adapter
     */
    public void initAdapter() {
        adapter = new RYJLFragmentAdapter(getActivity(), UserMessage.fragmentHead, pages);
        twd.setAdapter(adapter);
        twd.setOnScrollListener(this);
    }

    /**
     * 处理接受消息的方法  “subscriber methods”
     * 也可以使用注释
     *
     * @param evnt
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {

        int msgType = evnt.getIsMessage();
        String message_str = evnt.getMessage();
        setBiaodanMessage(message_str,msgType);
        if (biaoDanType ==1) {
            pages = 1;
            getPage();
            adapter.setLists(UserMessage.fragmentHead, pages);
        }
    }

    /**
     * 计算页数
     */
    public void getPage() {
        int a = UserMessage.transfusion_Message.size() / 18;
        if (UserMessage.transfusion_Message.size() > 18) {
            pages = pages + a;
        }
    }

    /**
     * 解析表头信息
     *
     * @param message
     */
    public void setBiaodanHead(String message) {
        String messaegs = message.substring(0,message.length()-2);
        UserMessage.fragmentHead = CommUtils.getJson(HexadecimalConver.toStringHex(messaegs), "baseinfo");
        if(adapter != null){
            adapter.setLists(UserMessage.fragmentHead, pages);
        }
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
            case 2://2是清空所有信息
                ClearBiaodanHead();
                break;
            case 3://3是签字信息
                biaoDanType = Integer
                        .parseInt(SubStringUtils.substring(message,
                                52, 54), 16);
                int qianzi_yizhuzhonglei = Integer
                        .parseInt(SubStringUtils.substring(message,
                                54, 56), 16);
                int qianzi_hangHao = Integer
                        .parseInt(SubStringUtils.substring(message,
                                56, 60), 16);
                int qianzi_zhuangTai = Integer
                        .parseInt(SubStringUtils.substring(message,
                                60, 62), 16);

                int hang = 0;
                String date = DateUtils.getminDate();
                String nurseName = datas.getData(MyGlobal1.NURSE_NAME);
                if(qianzi_hangHao >= 1){
                    hang = qianzi_hangHao-1;
                }

                switch (qianzi_zhuangTai){
                    case 1:
                        List<String> list ;
                        list = UserMessage.transfusion_Message.get(hang);
                        list.set(3,date);
                        list.set(4,nurseName);
                        list.set(5, String.valueOf(qianzi_yizhuzhonglei));
                        break;
                    case 2:
                        MyToast.showTestToast(getActivity(),getString(R.string.qianzi_faile));
                        break;
                    default:
                        break;
                }
                break;
            case 4://4是表单信息
                setBiaodan(message);
                break;
            default:
                break;
        }
    }

    public void setBiaodan(String message){
        biaoDanType = Integer
                .parseInt(SubStringUtils.substring(message,
                        52, 54), 16);
        validLenth=Integer.parseInt(SubStringUtils.substring(message,48,52),16);
        //获取值类型 1.脉搏 2.体温 3.json对象 tiwendan
        formType=Integer.parseInt(SubStringUtils.substring(message,54,56),16);
        switch (formType){
            case 1:
                twdResult.setMbsz(
                        CommUtils.getDatamap(SubStringUtils.substring(message,56,56+validLenth))
                );
                break;
            case 2:
                twdResult.setTwsz(
                        CommUtils.getDatamap(SubStringUtils.substring(message,56,56+validLenth))
                );
                break;
            case 3:
                twdResult.setOther(
                        CommUtils.getJson(message, "tiwendan")
                );
                break;
        }
    }

    /**
     * 清空本表所有个人信息
     */
    public void ClearBiaodanHead() {
        UserMessage.fragmentHead.clear();
        UserMessage.transfusion_Message.clear();
        pages = 1;
        adapter.setLists(UserMessage.fragmentHead, pages);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        String number = (firstVisibleItem+1)+"/" + pages;
        BlxqActivity.setPageNumber(number);
    }
}
