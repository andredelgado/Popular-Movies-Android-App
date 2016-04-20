package xyz.adelgado.popularmovies.common.di;

import android.content.Context;
import android.content.res.Resources;
import dagger.Component;
import javax.inject.Singleton;
import xyz.adelgado.popularmovies.MoviesApplication;
import xyz.adelgado.popularmovies.data.api.TheMovieDBService;

@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {
  Context context();

  MoviesApplication.Mode applicationMode();
  Resources resources();

  TheMovieDBService theMovieDBService();
}

