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
 * 服药单每页的数据
 */

public class TakemedicineAdapter extends BaseAdapter {

    private List<List<String>> specailList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext = null;
    TakeUpdateListener updateListener;


    public TakemedicineAdapter(Context context, List<List<String>> specailList) {
        this.mContext = context;
        this.specailList = specailList;
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<List<String>> specailList) {
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    public interface TakeUpdateListener {
        public void onUpdateClick(int postion, TakemedicineAdapter injectionAdapter, List<List<String>> listdata);
    }

    public void setOnupdateClickListener(TakeUpdateListener updateListener) {
        this.updateListener = updateListener;
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
            convertView = mInflater.inflate(R.layout.adapter_takemedcine, null);
            holder = new ViewHolder();
            holder.take_drug_name = (TextView) convertView.findViewById(R.id.take_drug_name);
            holder.take_drug_number = (TextView) convertView.findViewById(R.id.take_drug_number);
            holder.take_drug_usage = (TextView) convertView.findViewById(R.id.take_drug_usage);
            holder.take_date = (TextView) convertView.findViewById(R.id.take_date);
            holder.take_signature = (TextView) convertView.findViewById(R.id.take_signature);
            holder.take_signature_buton = (FitHeightButton) convertView.findViewById(R.id.take_signature_buton);
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.take_signature_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateListener.onUpdateClick(position,TakemedicineAdapter.this,specailList);
            }
        });

        if (specailList.size() >= 0 || specailList != null) {
            list = specailList.get(position);
            if (list != null)
                holder.take_drug_name.setText(CommUtils.getListString(list, 0));
            holder.take_drug_number.setText(CommUtils.getListString(list, 1));
            holder.take_drug_usage.setText(CommUtils.getListString(list, 2));
            holder.take_date.setText(CommUtils.getListString(list, 3));
            if (TextUtils.isEmpty(CommUtils.getListString(list, 4))) {
                holder.take_signature.setVisibility(View.GONE);
                holder.take_signature_buton.setVisibility(View.VISIBLE);
            } else {
                holder.take_signature.setText(CommUtils.getListString(list, 4));
                holder.take_signature.setVisibility(View.VISIBLE);
                holder.take_signature_buton.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    class ViewHolder {
        TextView take_drug_name;
        TextView take_drug_number;
        TextView take_drug_usage;
        TextView take_date;
        TextView take_signature;
        FitHeightButton take_signature_buton;
    }
}
