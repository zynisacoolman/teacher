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
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.widget.MyShareUtils;

/**
 * Created by zyn on 2017-12-02.
 * 一般患者护理记录单
 */

public class HLJL2FragmentAdapter extends BaseAdapter {


    private List<String> specailList = new ArrayList<>();//表头信息
    private List<List<String>> page_List = new ArrayList<>();//此页item信息
    List<String> list = new ArrayList<>();//某一项的要修改的信息
    private LayoutInflater mInflater;
    private Context mContext = null;
    int index ;//数据条数
    String nurseName = "";//签名
    public static MyShareUtils datas = null;//缓存数据

    int yiZhuHangHao = 0;//医嘱行号
    int yiZhuType = 0;//医嘱种类



    public HLJL2FragmentAdapter(Context context, int index) {
        this.mContext = context;
        this.index = index;
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<String> specailList, int index) {
        this.index = index;
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return index;
//        return 1+ UserMessage.YBhljlDan.size()/13;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_fragmentybhljl, null);
            holder = new ViewHolder();
            holder.h_name = (TextView) convertView.findViewById(R.id.h_name);
            holder.h_sex = (TextView) convertView.findViewById(R.id.h_sex);
            holder.h_age = (TextView) convertView.findViewById(R.id.h_age);
            holder.h_division = (TextView) convertView.findViewById(R.id.h_division);
            holder.h_bednumber = (TextView) convertView.findViewById(R.id.h_bednumber);
            holder.h_illrecordNum=(TextView) convertView.findViewById(R.id.h_illrecordNum);
            holder.mylist = (MyList) convertView.findViewById(R.id.ybhllist);
            holder.hljl2itemAdapter = new HLJL2itemAdapter(mContext,position);
            holder.mylist.setAdapter(holder.hljl2itemAdapter);
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }
        holder.hljl2itemAdapter.notifyDataSetChanged();
        if (specailList.size() >= 0 || specailList != null) {
            holder.h_name.setText(CommUtils.getListString(specailList, 0));
            holder.h_sex.setText(CommUtils.getListString(specailList, 1));
            holder.h_age.setText(CommUtils.getListString(specailList, 2));
            holder.h_division.setText(CommUtils.getListString(specailList, 3));
            holder.h_bednumber.setText(CommUtils.getListString(specailList, 4));
            holder.h_illrecordNum.setText(CommUtils.getListString(specailList, 5));
        }
        return convertView;
    }





    class ViewHolder {
        TextView h_name;//姓名
        TextView h_sex;//性别
        TextView h_age;//年龄
        TextView h_division;//科室
        TextView h_bednumber;//床号
        TextView h_illrecordNum;//病案号

        HLJL2itemAdapter hljl2itemAdapter;
        MyList mylist ;
        TextView transfusion_page_number;//页数
        TextView h_ryrq;//入院日期
        TextView h_zyblh;//住院病历号

    }
}

