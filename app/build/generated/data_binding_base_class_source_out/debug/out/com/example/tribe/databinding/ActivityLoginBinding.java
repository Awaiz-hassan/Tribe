// Generated by view binder compiler. Do not edit!
package com.example.tribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tribe.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonLogin;

  @NonNull
  public final EditText editTextEmailOrUsername;

  @NonNull
  public final EditText editTextPassword;

  @NonNull
  public final TextView forgotYourPassword;

  @NonNull
  public final TextView textViewCreateAccount;

  private ActivityLoginBinding(@NonNull LinearLayout rootView, @NonNull Button buttonLogin,
      @NonNull EditText editTextEmailOrUsername, @NonNull EditText editTextPassword,
      @NonNull TextView forgotYourPassword, @NonNull TextView textViewCreateAccount) {
    this.rootView = rootView;
    this.buttonLogin = buttonLogin;
    this.editTextEmailOrUsername = editTextEmailOrUsername;
    this.editTextPassword = editTextPassword;
    this.forgotYourPassword = forgotYourPassword;
    this.textViewCreateAccount = textViewCreateAccount;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_login;
      Button buttonLogin = ViewBindings.findChildViewById(rootView, id);
      if (buttonLogin == null) {
        break missingId;
      }

      id = R.id.edit_text_email_or_username;
      EditText editTextEmailOrUsername = ViewBindings.findChildViewById(rootView, id);
      if (editTextEmailOrUsername == null) {
        break missingId;
      }

      id = R.id.edit_text_password;
      EditText editTextPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextPassword == null) {
        break missingId;
      }

      id = R.id.forgot_your_password;
      TextView forgotYourPassword = ViewBindings.findChildViewById(rootView, id);
      if (forgotYourPassword == null) {
        break missingId;
      }

      id = R.id.text_view_create_account;
      TextView textViewCreateAccount = ViewBindings.findChildViewById(rootView, id);
      if (textViewCreateAccount == null) {
        break missingId;
      }

      return new ActivityLoginBinding((LinearLayout) rootView, buttonLogin, editTextEmailOrUsername,
          editTextPassword, forgotYourPassword, textViewCreateAccount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
