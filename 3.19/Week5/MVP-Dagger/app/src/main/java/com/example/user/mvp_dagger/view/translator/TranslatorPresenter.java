package com.example.user.mvp_dagger.view.translator;

import com.example.user.mvp_dagger.model.Sentence;
import com.example.user.mvp_dagger.utils.Translator;

import javax.inject.Inject;

public class TranslatorPresenter implements TranslatorContract.Presenter {

    TranslatorContract.View view;


    @Override
    public void attachView(TranslatorContract.View view) {
        this.view = view;
    }

    @Override
    public void translate(Sentence sentence) {
        view.onTranslation(Translator.toPigLatin(sentence));
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
