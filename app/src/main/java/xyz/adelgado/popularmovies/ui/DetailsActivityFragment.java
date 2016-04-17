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
public class DetailsActivityFragment extends Fragment {

	Movie mMovie;

	public DetailsActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_details, container, false);

		ImageView imageView = (ImageView) view.findViewById(R.id.poster_display);
		TextView yearDisplay = (TextView) view.findViewById(R.id.year_display);
		TextView rateDisplay = (TextView) view.findViewById(R.id.rate_display);
		TextView overviewDisplay = (TextView) view.findViewById(R.id.overview_textview);

		mMovie = getActivity().getIntent().getParcelableExtra("movie");

		Picasso.with(getContext()).load(mMovie.getPosterPath()).fit().into(imageView);
		yearDisplay.setText(mMovie.getReleaseYear());
		rateDisplay.setText(String.valueOf(mMovie.getVoteAverage()) + "/10");
		overviewDisplay.setText(mMovie.getOverview());
		return view;
	}
}
