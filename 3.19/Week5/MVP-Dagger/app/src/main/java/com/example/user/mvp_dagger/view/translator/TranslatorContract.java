package com.example.user.mvp_dagger.view.translator;

import com.example.user.mvp_dagger.model.Sentence;
import com.example.user.mvp_dagger.utils.base.BasePresenter;
import com.example.user.mvp_dagger.utils.base.BaseView;

public interface TranslatorContract {

    //interface to communicate from presenter to view
    interface View extends BaseView {
        //specific methods for each view
        void onTranslation(Sentence sentence);
    }

    interface Presenter extends BasePresenter<View> {
        //specific method for each view's presenter
        void translate(Sentence sentence);

    }

}
