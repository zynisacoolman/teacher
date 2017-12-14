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

public class TransfusionrecordFragment_ViewBinding implements Unbinder {
  private TransfusionrecordFragment target;

  @UiThread
  public TransfusionrecordFragment_ViewBinding(TransfusionrecordFragment target, View source) {
    this.target = target;

    target.fragmentTrancordlist = Utils.findRequiredViewAsType(source, R.id.fragment_fitlist, "field 'fragmentTrancordlist'", MyList.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TransfusionrecordFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fragmentTrancordlist = null;
  }
}
