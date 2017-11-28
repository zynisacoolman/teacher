package cn.jucheng.www.hulisiwei;

import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.view.View;
import android.widget.ExpandableListView;

import java.io.File;

import butterknife.BindView;
import cn.jucheng.jclibs.tools.MyToast;

import static android.Manifest.permission_group.STORAGE;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bllb_);
        //判断是否存在病例目录
        if(new File(BLPath).exists()){
            //调用jclib中的init生成log目录
            init();
            //初始化控件
            viewInit();
        }else{
            MyToast.showTestToast(this,"没有病例！");
            finish();
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
