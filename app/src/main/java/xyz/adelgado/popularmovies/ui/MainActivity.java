package xyz.adelgado.popularmovies.ui;

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
import xyz.adelgado.popularmovies.adapters.MoviesFilterSpinnerAdapter;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FragmentManager fm = getSupportFragmentManager();
		final MainActivityFragment activityFragment = (MainActivityFragment) fm.findFragmentById(R.id.fragment_main);

		final ArrayList<String> list = new ArrayList<>();
		list.add("Popular Movies");
		list.add("Top Movies");

		View spinnerContainer = LayoutInflater.from(this).inflate(R.layout.toolbar_spinner,
				toolbar, false);
		ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		toolbar.addView(spinnerContainer, lp);

		MoviesFilterSpinnerAdapter spinnerAdapter = new MoviesFilterSpinnerAdapter(getApplicationContext());
		spinnerAdapter.addItems(list);

		Spinner spinner = (Spinner) spinnerContainer.findViewById(R.id.toolbar_spinner);
		spinner.setAdapter(spinnerAdapter);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
				if(position == 0) {
					activityFragment.updateMovies("popular");
				} else if(position == 1) {
					activityFragment.updateMovies("top_rated");
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {
			}

		});
	}
}
