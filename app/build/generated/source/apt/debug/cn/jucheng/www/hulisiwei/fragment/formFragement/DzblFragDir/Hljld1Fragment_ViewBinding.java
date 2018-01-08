// Generated code from Butter Knife. Do not modify!
package cn.jucheng.www.hulisiwei.fragment.formFragement.DzblFragDir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jucheng.www.hulisiwei.R;
import cn.jucheng.www.hulisiwei.customcontrols.FitHeightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Hljld1Fragment_ViewBinding implements Unbinder {
  private Hljld1Fragment target;

  @UiThread
  public Hljld1Fragment_ViewBinding(Hljld1Fragment target, View source) {
    this.target = target;

    target.h_name = Utils.findRequiredViewAsType(source, R.id.h_name, "field 'h_name'", FitHeightTextView.class);
    target.h_age = Utils.findRequiredViewAsType(source, R.id.h_age, "field 'h_age'", FitHeightTextView.class);
    target.h_bednum = Utils.findRequiredViewAsType(source, R.id.h_bednumber, "field 'h_bednum'", FitHeightTextView.class);
    target.h_division = Utils.findRequiredViewAsType(source, R.id.h_division, "field 'h_division'", FitHeightTextView.class);
    target.h_illrecordNum = Utils.findRequiredViewAsType(source, R.id.h_illrecordNum, "field 'h_illrecordNum'", FitHeightTextView.class);
    target.h_sex = Utils.findRequiredViewAsType(source, R.id.h_sex, "field 'h_sex'", FitHeightTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Hljld1Fragment target = this.target;
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
