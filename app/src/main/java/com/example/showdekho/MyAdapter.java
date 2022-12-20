package com.example.showdekho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    TextView MovieName_id, ShowTime_id, Location_id, Amount_id, Language_id, Genre_id;
    private ArrayList MovieName, ShowTime, Location, Amount, Language, Genre;


    public MyAdapter(Context context, ArrayList movieName, ArrayList showTime, ArrayList location, ArrayList amount, ArrayList language, ArrayList genre) {
        this.context = context;
        MovieName = movieName;
        ShowTime = showTime;
        Location = location;
        Amount = amount;
        Language = language;
        Genre = genre;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.MovieName_id.setText(MovieName_id[position]);
        holder.MovieName_id.setText(String.valueOf(MovieName_id.get(position)));
        holder.ShowTime_id.setText(String.valueOf(ShowTime_id.get(position)));
        holder.Location_id.setText(String.valueOf(Location_id.get(position)));
        holder.Amount_id.setText(String.valueOf(Amount_id.get(position)));
        holder.Language_id.setText(String.valueOf(Language_id.get(position)));
        holder.Genre_id.setText(String.valueOf(Genre_id.get(position)));


    }

    @Override
    public int getItemCount() {
        return 0;
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
