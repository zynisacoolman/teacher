package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.adapter.fragmentAdapter.TWDFragmentAdapter;
import cn.jucheng.www.hulisiwei.base.BaseFragment;
import cn.jucheng.www.hulisiwei.customcontrols.CustomCurveChart;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;

import static cn.jucheng.www.hulisiwei.module.UserMessage.twdResult;

/**
 * Created by zyn on 2017-11-22.
 * 体温单
 */

public class TwdFragment extends BaseFragment implements AbsListView.OnScrollListener {

//    @BindView(R.id.fragment_fitlist)
//    MyList twd;

    Unbinder unbinder;
    @BindView(R.id.v_1)
    View v1;
    @BindView(R.id.h_name)
    TextView hName;
    @BindView(R.id.h_sex)
    TextView hSex;
    @BindView(R.id.h_age)
    TextView hAge;
    @BindView(R.id.h_division)
    TextView hDivision;
    @BindView(R.id.h_bednumber)
    TextView hBednumber;
    @BindView(R.id.h_illrecordNum)
    TextView hIllrecordNum;
    @BindView(R.id.v_2)
    View v2;
    @BindView(R.id.h_ryrq)
    TextView hRyrq;
    @BindView(R.id.h_zyblh)
    TextView hZyblh;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.v_3)
    View v3;
    @BindView(R.id.gv_twd_ryrq)
    GridView gvTwdRyrq;
    @BindView(R.id.gv_twd_zydays)
    GridView gvTwdZydays;
    @BindView(R.id.gv_twd_sshdays)
    GridView gvTwdSshdays;
    @BindView(R.id.gv_twd_hxcs1)
    GridView gvTwdHxcs1;
    @BindView(R.id.gv_twd_hxcs2)
    GridView gvTwdHxcs2;
    @BindView(R.id.gv_twd_xueya)
    GridView gvTwdXueya;
    @BindView(R.id.gv_twd_ruliang)
    GridView gvTwdRuliang;
    @BindView(R.id.gv_twd_chuliang)
    GridView gvTwdChuliang;
    @BindView(R.id.gv_twd_dabian)
    GridView gvTwdDabian;
    @BindView(R.id.gv_twd_tizhong)
    GridView gvTwdTizhong;
    @BindView(R.id.gv_twd_shengao)
    GridView gvTwdShengao;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.rl_twd_)
    RelativeLayout rlTwd;
    @BindView(R.id.ll_twd)
    LinearLayout llTwd;
    private View view;

    RelativeLayout rl;
    /**
     * 数据源
     */
    List<String> specailList = new ArrayList<>();
    TWDFragmentAdapter adapter;

    /**
     * gridview 适配器
     **/
    private List<Map<String, Object>> data_list;//gridview 适配器
    String [] from ={"text"};
    int [] to = {R.id.gv_twd_item};


    int biaoDanType;//表单类型
    int pages = 1;//页数

    int validLenth;//字符串有效长度
    int formType;//体温单细分类 1.脉搏 2.体温 3.其他json类型数据
    String[] xLabel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    String[] yLabel = {"0", "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "1100"};

    @Override
    public int getID() {
        return R.layout.adapter_fragmenttwd;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.adapter_fragmenttwd, null);
//        rl = (RelativeLayout) view.findViewById(R.id.rl_twd_);
//        unbinder = ButterKnife.bind(this, view);
//        EventBus.getDefault().register(this);
////        initView();
////        initAdapter();
//        return view;
//    }
    @Override
    public void onViewCreated(View view,  @Nullable Bundle savedInstanceState){
        initView();
    }


    /**
     * 加载数据
     */
    public void initView() {
        //获取表单信息
        if (!TextUtils.isEmpty(UserMessage.biaodan_message)) {
            setBiaodan(UserMessage.biaodan_message);
        }

//        getPage();
    }

    /**
     * 初始adapter
     */
//    public void initAdapter() {
//        adapter = new TWDFragmentAdapter(getActivity(), UserMessage.fragmentHead, pages);
//        twd.setAdapter(adapter);
//        twd.setOnScrollListener(this);
//    }

    /**
     * 处理接受消息的方法  “subscriber methods”
     * 也可以使用注释
     *
     * @param evnt
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {
//        setBiaodanHead();
        int msgType = evnt.getIsMessage();
        String message_str = evnt.getMessage();
        setBiaodanMessage(message_str, msgType);
//        if (biaoDanType ==1) {
//            pages = 1;
//            getPage();
//            adapter.setLists(UserMessage.fragmentHead, pages);
        setBiaodan(message_str);
//        }
    }



    /**
     * 解析表头信息
     */
    public void setBiaodanHead() {
        if (adapter != null) {
            adapter.setLists(UserMessage.fragmentHead, pages);
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
                OnformHeadUpdate(message);
                break;

            case 4://4是表单信息
                setBiaodan(message);
                break;
            default:
                break;
        }
    }

    public void OnformHeadUpdate(String string) {
        int bdt = Integer.parseInt(SubStringUtils.substring(string, 48, 52), 16);
        String jsont = HexadecimalConver.decode(
                SubStringUtils.substring(string, 52, 52 + bdt * 2));

        UserMessage.fragmentHead = CommUtils.getJson(jsont, "baseinfo");
        hName.setText(CommUtils.getListString(specailList, 0));
        hAge.setText(CommUtils.getListString(specailList, 1));
        hSex.setText(CommUtils.getListString(specailList, 2));
        hDivision.setText(CommUtils.getListString(specailList, 3));
        hBednumber.setText(CommUtils.getListString(specailList, 4));
        hRyrq.setText(CommUtils.getListString(specailList, 5));
        hZyblh.setText(CommUtils.getListString(specailList,6));
    }

    public void setBiaodan(String message) {
        //表单类型
        biaoDanType = Integer
                .parseInt(SubStringUtils.substring(message,
                        52, 54), 16);
        //有效数据长度
        validLenth = Integer.parseInt(SubStringUtils.substring(message, 48, 52), 16);
        //获取值类型 1.脉搏 2.体温 3.json对象 tiwendan
        formType = Integer.parseInt(SubStringUtils.substring(message, 54, 56), 16);
        if (biaoDanType == 1) {
            switch (formType) {
                case 1:
//                    for(int i = 0; i < rl.getChildCount(); i++){
//                        if(rl.getChildAt(i).getClass()==CustomCurveChart.class && rl.getChildAt(i).getId()==R.id.twd_mb){
//                        }
//                            rl.removeViewAt(i);
//                        }
                    twdResult.setMbsz(
                            CommUtils.getDatamap(SubStringUtils.substring(message, 56, 56 + (validLenth - 2) * 2)));
                    CustomCurveChart ccc = new CustomCurveChart(getActivity(), xLabel, yLabel, twdResult.getMbsz(), R.color.color25, false);
                    ccc.setLayoutParams(new RelativeLayout.LayoutParams(rl.getWidth(),
                            rl.getHeight()));
                    ccc.setId(R.id.twd_mb);
                    rl.addView(ccc);
                    break;
                case 2:
//                    for(int i = 0; i < rl.getChildCount(); i++){
//                        if(rl.getChildAt(i).getClass()==CustomCurveChart.class && rl.getChildAt(i).getId()==R.id.twd_tw){
//                            rl.removeViewAt(i);
//                        }
//                    }
                    twdResult.setTwsz(
                            CommUtils.getDatamap(SubStringUtils.substring(message, 56, 56 + (validLenth - 2) * 2)));
                    CustomCurveChart ddd = new CustomCurveChart(getActivity(), xLabel, yLabel, twdResult.getTwsz(), R.color.ywtextmessage, false);
                    ddd.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
                    ddd.setId(R.id.twd_tw);
                    rl.addView(ddd);
                    break;
                case 3:
                    twdResult.setOther(
                            CommUtils.getJson(SubStringUtils.substring(message, 56, 56 + (validLenth - 2) * 2), "tiwendan"));
                    List<Map<String, Object>> maplist = setJsonData();
                    gvTwdRyrq.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(0,7),R.layout.gridview_twd_item,from,to));
                    gvTwdZydays.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(7,14),R.layout.gridview_twd_item,from,to));
                    gvTwdSshdays.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(14,21),R.layout.gridview_twd_item,from,to));
                    gvTwdHxcs1.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(21,21+42),R.layout.gridview_twd_item,from,to));
                    gvTwdHxcs2.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(21+42,21+42+42),R.layout.gridview_twd_item,from,to));
                    gvTwdXueya.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(105,105+14),R.layout.gridview_twd_item,from,to));
                    gvTwdRuliang.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(119,119+7),R.layout.gridview_twd_item,from,to));
                    gvTwdChuliang.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(126,126+7),R.layout.gridview_twd_item,from,to));
                    gvTwdDabian.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(133,133+7),R.layout.gridview_twd_item,from,to));
                    gvTwdTizhong.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(140,140+7),R.layout.gridview_twd_item,from,to));
                    gvTwdShengao.setAdapter(new SimpleAdapter(getActivity(),maplist.subList(147,147+7),R.layout.gridview_twd_item,from,to));


                    break;
            }
        }

    }

    List<Map<String, Object>> setJsonData(){

        for(int i = 0; i<UserMessage.twdResult.getOther().size(); i++){
            Map<String, Object> map = new HashMap<>();
            map.put("text", UserMessage.twdResult.getOther().get(i));
            data_list.add(map);
        }

        return data_list;
    }
    @Override
    public void onResume() {
        super.onResume();

    }



    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }
}
