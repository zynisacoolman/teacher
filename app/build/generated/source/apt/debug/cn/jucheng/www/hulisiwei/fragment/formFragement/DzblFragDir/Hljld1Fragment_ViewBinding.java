// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.base.MyList;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Hljld1Fragment_ViewBinding implements Unbinder {
  private Hljld1Fragment target;

  @UiThread
  public Hljld1Fragment_ViewBinding(Hljld1Fragment target, View source) {
    this.target = target;

    target.twd = Utils.findRequiredViewAsType(source, R.id.fragment_fitlist, "field 'twd'", MyList.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Hljld1Fragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.twd = null;
  }
}