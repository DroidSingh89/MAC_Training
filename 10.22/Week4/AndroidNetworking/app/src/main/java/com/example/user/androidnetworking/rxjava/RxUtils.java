package com.example.user.androidnetworking.rxjava;

import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

class RxUtils {


    static Function<Integer, Integer> getMultiplyFunc() {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer * 10;
            }
        };
    }

    static Predicate<Integer> getGreaterThan30Predicate() {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {

                if (integer >= 30) return true;
                else return false;

            }
        };
    }

    static Function<Integer, Integer> getDivideBy2Func() {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer / 2;
            }
        };
    }

}
