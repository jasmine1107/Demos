// Generated code from Butter Knife. Do not modify!
package com.demo;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.demo.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427422, "field 'center'");
    target.center = (android.widget.FrameLayout) view;
    view = finder.findRequiredView(source, 2131427370, "field 'bottom'");
    target.bottom = (android.widget.LinearLayout) view;
  }

  public static void reset(com.demo.MainActivity target) {
    target.center = null;
    target.bottom = null;
  }
}
