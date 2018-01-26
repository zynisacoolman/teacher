// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterblzgTab1$ViewHolder_ViewBinding implements Unbinder {
  private AdapterblzgTab1.ViewHolder target;

  @UiThread
  public AdapterblzgTab1$ViewHolder_ViewBinding(AdapterblzgTab1.ViewHolder target, View source) {
    this.target = target;

    target.index = Utils.findRequiredViewAsType(source, R.id.index, "field 'index'", TextView.class);
    target.yznr = Utils.findRequiredViewAsType(source, R.id.yznr, "field 'yznr'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterblzgTab1.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.index = null;
    target.yznr = null;
  }
}
