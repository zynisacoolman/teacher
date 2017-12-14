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

public class LongYZDFragment_ViewBinding implements Unbinder {
  private LongYZDFragment target;

  @UiThread
  public LongYZDFragment_ViewBinding(LongYZDFragment target, View source) {
    this.target = target;

    target.fragmentInjectlist = Utils.findRequiredViewAsType(source, R.id.fragment_fitlist, "field 'fragmentInjectlist'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LongYZDFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fragmentInjectlist = null;
  }
}
