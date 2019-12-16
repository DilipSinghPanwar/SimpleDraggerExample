package com.e.simpledraggerexample;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Dilip-MavenCluster on 16-12-2019 15:48.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class, Add.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}
