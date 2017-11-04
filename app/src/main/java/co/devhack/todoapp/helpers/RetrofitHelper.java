package co.devhack.todoapp.helpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by krlosf on 3/11/17.
 */

public class RetrofitHelper {

    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://us-central1-test-1-600e1.cloudfunctions.net/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
