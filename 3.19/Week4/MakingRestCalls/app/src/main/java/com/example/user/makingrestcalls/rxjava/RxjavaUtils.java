package com.example.user.makingrestcalls.rxjava;

import com.example.user.makingrestcalls.model.GithubProfile;

import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class RxjavaUtils {


    public static Function<Integer, Integer> getFunction(){

        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer * 10;
            }
        };

    }

    public static Predicate<Integer> getPredicate() {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                if (integer > 3) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

    public static Function<GithubProfile, GithubProfile> getGithubFunction() {
        return new Function<GithubProfile, GithubProfile>() {
            @Override
            public GithubProfile apply(GithubProfile githubProfile) throws Exception {
                String name = githubProfile.getName();
                githubProfile.setName(name + "Something");
                return githubProfile;
            }
        };
    }
}
