package xyz.adelgado.popularmovies.common.di;

import android.content.Context;
import android.content.res.Resources;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import xyz.adelgado.popularmovies.MoviesApplication;

@Module public class ApplicationModule {
  private final MoviesApplication application;

  public ApplicationModule(MoviesApplication application) {
    this.application = application;
  }

  @Provides @Singleton public Context provideApplicationContext() {
    return application;
  }

  @Provides @Singleton public MoviesApplication.Mode provideApplicationMode() {
    return application.getMode();
  }

  @Provides @Singleton public Resources provideResources() {
    return application.getResources();
  }


  @Provides @Singleton public Gson provideGson() {
    return new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();
  }

  @Provides @Singleton public OkHttpClient provideOkHttpClient() {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    if (MoviesApplication.DEBUG) {
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    int timeout = 60;
    return new OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(timeout, TimeUnit.SECONDS)
        .readTimeout(timeout, TimeUnit.SECONDS)
        .writeTimeout(timeout, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build();
  }
}