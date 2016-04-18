package xyz.adelgado.popularmovies.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import xyz.adelgado.popularmovies.R;
import xyz.adelgado.popularmovies.data.models.Movie;

public class DetailsActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ImageView backdropDisplay = (ImageView) findViewById(R.id.backdrop_display);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    Movie movie = getIntent().getParcelableExtra(getString(R.string.movie_extras_placeholder));
    getSupportActionBar().setTitle(movie.getTitle());
    Picasso.with(getApplicationContext()).load(movie.getBackdropPath()).fit().into(backdropDisplay);
  }
}
