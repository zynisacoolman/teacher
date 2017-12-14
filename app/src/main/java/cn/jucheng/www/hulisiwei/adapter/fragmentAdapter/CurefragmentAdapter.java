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

import cn.jucheng.jclibs.tools.MyLog;
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
 * 治疗单页数
 */

public class CurefragmentAdapter extends BaseAdapter implements CureAdapter.CureUpdateListener {

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


    public CurefragmentAdapter(Context context, List<String> specailList, int index) {
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
            convertView = mInflater.inflate(R.layout.adapter_fragmentcure, null);
            holder = new ViewHolder();
            holder.cureName = (TextView) convertView.findViewById(R.id.cure_name);
            holder.cure_sex = (TextView) convertView.findViewById(R.id.cure_sex);
            holder.cure_age = (TextView) convertView.findViewById(R.id.cure_age);
            holder.cure_division = (TextView) convertView.findViewById(R.id.cure_division);
            holder.cure_bednumber = (TextView) convertView.findViewById(R.id.cure_bednumber);
            holder.cure_medicalrecord_number = (FitHeightTextView) convertView.findViewById(R.id.cure_medicalrecord_number);
            holder.cure_list = (ListView) convertView.findViewById(R.id.cure_list);
            holder.cure_years = (TextView) convertView.findViewById(R.id.cure_years);
            holder.cure_mouth = (TextView) convertView.findViewById(R.id.cure_mouth);
            holder.cure_day = (TextView) convertView.findViewById(R.id.cure_day);
            holder.cure_checkuser = (TextView) convertView.findViewById(R.id.cure_checkuser);
            holder.cure_carryout = (TextView) convertView.findViewById(R.id.cure_carryout);
            convertView.setTag(holder); //

            holder.adapter = new CureAdapter(mContext, page_List);
            holder.cure_list.setAdapter(holder.adapter);
            holder.adapter.setOnupdateClickListener(this);
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

//        holder.cure_page_number.setText("第" + (position + 1) + "页");
        page_List = new ArrayList<>();
        page_List.addAll(CommUtils.getDataList(UserMessage.cure_Message, (position + 1), 22));
        holder.adapter.setLists(page_List);

        if (specailList.size() >= 0 || specailList != null) {
            holder.cureName.setText(CommUtils.getListString(specailList, 0));
            holder.cure_sex.setText(CommUtils.getListString(specailList, 1));
            holder.cure_age.setText(CommUtils.getListString(specailList, 2));
            holder.cure_division.setText(CommUtils.getListString(specailList, 3));
            holder.cure_bednumber.setText(CommUtils.getListString(specailList, 4));
            holder.cure_medicalrecord_number.setText(CommUtils.getListString(specailList, 5));

            if ("".equals(holder.cure_years.getText().toString())) {
                holder.cure_years.setText(DateUtils.getYear());
                holder.cure_mouth.setText(DateUtils.getMonth());
                holder.cure_day.setText(DateUtils.getDay());
            }
            nurseName = datas.getData(MyGlobal1.NURSE_NAME);
            if (nurseName != null && !TextUtils.isEmpty(nurseName)) {
                holder.cure_carryout.setText(nurseName);
            } else {
                holder.cure_carryout.setText("");
            }
        }
        return convertView;
    }

    @Override
    public void onUpdateClick(int postion, CureAdapter cureAdapter, List<List<String>> listdata) {
        MyLog.d("mwh","listdata"+listdata);
        List<String> list_message = new ArrayList<>();
        list_message = listdata.get(postion);
        MyLog.d("mwh","list_message"+list_message);
        yiZhuType = Integer.parseInt(String.valueOf(list_message.get(4)));
        yiZhuHangHao = Integer.parseInt(String.valueOf(list_message.get(5)));

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
            list.set(0, date);
            list.set(3, nurseName);
            cureAdapter.setLists(listdata);
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
        TextView cureName;//姓名
        TextView cure_sex;//性别
        TextView cure_age;//年龄
        TextView cure_division;//科室
        TextView cure_bednumber;//床号
        FitHeightTextView cure_medicalrecord_number;//病案号
        ListView cure_list;//listview
        TextView cure_years;//年
        TextView cure_mouth;//月
        TextView cure_day;//日
        TextView cure_checkuser;//核对者
        TextView cure_carryout;//执行者
//        TextView cure_page_number;//页数
        CureAdapter adapter;//数据源adapter

    }
}
