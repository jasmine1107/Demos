package com.demo.dagger.module.activity;

import com.demo.MainActivity;
import com.demo.presenter.activity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jasmine on 2017/9/10.
 */

@Module
public class MainActivityModule {

    private final MainActivity activity;

    public MainActivityModule(MainActivity activity) {

        this.activity = activity;
    }


    @Provides
    MainActivityPresenter ProvidesMainActivityPresenter() {
        return new MainActivityPresenter(activity);

    }

}
