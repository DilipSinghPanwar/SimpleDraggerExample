package com.e.simpledraggerexample;

import android.app.Application;

/**
 * Created by Dilip-MavenCluster on 16-12-2019 15:48.
 */
public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }

}