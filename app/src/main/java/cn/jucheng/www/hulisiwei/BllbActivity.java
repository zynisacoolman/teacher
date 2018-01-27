package cn.jucheng.www.hulisiwei;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jucheng.jclibs.tools.MyLog;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.adapter.ExplistBLLBAdapter;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Baseinfo;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Medicalrecordsbaseinfo;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Patientinfo;
import cn.jucheng.www.hulisiwei.dialogs.ReconnectDialog;
import cn.jucheng.www.hulisiwei.interfaca.OnBllbSonClickListener;
import cn.jucheng.www.hulisiwei.utils.CustomDialog;
import cn.jucheng.www.hulisiwei.utils.DateUtils;
import cn.jucheng.www.hulisiwei.widget.HexadecimalConver;
import cn.jucheng.www.hulisiwei.widget.MyMessage;

import static cn.jucheng.jclibs.tools.MyLog.init;
import static cn.jucheng.www.hulisiwei.utils.CommUtils.getStringFromPath;


/**
 * Created by jc on 2017/11/28.
 */

public class BllbActivity extends MyBaseActivity implements View.OnClickListener, OnBllbSonClickListener {
    private static String TAG="BllbActivity";
    @BindView(R.id.el_bllb)
    ExpandableListView expandableListView;
    @BindView(R.id.v_blxq_layout)
    LinearLayout vBlxq;
    final String jsonName = "case.json";
    String jsonContent;
    String jsonshare;
    String fa,so;
    String befortime;
    private String endtime;
    protected static String BLPath = Environment.getExternalStorageDirectory() +
            File.separator +
            "jucheng" + File.separator +
            "hulisiwei" + File.separator +
            "case" + File.separator +
            "automode" + File.separator;


    String[][] strson ;
    String[] strfa ;
    String[] nameCN ={"呼吸系统" , "循环系统" , "消化系统" , "泌尿系统" , "血液系统" , "内分泌系统及营养代谢性",
        "风湿性疾病" , "理化因素所致疾病" , "营养代谢及体液失衡" , "重症监测治疗与复苏", "休克" , "其他"
    };
    String[] nameEn ={"CaseCteg_Breathe","CaseCteg_Periodic","CaseCteg_Digestion","CaseCteg_Urinary","CaseCteg_Blood","CaseCteg_InternalSecretion",
    "CaseCteg_Rheumatism","CaseCteg_LiHua","CaseCteg_NutritionMetabolism","CaseCteg_ICU","CaseCteg_Shock","CaseCteg_Other"};
    /**
     * 存储状态发生改变后的数据
     * rectime 状态进行的时间
     * recstates 当前病例运行状态
     * recblmc 当前病例名称
     * */
    String rectime;
    String recstates;
    String recblmc;

    @BindView(R.id.tv_blxq_xm)
    TextView tvBlxqXm;
    @BindView(R.id.tv_blxq_xb)
    TextView tvBlxqXb;
    @BindView(R.id.tv_blxq_nld)
    TextView tvBlxqNld;
    @BindView(R.id.tv_blxq_hyzk)
    TextView tvBlxqHyzk;
    @BindView(R.id.tv_blxq_xs)
    TextView tvBlxqXs;
    @BindView(R.id.tv_blxq_dh)
    TextView tvBlxqDh;
    @BindView(R.id.tv_blxq_zz)
    TextView tvBlxqZz;
    @BindView(R.id.tv_blxq_zs)
    TextView tvBlxqZs;
    @BindView(R.id.tv_blxq_xbs)
    TextView tvBlxqXbs;
    @BindView(R.id.tv_btn_xl)
    TextView tvbtnxl;
    @BindView(R.id.iv_exit)
    ImageView ivexit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("start","error after oncreate");
        setContentView(R.layout.activity_bllb_);
        ButterKnife.bind(this);
        //索要学生机状态
        if(!DEBUG){
            MyMessage.sendMessage(MyMessage.getMsgSuoyaoxueshengjizhuangtai());
        }

        if (Environment.getExternalStorageState().
                equals(Environment.MEDIA_MOUNTED)) {
            getFile(BLPath);
            //获得hulisiwei/case.json并且缓存到sharepreference中

            viewInit();
        }
    }
    //获取sd卡中文件
    private void getFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            //初始化
            init();
            getDate(str);
            viewInit();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //从文件夹中获取strfa,strson 数据
    private void getDate(String filepath) {

        File file = new File(filepath);
        if (file.isDirectory()) {
            String[] fName = file.list();
            String[][] ffName = new String[fName.length][];
            for (int s = 0; s < fName.length; s++) {
                File file2 = new File(filepath + File.separator + fName[s]);
                ffName[s] = file2.list();
                strfa = fName;
                strson = ffName;
            }
        }
    }

    private void viewInit() {
        //设置二级列表
        expandableListView.setAdapter(new ExplistBLLBAdapter(this, strfa, strson, this));
        //去掉箭头
        expandableListView.setGroupIndicator(null);
        ivexit.setOnClickListener(this);
        tvbtnxl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m=0;
                for (String s:nameCN) {
                    int i=0;
                    i++;
                    if(s.equals(fa)){
                        m=i;
                    }
                }
                if(m==0){
                    MyToast.showTestToast(BllbActivity.this,"请先选择一个病例");
                }else{
                    //调试模式，先不下发病例数据
                    if(!DEBUG){
                        MyMessage.sendMessage(MyMessage.getMsgBinglimingcheng(m,
                                so
                        ));
                    }
                    startActivity(new Intent(BllbActivity.this,BlxqActivity.class));
                }
            }
        });
    }


    @Override
    protected void HandlerMessage(Message msg) {
        String string=(String)msg.obj;
        switch (msg.what){
            case MyMessage.MLZ_SBSJ://校正时间

                int nian = Integer
                        .parseInt(SubStringUtils.substring(string,
                                52, 56), 16);
                int yue = Integer
                        .parseInt(SubStringUtils.substring(string,
                                56, 58), 16);
                int ri = Integer
                        .parseInt(SubStringUtils.substring(string,
                                58, 60), 16);
                int shi = Integer
                        .parseInt(SubStringUtils.substring(string,
                                60, 62), 16);
                int fen = Integer
                        .parseInt(SubStringUtils.substring(string,
                                62, 64), 16);
                int miao = Integer
                        .parseInt(SubStringUtils.substring(string,
                                64, 66), 16);
                befortime = nian + "-" + yue + "-" + ri + " " + shi + ":" + fen + ":" + miao;

                String timename = DateUtils.getCurrentTimeZone();
                MyLog.d("mwh","timename"+timename);
                SetTime();
            case MyMessage.MLZ_SYXSJZT:
                int status=Integer.parseInt(SubStringUtils.substring(string,48,52),16);
                switch (status){
                    case 0://没有收到教师下发的病例且没有开始
                        break;
                    default://收到教师下发的病例
                        new ReconnectDialog.Builder(this).
                                setTitle("提示").
                                setMessage("是否结束当前病例").
                                setPositiveButton("是", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setNegativeButton("否", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //开始当前病例
                                        Bundle bundle=new Bundle();
                                        bundle.putString("rectime",rectime);
                                        bundle.putString("recstatus",recstates);
                                        bundle.putString("recname",recblmc);
                                        startActivity(new Intent(BllbActivity.this,BlxqActivity.class).putExtras(bundle));
                                    }
                                }).create().show();
                        break;
                }
                break;
            //接受重新连接后学生机发送的病例名
            case MyMessage.MLZ_BLM:
                //病例名长度
                int lenth;
                lenth=Integer.parseInt(SubStringUtils.substring(string,48,52),16);
                recblmc= HexadecimalConver.decode(SubStringUtils.substring(string,60,(lenth-4)*2));
                break;
            //接受重新连接后学生机发送的状态改变命令 //当前病例状态
            case MyMessage.MLZ_ZTGB:
                //前两位高位后两位低位
                recstates=SubStringUtils.substring(string,52,56);
                break;
            //接受重新连接后学生机发送的训练总时间，前三个字节是总时间，后三个字节是状态改变时间
            case MyMessage.MLZ_JZZSJ:
                rectime=SubStringUtils.substring(string,52,64);
                break;
        }

    }
    /**
     * 校正时间
     */
    public void SetTime(){
        new CustomDialog(this, R.style.new_dialogs, new CustomDialog.OnCloseListener() {
            @Override
            public void onClick(Dialog dialog, boolean confirm) {
                if(confirm){//确定
                    dialog.dismiss();
                    Intent intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                    startActivityForResult(intent, 5);
                }else{//取消
                    dialog.dismiss();
                    onExit();
                }
            }
        }).setNowtime(getString(R.string.now_times)+"").setTime(getString(R.string.your_times)+"").show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 5:
                Date curDate2 = new Date(System.currentTimeMillis());//获取当前时间
                Date datea;
                try {
                    datea = DateUtils.stringToDate(befortime, "yyyy-MM-dd HH:mm:ss");//服务器时间
                } catch (ParseException e) {
                    e.printStackTrace();
                    datea = new Date(System.currentTimeMillis());//获取当前时间
                }
                endtime = DateUtils.getTimeLong(curDate2, datea);

                if (!TextUtils.isEmpty(endtime)) {//相差时间超过10分钟以上,进入设置
                    Intent intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                    startActivityForResult(intent, 5);
                    MyToast.showTestToast(BllbActivity.this, endtime + "请修改时间后再次使用app");
                }
                break;
            default:
                break;
        }
    }
    @Override
    public void exc() {

    }
    @OnClick({R.id.iv_settings,R.id.tv_btn_xl})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_settings:
                Intent intents = new Intent(this, SettingsActivity.class);
                startActivity(intents);
                break;

            case R.id.iv_exit:
                onExit();
                break;
        }
    }
    //回调接口实现子列表点击
    @Override
    public void onbllbSonClickListener(int f, int s) {
        fa=strfa[f];
        so=strson[f][s];
        jsonContent = getStringFromPath(BLPath + strfa[f] + File.separator + strson[f][s] + File.separator + jsonName);
        new LoadDataTask().execute();
    }
    //异步解析json串并显示于控件
     class LoadDataTask extends AsyncTask< Integer,Integer, Object[]> {
         Object[] object;
        @Override
        protected Object[] doInBackground(Integer... integers) {
            try{
            JsonObject obj = new JsonParser().parse(jsonContent).getAsJsonObject().get("jc2100").getAsJsonObject().get("case").getAsJsonObject();
            JsonObject baseinfo = obj.get("baseinfo").getAsJsonObject();
            JsonObject patientinfo =obj.get("patientinfo").getAsJsonObject();
            JsonObject medicalrecordsbaseinfo=obj.get("medicalrecordsbaseinfo").getAsJsonObject();
            Gson gson = new Gson();
            Patientinfo pi = gson.fromJson(patientinfo, Patientinfo.class);
            Baseinfo bi = gson.fromJson(baseinfo,Baseinfo.class);
            Medicalrecordsbaseinfo mbi=gson.fromJson(medicalrecordsbaseinfo,Medicalrecordsbaseinfo.class);
            object=new Object[] {pi,bi,mbi};

        }catch (NullPointerException e){
                Log.d(TAG, "json串有空数据 ");
                return null;
            }
            return object;
        }
        protected void onPostExecute(Object result[]) {
            //判断是否存在数据
            if(result!=null){
                Patientinfo pi=(Patientinfo)result[0];
                Medicalrecordsbaseinfo mbi=(Medicalrecordsbaseinfo)result[2];
                setView(pi,mbi);
            }else{
                //不存在数据，置空
                tvBlxqXm.setText("姓名:");
                tvBlxqXb.setText("性别:");
                tvBlxqNld.setText("年龄段:");
                tvBlxqHyzk.setText("婚姻状况:");
                tvBlxqXs.setText("职业:");
                tvBlxqZz.setText("住址:");
                tvBlxqZs.setText("");
                tvBlxqXbs.setText("");
            }
        }
    }
    private void setView(Patientinfo pi,Medicalrecordsbaseinfo mbi) {
        tvBlxqXm.setText(String.format("姓名：%s",(pi.getName()==null)?"":pi.getName()));
        tvBlxqXb.setText(String.format("性别:%s",pi.getSex()==null?"":pi.getSex()));
        tvBlxqNld.setText(String.format("年龄段:%s",pi.getAge()==null?"":pi.getAge()));
        tvBlxqHyzk.setText(String.format("婚姻状况:%s",pi.getHunyin()==null?"":pi.getHunyin()));
        tvBlxqXs.setText(String.format("职业:%s",pi.getZhiye())==null?"":pi.getZhiye());
        tvBlxqZz.setText(String.format("住址:%s",pi.getHukoudizhi()==null?"":pi.getHukoudizhi()));
        tvBlxqZs.setText(mbi.getZhusu()==null?"":mbi.getZhusu());
        tvBlxqXbs.setText(mbi.getXianbingshi()==null?"":mbi.getXianbingshi());
    }
}
