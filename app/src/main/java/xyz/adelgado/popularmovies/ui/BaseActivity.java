package xyz.adelgado.popularmovies.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import xyz.adelgado.popularmovies.MoviesApplication;
import xyz.adelgado.popularmovies.common.di.ActivityComponent;
import xyz.adelgado.popularmovies.common.di.ActivityModule;
import xyz.adelgado.popularmovies.common.di.ApplicationComponent;
import xyz.adelgado.popularmovies.common.di.DaggerActivityComponent;

/**
 * Created by andredelgado on 18/04/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutRes());
    ButterKnife.bind(this);
  }

  @LayoutRes protected abstract int getLayoutRes();

  protected ActivityComponent getActivityComponent() {
    return DaggerActivityComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  private ApplicationComponent getApplicationComponent() {
    return ((MoviesApplication) getApplication()).getApplicationComponent();
  }

  private ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }
}
