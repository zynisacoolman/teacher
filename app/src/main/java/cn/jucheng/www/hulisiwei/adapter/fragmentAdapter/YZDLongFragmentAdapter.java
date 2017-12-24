package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.MyList;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.widget.MyShareUtils;

/**
 * Created by w on 2017-12-02.
 * 输液记录单分页
 */

public class YZDLongFragmentAdapter extends BaseAdapter {
    private List<String> specailList = new ArrayList<>();//表头信息
    private List<List<String>> page_List = new ArrayList<>();//此页item信息
    List<String> list = new ArrayList<>();//某一项的要修改的信息
    private LayoutInflater mInflater;
    private Context mContext = null;
    int index = 1;//数据条数
    String nurseName = "";//签名
    public static MyShareUtils datas = null;//缓存数据

    int yiZhuHangHao = 0;//医嘱行号
    int yiZhuType = 0;//医嘱种类
    final String TAG="YZDLongFragmentAdapter";




    public YZDLongFragmentAdapter(Context context, int index) {
        this.mContext = context;
        this.index = index;
        mInflater = LayoutInflater.from(context);
        if (datas == null)
            datas = MyShareUtils.getInstances(context);
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
//        YZDLongStartAdapter yzdleft=new YZDLongStartAdapter(mContext,position);
//        YZDLongStopAdapter yzdright=new YZDLongStopAdapter(mContext,position);
//        YZDLonghsAdapter yzdmiddle = new YZDLonghsAdapter(mContext,position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_fragmentyzdlong, null);
            holder = new ViewHolder();
            holder.h_name = (TextView) convertView.findViewById(R.id.h_name);
            holder.h_sex = (TextView) convertView.findViewById(R.id.h_sex);
            holder.h_age = (TextView) convertView.findViewById(R.id.h_age);
            holder.h_division = (TextView) convertView.findViewById(R.id.h_division);
            holder.h_bednumber = (TextView) convertView.findViewById(R.id.h_bednumber);
            holder.h_illrecordNum=(FitHeightTextView) convertView.findViewById(R.id.h_illrecordNum);
            holder.lv_hssign=(MyList) convertView.findViewById(R.id.gv_hssign);
            holder.lv_start=(MyList) convertView.findViewById(R.id.gv_start);
            holder.transfusion_page_number=(TextView)convertView.findViewById(R.id.inject_page_number);//页面号
            holder.yzdright=new YZDLongStopAdapter(mContext,position);
            holder.lv_stop=(MyList) convertView.findViewById(R.id.gv_stop);
            holder.lv_stop.setAdapter(holder.yzdright);
//            holder.yzdright.notifyDataSetChanged();
//                yzdright.notifyDataSetChanged();
//            holder.lv_hssign=(MyList)convertView.findViewById(R.id.gv_hssign);
//                holder.lv_hssign.setAdapter(yzdmiddle);
//                yzdmiddle.notifyDataSetChanged();
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }
        holder.yzdright.notifyDataSetChanged();
        holder.transfusion_page_number.setText("第" + (position + 1) + "页");
        if (specailList.size() >= 0 || specailList != null) {
            holder.h_name.setText(UserMessage.fragmentHead.get(0));
            holder.h_sex.setText(UserMessage.fragmentHead.get(1));
            holder.h_age.setText(UserMessage.fragmentHead.get(2));
            holder.h_division.setText(UserMessage.fragmentHead.get(3));
            holder.h_bednumber.setText(UserMessage.fragmentHead.get(4));
            holder.h_illrecordNum.setText(UserMessage.fragmentHead.get(5));
        }
        return convertView;
    }




    class ViewHolder {
        TextView h_name;//姓名
        TextView h_sex;//性别
        TextView h_age;//年龄
        TextView h_division;//科室
        TextView h_bednumber;//床号
        FitHeightTextView h_illrecordNum;//病案号

        YZDLongStopAdapter yzdright;
        YZDLongStartAdapter yzdleft;
        YZDLonghsAdapter yzdhs;
        TextView transfusion_page_number;//页数
        TextView h_ryrq;//入院日期
        TextView h_zyblh;//住院病历号
        MyList lv_hssign;
        MyList lv_start;
        MyList lv_stop;

    }
}
