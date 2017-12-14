// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.formFragement;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.MyList;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TakemedicinelistFragment_ViewBinding implements Unbinder {
  private TakemedicinelistFragment target;

  @UiThread
  public TakemedicinelistFragment_ViewBinding(TakemedicinelistFragment target, View source) {
    this.target = target;

    target.fragmentTakemedicinelist = Utils.findRequiredViewAsType(source, R.id.fragment_fitlist, "field 'fragmentTakemedicinelist'", MyList.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TakemedicinelistFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fragmentTakemedicinelist = null;
  }
}
