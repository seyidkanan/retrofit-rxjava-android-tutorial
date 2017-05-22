package az.kanan.retrofitrxjavaexample.api;

import az.kanan.retrofitrxjavaexample.pojo.User;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Kanan on 5/22/2017.
 */

public interface Api {
    
    //https://api.github.com/users/seyidkanan
    @GET("users/{username}")
    Observable<User> getUserData(@Path("username") String userName);
}
