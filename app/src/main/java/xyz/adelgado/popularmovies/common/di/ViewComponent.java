package xyz.adelgado.popularmovies.common.di;

import android.view.View;
import dagger.Component;

@PerView @Component(dependencies = ApplicationComponent.class, modules = ViewModule.class)
public interface ViewComponent {

  View view();

}
