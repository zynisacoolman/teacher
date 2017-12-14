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

public class BloodrecordlistFragment_ViewBinding implements Unbinder {
  private BloodrecordlistFragment target;

  @UiThread
  public BloodrecordlistFragment_ViewBinding(BloodrecordlistFragment target, View source) {
    this.target = target;

    target.fragmentBloodrecordlist = Utils.findRequiredViewAsType(source, R.id.fragment_fitlist, "field 'fragmentBloodrecordlist'", MyList.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BloodrecordlistFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fragmentBloodrecordlist = null;
  }
}
