package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.MyList;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.widget.MyShareUtils;

/**
 * Created by zyn on 2017-12-02.
 * 血糖记录单
 */

public class XTJLDFragmentAdapter extends BaseAdapter {


    List<String> list = new ArrayList<>();//某一项的要修改的信息
    private LayoutInflater mInflater;
    private Context mContext = null;
    int index = 1;//数据条数
    String nurseName = "";//签名
    public static MyShareUtils datas = null;//缓存数据




    public XTJLDFragmentAdapter(Context context, int index) {
        this.mContext = context;
        this.index = index;
    }
    @Override
    public int getCount() {
        return index;
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
            convertView = mInflater.inflate(R.layout.adapter_fragmentxtjcb, null);
            holder = new ViewHolder();
            holder.h_name = (TextView) convertView.findViewById(R.id.h_name);
            holder.h_sex = (TextView) convertView.findViewById(R.id.h_sex);
            holder.h_age = (TextView) convertView.findViewById(R.id.h_age);
            holder.h_division = (TextView) convertView.findViewById(R.id.h_division);
            holder.h_bednumber = (TextView) convertView.findViewById(R.id.h_bednumber);
            holder.h_illrecordNum=(FitHeightTextView) convertView.findViewById(R.id.h_illrecordNum);
            holder.transfusion_page_number=(FitHeightTextView)convertView.findViewById(R.id.inject_page_number);
            holder.listView=(MyList)convertView.findViewById(R.id.inject_list);
            holder.xtjlDiTemFragmentAdapter=new XTJLDiTemFragmentAdapter(mContext,position);
            holder.listView.setAdapter(holder.xtjlDiTemFragmentAdapter);
            holder.xtjlDiTemFragmentAdapter.notifyDataSetChanged();
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }
            holder.h_name.setText(UserMessage.fragmentHead.get(0));
            holder.h_sex.setText(UserMessage.fragmentHead.get(1));
            holder.h_age.setText(UserMessage.fragmentHead.get(2));
            holder.h_division.setText(UserMessage.fragmentHead.get(3));
            holder.h_bednumber.setText(UserMessage.fragmentHead.get(4));
            holder.h_illrecordNum.setText(UserMessage.fragmentHead.get(5));
            holder.transfusion_page_number.setText(String.format("第%d页",position+1));


        return convertView;
    }

    class ViewHolder {
        TextView h_name;//姓名
        TextView h_sex;//性别
        TextView h_age;//年龄
        TextView h_division;//科室
        TextView h_bednumber;//床号
        FitHeightTextView h_illrecordNum;//病案号
        XTJLDiTemFragmentAdapter xtjlDiTemFragmentAdapter;
        ListView listView;//listview
        TextView transfusion_page_number;//页数
        TextView h_ryrq;//入院日期
        TextView h_zyblh;//住院病历号

    }
}

