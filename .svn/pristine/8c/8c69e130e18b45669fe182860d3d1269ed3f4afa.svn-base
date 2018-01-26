package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import cn.jucheng.www.hulisiwei.module.UserMessage;

/**
 * Created by zyn on 2017/12/21.
 */

public class XTJLDiTemFragmentAdapter extends BaseAdapter {
    int page;
    Context context;

    public XTJLDiTemFragmentAdapter(Context mcontext, int Page) {
        page = Page;
        context = mcontext;
    }

    @Override
    public int getCount() {
        return UserMessage.XTJLD.size() - 18 * page > 18 ? 18 : UserMessage.YZDlongstart.size() - 18 * page;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.layout_xtjld_item, parent);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.data.setText(UserMessage.XTJLD.get(page).getDate());
        vh.shang1.setText(UserMessage.XTJLD.get(page).getData().get(position*18).get(0));
        vh.xia1.setText(UserMessage.XTJLD.get(page).getData().get(position*18).get(1));
        vh.shang2.setText(UserMessage.XTJLD.get(page).getData().get(1+position*18).get(0));
        vh.xia2.setText(UserMessage.XTJLD.get(page).getData().get(1+position*18).get(1));
        vh.shang3.setText(UserMessage.XTJLD.get(page).getData().get(2+position*18).get(0));
        vh.xia3.setText(UserMessage.XTJLD.get(page).getData().get(2+position*18).get(1));
        vh.shang4.setText(UserMessage.XTJLD.get(page).getData().get(3+position*18).get(0));
        vh.xia4.setText(UserMessage.XTJLD.get(page).getData().get(3+position*18).get(1));
        vh.shang5.setText(UserMessage.XTJLD.get(page).getData().get(4+position*18).get(0));
        vh.xia5.setText(UserMessage.XTJLD.get(page).getData().get(4+position*18).get(1));
        vh.shang6.setText(UserMessage.XTJLD.get(page).getData().get(5+position*18).get(0));
        vh.xia6.setText(UserMessage.XTJLD.get(page).getData().get(5+position*18).get(1));
        vh.shang7.setText(UserMessage.XTJLD.get(page).getData().get(6+position*18).get(0));
        vh.xia7.setText(UserMessage.XTJLD.get(page).getData().get(6+position*18).get(1));
        vh.shang8.setText(UserMessage.XTJLD.get(page).getData().get(7+position*18).get(0));
        vh.xia8.setText(UserMessage.XTJLD.get(page).getData().get(7+position*18).get(1));

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.data)
        TextView data;
        @BindView(R.id.shang1)
        FitHeightTextView shang1;
        @BindView(R.id.shang2)
        FitHeightTextView shang2;
        @BindView(R.id.shang3)
        FitHeightTextView shang3;
        @BindView(R.id.shang4)
        FitHeightTextView shang4;
        @BindView(R.id.shang5)
        FitHeightTextView shang5;
        @BindView(R.id.shang6)
        FitHeightTextView shang6;
        @BindView(R.id.shang7)
        FitHeightTextView shang7;
        @BindView(R.id.shang8)
        FitHeightTextView shang8;
        @BindView(R.id.xia1)
        FitHeightTextView xia1;
        @BindView(R.id.xia2)
        FitHeightTextView xia2;
        @BindView(R.id.xia3)
        FitHeightTextView xia3;
        @BindView(R.id.xia4)
        FitHeightTextView xia4;
        @BindView(R.id.xia5)
        FitHeightTextView xia5;
        @BindView(R.id.xia6)
        FitHeightTextView xia6;
        @BindView(R.id.xia7)
        FitHeightTextView xia7;
        @BindView(R.id.xia8)
        FitHeightTextView xia8;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
