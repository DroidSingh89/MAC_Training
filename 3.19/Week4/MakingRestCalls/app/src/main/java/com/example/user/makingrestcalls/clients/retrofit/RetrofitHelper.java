package com.example.user.makingrestcalls.clients.retrofit;

import android.content.Context;

import com.example.user.makingrestcalls.model.GithubProfile;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {


    public static final String MOCKY_BASEURL = "http://www.mocky.io/";
    public static final String GITHUB_BASEURL = "https://api.github.com/";


    Context context;

    public RetrofitHelper(Context applicationContext) {
        this.context = applicationContext;
    }


    public  Retrofit create(String BaseURL)  {

        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;

    }

    public  Call<GithubProfile> getProfileWithMocky() {

        Retrofit retrofit = create(MOCKY_BASEURL);
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getResponse();
    }

    public Call<GithubProfile> getProfileWithGithub(String username){
        return create(GITHUB_BASEURL)
                .create(RetrofitService.class)
                .getResponseWithGithub(username);
    }

    public Observable<GithubProfile> getProfileObs(String username){
        return create(GITHUB_BASEURL)
                .create(RetrofitService.class)
                .getResponseObs(username);
    }

}
