// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
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
  }

  @Override
  @CallSuper
  public void unbind() {
    BllbActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.expandableListView = null;
    target.vBlxq = null;
  }
}
