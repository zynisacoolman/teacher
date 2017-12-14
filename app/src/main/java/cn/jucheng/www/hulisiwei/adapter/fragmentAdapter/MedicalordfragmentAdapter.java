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
 * 医嘱执行单分页
 */

public class MedicalordfragmentAdapter extends BaseAdapter implements MedicalorsersexrcutiveAdapter.MedUpdateListener {


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


    public MedicalordfragmentAdapter(Context context, List<String> specailList, int index) {
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
            convertView = mInflater.inflate(R.layout.adapter_fragmentmedicalord, null);
            holder = new ViewHolder();
            holder.execute_name = (TextView) convertView.findViewById(R.id.execute_name);
            holder.execute_sex = (TextView) convertView.findViewById(R.id.execute_sex);
            holder.execute_age = (TextView) convertView.findViewById(R.id.execute_age);
            holder.execute_division = (TextView) convertView.findViewById(R.id.execute_division);
            holder.execute_bednumber = (TextView) convertView.findViewById(R.id.execute_bednumber);
            holder.execute_medicalrecord_number = (FitHeightTextView) convertView.findViewById(R.id.execute_medicalrecord_number);
            holder.execute_list = (ListView) convertView.findViewById(R.id.execute_list);
            holder.medexecute_checkuser = (TextView) convertView.findViewById(R.id.medexecute_checkuser);
            holder.medexecute_date = (TextView) convertView.findViewById(R.id.medexecute_date);
            holder.medicalord_page_number = (TextView) convertView.findViewById(R.id.medicalord_page_number);
            convertView.setTag(holder); //

            holder.adapter = new MedicalorsersexrcutiveAdapter(mContext, page_List);
            holder.execute_list.setAdapter(holder.adapter);
            holder.adapter.setOnupdateClickListener(this);
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.medicalord_page_number.setText("第" + (position + 1) + "页");
        page_List = new ArrayList<>();
        page_List.addAll(CommUtils.getDataList(UserMessage.medicalord_Message, (position + 1), 10));
        holder.adapter.setLists(page_List);

        if (specailList.size() >= 0 || specailList != null) {
            holder.execute_name.setText(CommUtils.getListString(specailList, 0));
            holder.execute_sex.setText(CommUtils.getListString(specailList, 1));
            holder.execute_age.setText(CommUtils.getListString(specailList, 2));
            holder.execute_division.setText(CommUtils.getListString(specailList, 3));
            holder.execute_bednumber.setText(CommUtils.getListString(specailList, 4));
            holder.execute_medicalrecord_number.setText(CommUtils.getListString(specailList, 5));

            holder.medexecute_date.setText(DateUtils.getDate());
        }

        return convertView;
    }

    @Override
    public void onUpdateClick(int postion, MedicalorsersexrcutiveAdapter medicalorsersexrcutiveAdapter, List<List<String>> listdata) {
        List<String> list_message = new ArrayList<>();
        list_message = listdata.get(postion);
        yiZhuType = Integer.parseInt(String.valueOf(list_message.get(2)));
        yiZhuHangHao = Integer.parseInt(String.valueOf(list_message.get(3)));

        sendMessage(yiZhuType, yiZhuHangHao);
        nurseName = datas.getData(MyGlobal1.NURSE_NAME);
        if (TextUtils.isEmpty(nurseName)) {
            nurseName = "";
        }

        if(TextUtils.isEmpty(nurseName)){
            toastListener.onToastClick();
        }else {
            list = new ArrayList<>();
            list = listdata.get(postion);
            list.set(1, nurseName);
            medicalorsersexrcutiveAdapter.setLists(listdata);
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
        TextView execute_name;//姓名
        TextView execute_sex;//性别
        TextView execute_age;//年龄
        TextView execute_division;//科室
        TextView execute_bednumber;//床号
        FitHeightTextView execute_medicalrecord_number;//病案号
        ListView execute_list;//listview
        TextView medexecute_checkuser;//核对者
        TextView medexecute_date;//日期
        TextView medicalord_page_number;//页数
        MedicalorsersexrcutiveAdapter adapter;//数据源adapter

    }
}
