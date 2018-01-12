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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.jucheng.jclibs.tools.MyToast;
import cn.jucheng.www.hulisiwei.customcontrols.ArrowLine;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.databean.bllbbean.Changqiyizhu;
import cn.jucheng.www.hulisiwei.databean.bllbbean.States_transfer;
import cn.jucheng.www.hulisiwei.databean.blzgbean.ChildList;
import cn.jucheng.www.hulisiwei.databean.blzgbean.TableItemBlzgBean;
import cn.jucheng.www.hulisiwei.databean.blzgbean.medicine.MedicineRootBean;
import cn.jucheng.www.hulisiwei.databean.blzgbean.phyexam.PhyexamRootBean;
import cn.jucheng.www.hulisiwei.databean.blzgbean.phyexam.Physical;
import cn.jucheng.www.hulisiwei.databean.blzgbean.special_disposal.SpecialRootBean;
import cn.jucheng.www.hulisiwei.fragment.blzgFragment.Tabtzcs;
import cn.jucheng.www.hulisiwei.fragment.blzgFragment.Tabyzlb;
import cn.jucheng.www.hulisiwei.fragment.blzgFragment.Tabztzg;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;

import static cn.jucheng.www.hulisiwei.module.UserMessage.searchmapStatename;
import static cn.jucheng.www.hulisiwei.module.UserMessage.searchmapStatetransfer;

/**
 * Created by zyn on 2018/1/3.
 */

public class BlzgActivity extends MyBaseActivity {
    @BindView(R.id.tv_close)
    FitHeightTextView tv_close;
    Context context ;
    //存放文件信息的全局变量
    MedicineRootBean medicineRootBean;
    PhyexamRootBean phyexamRootBean;
    SpecialRootBean specialRootBean;
    //当前状态id
    int cur_id;
    //存放 医嘱名称
    ArrayList<String> yzneirong = new ArrayList<>();
    //存放 病例转归页面的医嘱名称
    List<TableItemBlzgBean> zgTablelst=new ArrayList<>();
    //存放
    RelativeLayout.LayoutParams[] layoutParams ;
    List<ChildList> childListlst=new ArrayList<>();
    TextView[] blzgViews;
    private final String TAG= "BlzgActivity.class";
    private final String[] 计量单位 = {
        "没有单位", "mg", "ml", "mg","ml","U","U","ug","ug"
    };
    private final String[] 药物处置方式 = {
            "没有方式",
            "口服 ",
            "肌肉注射",
            "静脉滴注",
            "静脉注射",
            "静脉泵入",
            "皮下注射",
            "鼻腔吸入",
            "气管注入",
            "局部用药",
            "皮内注射",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blzg_layout);
        context=super.getBaseContext();
        //读取文件信息
        initdata();
//        第一步需要解析数据
        setBlzgItem();

//        第二部在左边布局中根据数据布置控件
        initView();
        initFragment();
    }

    private void initdata() {
        String medicine = CommUtils.getStringFromAssets("db/medicine.json",context);
        String phyexam_item = CommUtils.getStringFromAssets("db/phyexam_item.json",context);
        String special_disposal = CommUtils.getStringFromAssets("db/special_disposal.json",context);
        Gson gson = new Gson();
        medicineRootBean = gson.fromJson(medicine, MedicineRootBean.class);
        medicineRootBean.getJuchengesp().initGetAllMedicines();
        phyexamRootBean = gson.fromJson(phyexam_item, PhyexamRootBean.class);
        for(Physical physical:phyexamRootBean.getJuchengesp().getPhysical()){
            physical.init名字toID默认值();
        }

        specialRootBean = gson.fromJson(special_disposal, SpecialRootBean.class);
        specialRootBean.getJuchengesp().mapSpecialdisposal();
    }

    private void initFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_layout, new Tabyzlb());
        ft.add(R.id.fragment_layout,new Tabztzg());
        ft.add(R.id.fragment_layout,new Tabtzcs());
        ft.commit();
    }
    //设置病例转归的状态图
    public void setBlzgItem() {
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
            final int finalI = i;
            blzgViews[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyToast.showToast(BlzgActivity.this
                            , "第%d 个转归病例");
                    获取医嘱列表信息(UserMessage.blzgCache.getDatas().get(finalI).getId());//根据 所选择状态号重新解析数据，并发送给fragment ，fragment对数据进行重新赋值处理
                    获取状态转归信息(cur_id);
                    获取体征参数(cur_id);
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
            layoutParams[i] = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT
                    ,RelativeLayout.LayoutParams.WRAP_CONTENT); // 大小
            layoutParams[i].topMargin = UserMessage.blzgCache.getDatas().get(i).getY();
            layoutParams[i].leftMargin = UserMessage.blzgCache.getDatas().get(i).getX(); // 设置的按钮位置
            blzgViews[i].setLayoutParams(layoutParams[i]);
            rlBl.addView(blzgViews[i]);
            //划线
            for(ChildList cl:UserMessage.blzgCache.getDatas().get(i).getChildList()){
                int sx = 0,sy = 0,tx = 0,ty = 0;
                switch (cl.getSDir()){
                    case 0:
                        sx=UserMessage.blzgCache.getDatas().get(i).getX()+blzgViews[i].getWidth()/2;
                        sy=UserMessage.blzgCache.getDatas().get(i).getY();
                        break;
                    case 1:
                        sx=UserMessage.blzgCache.getDatas().get(i).getX()+blzgViews[i].getWidth();
                        sy=UserMessage.blzgCache.getDatas().get(i).getY()+blzgViews[i].getHeight()/2;
                        break;
                    case 2:
                        sx=UserMessage.blzgCache.getDatas().get(i).getX()+blzgViews[i].getWidth()/2;
                        sy=UserMessage.blzgCache.getDatas().get(i).getY()+blzgViews[i].getHeight();
                        break;
                    case 3:
                        sx=UserMessage.blzgCache.getDatas().get(i).getX();
                        sy=UserMessage.blzgCache.getDatas().get(i).getY()+blzgViews[i].getHeight()/2;
                        break;
                }
                switch (cl.getTDir()){
                    case 0:
                        tx=UserMessage.idStatus.get(cl.getTId()).getX()+blzgViews[i].getWidth()/2;
                        ty=UserMessage.idStatus.get(cl.getTId()).getY();
                        break;
                    case 1:
                        tx=UserMessage.idStatus.get(cl.getTId()).getX()+blzgViews[i].getWidth();
                        ty=UserMessage.idStatus.get(cl.getTId()).getY()+blzgViews[i].getHeight()/2;
                        break;
                    case 2:
                        tx=UserMessage.idStatus.get(cl.getTId()).getX()+blzgViews[i].getWidth()/2;
                        ty=UserMessage.idStatus.get(cl.getTId()).getY()+blzgViews[i].getHeight();
                        break;
                    case 3:
                        tx=UserMessage.idStatus.get(cl.getTId()).getX();
                        ty=UserMessage.idStatus.get(cl.getTId()).getY()+blzgViews[i].getHeight()/2;
                        break;
                }
                ArrowLine arrowLine =new ArrowLine(BlzgActivity.this);
//                arrowLine.drawAL(sx,sy,tx,ty);
                rlBl.addView(arrowLine);

            }

        }
        Log.v("控件布置","病例状态发布完成");
    }
    private void 获取体征参数(int cur_id) {
        Double db1 = UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("心率").getId())==null?
                UserMessage.searchValue.get("心率").getDefValue().getDefaultvalue():
                UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("心率").getId()).getState_value();
        Double db2 = UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("脉搏").getId())==null?
                UserMessage.searchValue.get("脉搏").getDefValue().getDefaultvalue():
                UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("脉搏").getId()).getState_value();
        Double db3 = UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("呼吸").getId())==null?
                UserMessage.searchValue.get("呼吸").getDefValue().getDefaultvalue():
                UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("呼吸").getId()).getState_value();
        Double db4 = UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("血氧饱和度").getId())==null?
                UserMessage.searchValue.get("血氧饱和度").getDefValue().getDefaultvalue():
                UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("血氧饱和度").getId()).getState_value();
        Double db51 = UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("收缩压").getId())==null?
                UserMessage.searchValue.get("收缩压").getDefValue().getDefaultvalue():
                UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("收缩压").getId()).getState_value();
        Double db52 = UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("舒张压").getId())==null?
                UserMessage.searchValue.get("舒张压").getDefValue().getDefaultvalue():
                UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("舒张压").getId()).getState_value();
        Double db6 = UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("体温").getId())==null?
                UserMessage.searchValue.get("体温").getDefValue().getDefaultvalue():
                UserMessage.searchExamResult.get(cur_id).get(UserMessage.searchValue.get("体温").getId()).getState_value();
    }


    private void 获取状态转归信息(int id) {
        List<States_transfer> lst=null;
        TableItemBlzgBean tbib=new TableItemBlzgBean();
        if(searchmapStatetransfer.containsKey(id)){
            //获取病例转归信息
            lst= searchmapStatetransfer.get(id);
        }
        for (States_transfer st:
             lst) {
            ArrayList<String> blzgYznr = new ArrayList<>();
            for(int i = 0;i<st.getDispose().size();i++){
                if(st.getDispose().get(i).getDispose_type()==1){
                    int dis_id = st.getDispose().get(i).getDispose_id();
                    if (UserMessage.allMedicines.containsKey(dis_id)) {
                        StringBuilder sb = new StringBuilder();
                        String 药物名称 = UserMessage.allMedicines.get(dis_id).getMedicine_name();
                        int 处置方式 =st.getDispose().get(i).getDispose_way().getSelcect_way();
                        float 药物用量 = st.getDispose().get(i).getDispose_way().getDose();
//                                    float 药物计量单位=allyizhu.get(s).getContent().get(l).getDrug_dose();
                        int 药物计量单位 = UserMessage.allMedicines.get(dis_id).getDose_unit();
                        sb.append(药物处置方式[处置方式]).
                                append(药物名称).
                                append(药物用量).append(计量单位[药物计量单位]);
                        blzgYznr.add(sb.toString());
                    }
                }
                if(st.getDispose().get(i).getDispose_type()==2){
                    int dis_id = st.getDispose().get(i).getDispose_id();
                    //获取点击状态药物信息
                    if (UserMessage.allSpecialdispose.containsKey(dis_id)) {
                        StringBuilder sb = new StringBuilder();
                        String 特殊处置 = UserMessage.allSpecialdispose.get(dis_id);
                        sb.append(特殊处置);
                        blzgYznr.add(sb.toString());
                    }
                }
            }
            tbib.set遗嘱内容(blzgYznr);
            for(int s =0;s<st.getExit_state_id().size();s++){
                TableItemBlzgBean.Exitdispose te=new TableItemBlzgBean.Exitdispose();
                te.set出口概率(st.getExit_state_id().get(s).getPercent());
                if(searchmapStatetransfer.containsKey(st.getExit_state_id().get(s).getState_id())){
                    te.set出口状态(searchmapStatename.get(st.getExit_state_id().get(s).getState_id()));
                }

                tbib.set出口状态概率(new ArrayList<TableItemBlzgBean.Exitdispose>());
                tbib.get出口状态概率().add(te);
            }
            zgTablelst.add(tbib);
        }
    }

    @Override
    protected void HandlerMessage(Message msg) {

    }

    @Override
    public void exc() {

    }


    public void 获取医嘱列表信息(int id) {

        /**
         *@param yzneirong 这个list存放的是组装好的数据
         *@parma sb 这个变量存储
         **/
        for (int i=0;i<UserMessage.statesinfo.getStates().size();i++){
            if(id == UserMessage.statesinfo.getStates().get(i).getId()){
                cur_id=id;

                if(UserMessage.statesinfo.getStates().get(i).getChangqiyizhu()!=null
                        ||UserMessage.statesinfo.getStates().get(i).getLinshiyizhu()!=null){
                    /**
                     * param yizhu 用来整合所有
                     * */
                    List<Changqiyizhu> allyizhu = new ArrayList<>();
                    if(UserMessage.statesinfo.getStates().get(i).getChangqiyizhu()!=null){
                        allyizhu.addAll(UserMessage.statesinfo.getStates().get(i).getChangqiyizhu());
                    }
                    if(UserMessage.statesinfo.getStates().get(i).getLinshiyizhu()!=null){
                        allyizhu.addAll(UserMessage.statesinfo.getStates().get(i).getLinshiyizhu());
                    }
                    //
                for(int s =0 ;s<allyizhu.size();s++){
                    if(allyizhu.get(s).getCteg()==1){
                        //在medicine.json中找
                            for(int l=0;l<allyizhu.get(s).getContent().size();l++){
                                //获取点击状态药物信息
                                int medicine_id = allyizhu.get(s).getContent().get(l).getDrug_id();
                                //遍历medicineRootbean的medicinelist 获取药归类id
                                if (UserMessage.allMedicines.containsKey(medicine_id)) {
                                    StringBuilder sb = new StringBuilder();
                                    String 药物名称 = UserMessage.allMedicines.get(medicine_id).getMedicine_name();
                                    int 处置方式 = allyizhu.get(s).getContent().get(l).getSelect_dispose_way();
                                    float 药物用量 = UserMessage.allMedicines.get(medicine_id).getDose_value();
//                                    float 药物计量单位=allyizhu.get(s).getContent().get(l).getDrug_dose();
                                    int 药物计量单位 = UserMessage.allMedicines.get(medicine_id).getDose_unit();
                                    sb.append(药物处置方式[处置方式]).
                                            append(药物名称).
                                            append(药物用量).append(计量单位[(int) 药物计量单位]);
                                    yzneirong.add(sb.toString());
                                }
                            }
                        }
                    if(allyizhu.get(s).getCteg()==2){
                            //在special中查找药物信息
                            for(int l=0;l<allyizhu.get(s).getContent().size();l++){
                                //获取点击状态药物信息
                                int special_id = allyizhu.get(s).getContent().get(l).getSpecialdispse_id();
                                if (UserMessage.allSpecialdispose.containsKey(special_id)) {
                                    StringBuilder sb = new StringBuilder();
                                    String 特殊处置 = UserMessage.allSpecialdispose.get(special_id);
                                    sb.append(特殊处置);
                                    yzneirong.add(sb.toString());
                                }
                            }
                        }
                    }
                }else {
                    Log.v(TAG,"没有医嘱信息");
                }

            }
        }
    }
}
