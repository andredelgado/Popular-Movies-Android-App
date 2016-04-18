package xyz.adelgado.popularmovies.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import xyz.adelgado.popularmovies.R;
import xyz.adelgado.popularmovies.models.Movie;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsFragment extends Fragment {

  Movie mMovie;

  public DetailsFragment() {
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_details, container, false);

    ImageView imageView = (ImageView) view.findViewById(R.id.poster_display);
    TextView titleDisplay = (TextView) view.findViewById(R.id.title_display);
    TextView yearDisplay = (TextView) view.findViewById(R.id.year_display);
    TextView rateDisplay = (TextView) view.findViewById(R.id.rate_display);
    TextView overviewDisplay = (TextView) view.findViewById(R.id.overview_display);

    mMovie =
        getActivity().getIntent().getParcelableExtra(getString(R.string.movie_extras_placeholder));

    Picasso.with(getContext()).load(mMovie.getPosterPath()).fit().into(imageView);
    titleDisplay.setText(mMovie.getTitle());
    yearDisplay.setText(mMovie.getReleaseYear());
    rateDisplay.setText(String.format("%s/10", String.valueOf(mMovie.getVoteAverage())));
    overviewDisplay.setText(mMovie.getOverview());
    return view;
  }
}
