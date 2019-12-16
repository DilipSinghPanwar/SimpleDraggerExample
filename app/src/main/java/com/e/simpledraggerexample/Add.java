package com.e.simpledraggerexample;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dilip-MavenCluster on 16-12-2019 16:30.
 */
@Module
public class Add {

    @Inject
    public Add() {
    }

    @Provides
    public Integer Sum(int a,int b){
        return a+b;
    }
}
