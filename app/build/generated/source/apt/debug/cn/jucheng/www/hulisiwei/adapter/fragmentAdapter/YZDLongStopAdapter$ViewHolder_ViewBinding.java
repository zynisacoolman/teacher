// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.adapter.fragmentAdapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class YZDLongStopAdapter$ViewHolder_ViewBinding implements Unbinder {
  private YZDLongStopAdapter.ViewHolder target;

  @UiThread
  public YZDLongStopAdapter$ViewHolder_ViewBinding(YZDLongStopAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.fvData = Utils.findRequiredViewAsType(source, R.id.fv_data, "field 'fvData'", TextView.class);
    target.fvTime = Utils.findRequiredViewAsType(source, R.id.fv_time, "field 'fvTime'", TextView.class);
    target.fvYssign = Utils.findRequiredViewAsType(source, R.id.fv_yssign, "field 'fvYssign'", TextView.class);
    target.fvHssign = Utils.findRequiredViewAsType(source, R.id.fv_hssign, "field 'fvHssign'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    YZDLongStopAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fvData = null;
    target.fvTime = null;
    target.fvYssign = null;
    target.fvHssign = null;
  }
}
