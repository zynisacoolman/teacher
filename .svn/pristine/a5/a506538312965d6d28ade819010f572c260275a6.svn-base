package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.CustomCurveChart;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.widget.MyShareUtils;

/**
 * Created by w on 2017-12-02.
 * 输液记录单分页
 */

public class TWDFragmentAdapter extends BaseAdapter {


    private List<String> specailList = new ArrayList<>();//表头信息
    private List<List<String>> page_List = new ArrayList<>();//此页item信息
    List<String> list = new ArrayList<>();//某一项的要修改的信息
    private LayoutInflater mInflater;
    private Context mContext = null;
    int index = 1;//数据条数
    public static MyShareUtils datas = null;//缓存数据
    /**
     * gridview 适配器
     **/
    private List<Map<String, Object>> data_list;//gridview 适配器
    String [] from ={"text"};
    int [] to = {R.id.gv_twd_item};


    int yiZhuHangHao = 0;//医嘱行号
    int yiZhuType = 0;//医嘱种类
    int group=0;

    String[] xLabel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    String[] yLabel = {"0", "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "1100"};


    public TWDFragmentAdapter(Context context, List<String> specailList, int index) {
        this.mContext = context;
        this.specailList = specailList;
        this.index = index;
        mInflater = LayoutInflater.from(context);
        if (datas == null)
            datas = MyShareUtils.getInstances(context);
    }

    public void setLists(List<String> specailList, int index) {
        this.index = index;
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return index;
    }

    @Override
    public Object getItem(int position) {
        return page_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_fragmenttwd, null);
            holder = new ViewHolder();
            holder.h_name = (TextView) convertView.findViewById(R.id.h_name);
            holder.h_sex = (TextView) convertView.findViewById(R.id.h_sex);
            holder.h_age = (TextView) convertView.findViewById(R.id.h_age);
            holder.h_division = (TextView) convertView.findViewById(R.id.h_division);
            holder.h_bednumber = (TextView) convertView.findViewById(R.id.h_bednumber);
            holder.h_ryrq = (FitHeightTextView) convertView.findViewById(R.id.h_ryrq);
            holder.h_zyblh=(FitHeightTextView) convertView.findViewById(R.id.h_zyblh);
            holder.ll_twd =(LinearLayout)convertView.findViewById(R.id.ll_twd);
            holder.gv_date =(GridView)convertView.findViewById(R.id.gv_twd_ryrq);//日期
            holder.gv_zydays=(GridView)convertView.findViewById(R.id.gv_twd_zydays);//住院天数
            holder.gv_ssdays=(GridView)convertView.findViewById(R.id.gv_twd_sshdays);//手术后天数
            holder.gv_twd_hxcs1=(GridView)convertView.findViewById(R.id.gv_twd_hxcs1);
            holder.gv_twd_hxcs2=(GridView)convertView.findViewById(R.id.gv_twd_hxcs2);
            holder.gv_xueya =(GridView)convertView.findViewById(R.id.gv_twd_xueya);
            holder.gv_ruliang =(GridView)convertView.findViewById(R.id.gv_twd_ruliang);

            convertView.setTag(holder); //

        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }


        if (specailList.size() >= 0 || specailList != null) {
            holder.h_name.setText(CommUtils.getListString(specailList, 0));
            holder.h_age.setText(CommUtils.getListString(specailList, 1));
            holder.h_sex.setText(CommUtils.getListString(specailList, 2));
            holder.h_division.setText(CommUtils.getListString(specailList, 3));
            holder.h_bednumber.setText(CommUtils.getListString(specailList, 4));

            if(UserMessage.twdResult.getTwsz()!=null)
                holder.ll_twd.addView(new CustomCurveChart(mContext, xLabel,yLabel,UserMessage.twdResult.getTwsz(),R.color.red,false));
            if(UserMessage.twdResult.getMbsz()!=null)
                holder.ll_twd.addView(new CustomCurveChart(mContext, xLabel,yLabel,UserMessage.twdResult.getMbsz(),R.color.bg_txt_color,false));
            if(UserMessage.twdResult.getOther()!=null){
                holder.h_ryrq.setText(CommUtils.getListString(UserMessage.twdResult.getOther(),0));//设置日期 由于这部分内容在json中所以 日期需要在这里实现
                holder.h_zyblh.setText(CommUtils.getListString(UserMessage.twdResult.getOther(),1));//住院病历号
                group=(data_list.size()-2)/22;//在这里初始化group的值
                if(group>0){
                    holder.gv_date.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(2,group+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_zydays.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group+2,group*2+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_ssdays.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*2+2,group*3+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_twd_hxcs1.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*3+2,group*9+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_twd_hxcs2.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*9+2,group*15+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_xueya.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*15+2,group*17+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_ruliang.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*17+2,group*18+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_chuliang.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*18+2,group*19+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_dabian.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*19+2,group*20+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_tizhong.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*20+2,group*21+2),R.layout.gridview_twd_item,from,to));
                    holder.gv_shengao.setAdapter(new SimpleAdapter(mContext,setJsonData().subList(group*21+2,group*22+2),R.layout.gridview_twd_item,from,to));
                }else{
                    Log.d("no date","没有数据");
                }
            }
        }

        return convertView;
    }
    List<Map<String, Object>> setJsonData(){

        for(int i = 0; i<UserMessage.twdResult.getOther().size(); i++){
            Map<String, Object> map = new HashMap<>();
            map.put("text", UserMessage.twdResult.getOther().get(i));
            data_list.add(map);
        }

        return data_list;
    }




    class ViewHolder {
        TextView h_name;//姓名
        TextView h_sex;//性别
        TextView h_age;//年龄
        TextView h_division;//科室
        TextView h_bednumber;//床号
        LinearLayout ll_twd;
        TextView h_ryrq;//入院日期
        TextView h_zyblh;//住院病历号
//        XYtoLine xYtoLine;
        LinearLayout b_qx;
        GridView gv_twd_hxcs1;
        GridView gv_twd_hxcs2;
        GridView gv_date;
        GridView gv_zydays;
        GridView gv_ssdays;
        GridView gv_xueya;
        GridView gv_ruliang;
        GridView gv_chuliang;
        GridView gv_dabian;
        GridView gv_tizhong;
        GridView gv_shengao;
    }
}
