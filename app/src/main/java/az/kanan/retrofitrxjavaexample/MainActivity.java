package az.kanan.retrofitrxjavaexample;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import az.kanan.retrofitrxjavaexample.api.Api;
import az.kanan.retrofitrxjavaexample.api.RetrofitCreater;
import az.kanan.retrofitrxjavaexample.pojo.User;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api api = RetrofitCreater.create(Api.class);

        Observable<User> userInfo = api.getUserData("seyidkanan");
        userInfo.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(user -> "userName=" + user.getName() + "\nurl=" + user.getUrl())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("kanan", e.toString());
                    }

                    @Override
                    public void onNext(String user) {
                        Log.e("kanan", user);
                    }
                });

    }
}
