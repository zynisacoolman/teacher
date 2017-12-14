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
 * Created by w on 2017-11-28.
 * 输血观察记录单数据页
 */

public class BloodrecordAdapter extends BaseAdapter {

    private List<List<String>> specailList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext = null;
    BollUpdateListener bollUpdateListener;

    public BloodrecordAdapter(Context context, List<List<String>> specailList) {
        this.mContext = context;
        this.specailList = specailList;
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<List<String>> specailList) {
        this.specailList = specailList;
        notifyDataSetChanged();
    }

    public interface BollUpdateListener {
        public void onUpdateClick(int postion, BloodrecordAdapter injectionAdapter, List<List<String>> listdata);
    }

    public void setOnupdateClickListener(BollUpdateListener bollUpdateListener) {
        this.bollUpdateListener = bollUpdateListener;
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
            convertView = mInflater.inflate(R.layout.adapter_bloodrecord, null);
            holder = new ViewHolder();
            holder.bllodrecord_date = (TextView) convertView.findViewById(R.id.bllodrecord_date);
            holder.bllodrecord_animalheat = (TextView) convertView.findViewById(R.id.bllodrecord_animalheat);
            holder.bllodrecord_headneedle = (TextView) convertView.findViewById(R.id.bllodrecord_headneedle);
            holder.bllodrecord_remainingneedle = (TextView) convertView.findViewById(R.id.bllodrecord_remainingneedle);
            holder.bllodrecord_ductusvenosus = (TextView) convertView.findViewById(R.id.bllodrecord_ductusvenosus);
            holder.bllodrecord_rbc = (TextView) convertView.findViewById(R.id.bllodrecord_rbc);
            holder.bllodrecord_plt = (TextView) convertView.findViewById(R.id.bllodrecord_plt);
            holder.bllodrecord_plasma = (TextView) convertView.findViewById(R.id.bllodrecord_plasma);
            holder.bllodrecord_else = (TextView) convertView.findViewById(R.id.bllodrecord_else);
            holder.bllodrecord_performer = (TextView) convertView.findViewById(R.id.bllodrecord_performer);
            holder.bllodrecord_checker = (TextView) convertView.findViewById(R.id.bllodrecord_checker);
            holder.bllodrecord_action_time = (TextView) convertView.findViewById(R.id.bllodrecord_action_time);
            holder.bllodrecord_healthguidance = (TextView) convertView.findViewById(R.id.bllodrecord_healthguidance);
            holder.bllodrecord_15min = (TextView) convertView.findViewById(R.id.bllodrecord_15min);
            holder.bllodrecord_30min = (TextView) convertView.findViewById(R.id.bllodrecord_30min);
            holder.bllodrecord_1h = (TextView) convertView.findViewById(R.id.bllodrecord_1h);
            holder.bllodrecord_2h = (TextView) convertView.findViewById(R.id.bllodrecord_2h);
            holder.bllodrecord_3h = (TextView) convertView.findViewById(R.id.bllodrecord_3h);
            holder.bllodrecord_rest = (TextView) convertView.findViewById(R.id.bllodrecord_rest);
            holder.bllodrecord_not = (TextView) convertView.findViewById(R.id.bllodrecord_not);
            holder.bllodrecord_allergy = (TextView) convertView.findViewById(R.id.bllodrecord_allergy);
            holder.bllodrecord_fever = (TextView) convertView.findViewById(R.id.bllodrecord_fever);
            holder.bllodrecord_solutioncontent = (TextView) convertView.findViewById(R.id.bllodrecord_solutioncontent);
            holder.bllodrecord_largedose = (TextView) convertView.findViewById(R.id.bllodrecord_largedose);
            holder.bllodrecord_endtime = (TextView) convertView.findViewById(R.id.bllodrecord_endtime);
            holder.bllodrecord_nursname = (TextView) convertView.findViewById(R.id.bllodrecord_nursname);
            holder.bllodrecord_signature_buton = (FitHeightButton) convertView.findViewById(R.id.bllodrecord_signature_buton);
            convertView.setTag(holder); //
        } else {
            holder = (ViewHolder) convertView.getTag(); //
        }

        holder.bllodrecord_signature_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bollUpdateListener.onUpdateClick(position,BloodrecordAdapter.this,specailList);
            }
        });

        if (specailList.size() >= 0 || specailList != null) {
            list = specailList.get(position);
            if (list != null)
                holder.bllodrecord_date.setText(CommUtils.getListString(list, 0));
            holder.bllodrecord_animalheat.setText(CommUtils.getListString(list, 1));
            holder.bllodrecord_headneedle.setText(CommUtils.getListString(list, 2));
            holder.bllodrecord_remainingneedle.setText(CommUtils.getListString(list, 3));
            holder.bllodrecord_ductusvenosus.setText(CommUtils.getListString(list, 4));
            holder.bllodrecord_rbc.setText(CommUtils.getListString(list, 5));
            holder.bllodrecord_plt.setText(CommUtils.getListString(list, 6));
            holder.bllodrecord_plasma.setText(CommUtils.getListString(list, 7));
            holder.bllodrecord_else.setText(CommUtils.getListString(list, 8));
            holder.bllodrecord_performer.setText(CommUtils.getListString(list, 9));
            holder.bllodrecord_checker.setText(CommUtils.getListString(list, 10));
            holder.bllodrecord_action_time.setText(CommUtils.getListString(list, 11));
            holder.bllodrecord_healthguidance.setText(CommUtils.getListString(list, 12));
            holder.bllodrecord_15min.setText(CommUtils.getListString(list, 13));
            holder.bllodrecord_30min.setText(CommUtils.getListString(list, 14));
            holder.bllodrecord_1h.setText(CommUtils.getListString(list, 15));
            holder.bllodrecord_2h.setText(CommUtils.getListString(list, 16));
            holder.bllodrecord_3h.setText(CommUtils.getListString(list, 17));
            holder.bllodrecord_rest.setText(CommUtils.getListString(list, 18));
            holder.bllodrecord_not.setText(CommUtils.getListString(list, 19));
            holder.bllodrecord_allergy.setText(CommUtils.getListString(list, 20));
            holder.bllodrecord_fever.setText(CommUtils.getListString(list, 21));
            holder.bllodrecord_solutioncontent.setText(CommUtils.getListString(list, 22));
            holder.bllodrecord_largedose.setText(CommUtils.getListString(list, 23));
            holder.bllodrecord_endtime.setText(CommUtils.getListString(list, 24));
            if (TextUtils.isEmpty(CommUtils.getListString(list, 25))) {
                holder.bllodrecord_nursname.setVisibility(View.GONE);
                holder.bllodrecord_signature_buton.setVisibility(View.VISIBLE);
            } else {
                holder.bllodrecord_nursname.setText(CommUtils.getListString(list, 25));
                holder.bllodrecord_nursname.setVisibility(View.VISIBLE);
                holder.bllodrecord_signature_buton.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    class ViewHolder {
        //日期
        TextView bllodrecord_date;
        //体温
        TextView bllodrecord_animalheat;
        //头皮针
        TextView bllodrecord_headneedle;
        //留置针
        TextView bllodrecord_remainingneedle;
        //静脉导管
        TextView bllodrecord_ductusvenosus;
        //RBC
        TextView bllodrecord_rbc;
        //PLT
        TextView bllodrecord_plt;
        //血浆
        TextView bllodrecord_plasma;
        //其他
        TextView bllodrecord_else;
        //执行者
        TextView bllodrecord_performer;
        //核对者
        TextView bllodrecord_checker;
        //开始时间
        TextView bllodrecord_action_time;
        //健康指导
        TextView bllodrecord_healthguidance;
        //15min
        TextView bllodrecord_15min;
        //30min
        TextView bllodrecord_30min;
        //1h
        TextView bllodrecord_1h;
        //2h
        TextView bllodrecord_2h;
        //3h
        TextView bllodrecord_3h;
        //输血观察其他
        TextView bllodrecord_rest;
        //无
        TextView bllodrecord_not;
        //过敏
        TextView bllodrecord_allergy;
        //发热
        TextView bllodrecord_fever;
        //溶量
        TextView bllodrecord_solutioncontent;
        //大剂量
        TextView bllodrecord_largedose;
        //结束时间
        TextView bllodrecord_endtime;
        //护士签名
        TextView bllodrecord_nursname;
        FitHeightButton bllodrecord_signature_buton;
    }
}
