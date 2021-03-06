package xyz.adelgado.popularmovies.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import xyz.adelgado.popularmovies.R;
import xyz.adelgado.popularmovies.models.Movie;
import xyz.adelgado.popularmovies.ui.DetailsActivity;

/**
 * Created by andredelgado on 15/04/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

  private final Picasso imageLoader;
  private final Context context;
  private List<Movie> mMoviesList;

  public MoviesAdapter(Context context) {
    this.context = context;
    this.imageLoader = Picasso.with(context);
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

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recyclerview_movies, parent, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    final Movie movie = mMoviesList.get(position);
    imageLoader.load(movie.getPosterPath()).fit().into(holder.posterDisplay);
    holder.posterDisplay.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(context.getString(R.string.movie_extras_placeholder), movie);
        context.startActivity(intent);
      }
    });
  }

  @Override public int getItemCount() {
    return mMoviesList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView posterDisplay;

    public ViewHolder(View itemView) {
      super(itemView);
      posterDisplay = (ImageView) itemView.findViewById(R.id.poster_image_view);
    }
  }
}
