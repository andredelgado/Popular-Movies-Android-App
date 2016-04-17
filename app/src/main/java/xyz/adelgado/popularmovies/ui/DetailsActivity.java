package xyz.adelgado.popularmovies.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import xyz.adelgado.popularmovies.R;
import xyz.adelgado.popularmovies.models.Movie;

public class DetailsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		ImageView backdropDisplay = (ImageView) findViewById(R.id.backdrop_display);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		Movie movie = getIntent().getParcelableExtra("movie");
		getSupportActionBar().setTitle(movie.getTitle());
		Picasso.with(getApplicationContext()).load(movie.getBackdropPath()).fit().into(backdropDisplay);
	}

}
