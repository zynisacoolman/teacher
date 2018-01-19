// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightButton;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightEditText;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BlxqActivity_ViewBinding implements Unbinder {
  private BlxqActivity target;

  private View view2131099718;

  private View view2131100196;

  private View view2131100032;

  @UiThread
  public BlxqActivity_ViewBinding(BlxqActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BlxqActivity_ViewBinding(final BlxqActivity target, View source) {
    this.target = target;

    View view;
    target.tvNameBl = Utils.findRequiredViewAsType(source, R.id.tv_name_bl, "field 'tvNameBl'", FitHeightTextView.class);
    target.tvTimeBl = Utils.findRequiredViewAsType(source, R.id.tv_time_Bl, "field 'tvTimeBl'", FitHeightTextView.class);
    target.tvTimeState = Utils.findRequiredViewAsType(source, R.id.tv_time_state, "field 'tvTimeState'", FitHeightTextView.class);
    view = Utils.findRequiredView(source, R.id.btn_blnr, "field 'btnBlnr' and method 'onClick'");
    target.btnBlnr = Utils.castView(view, R.id.btn_blnr, "field 'btnBlnr'", FitHeightButton.class);
    view2131099718 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.btnCzjl = Utils.findRequiredViewAsType(source, R.id.btn_czjl, "field 'btnCzjl'", FitHeightButton.class);
    target.lvBlxq = Utils.findRequiredViewAsType(source, R.id.lv_blxq, "field 'lvBlxq'", ListView.class);
    view = Utils.findRequiredView(source, R.id.tv_blzg, "field 'tvBlzg' and method 'onClick'");
    target.tvBlzg = Utils.castView(view, R.id.tv_blzg, "field 'tvBlzg'", FitHeightTextView.class);
    view2131100196 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mainTabFragmentlayout = Utils.findRequiredViewAsType(source, R.id.main_tab_fragmentlayout, "field 'mainTabFragmentlayout'", FrameLayout.class);
    target.fg1 = Utils.findRequiredViewAsType(source, R.id.fg_1, "field 'fg1'", LinearLayout.class);
    target.evJstx = Utils.findRequiredViewAsType(source, R.id.ev_jstx, "field 'evJstx'", FitHeightEditText.class);
    target.tv = Utils.findRequiredViewAsType(source, R.id.tv, "field 'tv'", FitHeightTextView.class);
    view = Utils.findRequiredView(source, R.id.iv_setting, "method 'onClick'");
    view2131100032 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    BlxqActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvNameBl = null;
    target.tvTimeBl = null;
    target.tvTimeState = null;
    target.btnBlnr = null;
    target.btnCzjl = null;
    target.lvBlxq = null;
    target.tvBlzg = null;
    target.mainTabFragmentlayout = null;
    target.fg1 = null;
    target.evJstx = null;
    target.tv = null;

    view2131099718.setOnClickListener(null);
    view2131099718 = null;
    view2131100196.setOnClickListener(null);
    view2131100196 = null;
    view2131100032.setOnClickListener(null);
    view2131100032 = null;
  }
}
