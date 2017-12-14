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
 * 治疗单数据页
 */

public class CureAdapter extends BaseAdapter {

    private List<List<String>> specailList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext = null;
    CureUpdateListener updateListener;


    public CureAdapter(Context context, List<List<String>> specailList) {
        this.mContext = context;
        this.specailList = specailList;
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<List<String>> specailList) {
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    public interface CureUpdateListener {
        public void onUpdateClick(int postion, CureAdapter cureAdapter, List<List<String>> listdata);
    }

    public void setOnupdateClickListener(CureUpdateListener updateListener) {
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
            convertView = mInflater.inflate(R.layout.adapter_curelist, null);
            holder = new ViewHolder();
            holder.cure_date = (TextView) convertView.findViewById(R.id.cure_date);
            holder.cure_exture = (TextView) convertView.findViewById(R.id.cure_exture);
            holder.cure_drug_qianzi = (TextView) convertView.findViewById(R.id.cure_drug_qianzi);
            holder.cure_qianiz = (TextView) convertView.findViewById(R.id.cure_qianiz);
            holder.cure_signature_buton = (FitHeightButton) convertView.findViewById(R.id.cure_signature_buton);
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.cure_signature_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateListener.onUpdateClick(position,CureAdapter.this,specailList);
            }
        });

        if (specailList.size() >= 0 || specailList != null) {
            list = specailList.get(position);
            if (list != null)
                holder.cure_date.setText(CommUtils.getListString(list, 0));
            holder.cure_exture.setText(CommUtils.getListString(list, 1));
            holder.cure_drug_qianzi.setText(CommUtils.getListString(list, 2));
            if (TextUtils.isEmpty(CommUtils.getListString(list, 3))) {
                holder.cure_qianiz.setVisibility(View.GONE);
                holder.cure_signature_buton.setVisibility(View.VISIBLE);
            } else {
                holder.cure_qianiz.setText(CommUtils.getListString(list, 3));
                holder.cure_qianiz.setVisibility(View.VISIBLE);
                holder.cure_signature_buton.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    class ViewHolder {
        //日期
        TextView cure_date;
        //治疗项目
        TextView cure_exture;
        //患者签字
        TextView cure_drug_qianzi;
        //签字
        TextView cure_qianiz;
        FitHeightButton cure_signature_buton;
    }
}
