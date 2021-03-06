package com.example.tribe.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.tribe.Model.Comment;
import com.example.tribe.Model.User;
import com.example.tribe.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private Context mContext;
    private List<Comment> mComment;
    private String postid;

    private FirebaseUser firebaseUser;

    public CommentAdapter(Context mContext, List<Comment> mComment , String postid) {
        this.mContext = mContext;
        this.mComment = mComment;
        this.postid = postid;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.comment_item , parent , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        final Comment comment = mComment.get(position);

        holder.comment.setText(comment.getComment());
        getUserInfo(holder.image_profile , holder.username , comment.getPublisher());



        holder.itemView.setOnLongClickListener(v -> {
            if (comment.getPublisher().endsWith(firebaseUser.getUid())){
                AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
                alertDialog.setTitle("Do you want to delete?");

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                        (dialog, which) -> {
                            FirebaseDatabase.getInstance().getReference("Comments")
                                    .child(postid).child(comment.getCommentid())
                                    .removeValue().addOnCompleteListener(task -> {
                                        if (task.isSuccessful())
                                            Toast.makeText(mContext, "Deleted!", Toast.LENGTH_SHORT).show();
                                    });
                            dialog.dismiss();
                        });
                alertDialog.show();
            }
            return true;
        });

    }

    @Override
    public int getItemCount() {
        return mComment.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image_profile;
        public TextView username;
        public TextView comment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_profile = itemView.findViewById(R.id.image_profile);
            username = itemView.findViewById(R.id.username);
            comment = itemView.findViewById(R.id.comment);
        }
    }

    private void getUserInfo (final ImageView imageView , final TextView username , String publisherid) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(publisherid);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                RequestOptions options = new RequestOptions()
                        .centerCrop()
                        .placeholder(R.drawable.default_image)
                        .error(R.drawable.default_image)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH);
                if(mComment!=null&user!=null){
                Glide.with(mContext).load(user.getImageURL())
                        .apply(options)
                        .into(imageView);
                username.setText(user.getUsername());}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
