package xyz.adelgado.popularmovies;

import android.app.Application;
import com.karumi.dexter.Dexter;
import timber.log.Timber;
import xyz.adelgado.popularmovies.common.di.ApplicationComponent;
import xyz.adelgado.popularmovies.common.di.ApplicationModule;

/**
 * Created by andredelgado on 18/04/16.
 */
public class MoviesApplication extends Application {

  public static final boolean DEBUG = BuildConfig.DEBUG;

  private Mode mode;
  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    checkTestMode();
    this.initializeInjector();

    Dexter.initialize(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  private void initializeInjector() {
    this.applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }

  public Mode getMode() {
    return mode;
  }

  private void checkTestMode() {
    try {
      getClassLoader().loadClass("xyz.adelgado.popularmovies.ApplicationTest");
      mode = Mode.TEST;
    } catch (final Exception e) {
      mode = Mode.NORMAL;
    }
  }

  public enum Mode {
    NORMAL, TEST
  }
}
