// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ZqtysFragment_ViewBinding implements Unbinder {
  private ZqtysFragment target;

  @UiThread
  public ZqtysFragment_ViewBinding(ZqtysFragment target, View source) {
    this.target = target;

    target.h_name = Utils.findRequiredViewAsType(source, R.id.h_name, "field 'h_name'", TextView.class);
    target.h_age = Utils.findRequiredViewAsType(source, R.id.h_age, "field 'h_age'", TextView.class);
    target.h_bednum = Utils.findRequiredViewAsType(source, R.id.h_bednumber, "field 'h_bednum'", TextView.class);
    target.h_division = Utils.findRequiredViewAsType(source, R.id.h_division, "field 'h_division'", TextView.class);
    target.h_illrecordNum = Utils.findRequiredViewAsType(source, R.id.h_illrecordNum, "field 'h_illrecordNum'", TextView.class);
    target.h_sex = Utils.findRequiredViewAsType(source, R.id.h_sex, "field 'h_sex'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ZqtysFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.h_name = null;
    target.h_age = null;
    target.h_bednum = null;
    target.h_division = null;
    target.h_illrecordNum = null;
    target.h_sex = null;
  }
}
