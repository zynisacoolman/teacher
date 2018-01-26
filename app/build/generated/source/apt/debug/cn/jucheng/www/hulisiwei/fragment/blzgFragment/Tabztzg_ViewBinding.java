// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.blzgFragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Tabztzg_ViewBinding implements Unbinder {
  private Tabztzg target;

  @UiThread
  public Tabztzg_ViewBinding(Tabztzg target, View source) {
    this.target = target;

    target.lst = Utils.findRequiredViewAsType(source, R.id.lstzg, "field 'lst'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Tabztzg target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lst = null;
  }
}
