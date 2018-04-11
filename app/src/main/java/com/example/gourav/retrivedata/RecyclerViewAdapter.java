package com.example.gourav.retrivedata;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Blog> MainImageUploadInfoList;
    List<String> keyList;
    DatabaseReference myref ;
    DatabaseReference mychild,mlike,mcheck,del;
    String Activity;

    boolean mprocesslike = false;
    public Boolean aBoolean;

    public RecyclerViewAdapter(Context context, List<Blog> TempList) {

        this.MainImageUploadInfoList = TempList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        Blog blog=MainImageUploadInfoList.get(position);
        holder.name.setText(blog.getName());
        holder.aphone.setText(blog.getAphone());
        holder.phone.setText( blog.getPhone() );
        holder.msg.setText(blog.getMessage());
        holder.email.setText( blog.getEmail() );
        holder.name.setText( blog.getName() );

    }
    public int getItemCount1() {

        return keyList.size();
    }
    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public TextView name;
        public TextView email;
        public TextView aphone;
        public TextView phone;
        public TextView msg;

        public ViewHolder(View itemView) {

            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);

            email = (TextView) itemView.findViewById(R.id.email);


            aphone = (TextView) itemView.findViewById(R.id.aphone);

            phone = (TextView) itemView.findViewById(R.id.phone);

            msg = (TextView) itemView.findViewById(R.id.msg);




        }
    }

    public void clear()
    {
        int size = this.MainImageUploadInfoList.size();
        if (size > 0)
        {
            for (int i = 0;i<size;i++)
                delete(i);
            this.notifyItemRangeRemoved(0,size);
        }
    }

    private void delete(int i) {
        MainImageUploadInfoList.remove(i);
        notifyItemRemoved(i);
    }
}
