package cn.jucheng.www.hulisiwei.fragment.formFragement;

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
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.base.MyList;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;
import cn.jucheng.www.hulisiwei.adapter.fragmentAdapter.TakeMedicinefragmentAdapter;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.utils.DateUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;
import cn.jucheng.www.hulisiwei.widget.MyGlobal1;
import cn.jucheng.www.hulisiwei.widget.MyShareUtils;

/**
 * Created by w on 2017-11-22.
 * 服药单页
 */

public class TakemedicinelistFragment extends BaseFragment implements TakeMedicinefragmentAdapter.ToastListener,AbsListView.OnScrollListener {


    @BindView(R.id.fragment_fitlist)
    MyList fragmentTakemedicinelist;

    Unbinder unbinder;
    private View view;

    /**
     * 数据源
     */
    List<String> specailList = new ArrayList<>();
    TakeMedicinefragmentAdapter adapter;

    public static MyShareUtils datas = null;//缓存数据
    String yiZhuHangHao = "";//医嘱行号
    String yiZhuType = "";//医嘱种类
    int isMessage = 0;//信息类型
    int biaoDanType;//表单类型
    int pages = 1;//页数


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fitlist, null);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);//在当前界面注册一个订阅者
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
        adapter = new TakeMedicinefragmentAdapter(getActivity(), UserMessage.fragmentHead, pages);
        fragmentTakemedicinelist.setAdapter(adapter);
        adapter.setOntoastClickListener(this);
        fragmentTakemedicinelist.setOnScrollListener(this);

    }

    /**
     * 处理接受消息的方法  “subscriber methods”
     * 也可以使用注释
     *
     * @param evnt
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {
        isMessage = evnt.getIsMessage();
        String message_str = evnt.getMessage();
        setBiaodanMessage(message_str);
        if (biaoDanType == 17) {
            pages = 1;
        getPage();
        adapter.setLists(UserMessage.fragmentHead, pages);
        }
    }

    /**
     * 计算页数
     */
    public void getPage() {
        int a = UserMessage.takemedicine_Message.size() / 18;
        if (UserMessage.takemedicine_Message.size() > 18) {
            pages = pages + a;
        }
    }

    /**
     * 解析表单信息
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
    public void setBiaodanMessage(String message) {
        switch (isMessage){
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
                        List<String> list = new ArrayList<>();
                        list = UserMessage.takemedicine_Message.get(hang);
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
        int yiZhuTypes = Integer
                .parseInt(SubStringUtils.substring(message,
                        54, 56), 16);
        int yiZhuHangHaos = Integer
                .parseInt(SubStringUtils.substring(message,
                        56, 60), 16);
        int yiZhuZhuangTai = Integer
                .parseInt(SubStringUtils.substring(message,
                        60, 62), 16);
        int yiZhuchangdus = Integer
                .parseInt(SubStringUtils.substring(message,
                        62, 66), 16);

        int end_lenth = (yiZhuchangdus * 2) + 66;
        yiZhuType = String.valueOf(yiZhuTypes);
        yiZhuHangHao = String.valueOf(yiZhuHangHaos);
        String messaegs = HexadecimalConver.toStringHex(SubStringUtils.substring(message,
                66, end_lenth));
        if(biaoDanType == 17){
            int hang = yiZhuHangHaos-1;

            if(UserMessage.takemedicine_Message.size() >= yiZhuHangHaos){
                specailList = new ArrayList<>();
                specailList = CommUtils.getJson(messaegs, "fuyaodan");
                specailList.add(yiZhuType);
                specailList.add(yiZhuHangHao);
                UserMessage.takemedicine_Message.set(hang,specailList);
            }else {
                specailList = new ArrayList<>();
                specailList = CommUtils.getJson(messaegs, "fuyaodan");
                specailList.add(yiZhuType);
                specailList.add(yiZhuHangHao);
                UserMessage.takemedicine_Message.add(specailList);
            }
        }
    }

    /**
     * 清空本表所有个人信息
     */
    public void ClearBiaodanHead() {
        UserMessage.fragmentHead.clear();
        UserMessage.takemedicine_Message.clear();
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
        EventBus.getDefault().unregister(this);//取消注册
    }

    @Override
    public void onToastClick() {
        MyToast.showTestToast(getActivity(),"请先填写护士姓名.");
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
