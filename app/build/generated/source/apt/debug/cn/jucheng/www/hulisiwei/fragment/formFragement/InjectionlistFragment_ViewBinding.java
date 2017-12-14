// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.formFragement;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InjectionlistFragment_ViewBinding implements Unbinder {
  private InjectionlistFragment target;

  @UiThread
  public InjectionlistFragment_ViewBinding(InjectionlistFragment target, View source) {
    this.target = target;

    target.fragmentInjectlist = Utils.findRequiredViewAsType(source, R.id.fragment_fitlist, "field 'fragmentInjectlist'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InjectionlistFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fragmentInjectlist = null;
  }
}
