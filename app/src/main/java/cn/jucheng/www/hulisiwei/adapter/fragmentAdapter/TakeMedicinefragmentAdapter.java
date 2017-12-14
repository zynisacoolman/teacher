package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.module.UserMessage;
import cn.jucheng.www.hulisiwei.utils.CommUtils;
import cn.jucheng.www.hulisiwei.utils.DateUtils;
import cn.jucheng.www.hulisiwei.widget.MyGlobal1;
import cn.jucheng.www.hulisiwei.widget.MyMessage;
import cn.jucheng.www.hulisiwei.widget.MyShareUtils;

/**
 * Created by w on 2017-12-02.
 * 服药单分页
 */

public class TakeMedicinefragmentAdapter extends BaseAdapter implements TakemedicineAdapter.TakeUpdateListener {


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

    ToastListener toastListener;


    public TakeMedicinefragmentAdapter(Context context, List<String> specailList, int index) {
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
            convertView = mInflater.inflate(R.layout.adapter_fragment_takemedicine, null);
            holder = new ViewHolder();
            holder.takemedicine_name = (TextView) convertView.findViewById(R.id.takemedicine_name);
            holder.takemedicine_sex = (TextView) convertView.findViewById(R.id.takemedicine_sex);
            holder.takemedicine_age = (TextView) convertView.findViewById(R.id.takemedicine_age);
            holder.takemedicine_division = (TextView) convertView.findViewById(R.id.takemedicine_division);
            holder.takemedicine_bednumber = (TextView) convertView.findViewById(R.id.takemedicine_bednumber);
            holder.take_medicalrecord_number = (FitHeightTextView) convertView.findViewById(R.id.take_medicalrecord_number);
            holder.takemedicine_list = (ListView) convertView.findViewById(R.id.takemedicine_list);
            holder.takemedicine_years = (TextView) convertView.findViewById(R.id.takemedicine_years);
            holder.takemedicine_mouth = (TextView) convertView.findViewById(R.id.takemedicine_mouth);
            holder.takemedicine_day = (TextView) convertView.findViewById(R.id.takemedicine_day);
            holder.takemedicine_checkuser = (TextView) convertView.findViewById(R.id.takemedicine_checkuser);
            holder.takemedicine_carryout = (TextView) convertView.findViewById(R.id.takemedicine_carryout);
            holder.takemedicine_page_number = (TextView) convertView.findViewById(R.id.takemedicine_page_number);
            convertView.setTag(holder); //

            holder.adapter = new TakemedicineAdapter(mContext, page_List);
            holder.takemedicine_list.setAdapter(holder.adapter);
            holder.adapter.setOnupdateClickListener(this);
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.takemedicine_page_number.setText("第" + (position + 1) + "页");
        page_List = new ArrayList<>();
        page_List.addAll(CommUtils.getDataList(UserMessage.takemedicine_Message, (position + 1), 18));
        holder.adapter.setLists(page_List);

        if (specailList.size() >= 0 || specailList != null) {
            holder.takemedicine_name.setText(CommUtils.getListString(specailList, 0));
            holder.takemedicine_sex.setText(CommUtils.getListString(specailList, 1));
            holder.takemedicine_age.setText(CommUtils.getListString(specailList, 2));
            holder.takemedicine_division.setText(CommUtils.getListString(specailList, 3));
            holder.takemedicine_bednumber.setText(CommUtils.getListString(specailList, 4));
            holder.take_medicalrecord_number.setText(CommUtils.getListString(specailList, 5));

            if ("".equals(holder.takemedicine_years.getText().toString())) {
                holder.takemedicine_years.setText(DateUtils.getYear());
                holder.takemedicine_mouth.setText(DateUtils.getMonth());
                holder.takemedicine_day.setText(DateUtils.getDay());
            }
            nurseName = datas.getData(MyGlobal1.NURSE_NAME);
            if (nurseName != null && !TextUtils.isEmpty(nurseName)) {
                holder.takemedicine_carryout.setText(nurseName);
            } else {
                holder.takemedicine_carryout.setText("");
            }
        }

        return convertView;
    }

    @Override
    public void onUpdateClick(int postion, TakemedicineAdapter takemedicineAdapter, List<List<String>> listdata) {
        List<String> list_message = new ArrayList<>();
        list_message = listdata.get(postion);
        yiZhuType = Integer.parseInt(String.valueOf(list_message.get(5)));
        yiZhuHangHao = Integer.parseInt(String.valueOf(list_message.get(6)));

        sendMessage(yiZhuType, yiZhuHangHao);
        nurseName = datas.getData(MyGlobal1.NURSE_NAME);
        if (TextUtils.isEmpty(nurseName)) {
            nurseName = "";
        }

        String date = DateUtils.getminDate();

        if(TextUtils.isEmpty(nurseName)){
            toastListener.onToastClick();
        }else {
            list = new ArrayList<>();
            list = listdata.get(postion);
            list.set(3, date);
            list.set(4, nurseName);
            takemedicineAdapter.setLists(listdata);
        }
    }

    /**
     * 发送消息
     *
     * @param etYiZhuZhongLei
     * @param etHangHao
     */
    public void sendMessage(int etYiZhuZhongLei, int etHangHao) {
        MyMessage.sendMessage(MyMessage.getMsgXueshengdianjiqianzi(
                new Integer(etYiZhuZhongLei), new Integer(etHangHao)));
    }

    public interface ToastListener {
        public void onToastClick();
    }

    public void setOntoastClickListener(ToastListener toastListener) {
        this.toastListener = toastListener;
    }

    class ViewHolder {
        TextView takemedicine_name;//姓名
        TextView takemedicine_sex;//性别
        TextView takemedicine_age;//年龄
        TextView takemedicine_division;//科室
        TextView takemedicine_bednumber;//床号
        FitHeightTextView take_medicalrecord_number;//病案号
        ListView takemedicine_list;//listview
        TextView takemedicine_years;//年
        TextView takemedicine_mouth;//月
        TextView takemedicine_day;//日
        TextView takemedicine_checkuser;//核对者
        TextView takemedicine_carryout;//执行者
        TextView takemedicine_page_number;//页数
        TakemedicineAdapter adapter;//数据源adapter

    }
}
