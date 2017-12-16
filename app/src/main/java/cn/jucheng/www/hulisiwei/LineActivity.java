package cn.jucheng.www.hulisiwei;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import java.util.ArrayList;

import cn.jucheng.www.hulisiwei.customcontrols.CustomCurveChart;


public class LineActivity extends Activity {

    private LinearLayout customCurveChart1,customCurveChart2;
    ArrayList[] xy=new ArrayList[2];

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xy_layout);

        customCurveChart1 = (LinearLayout) findViewById(R.id.customCurveChart1);
        initCurveChart1();


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 初始化曲线图数据
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initCurveChart1() {
        xy[0]=new ArrayList<Integer>();
        xy[1]=new ArrayList<Integer>();
        String[] xLabel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] yLabel = {"0", "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "1100"};

        xy[0].add(111);
        xy[1].add(222);
        xy[1].add(444);
        xy[0].add(231);
        xy[1].add(444);
        xy[0].add(555);
        xy[0].add(600);
        xy[1].add(400);
        Integer color = R.color.ywtextmessage;
        customCurveChart1.addView(new CustomCurveChart(this , xLabel, yLabel, xy, color, false));
    }
}
