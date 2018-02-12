package com.example.user.mvp_dagger;

import javax.inject.Inject;

/**
 * Created by singh on 2/9/18.
 */

public class Dependent {


    Dependency dependency;

    public Dependent(Dependency dependency) {
        this.dependency = dependency;
    }

    public Dependent(int a, int b) {
        dependency = new Dependency(a, b);
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public int add() {
        return dependency.add();
    }
}
