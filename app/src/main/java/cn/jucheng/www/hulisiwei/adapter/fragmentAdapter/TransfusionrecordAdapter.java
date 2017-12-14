package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightButton;
import cn.jucheng.www.hulisiwei.utils.CommUtils;

/**
 * Created by w on 2017-11-27.
 * 输液记录单每页数据
 */

public class TransfusionrecordAdapter extends BaseAdapter {

    private List<List<String>> specailList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext = null;
    CordUpdateListener cordUpdateListener;


    public TransfusionrecordAdapter(Context context, List<List<String>> specailList) {
        this.mContext = context;
        this.specailList = specailList;
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<List<String>> specailList) {
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    public interface CordUpdateListener {
        public void onUpdateClick(int postion, TransfusionrecordAdapter injectionAdapter, List<List<String>> listdata);
    }

    public void setOnupdateClickListener(CordUpdateListener cordUpdateListener) {
        this.cordUpdateListener = cordUpdateListener;
    }

    @Override
    public int getCount() {
        return specailList.size();
    }

    @Override
    public Object getItem(int position) {
        return specailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_transfusionrecord, null);
            holder = new ViewHolder();
            holder.cords_drug_name = (TextView) convertView.findViewById(R.id.cords_drug_name);
            holder.cords_drug_number = (TextView) convertView.findViewById(R.id.cords_drug_number);
            holder.cords_drug_speed = (TextView) convertView.findViewById(R.id.cords_drug_speed);
            holder.cords_untowardeffect = (TextView) convertView.findViewById(R.id.cords_untowardeffect);
            holder.cords_dates = (TextView) convertView.findViewById(R.id.cords_dates);
            holder.cords_signature = (TextView) convertView.findViewById(R.id.cords_signature);
            holder.cords_signature_buton = (FitHeightButton) convertView.findViewById(R.id.cords_signature_buton);
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.cords_signature_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cordUpdateListener.onUpdateClick(position,TransfusionrecordAdapter.this,specailList);
            }
        });

        if (specailList.size() >= 0 || specailList != null) {
            list = specailList.get(position);
            if (list != null)
                holder.cords_drug_name.setText(CommUtils.getListString(list, 0));
            holder.cords_drug_number.setText(CommUtils.getListString(list, 1));
            holder.cords_drug_speed.setText(CommUtils.getListString(list, 2));
            holder.cords_untowardeffect.setText(CommUtils.getListString(list, 3));
            holder.cords_dates.setText(CommUtils.getListString(list, 4));
            if (TextUtils.isEmpty(CommUtils.getListString(list, 5))) {
                holder.cords_signature.setVisibility(View.GONE);
                holder.cords_signature_buton.setVisibility(View.VISIBLE);
            } else {
                holder.cords_signature.setText(CommUtils.getListString(list, 5));
                holder.cords_signature.setVisibility(View.VISIBLE);
                holder.cords_signature_buton.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    class ViewHolder {
        TextView cords_drug_name;//药物名称
        TextView cords_drug_number;//数量
        TextView cords_drug_speed;//速度
        TextView cords_untowardeffect;//不良反应
        TextView cords_dates;//时间
        TextView cords_signature;//签字
        FitHeightButton cords_signature_buton;
    }
}
