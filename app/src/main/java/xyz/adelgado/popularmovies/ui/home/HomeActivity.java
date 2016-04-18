package xyz.adelgado.popularmovies.ui.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import java.util.ArrayList;
import xyz.adelgado.popularmovies.R;

public class HomeActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FragmentManager fm = getSupportFragmentManager();
    final HomeFragment activityFragment = (HomeFragment) fm.findFragmentById(R.id.fragment_main);

    final ArrayList<String> list = new ArrayList<>();
    list.add(getString(R.string.popular_movies));
    list.add(getString(R.string.top_movies));

    View spinnerContainer =
        LayoutInflater.from(this).inflate(R.layout.toolbar_spinner, toolbar, false);
    ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT);
    toolbar.addView(spinnerContainer, lp);

    MoviesFilterAdapter spinnerAdapter = new MoviesFilterAdapter(getApplicationContext());
    spinnerAdapter.addItems(list);

    Spinner spinner = (Spinner) spinnerContainer.findViewById(R.id.toolbar_spinner);
    spinner.setAdapter(spinnerAdapter);

    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position,
          long id) {
        if (position == 0) {
          activityFragment.updateMovies(getString(R.string.popular_movies_action_tag));
        } else if (position == 1) {
          activityFragment.updateMovies(getString(R.string.top_rated_action_tag));
        }
      }

      @Override public void onNothingSelected(AdapterView<?> parentView) {
      }
    });
  }
}
