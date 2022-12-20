package com.example.showdekho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.showdekho.model.Movie;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Context context;
    private final List<Movie> moviesList;


    public MyAdapter(Context context, List<Movie> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.MovieName_id.setText(moviesList.get(position).getName());
        holder.ShowTime_id.setText(moviesList.get(position).getTime());
        holder.Location_id.setText(moviesList.get(position).getLocation());
        holder.Amount_id.setText(moviesList.get(position).getPrice());
        holder.Language_id.setText(moviesList.get(position).getLanguage());
        holder.Genre_id.setText(moviesList.get(position).getGenere());


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView MovieName_id, ShowTime_id, Location_id, Amount_id, Language_id, Genre_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MovieName_id = itemView.findViewById(R.id.mname);
            ShowTime_id = itemView.findViewById(R.id.stime);
            Location_id = itemView.findViewById(R.id.loca);
            Amount_id = itemView.findViewById(R.id.amnt);
            Language_id = itemView.findViewById(R.id.lan);
            Genre_id = itemView.findViewById(R.id.Genre);
        }
    }
}
