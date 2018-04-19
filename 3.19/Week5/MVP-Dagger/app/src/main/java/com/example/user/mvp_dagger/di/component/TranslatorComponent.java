package com.example.user.mvp_dagger.di.component;

import com.example.user.mvp_dagger.di.module.TranslatorModule;
import com.example.user.mvp_dagger.view.translator.TranslatorActivity;

import dagger.Component;

@Component(modules = TranslatorModule.class)
public interface TranslatorComponent {

    void inject(TranslatorActivity translatorActivity);

}
