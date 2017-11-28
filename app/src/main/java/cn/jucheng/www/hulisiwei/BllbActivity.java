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
    ArrayList filename;
    String[] firstCFilename;
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

        }
    }

    private void viewInit() {

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
