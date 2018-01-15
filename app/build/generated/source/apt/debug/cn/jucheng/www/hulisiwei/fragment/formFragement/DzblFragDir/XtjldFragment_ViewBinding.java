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

public class XtjldFragment_ViewBinding implements Unbinder {
  private XtjldFragment target;

  @UiThread
  public XtjldFragment_ViewBinding(XtjldFragment target, View source) {
    this.target = target;

    target.xtjld = Utils.findRequiredViewAsType(source, R.id.xtjc_list, "field 'xtjld'", MyList.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    XtjldFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.xtjld = null;
  }
}
