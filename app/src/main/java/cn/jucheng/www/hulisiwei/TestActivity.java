package cn.jucheng.www.hulisiwei;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;

import cn.jucheng.www.hulisiwei.customcontrols.CustomCurveChart;

import static cn.jucheng.www.hulisiwei.module.UserMessage.twdResult;

/**
 * Created by zyn on 2018/1/22.
 */

public class TestActivity extends MyBaseActivity {
    LinearLayout ll ;
    String[] xLabel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    String[] yLabel = {"0", "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "1100"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        ll = (LinearLayout) View.inflate(this,R.layout.layout_test,null);
//        twdResult.getMbsz() = new ArrayList<Integer>(){
//            {
//                add(100);
//                add(100);
//                add(200);
//                add(200);
//                add(300);
//                add(300);
//                add(300);
//            }
//        };
        ll.addView(new CustomCurveChart(TestActivity.this, xLabel,yLabel,twdResult.getMbsz(),R.color.bg_txt_color,false));
    }
    @Override
    protected void HandlerMessage(Message msg) {

    }

    @Override
    public void exc() {

    }
}
