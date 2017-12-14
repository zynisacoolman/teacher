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
 * 输液单每页数据
 */

public class TransfusionAdapter extends BaseAdapter {

    private List<List<String>> specailList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext = null;
    TranUpdateListener tranUpdateListener;


    public TransfusionAdapter(Context context, List<List<String>> specailList) {
        this.mContext = context;
        this.specailList = specailList;
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<List<String>> specailList) {
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    public interface TranUpdateListener {
        public void onUpdateClick(int postion, TransfusionAdapter injectionAdapter, List<List<String>> listdata);
    }

    public void setOnupdateClickListener(TranUpdateListener tranUpdateListener) {
        this.tranUpdateListener = tranUpdateListener;
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
            convertView = mInflater.inflate(R.layout.adapter_transfusion, null);
            holder = new ViewHolder();
            holder.transfusion_drug_name = (TextView) convertView.findViewById(R.id.transfusion_drug_name);
            holder.transfusion_drug_number = (TextView) convertView.findViewById(R.id.transfusion_drug_number);
            holder.transfusion_drug_usage = (TextView) convertView.findViewById(R.id.transfusion_drug_usage);
            holder.transfusion_date = (TextView) convertView.findViewById(R.id.transfusion_date);
            holder.transfusion_signature = (TextView) convertView.findViewById(R.id.transfusion_signature);
            holder.transfusion_signature_buton = (FitHeightButton) convertView.findViewById(R.id.transfusion_signature_buton);
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.transfusion_signature_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tranUpdateListener.onUpdateClick(position,TransfusionAdapter.this,specailList);
            }
        });

        if (specailList.size() >= 0 || specailList != null) {
            list = specailList.get(position);
            if (list != null)
                holder.transfusion_drug_name.setText(CommUtils.getListString(list, 0));
            holder.transfusion_drug_number.setText(CommUtils.getListString(list, 1));
            holder.transfusion_drug_usage.setText(CommUtils.getListString(list, 2));
            holder.transfusion_date.setText(CommUtils.getListString(list, 3));
            if (TextUtils.isEmpty(CommUtils.getListString(list, 4))) {
                holder.transfusion_signature.setVisibility(View.GONE);
                holder.transfusion_signature_buton.setVisibility(View.VISIBLE);
            } else {
                holder.transfusion_signature.setText(CommUtils.getListString(list, 4));
                holder.transfusion_signature.setVisibility(View.VISIBLE);
                holder.transfusion_signature_buton.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    class ViewHolder {
        TextView transfusion_drug_name;
        TextView transfusion_drug_number;
        TextView transfusion_drug_usage;
        TextView transfusion_date;
        TextView transfusion_signature;
        FitHeightButton transfusion_signature_buton;
    }
}
