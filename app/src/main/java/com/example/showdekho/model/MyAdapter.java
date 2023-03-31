package com.example.showdekho.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.showdekho.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Context context;
    private final List<Movie> moviesList;
    int seats;
    int price;

    int pricetotal;


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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.MovieName_id.setText(moviesList.get(position).getName());
        holder.ShowTime_id.setText(moviesList.get(position).getTime());
        holder.Location_id.setText(moviesList.get(position).getLocation());
        holder.Amount_id.setText(moviesList.get(position).getPrice());
        holder.Language_id.setText(moviesList.get(position).getLanguage());
        holder.Genre_id.setText(moviesList.get(position).getGenere());

        seats = 0;

        String priceStr = moviesList.get(position).getPrice();
        if (!priceStr.isEmpty() && priceStr.matches("\\d+")) {
            price = Integer.parseInt(priceStr);
        } else {
            price = 100;
        }


        holder.increase.setOnClickListener(v -> {
            seats = seats + 1;
            holder.value.setText(String.valueOf(seats));
            pricetotal = seats * price;
            holder.totalprice.setText(String.valueOf(pricetotal));
        });

        holder.decrease.setOnClickListener(v -> {
            if (seats > 0)
                seats = seats - 1;
            holder.value.setText(String.valueOf(seats));
            pricetotal = seats * price;
            holder.totalprice.setText(String.valueOf(pricetotal));
        });

        holder.book.setOnClickListener(v -> {
            Toast.makeText(context, "Ticket Booked", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView MovieName_id, ShowTime_id, Location_id, Amount_id, Language_id, Genre_id, value, totalprice, book;
        public Button increase, decrease;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MovieName_id = itemView.findViewById(R.id.mname);
            ShowTime_id = itemView.findViewById(R.id.stime);
            Location_id = itemView.findViewById(R.id.loca);
            Amount_id = itemView.findViewById(R.id.amnt);
            Language_id = itemView.findViewById(R.id.lan);
            Genre_id = itemView.findViewById(R.id.Genre);
            increase = itemView.findViewById(R.id.increment);
            decrease = itemView.findViewById(R.id.decrement);
            value = itemView.findViewById(R.id.totp);
            totalprice = itemView.findViewById(R.id.totprice);
            book = itemView.findViewById(R.id.book);
        }
    }
}