package com.example.tribe.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.tribe.Model.User;
import com.example.tribe.R;

import java.util.List;

public class TribeMembers extends RecyclerView.Adapter<TribeMembers.ViewHolder> {


    List<User> membersList;
    Context context;


    public TribeMembers(List<User> membersList, Context context) {
        this.membersList = membersList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.member_item , parent , false);

        return new TribeMembers.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user=membersList.get(position);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.default_image)
                .error(R.drawable.default_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        Glide.with(context).load(user.getImageURL())
                .apply(options)
                .into(holder.userImage);
        holder.username.setText(user.getUsername());


    }

    @Override
    public int getItemCount() {
        return membersList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView username;
        ImageView userImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            userImage =itemView.findViewById(R.id.userImage);
        }
    }

}
