// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Tabtzcs_ViewBinding implements Unbinder {
  private Tabtzcs target;

  @UiThread
  public Tabtzcs_ViewBinding(Tabtzcs target, View source) {
    this.target = target;

    target.tv1 = Utils.findRequiredViewAsType(source, R.id.tv_1, "field 'tv1'", TextView.class);
    target.tv3 = Utils.findRequiredViewAsType(source, R.id.tv_3, "field 'tv3'", TextView.class);
    target.tv5 = Utils.findRequiredViewAsType(source, R.id.tv_5, "field 'tv5'", TextView.class);
    target.tv2 = Utils.findRequiredViewAsType(source, R.id.tv_2, "field 'tv2'", TextView.class);
    target.tv4 = Utils.findRequiredViewAsType(source, R.id.tv_4, "field 'tv4'", TextView.class);
    target.tv6 = Utils.findRequiredViewAsType(source, R.id.tv_6, "field 'tv6'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Tabtzcs target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv1 = null;
    target.tv3 = null;
    target.tv5 = null;
    target.tv2 = null;
    target.tv4 = null;
    target.tv6 = null;
  }
}
