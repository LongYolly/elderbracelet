// Generated code from Butter Knife. Do not modify!
package com.bt.elderbracelet.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ContactServicesActivity$$ViewBinder<T extends com.bt.elderbracelet.activity.ContactServicesActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558410, "field 'titleview'");
    target.titleview = finder.castView(view, 2131558410, "field 'titleview'");
    view = finder.findRequiredView(source, 2131558486, "field 'tvReviceCall'");
    target.tvReviceCall = finder.castView(view, 2131558486, "field 'tvReviceCall'");
    view = finder.findRequiredView(source, 2131558487, "field 'linCall'");
    target.linCall = finder.castView(view, 2131558487, "field 'linCall'");
    view = finder.findRequiredView(source, 2131558488, "field 'linTextBg'");
    target.linTextBg = finder.castView(view, 2131558488, "field 'linTextBg'");
    view = finder.findRequiredView(source, 2131558490, "field 'etInputAdvice'");
    target.etInputAdvice = finder.castView(view, 2131558490, "field 'etInputAdvice'");
    view = finder.findRequiredView(source, 2131558491, "field 'btnAdviceSend'");
    target.btnAdviceSend = finder.castView(view, 2131558491, "field 'btnAdviceSend'");
  }

  @Override public void unbind(T target) {
    target.titleview = null;
    target.tvReviceCall = null;
    target.linCall = null;
    target.linTextBg = null;
    target.etInputAdvice = null;
    target.btnAdviceSend = null;
  }
}
