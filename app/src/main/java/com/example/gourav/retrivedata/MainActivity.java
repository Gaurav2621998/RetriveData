package com.example.gourav.retrivedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    List<Blog> blogs= new ArrayList<>(  );
    RecyclerViewAdapter adapter;
    Blog abc;


    DatabaseReference myRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        myRef=FirebaseDatabase.getInstance().getReference().child( "messages" );
        myRef.keepSynced( true );
        recyclerView = (RecyclerView) findViewById( R.id.rec );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                Blog abc = snapshot.getValue(Blog.class);
                    Toast.makeText(MainActivity.this, snapshot.child("name").getValue().toString(), Toast.LENGTH_SHORT).show();
                    blogs.add( abc );
                }

                adapter=new RecyclerViewAdapter(MainActivity.this,blogs);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }

        });

    }


    }


