package com.michaeljahns.namespace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserLayoutAdapter extends RecyclerView.Adapter<UserLayoutAdapter.UserViewHolder> {
    Context context;
    List<User> users;

    public UserLayoutAdapter(Context context,
                             List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_row, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.displayName.setText(users.get(position).getDisplayName());
        holder.createdAt.setText(users.get(position).getCreatedAt());
        holder.email.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView displayName, createdAt, email;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.displayName = itemView.findViewById(R.id.displayNameTextView);
            this.createdAt = itemView.findViewById(R.id.createdAtTextView);
            this.email = itemView.findViewById(R.id.emailTextView);
        }
    }
}
