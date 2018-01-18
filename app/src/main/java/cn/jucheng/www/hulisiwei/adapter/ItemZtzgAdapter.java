package cn.jucheng.www.hulisiwei.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.databean.blzgbean.TableItemBlzgBean;

/**
 * Created by zyn on 2018/1/16.
 */

public class ItemZtzgAdapter extends BaseAdapter {
    Context context;
    ArrayList<TableItemBlzgBean> arrayList;
    private LayoutInflater mInflater;
    Typeface tf;
    //此参数为了防止getView多次调用
    int getview次数=0;

    public ItemZtzgAdapter(Context mcontext, ArrayList<TableItemBlzgBean> datas) {
        context = mcontext;
        arrayList = datas;
        AssetManager mgr=context.getAssets();
        tf=Typeface.createFromAsset(mgr, "fonts/msyh.ttf");
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        getview次数++;
        if(getview次数>1){
            if(convertView != null){
                return convertView;
            }
        }
        ViewHolder vh ;
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.item_tab_ztzg_adapter, null);
                vh = new ViewHolder(convertView);
                convertView.setTag(vh);
            }else{
                vh = (ViewHolder)convertView.getTag();
            }
        vh.tvOrder.setText(new StringBuilder().append(position + 1).append("").toString());
        vh.tvOrder.setBackgroundResource(R.drawable.excel_bottom_line);
        for(String str:arrayList.get(position).get遗嘱内容()){
            TextView tv = new TextView(context);
            tv.setText(str);
            tv.setTypeface(tf);
            tv.setBackgroundResource(R.color.bg_bgcolor2);//bg_bgcolor2
            tv.setTextColor(context.getResources().getColor(R.color.btn_color_blue));
            tv.setTextSize(18);
            tv.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.CENTER;
            params.weight = 1 ;
            tv.setLayoutParams(params);
            tv.setBackgroundResource(R.drawable.excel_bottom_line);
            vh.llYizhu.addView(tv);
        }
        for(TableItemBlzgBean.Exitdispose str:arrayList.get(position).get出口状态概率()){
            TextView tv1 = new TextView(context);

            LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            paramss.weight = 1;

            tv1.setGravity(Gravity.CENTER);
            tv1.setText(str.get出口状态());
            tv1.setTypeface(tf);
            tv1.setBackgroundResource(R.color.bg_bgcolor2);//bg_bgcolor2
            tv1.setTextColor(context.getResources().getColor(R.color.btn_color_blue));
            tv1.setTextSize(18);
            tv1.setLayoutParams(paramss);
            tv1.setBackgroundResource(R.drawable.excel_bottom_line);
            vh.llChukou1.addView(tv1);

            TextView tv2 = new TextView(context);
            tv2.setText(String.format("%d", str.get出口概率()));
            tv2.setTypeface(tf);
            tv2.setGravity(Gravity.CENTER);
            tv2.setBackgroundResource(R.color.bg_bgcolor2);//bg_bgcolor2
            tv2.setTextColor(context.getResources().getColor(R.color.btn_color_blue));
            tv2.setTextSize(18);
            tv2.setLayoutParams(paramss);
            tv2.setBackgroundResource(R.drawable.excel_bottom_line);

            vh.llChukou2.addView(tv2);
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_order)
        TextView tvOrder;
        @BindView(R.id.ll_yizhu)
        LinearLayout llYizhu;
        @BindView(R.id.ll_chukou1)
        LinearLayout llChukou1;
        @BindView(R.id.ll_chukou2)
        LinearLayout llChukou2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
