package xyz.adelgado.popularmovies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.adelgado.popularmovies.R;
import xyz.adelgado.popularmovies.models.Movie;

/**
 * Created by andredelgado on 15/04/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> implements AdapterView.OnItemClickListener {

	private List<Movie> mMoviesList;
	private Context context;

	public MoviesAdapter(Context context) {
		this.context = context;
		mMoviesList = new ArrayList<>();
		notifyDataSetChanged();
	}

	public void addData(ArrayList<Movie> movies) {
		mMoviesList = movies;
		notifyDataSetChanged();
	}

	public void clear() {
		mMoviesList.clear();
		notifyDataSetChanged();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.recyclerview_movies, parent, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		Movie movie = mMoviesList.get(position);
		// TODO add image to imageview
	}

	@Override
	public int getItemCount() {
		return mMoviesList.size();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(context, mMoviesList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public ImageView posterDisplay;

		public ViewHolder(View itemView) {
			super(itemView);
			posterDisplay = (ImageView) itemView.findViewById(R.id.poster_image_view);
		}
	}
}
