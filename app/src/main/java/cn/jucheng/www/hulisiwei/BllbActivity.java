package cn.jucheng.www.hulisiwei;

import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.view.View;
import android.widget.ExpandableListView;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.www.hulisiwei.adapter.explistBLLBAdapter;

import static cn.jucheng.jclibs.tools.MyLog.init;


/**
 * Created by jc on 2017/11/28.
 */

public class BllbActivity extends MyBaseActivity implements View.OnClickListener{
    @BindView(R.id.el_bllb)
    ExpandableListView expandableListView;
    protected static String BLPath = Environment.getExternalStorageDirectory() + File.separator +
            "jucheng" + File.separator +
            "hulisiwei"+File.separator+
            "case"+File.separator+
            "automode";
    String[][] strson={{"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
                    {"宋江", "林冲", "李逵", "鲁智深"},
                    {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
                    {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤"}};

    String[] strfa={"西游记", "水浒传", "三国演义", "红楼梦"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bllb_);
        if(Environment.getExternalStorageState().
                equals(Environment.MEDIA_MOUNTED)){
            //判断是否存在病例目录
            if(new File(BLPath).exists()){
                //调用jclib中的init生成log目录
                init();
                //获取文件名数组
                getDate(BLPath);
                //初始化控件
                viewInit();
            }else{
                MyToast.showTestToast(this,"没有病例！");
                onExit();
            }
        }
    }

    private void getDate(String filepath) {
        File file =new File(filepath);
        if(file.isDirectory()){
            String[] fName = file.list();
            String[][] ffName=new String[fName.length][];
            for(int s=0;s<fName.length;s++){
                File file2=new File(filepath+File.separator+fName[s]);
                ffName[s] =file2.list();
                strfa=fName;
                strson=ffName;
            }
        }
    }

    private void viewInit() {
        expandableListView.setAdapter(new explistBLLBAdapter(this,strfa,strson));
    }

    @Override
    protected void HandlerMessage(Message msg) {

    }

    @Override
    public void exc() {

    }

    @Override
    public void onClick(View v) {
    }
}
