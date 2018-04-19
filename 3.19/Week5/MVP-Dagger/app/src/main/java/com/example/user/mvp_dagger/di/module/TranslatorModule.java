package com.example.user.mvp_dagger.di.module;

import com.example.user.mvp_dagger.utils.Translator;
import com.example.user.mvp_dagger.view.translator.TranslatorActivity;
import com.example.user.mvp_dagger.view.translator.TranslatorContract;
import com.example.user.mvp_dagger.view.translator.TranslatorPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class TranslatorModule {


    @Provides
    TranslatorPresenter providesTranslatorPresenter(){
        return new TranslatorPresenter();
    }



}
