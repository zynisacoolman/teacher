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
 * Created by w on 2017-11-25.
 * 注射单每页的数据数据
 */

public class InjectionAdapter extends BaseAdapter {

    private List<List<String>> specailList = new ArrayList<>();
    List<String> list = new ArrayList<>();

    private LayoutInflater mInflater;
    private Context mContext = null;
    UpdateListener updateListener;


    public InjectionAdapter(Context context, List<List<String>> specailList) {
        this.mContext = context;
        this.specailList = specailList;
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<List<String>> specailList) {
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    public interface UpdateListener {
        public void onUpdateClick(int postion, InjectionAdapter injectionAdapter, List<List<String>> listdata);
    }

    public void setOnupdateClickListener(UpdateListener updateListener) {
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
            convertView = mInflater.inflate(R.layout.adapter_injections, null);
            holder = new ViewHolder();
            holder.inject_drug_name = (TextView) convertView.findViewById(R.id.inject_drug_name);
            holder.inject_drug_number = (TextView) convertView.findViewById(R.id.inject_drug_number);
            holder.inject_drug_usage = (TextView) convertView.findViewById(R.id.inject_drug_usage);
            holder.inject_date = (TextView) convertView.findViewById(R.id.inject_date);
            holder.inject_signature = (TextView) convertView.findViewById(R.id.inject_signature);
            holder.inject_signature_buton = (FitHeightButton) convertView.findViewById(R.id.inject_signature_buton);
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.inject_signature_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateListener.onUpdateClick(position, InjectionAdapter.this, specailList);
            }
        });

        if (specailList.size() >= 0 || specailList != null) {
            list = specailList.get(position);
            if (list != null)
                holder.inject_drug_name.setText(CommUtils.getListString(list, 0));
            holder.inject_drug_number.setText(CommUtils.getListString(list, 1));
            holder.inject_drug_usage.setText(CommUtils.getListString(list, 2));
            holder.inject_date.setText(CommUtils.getListString(list, 3));
            if (TextUtils.isEmpty(CommUtils.getListString(list, 4))) {
                holder.inject_signature.setVisibility(View.GONE);
                holder.inject_signature_buton.setVisibility(View.VISIBLE);
            } else {
                holder.inject_signature.setText(CommUtils.getListString(list, 4));
                holder.inject_signature.setVisibility(View.VISIBLE);
                holder.inject_signature_buton.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    class ViewHolder {
        TextView inject_drug_name;
        TextView inject_drug_number;
        TextView inject_drug_usage;
        TextView inject_date;
        TextView inject_signature;
        FitHeightButton inject_signature_buton;
    }
}