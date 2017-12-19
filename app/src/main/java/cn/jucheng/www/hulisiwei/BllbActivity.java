package cn.jucheng.www.hulisiwei;

import android.app.Dialog;
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
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jucheng.jclibs.tools.MyLog;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.jclibs.tools.SubStringUtils;
import cn.jucheng.www.hulisiwei.adapter.ExplistBLLBAdapter;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Baseinfo;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Medicalrecordsbaseinfo;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Patientinfo;
import cn.jucheng.www.hulisiwei.interfaca.OnBllbSonClickListener;
import cn.jucheng.www.hulisiwei.utils.CustomDialog;
import cn.jucheng.www.hulisiwei.utils.DateUtils;
import cn.jucheng.www.hulisiwei.widget.MyMessage;

import static cn.jucheng.jclibs.tools.MyLog.init;


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
    String fa,so;
    String befortime;
    private String endtime;
    protected static String BLPath = Environment.getExternalStorageDirectory() + File.separator +
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
    HashMap<String ,String > hashmap;
    @BindView(R.id.tv_blxq_xm)
    FitHeightTextView tvBlxqXm;
    @BindView(R.id.tv_blxq_xb)
    FitHeightTextView tvBlxqXb;
    @BindView(R.id.tv_blxq_nld)
    FitHeightTextView tvBlxqNld;
    @BindView(R.id.tv_blxq_hyzk)
    FitHeightTextView tvBlxqHyzk;
    @BindView(R.id.tv_blxq_xs)
    FitHeightTextView tvBlxqXs;
    @BindView(R.id.tv_blxq_dh)
    FitHeightTextView tvBlxqDh;
    @BindView(R.id.tv_blxq_zz)
    FitHeightTextView tvBlxqZz;
    @BindView(R.id.tv_blxq_zs)
    FitHeightTextView tvBlxqZs;
    @BindView(R.id.tv_blxq_xbs)
    FitHeightTextView tvBlxqXbs;
    @BindView(R.id.tv_btn_xl)
    FitHeightTextView tvbtnxl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bllb_);
        ButterKnife.bind(this);
        //索要学生机状态
        MyMessage.sendMessage(MyMessage.getMsgSuoyaoxueshengjizhuangtai());

        if (Environment.getExternalStorageState().
                equals(Environment.MEDIA_MOUNTED)) {
            getFile();
            viewInit();
        }
    }
    //获取sd卡中文件
    private void getFile() {
        File file = new File(BLPath);
        if (file.exists()) {
            //初始化
            init();
            getDate(BLPath);
            viewInit();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


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
        tvbtnxl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    //                int m=0;
    //                for(int i = 0;!nameCN[i].equals(fa); i++){
    //                    m=i;
    //                }
//                int i =0;
//                while(!nameCN[i].equals(fa)){
//                    i++;
//                }
//                MyMessage.sendMessage(MyMessage.getMsgBinglimingcheng(i, nameEn[i]));
                startActivity(new Intent(BllbActivity.this,BlxqActivity.class));
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

                        break;
                }
                break;
            case MyMessage.MLZ_BLM:
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
    @OnClick(R.id.iv_settings)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_settings:
                Intent intents = new Intent(this, SettingsActivity.class);
                startActivity(intents);
                break;
        }
    }
    //回调接口实现子列表点击
    @Override
    public void onbllbSonClickListener(int f, int s) {
        fa=strfa[f];
        so=strson[f][s];
        jsonContent = getFileFromSD(BLPath + strfa[f] + File.separator + strson[f][s] + File.separator + jsonName);
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
            }
            return object;
        }
        protected void onPostExecute(Object result[]) {
            Patientinfo pi=(Patientinfo)result[0];
            Baseinfo bi=(Baseinfo)result[1];
            Medicalrecordsbaseinfo mbi=(Medicalrecordsbaseinfo)result[2];
            setView(pi,bi,mbi);
        }
    }

    private void setView(Patientinfo pi,Baseinfo bi,Medicalrecordsbaseinfo mbi) {
        tvBlxqXm.setText("年龄："+pi.getName());
        tvBlxqXb.setText("性别:"+pi.getSex());
        tvBlxqNld.setText("年龄段:"+pi.getAge());
        tvBlxqHyzk.setText("婚姻状况:"+pi.getHunyin());
        tvBlxqXs.setText("职业:"+pi.getZhiye());
        tvBlxqZz.setText("住址:"+pi.getHukoudizhi());
        tvBlxqZs.setText(mbi.getZhusu());
        tvBlxqXbs.setText(mbi.getXianbingshi());
    }

    //从sd卡中读取指定目录文件内容并存储到String中
    private String getFileFromSD(String path) {
        String result = "";

        try {
            FileInputStream f = new FileInputStream(path);
            //原来一直显示乱码，其实改为gbk 或者utf8即可
            BufferedReader bis = new BufferedReader(new InputStreamReader(f,"GBK"));
            String line = "";
            while ((line = bis.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

}
