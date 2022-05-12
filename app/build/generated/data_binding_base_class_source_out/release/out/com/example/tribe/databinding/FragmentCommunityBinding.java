// Generated by view binder compiler. Do not edit!
package com.example.tribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tribe.R;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCommunityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView allPosts;

  @NonNull
  public final AppBarLayout bar;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ImageButton imageButton;

  @NonNull
  public final CardView postButton;

  @NonNull
  public final EditText postText;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView username;

  private FragmentCommunityBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView allPosts, @NonNull AppBarLayout bar,
      @NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton,
      @NonNull CardView postButton, @NonNull EditText postText, @NonNull Toolbar toolbar,
      @NonNull TextView username) {
    this.rootView = rootView;
    this.allPosts = allPosts;
    this.bar = bar;
    this.constraintLayout = constraintLayout;
    this.imageButton = imageButton;
    this.postButton = postButton;
    this.postText = postText;
    this.toolbar = toolbar;
    this.username = username;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCommunityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCommunityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_community, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCommunityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.all_posts;
      RecyclerView allPosts = ViewBindings.findChildViewById(rootView, id);
      if (allPosts == null) {
        break missingId;
      }

      id = R.id.bar;
      AppBarLayout bar = ViewBindings.findChildViewById(rootView, id);
      if (bar == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.imageButton;
      ImageButton imageButton = ViewBindings.findChildViewById(rootView, id);
      if (imageButton == null) {
        break missingId;
      }

      id = R.id.postButton;
      CardView postButton = ViewBindings.findChildViewById(rootView, id);
      if (postButton == null) {
        break missingId;
      }

      id = R.id.postText;
      EditText postText = ViewBindings.findChildViewById(rootView, id);
      if (postText == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.username;
      TextView username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      return new FragmentCommunityBinding((ConstraintLayout) rootView, allPosts, bar,
          constraintLayout, imageButton, postButton, postText, toolbar, username);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}