// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BllbActivity_ViewBinding implements Unbinder {
  private BllbActivity target;

  @UiThread
  public BllbActivity_ViewBinding(BllbActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BllbActivity_ViewBinding(BllbActivity target, View source) {
    this.target = target;

    target.expandableListView = Utils.findRequiredViewAsType(source, R.id.el_bllb, "field 'expandableListView'", ExpandableListView.class);
    target.vBlxq = Utils.findRequiredViewAsType(source, R.id.v_blxq_layout, "field 'vBlxq'", LinearLayout.class);
    target.tvBlxqXm = Utils.findRequiredViewAsType(source, R.id.tv_blxq_xm, "field 'tvBlxqXm'", FitHeightTextView.class);
    target.tvBlxqXb = Utils.findRequiredViewAsType(source, R.id.tv_blxq_xb, "field 'tvBlxqXb'", FitHeightTextView.class);
    target.tvBlxqNld = Utils.findRequiredViewAsType(source, R.id.tv_blxq_nld, "field 'tvBlxqNld'", FitHeightTextView.class);
    target.tvBlxqHyzk = Utils.findRequiredViewAsType(source, R.id.tv_blxq_hyzk, "field 'tvBlxqHyzk'", FitHeightTextView.class);
    target.tvBlxqXs = Utils.findRequiredViewAsType(source, R.id.tv_blxq_xs, "field 'tvBlxqXs'", FitHeightTextView.class);
    target.tvBlxqDh = Utils.findRequiredViewAsType(source, R.id.tv_blxq_dh, "field 'tvBlxqDh'", FitHeightTextView.class);
    target.tvBlxqZz = Utils.findRequiredViewAsType(source, R.id.tv_blxq_zz, "field 'tvBlxqZz'", FitHeightTextView.class);
    target.tvBlxqZs = Utils.findRequiredViewAsType(source, R.id.tv_blxq_zs, "field 'tvBlxqZs'", FitHeightTextView.class);
    target.tvBlxqXbs = Utils.findRequiredViewAsType(source, R.id.tv_blxq_xbs, "field 'tvBlxqXbs'", FitHeightTextView.class);
    target.tvbtnxl = Utils.findRequiredViewAsType(source, R.id.tv_btn_xl, "field 'tvbtnxl'", FitHeightTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BllbActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.expandableListView = null;
    target.vBlxq = null;
    target.tvBlxqXm = null;
    target.tvBlxqXb = null;
    target.tvBlxqNld = null;
    target.tvBlxqHyzk = null;
    target.tvBlxqXs = null;
    target.tvBlxqDh = null;
    target.tvBlxqZz = null;
    target.tvBlxqZs = null;
    target.tvBlxqXbs = null;
    target.tvbtnxl = null;
  }
}