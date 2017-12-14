package cn.jucheng.www.hulisiwei;

import android.app.ProgressDialog;
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

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.adapter.FragmentListAdapter;
import cn.jucheng.www.hulisiwei.adapter.SimpleTreeAdapter;
import cn.jucheng.www.hulisiwei.adapter.TreeListViewAdapter;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightButton;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightEditText;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.databean.blxqbean.FileBean;
import cn.jucheng.www.hulisiwei.fragment.formFragement.TwdFragment;
import cn.jucheng.www.hulisiwei.interfaca.MessageEvent;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.DateUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;
import cn.jucheng.www.hulisiwei.widget.MyGlobal1;
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


    private List<FileBean> mDatas = new ArrayList<FileBean>();
    private TreeListViewAdapter mAdapter;
    //学生操作记录的adapter
    private ArrayAdapter czjlAdapter;
    //学生操作记录
    private ArrayList CZJLList=new ArrayList();

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
        //等待学生发送消息
        pd = ProgressDialog.show(BlxqActivity.this, "提示", "等待学生选择病例");
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
//        fragmentList.put(0,new BloodrecordlistFragment());
//        fragmentList.put(1,new TransfusionrecordFragment());


    }

    @Override
    protected void HandlerMessage(Message msg) {
        String str =(String)msg.obj;
        switch(msg.what){
            case MyMessage.MLZ_GZBD:
                UserMessage.biaodan_message = str;//缓存表单数据
                EventBus.getDefault().post(new MessageEvent(UserMessage.biaodan_message, 4));
                break;
            case MyMessage.MLZ_BDT:
                String head_message = str.substring(52);
                datas.setData(MyGlobal1.ALLBIAODANMESSAGE, head_message);//存储表单头部信息
                EventBus.getDefault().post(new MessageEvent(head_message, 1));
                break;
            case MyMessage.MLZ_XSCZ://学生操作
                //mStr为临时变量存储解析出来的学生操作
                String mStr;
                int mLenth;
                mLenth=Integer
                        .parseInt(SubStringUtils.substring(str,
                                70, 74), 16);
                mStr=SubStringUtils.substring(str,74,mLenth);
                CZJLList.add(HexadecimalConver.decode(mStr));
                czjlAdapter.notifyDataSetChanged();
                break;
            case MyMessage.MLZ_XLJS://学生发送的信息
                if(Integer.parseInt(SubStringUtils.substring(str,52,54))==1){
                    pd.dismiss();
                    mHandler.postDelayed(TimerRunnable,1000);
                }
                break;
            case MyMessage.MLZ_ZTGB://学生向教师机发送新的状态 说明：状态跳转时，接收学生机发送的新的当前正在进行的病例状态

                break;
        }
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
    @Override
    public void exc() {

    }

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

        }
    }
    /**
     * 设置页码
     */
    public static void setPageNumber(String number) {
        tvPage.setText(number);
    }
}