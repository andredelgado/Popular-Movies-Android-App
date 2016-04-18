package xyz.adelgado.popularmovies.common.di;

import android.app.Activity;
import dagger.Component;
import xyz.adelgado.popularmovies.ui.home.HomeActivity;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  Activity activity();

  void inject(HomeActivity homeActivity);
}