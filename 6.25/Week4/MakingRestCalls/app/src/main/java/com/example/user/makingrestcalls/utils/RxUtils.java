package com.example.user.makingrestcalls.utils;

import com.example.user.makingrestcalls.model.APIResponse;
import com.example.user.makingrestcalls.model.CustomUser;
import com.example.user.makingrestcalls.model.Result;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

public class RxUtils {


    public static Function<APIResponse, CustomUser> getMappingFunction() {

        Function<APIResponse, CustomUser> function = new Function<APIResponse, CustomUser>() {
            @Override
            public CustomUser apply(APIResponse apiResponse) {

                return new CustomUser(apiResponse, "Engineering", "Atlanta");
            }
        };

        return function;

    }

    public static Function<APIResponse, Observable<Result>> getResultMapper() {


        Function<APIResponse, Observable<Result>> function = new Function<APIResponse, Observable<Result>>() {
            @Override
            public Observable<Result> apply(final APIResponse apiResponse) throws Exception {
//                mapping

//                create observable
                Observable<Result> resultObservable = Observable.create(new ObservableOnSubscribe<Result>() {
                    @Override
                    public void subscribe(ObservableEmitter<Result> emitter) throws Exception {

                        for (Result result : apiResponse.getResults()) {

                            emitter.onNext(result);

                        }

                        emitter.onComplete();

                    }
                });

                return resultObservable;
            }

        };

        return function;

    }

    public static Function<Result, Result> tranformResult() {
        Function<Result, Result> function = new Function<Result, Result>() {
            @Override
            public Result apply(Result result) throws Exception {

                result.getName()
                        .setLast(result.getName().getLast() + " " + getRandonInt());

                return result;
            }
        };
        return function;
    }

    private static String getRandonInt() {
        String randomValue = String.valueOf(new Random().nextInt(100));

        return randomValue;
    }

}
