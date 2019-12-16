package com.e.simpledraggerexample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dilip-MavenCluster on 16-12-2019 15:47.
 */
@Module
public class AppModule {
    private Application mApplication;

    AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }
}
