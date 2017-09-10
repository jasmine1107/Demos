package com.demo.dagger.component.activity;

import com.demo.MainActivity;
import com.demo.dagger.module.activity.MainActivityModule;

import dagger.Component;

/**
 * Created by jasmine on 2017/9/10.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void in(MainActivity activity);
}
