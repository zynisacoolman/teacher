// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HLJL3itemAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HLJL3itemAdapter.ViewHolder target;

  @UiThread
  public HLJL3itemAdapter$ViewHolder_ViewBinding(HLJL3itemAdapter.ViewHolder target, View source) {
    this.target = target;

    target.ftSj = Utils.findRequiredViewAsType(source, R.id.ft_sj, "field 'ftSj'", FitHeightTextView.class);
    target.ftXm = Utils.findRequiredViewAsType(source, R.id.ft_xm, "field 'ftXm'", FitHeightTextView.class);
    target.ftSl = Utils.findRequiredViewAsType(source, R.id.ft_sl, "field 'ftSl'", FitHeightTextView.class);
    target.ftXm2 = Utils.findRequiredViewAsType(source, R.id.ft_xm2, "field 'ftXm2'", FitHeightTextView.class);
    target.ftSl2 = Utils.findRequiredViewAsType(source, R.id.ft_sl2, "field 'ftSl2'", FitHeightTextView.class);
    target.ftQm = Utils.findRequiredViewAsType(source, R.id.ft_qm, "field 'ftQm'", FitHeightTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HLJL3itemAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ftSj = null;
    target.ftXm = null;
    target.ftSl = null;
    target.ftXm2 = null;
    target.ftSl2 = null;
    target.ftQm = null;
  }
}
