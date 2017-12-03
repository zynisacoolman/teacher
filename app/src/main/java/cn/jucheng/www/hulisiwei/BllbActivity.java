package cn.jucheng.www.hulisiwei;

import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import cn.jucheng.www.hulisiwei.adapter.explistBLLBAdapter;
import cn.jucheng.www.hulisiwei.interfaca.OnBllbSonClickListener;

import static cn.jucheng.jclibs.tools.MyLog.init;


/**
 * Created by jc on 2017/11/28.
 */

public class BllbActivity extends MyBaseActivity implements View.OnClickListener,OnBllbSonClickListener{
    @BindView(R.id.el_bllb)
    ExpandableListView expandableListView;
    @BindView(R.id.v_blxq_layout)
    LinearLayout vBlxq;



    protected static String BLPath = Environment.getExternalStorageDirectory() + File.separator +
            "jucheng" + File.separator +
            "hulisiwei"+File.separator+
            "case"+File.separator+
            "automode"+File.separator;
    String[][] strson={{"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
                    {"宋江", "林冲", "李逵", "鲁智深"},
                    {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
                    {"贾宝玉", "林黛玉", "薛宝钗"}};

    String[] strfa={"西游记", "水浒传", "三国演义", "红楼梦"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bllb_);
        if(Environment.getExternalStorageState().
                equals(Environment.MEDIA_MOUNTED)){
            //判断是否存在病例目录
            File file =new File(BLPath);
            if(file.exists()){
                //调用jclib中的init生成log目录
                init();
                //获取文件名数组
                getDate(BLPath);
                //初始化控件
                viewInit();
            }else{
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                viewInit();
//                MyToast.showTestToast(this,"没有病例！");
//                onExit();
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
        //设置二级列表
        expandableListView.setAdapter(new explistBLLBAdapter(this,strfa,strson,this));
        //去掉箭头
        expandableListView.setGroupIndicator(null);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                v.setBackgroundResource(R.drawable.bllb_xz_bg);
                Log.d("儿子", "儿子 onChildClick: ");



                return false;
            }
        });
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
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

    @Override
    public void onbllbSonClickListener(int f, int s) {
        vBlxq.addView(View.inflate(BllbActivity.this,R.layout.fragment_blxq,null));
    }
}
