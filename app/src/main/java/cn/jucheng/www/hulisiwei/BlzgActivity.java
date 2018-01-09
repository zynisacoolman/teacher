package cn.jucheng.www.hulisiwei;

import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.databean.blzgbean.medicine.MedicineRootBean;
import cn.jucheng.www.hulisiwei.databean.blzgbean.phyexam.PhyexamRootBean;
import cn.jucheng.www.hulisiwei.databean.blzgbean.special_disposal.SpecialRootBean;
import cn.jucheng.www.hulisiwei.fragment.blzgFragment.Tabtzcs;
import cn.jucheng.www.hulisiwei.fragment.blzgFragment.Tabyzlb;
import cn.jucheng.www.hulisiwei.fragment.blzgFragment.Tabztzg;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;

/**
 * Created by zyn on 2018/1/3.
 */

public class BlzgActivity extends MyBaseActivity {
    @BindView(R.id.tv_close)
    FitHeightTextView tv_close;
    Context context ;

    RelativeLayout.LayoutParams[] layoutParams ;
//    ItemBlzgView[] blzgViews;
    TextView[] blzgViews;
//    private android.app.FragmentManager fragmentManager;


//    Resources resources = currentMyBaseActivity.getResources();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blzg_layout);
        context=super.getBaseContext();
//        第一步需要解析数据
        setBlzgItem();
//        第二部在左边布局中根据数据布置控件
        initView();
        initFragment();
    }

    private void initFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_layout, new Tabyzlb());
        ft.add(R.id.fragment_layout,new Tabztzg());
        ft.add(R.id.fragment_layout,new Tabtzcs());
        ft.commit();
    }

    public void setBlzgItem() {
        //设置病例转归的状态图
        layoutParams = new RelativeLayout.LayoutParams[UserMessage.blzgCache.getDatas().size()];
        blzgViews = new TextView[UserMessage.blzgCache.getDatas().size()];
    }
    public void setData(){

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
            final int finalI = i;
            blzgViews[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyToast.showToast(BlzgActivity.this
                            , "第%d 个转归病例");
                    getData(UserMessage.blzgCache.getDatas().get(finalI).getId());//根据 所选择状态号重新解析数据，并发送给fragment ，fragment对数据进行重新赋值处理
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


    public void getData(int id) {
        String medicine = CommUtils.getStringFromAssets("db/medicine.json",context);
        String phyexam_item = CommUtils.getStringFromAssets("db/phyexam_item.json",context);
        String special_disposal = CommUtils.getStringFromAssets("db/special_disposal.json",context);
        Gson gson = new Gson();
        MedicineRootBean medicineRootBean = gson.fromJson(medicine, MedicineRootBean.class);
        PhyexamRootBean phyexamRootBean = gson.fromJson(phyexam_item, PhyexamRootBean.class);
        SpecialRootBean specialRootBean = gson.fromJson(special_disposal, SpecialRootBean.class);


    }
}
