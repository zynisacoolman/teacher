package cn.jucheng.www.hulisiwei;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.adapter.FragmentListAdapter;
import cn.jucheng.www.hulisiwei.adapter.SimpleTreeAdapter;
import cn.jucheng.www.hulisiwei.adapter.TreeListViewAdapter;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightButton;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightEditText;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Baseinfo;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Statesinfo;
import cn.jucheng.www.hulisiwei.databean.blxqbean.FileBean;
import cn.jucheng.www.hulisiwei.databean.blzgbean.BlzgBean;
import cn.jucheng.www.hulisiwei.dialogs.HuShitixingDialog;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.Hljld1Fragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.Hljld2Fragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.Hljld3Fragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.Hljld4Fragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.JcbgFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.MzblFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.RyjlFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.TgjcFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.TwdFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.XtjldFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.YzdLongFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.YzdTemFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.ZqtysFragment;
import cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir.ZyblFragment;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.utils.DateUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;
import cn.jucheng.www.hulisiwei.widget.MyMessage;

/**
 * Created by zyn on 2017/12/6.
 */

public class BlxqActivity extends MyBaseActivity implements View.OnClickListener {
    private static String TAG = "BlxqActivity";
    @BindView(R.id.tv_name_bl)
    FitHeightTextView tvNameBl;
    @BindView(R.id.tv_time_Bl)
    FitHeightTextView tvTimeBl;
    @BindView(R.id.tv_time_state)
    FitHeightTextView tvTimeState;
    @BindView(R.id.btn_blnr)
    FitHeightButton btnBlnr;
    @BindView(R.id.btn_czjl)
    FitHeightButton btnCzjl;

    static FitHeightTextView tvPage;
    @BindView(R.id.lv_blxq)
    ListView lvBlxq;
    @BindView(R.id.tv_blzg)
    FitHeightTextView tvBlzg;
    @BindView(R.id.main_tab_fragmentlayout)
    FrameLayout mainTabFragmentlayout;
    @BindView(R.id.fg_1)
    LinearLayout fg1;
    @BindView(R.id.ev_jstx)
    FitHeightEditText evJstx;
    @BindView(R.id.tv)
    FitHeightTextView tv;
    //定义一个接口来通知fragment进行数据更新
    private String conditionNow=null;
    private List<FileBean> mDatas = new ArrayList<FileBean>();
    private TreeListViewAdapter mAdapter;
    //学生操作记录的adapter
    private ArrayAdapter czjlAdapter;
    //学生操作记录
    private ArrayList CZJLList=new ArrayList();
    //是否为首次进行状态改变
    boolean firstChange =true;
    //当前状态id
    int current_state_order;

    FragmentListAdapter fragmentAdapter;
    private HashMap fragmentList = new HashMap();
    //等待进度条
    private ProgressDialog pd;


    //计时器 病例运行时间
    private boolean isStopCount = false;

    private boolean isPause = true;

    private Handler mHandler = new Handler();

    private long timer = 0;
    private String timeStr = "";

    //计时器 状态运行时间
    private boolean isStopCount2 = false;

    private boolean isPause2 = true;

    private Handler mHandler2 = new Handler();

    private long timer2 = 0;
    private String timeStr2 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blxq_);
        Intent intent = getIntent();
        Bundle bundle=intent.getExtras();
//        pd = ProgressDialog.show(BlxqActivity.this, "提示", "等待学生选择病例");
        //接受bundle信息 如果是由异常状态恢复的，不出现等待条，如果bundle为空说明是是新开的病例，打开状态条\
        if (bundle!=null){
            pd.dismiss();
            timer=DateUtils.getTimeLong(SubStringUtils.substring(bundle.getString("rectime"),0,6));
            timer2=DateUtils.getTimeLong(SubStringUtils.substring(bundle.getString("rectime"),6,12));
        }
        tvPage=new FitHeightTextView(this);
        tvPage.findViewById(R.id.tv_page);

        initDatas();
        setwedget();


    }
    //设置监听器
    private void setwedget() {
        try {
            mAdapter = new SimpleTreeAdapter<FileBean>(lvBlxq, this, mDatas, 10);
            lvBlxq.setAdapter(mAdapter);
            //绑定list和fragment
            fragmentAdapter = new FragmentListAdapter(getFragmentManager(),
                                                        mAdapter,
                                                        fragmentList,
                                                        R.id.main_tab_fragmentlayout,
                                                        2);
            czjlAdapter=new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,CZJLList);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        btnBlnr.setOnClickListener(this);
        btnCzjl.setOnClickListener(this);
    }

    private void initDatas() {

        // id , pid , label , 其他属性
        mDatas.add(new FileBean(1, 0, "电子病历"));
        mDatas.add(new FileBean(2, 1, "体温单"));
        mDatas.add(new FileBean(3, 1, "长期医嘱单"));
        mDatas.add(new FileBean(4, 1, "临时医嘱单"));
        mDatas.add(new FileBean(5, 1, "病历记录"));
        mDatas.add(new FileBean(6, 5, "入院记录"));

        mDatas.add(new FileBean(7, 5, "体格检查"));
        mDatas.add(new FileBean(8, 1, "知情同意书"));

        mDatas.add(new FileBean(9, 1, "血糖记录单"));
        mDatas.add(new FileBean(10, 1, "检查报告"));
        mDatas.add(new FileBean(11, 1, "护理记录单"));
        mDatas.add(new FileBean(12, 11, "护理记录单首页"));
        mDatas.add(new FileBean(13, 11, "一般患者护理记录单"));
        mDatas.add(new FileBean(14, 11, "出入液量记录单"));
        mDatas.add(new FileBean(15, 11, "压疮护理记录单"));
        mDatas.add(new FileBean(16, 1, "住院病例首页"));
        mDatas.add(new FileBean(17, 1, "门诊病历"));
        mDatas.add(new FileBean(18, 0, "护理评估量表"));
        mDatas.add(new FileBean(19, 18, "日常生活能力评估单"));
        mDatas.add(new FileBean(20, 18, "压疮评估单"));
        mDatas.add(new FileBean(21, 18, "跌倒坠床评估单"));
        mDatas.add(new FileBean(22, 18, "疼痛护理评估单"));
        mDatas.add(new FileBean(23, 18, "口腔护理评估单"));

        fragmentList.put(2,new TwdFragment());
        fragmentList.put(3,new YzdLongFragment());
        fragmentList.put(4,new YzdTemFragment());
        fragmentList.put(6,new RyjlFragment());
        fragmentList.put(7,new TgjcFragment());
        fragmentList.put(8,new ZqtysFragment());
        fragmentList.put(9,new XtjldFragment());
        fragmentList.put(10,new JcbgFragment());
        fragmentList.put(12,new Hljld1Fragment());
        fragmentList.put(13,new Hljld2Fragment());
        fragmentList.put(14,new Hljld3Fragment());
        fragmentList.put(15,new Hljld4Fragment());
        fragmentList.put(16,new ZyblFragment());
        fragmentList.put(17,new MzblFragment());
//        fragmentList.put(0,new BloodrecordlistFragment());
//        fragmentList.put(1,new TransfusionrecordFragment());
        //获取Baseinfo并存储到cache中
        JsonObject datas = CommUtils.getcaseJSON(CommUtils.getStringFromPath(BLPath2)).getAsJsonObject();
        Gson gson = new Gson();
        UserMessage.baseinfo = gson.fromJson(datas.get("baseinfo").getAsJsonObject(), Baseinfo.class);
        UserMessage.statesinfo = gson.fromJson(datas.get("statesinfo").getAsJsonObject(), Statesinfo.class);
        UserMessage.statesinfo.初始化状态转归Map();
        UserMessage.statesinfo.初始化状态名称Map();
        UserMessage.statesinfo.初始化状态参数map();

        //从baseinfo中拿到 状态状态数据
        String stateString = UserMessage.baseinfo.getState_chart();
        JsonObject jsonObject = new JsonParser().parse(stateString).getAsJsonObject();
        UserMessage.blzgCache = new Gson().fromJson(jsonObject, BlzgBean.class);
        UserMessage.blzgCache.initBlztMap();
    }

    @Override
    protected void HandlerMessage(Message msg) {
        String str =(String)msg.obj;
        switch(msg.what){
            case MyMessage.MLZ_GZBD:
                UserMessage.biaodan_message = str;//缓存表单数据
                EventBus.getDefault().post(new MessageEvent(UserMessage.biaodan_message, 4));
                break;
            case MyMessage.MLZ_ZCYZ:
                UserMessage.biaodan_message = str;//缓存转抄数据
                EventBus.getDefault().post(new MessageEvent(UserMessage.biaodan_message, 5));
                break;
            case MyMessage.MLZ_BDT:
                String head_message = str;
                EventBus.getDefault().post(new MessageEvent(head_message, 1));
                break;
            case MyMessage.MLZ_XSCZ://学生操作 48-50医嘱状态(1个字节，取值参见附录)+状态ID(两个字节)(50-54)
                //mStr为临时变量存储解析出来的学生操作mCon为当前病人状态 mYZ为医嘱状态，解析出来备用
                String mStr,mCon,mYZ;
                int mLenth;
                mLenth=Integer
                        .parseInt(SubStringUtils.substring(str,
                                70, 74), 16);
                mStr=SubStringUtils.substring(str,74,mLenth);
                mCon=SubStringUtils.substring(str,50,54);
                mYZ=SubStringUtils.substring(str,48,50);
                CZJLList.add(HexadecimalConver.decode(mStr));
                czjlAdapter.notifyDataSetChanged();
                break;
            case MyMessage.MLZ_XLJS://学生发送的信息 17标志着开始训练
                if(Integer.parseInt(SubStringUtils.substring(str,52,54))==1){
                    pd.dismiss();
                    mHandler.postDelayed(TimerRunnable,1000);
                }
                break;
            case MyMessage.MLZ_ZTGB://状态改变 说明：状态跳转时，接收学生机发送的新的当前正在进行的病例状态
                if(!SubStringUtils.substring(str,52,56).equals(conditionNow)){
                    //将学生当前状态置为改变后的状态
                    conditionNow=SubStringUtils.substring(str,52,56);
                    //开始计时
                    mHandler2.postDelayed(ConditionRunnable,1000);
                    //改变病例转归的数据信息
                    int id =Integer.parseInt(conditionNow);
                        for(int i=0;i<UserMessage.blzgCache.getDatas().size();i++){
//                            if(!firstChange){
                                //for(int t =0;t<UserMessage.blzgCache.getDatas().size();t++){
                                /**
                                 * 将上个进行中状态设为已读,已读状态为3
                                 * */
                            if(UserMessage.blzgCache.getDatas().get(i).getId()==UserMessage.blzgLastItemCache.getId()){
                                    UserMessage.blzgCache.getDatas().get(i).setState(3);
                                    //}
                            }
//                                else{
//                                    /***此次更新状态不用设置已读*/
//                                    Log.v("首次状态改变","首次状态改变");
//                                }
//                            }
                            if(id==UserMessage.blzgCache.getDatas().get(i).getId()){
                                //将当前运行中的状态值置为2
                                UserMessage.blzgCache.getDatas().get(i).setState(2);
                                current_state_order=i;
                            }
                        }
                    //将当前condition记录下来备用
                    UserMessage.blzgLastItemCache =UserMessage.blzgCache.getDatas().get(current_state_order);
//                    firstChange=false ;
                }
                break;
            case MyMessage.MLZ_XSTZJS://病人病情状态发生变化，此时教师接收信息，并显示
                final String stuMsg=SubStringUtils.substring(str,48,52);
                if(conditionNow.equals(stuMsg)){
                    int mh,ml,toDate;
                    mh=Integer.parseInt(SubStringUtils.substring(str,52,54),16);//高位16进制字符
                    ml=Integer.parseInt(SubStringUtils.substring(str,54,56),16);//低位16进制字符
//                    StringBuffer sb=new StringBuffer().append(mh).append(ml);//理解错误
//                    mh=Integer.parseInt(sb.toString());
                    toDate=mh*256+ml;//toDate是转换后的值
                    new HuShitixingDialog.Builder(this)
                            .setMessage(HexadecimalConver.decode(SubStringUtils.substring(str,56,56+toDate)))
                            .setPositiveButton("下发新医嘱", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(conditionNow.equals(stuMsg)){
                                        MyMessage.sendMessage(MyMessage.getMsgJiaoshiquerenbingqingbianhua(stuMsg));
                                    }else {
                                        return;//如果现在病人状态和学生发送的病人状态不符，则返回
                                    }

                                }
                            }).setNegativeButton("取消下发", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();

                }
                break;

        }
    }

    @Override
    public void exc() {

    }

    private Runnable TimerRunnable = new Runnable() {

        @Override
        public void run() {
            if(!isStopCount){
                timer += 1000;
                timeStr = DateUtils.getFormatTime(timer);
                tvTimeBl.setText("病例运行时间："+timeStr);
            }
            mHandler.postDelayed(TimerRunnable,1000);
        }
    };
    private Runnable ConditionRunnable = new Runnable() {

        @Override
        public void run() {
            if(!isStopCount2){
                timer2 += 1000;
                timeStr2 = DateUtils.getFormatTime(timer2);
                tvTimeState.setText("病例运行时间："+timeStr2);
            }
            mHandler2.postDelayed(ConditionRunnable,1000);
        }
    };

    @OnClick({R.id.btn_blnr,R.id.iv_setting,R.id.tv_blzg})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_blnr:
                btnBlnr.setChecked(true);
                btnCzjl.setChecked(false);
                lvBlxq.setAdapter(mAdapter);
                Log.d(TAG, "onClick: left");
                break;
            case R.id.btn_czjl:
                btnCzjl.setChecked(true);
                btnBlnr.setChecked(false);
                lvBlxq.setAdapter(czjlAdapter);
                Log.d(TAG, "onClick:right");
                break;
            case R.id.tv:
                String ts=evJstx.getText().toString();
                if (ts.length()<1){
                    MyToast.showToast(this,"请输入提醒");
                }else{
                    MyMessage.sendMessage(MyMessage.getMsgJiaoshitishi(ts));
                }
                break;
            case R.id.iv_setting:
                Intent intents = new Intent(this, SettingsActivity.class);
                startActivity(intents);
                break;
            case R.id.tv_blzg:
                startActivity(new Intent(this,BlzgActivity.class));
                break;

        }
    }
    /**
     * 设置页码
     */
    public static void setPageNumber(String number) {
        tvPage.setText(number);
    }
}
