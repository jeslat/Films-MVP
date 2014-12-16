package com.jla.modelviewpresenter.view.filmList.view;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jla.modelviewpresenter.R;
import com.jla.modelviewpresenter.domain.model.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private List<Film> films;
    private Context context;

    public FilmsAdapter(List<Film> films, Context context) {
        this.films = films;
        this.context = context;
    }

    @Override
    public FilmsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.films_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmsAdapter.ViewHolder viewHolder, int position) {
        viewHolder.tvFilmName.setText(films.get(position).getTitle());
        Picasso picasso = Picasso.with(context);
        picasso.setIndicatorsEnabled(true);
        picasso.load(Uri.parse(films.get(position).getPosterUrl()))
                .into(viewHolder.ivFilmPicture);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.tv_film_name)
        public TextView tvFilmName;
        @InjectView(R.id.iv_film_picture)
        public ImageView ivFilmPicture;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
