package com.example.user.androidnetworking.di;

import com.example.user.androidnetworking.model.data.RandomRepository;
import com.example.user.androidnetworking.ui.user.UserPresenter;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataModule.class)
public class UserModule {

    @Provides
    UserPresenter providesUserPresenter(RandomRepository randomRepository) {
        return new UserPresenter(randomRepository);
    }

}
