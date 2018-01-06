package cn.jucheng.www.hulisiwei;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.module.UserMessage;

/**
 * Created by zyn on 2018/1/3.
 */

public class BlzgActivity extends MyBaseActivity {
    @BindView(R.id.tv_close)
    FitHeightTextView tv_close;

    RelativeLayout.LayoutParams[] layoutParams ;
//    ItemBlzgView[] blzgViews;
    TextView[] blzgViews;

    Resources resources = currentMyBaseActivity.getResources();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blzg_layout);
//        第一步需要解析数据
        getData();
//        第二部在布局中根据数据布置控件
        initView();

    }
    public void getData() {

        layoutParams = new RelativeLayout.LayoutParams[UserMessage.blzgCache.getDatas().size()];
        blzgViews = new TextView[UserMessage.blzgCache.getDatas().size()];
    }
    private void initView() {
        tv_close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BlzgActivity.this.finish();
            }
        });
        RelativeLayout rlBl=(RelativeLayout) findViewById(R.id.rl_blzg);
        for(int i=0;i<UserMessage.blzgCache.getDatas().size();i++){
            blzgViews[i]=new TextView(this);
            blzgViews[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyToast.showToast(BlzgActivity.this
                            , "第%d 个转归病例");
                }
            });
            Drawable bgDrawable =null;
            switch (UserMessage.blzgCache.getDatas().get(i).getState()){
                case 1://未执行
                    bgDrawable=getDrawable(R.drawable.blzg_d);
                    break;
                case 2://执行中
                    bgDrawable=getDrawable(R.drawable.blzg_p);
                    break;
                case 3://已执行
                    bgDrawable=getDrawable(R.drawable.blzg_n);
                    break;
            }
            blzgViews[i].setBackground(bgDrawable);
            blzgViews[i].setText(UserMessage.blzgCache.getDatas().get(i).getTitle());
            blzgViews[i].setGravity(Gravity.CENTER);
            layoutParams[i] = new RelativeLayout.LayoutParams(UserMessage.blzgCache.getDatas().get(i).getW(),
                                                              UserMessage.blzgCache.getDatas().get(i).getH()); // 大小

            layoutParams[i].topMargin = UserMessage.blzgCache.getDatas().get(i).getY();
            layoutParams[i].leftMargin = UserMessage.blzgCache.getDatas().get(i).getX(); // 设置的按钮位置
            blzgViews[i].setLayoutParams(layoutParams[i]);
            rlBl.addView(blzgViews[i]);
        }
        Log.v("控件布置","病例状态发布完成");
    }


    @Override
    protected void HandlerMessage(Message msg) {

    }

    @Override
    public void exc() {

    }


}
