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
 * 医嘱执行单每页数据
 */

public class MedicalorsersexrcutiveAdapter extends BaseAdapter {

    private List<List<String>> specailList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext = null;
    MedUpdateListener medUpdateListener;


    public MedicalorsersexrcutiveAdapter(Context context, List<List<String>> specailList) {
        this.mContext = context;
        this.specailList = specailList;
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<List<String>> specailList) {
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    public interface MedUpdateListener {
        public void onUpdateClick(int postion, MedicalorsersexrcutiveAdapter injectionAdapter, List<List<String>> listdata);
    }

    public void setOnupdateClickListener(MedUpdateListener medUpdateListener) {
        this.medUpdateListener = medUpdateListener;
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
            convertView = mInflater.inflate(R.layout.adapter_medicalorsersexrcutive, null);
            holder = new ViewHolder();
            holder.med_drug_content = (TextView) convertView.findViewById(R.id.med_drug_content);
            holder.med_signature = (TextView) convertView.findViewById(R.id.med_signature);
            holder.med_signature_buton = (FitHeightButton) convertView.findViewById(R.id.med_signature_buton);
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.med_signature_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medUpdateListener.onUpdateClick(position,MedicalorsersexrcutiveAdapter.this,specailList);
            }
        });

        if (specailList.size() >= 0 || specailList != null) {
            list = specailList.get(position);
            if (list != null)
                holder.med_drug_content.setText(CommUtils.getListString(list, 0));
            if (TextUtils.isEmpty(CommUtils.getListString(list, 1))) {
                holder.med_signature.setVisibility(View.GONE);
                holder.med_signature_buton.setVisibility(View.VISIBLE);
            } else {
                holder.med_signature.setText(CommUtils.getListString(list, 1));
                holder.med_signature.setVisibility(View.VISIBLE);
                holder.med_signature_buton.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    class ViewHolder {
        TextView med_drug_content;
        TextView med_signature;
        FitHeightButton med_signature_buton;
    }
}
