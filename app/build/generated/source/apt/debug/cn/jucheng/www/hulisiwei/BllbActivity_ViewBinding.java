// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BllbActivity_ViewBinding implements Unbinder {
  private BllbActivity target;

  private View view2131231366;

  private View view2131231148;

  @UiThread
  public BllbActivity_ViewBinding(BllbActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BllbActivity_ViewBinding(final BllbActivity target, View source) {
    this.target = target;

    View view;
    target.expandableListView = Utils.findRequiredViewAsType(source, R.id.el_bllb, "field 'expandableListView'", ExpandableListView.class);
    target.vBlxq = Utils.findRequiredViewAsType(source, R.id.v_blxq_layout, "field 'vBlxq'", LinearLayout.class);
    target.tvBlxqXm = Utils.findRequiredViewAsType(source, R.id.tv_blxq_xm, "field 'tvBlxqXm'", TextView.class);
    target.tvBlxqXb = Utils.findRequiredViewAsType(source, R.id.tv_blxq_xb, "field 'tvBlxqXb'", TextView.class);
    target.tvBlxqNld = Utils.findRequiredViewAsType(source, R.id.tv_blxq_nld, "field 'tvBlxqNld'", TextView.class);
    target.tvBlxqHyzk = Utils.findRequiredViewAsType(source, R.id.tv_blxq_hyzk, "field 'tvBlxqHyzk'", TextView.class);
    target.tvBlxqXs = Utils.findRequiredViewAsType(source, R.id.tv_blxq_xs, "field 'tvBlxqXs'", TextView.class);
    target.tvBlxqDh = Utils.findRequiredViewAsType(source, R.id.tv_blxq_dh, "field 'tvBlxqDh'", TextView.class);
    target.tvBlxqZz = Utils.findRequiredViewAsType(source, R.id.tv_blxq_zz, "field 'tvBlxqZz'", TextView.class);
    target.tvBlxqZs = Utils.findRequiredViewAsType(source, R.id.tv_blxq_zs, "field 'tvBlxqZs'", TextView.class);
    target.tvBlxqXbs = Utils.findRequiredViewAsType(source, R.id.tv_blxq_xbs, "field 'tvBlxqXbs'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_btn_xl, "field 'tvbtnxl' and method 'onClick'");
    target.tvbtnxl = Utils.castView(view, R.id.tv_btn_xl, "field 'tvbtnxl'", TextView.class);
    view2131231366 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.ivexit = Utils.findRequiredViewAsType(source, R.id.iv_exit, "field 'ivexit'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.iv_settings, "method 'onClick'");
    view2131231148 = view;
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
    target.ivexit = null;

    view2131231366.setOnClickListener(null);
    view2131231366 = null;
    view2131231148.setOnClickListener(null);
    view2131231148 = null;
  }
}
