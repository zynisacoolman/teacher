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

public class Tabyzlb_ViewBinding implements Unbinder {
  private Tabyzlb target;

  @UiThread
  public Tabyzlb_ViewBinding(Tabyzlb target, View source) {
    this.target = target;

    target.lst = Utils.findRequiredViewAsType(source, R.id.tab1_yzlb, "field 'lst'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Tabyzlb target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lst = null;
  }
}
