package xyz.adelgado.popularmovies.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.adelgado.popularmovies.R;

/**
 * Created by andredelgado on 16/04/16.
 */
public class MoviesFilterSpinnerAdapter extends BaseAdapter implements AdapterView.OnItemSelectedListener {

	LayoutInflater inflater;

	private List<String> mItems = new ArrayList<>();

	public MoviesFilterSpinnerAdapter(Context context) {
		inflater= (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
	}

	public void clear() {
		mItems.clear();
	}

	public void addItem(String item) {
		mItems.add(item);
	}

	public void addItems(List<String> items) {
		mItems.addAll(items);
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getDropDownView(final int position, View view, ViewGroup parent) {
		if (view == null || !view.getTag().toString().equals("DROPDOWN")) {
			view = inflater.inflate(R.layout.toolbar_spinner_item_dropdown, parent, false);
			view.setTag("DROPDOWN");
		}

		TextView textView = (TextView) view.findViewById(android.R.id.text1);
		textView.setText(getTitle(position));

		return view;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")) {
			view = inflater.inflate(R.layout.
					toolbar_spinner_item_actionbar, parent, false);
			view.setTag("NON_DROPDOWN");
		}
		TextView textView = (TextView) view.findViewById(android.R.id.text1);
		textView.setText(getTitle(position));
		return view;
	}

	private String getTitle(int position) {
		return position >= 0 && position < mItems.size() ? mItems.get(position) : "";
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		Log.d("asd", "asd");
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
