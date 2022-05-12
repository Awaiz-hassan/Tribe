package com.example.tribe.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tribe.Model.EventMOdel;
import com.example.tribe.R;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    Context context;
    List<EventMOdel> eventList;

    public EventsAdapter(Context context, List<EventMOdel> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false);
        return new EventsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.ViewHolder holder, int position) {
        holder.date.setText(eventList.get(position).getDate());
        holder.time.setText(eventList.get(position).getTime());
        holder.description.setText(eventList.get(position).getDescription());
        holder.title.setText(eventList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date,time,description,title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            description=itemView.findViewById(R.id.description);
            title=itemView.findViewById(R.id.title);
        }
    }
}
