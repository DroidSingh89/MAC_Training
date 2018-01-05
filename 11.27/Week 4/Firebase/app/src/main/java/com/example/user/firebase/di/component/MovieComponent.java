package com.example.user.firebase.di.component;


import com.example.user.firebase.di.module.MovieModule;
import com.example.user.firebase.view.movie.MovieActivity;

import dagger.Subcomponent;

/**
 * Created by singh on 12/21/17.
 */
@Subcomponent(modules = MovieModule.class)
public interface MovieComponent {

    void inject(MovieActivity movieActivity);
}
