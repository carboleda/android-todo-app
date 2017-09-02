package co.devhack.todoapp;

import android.app.Application;

/**
 * Created by krlosf on 1/09/17.
 */

public class SingletonApplication extends Application {
    private static SingletonApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static SingletonApplication getInstance() {
        return instance;
    }
}
