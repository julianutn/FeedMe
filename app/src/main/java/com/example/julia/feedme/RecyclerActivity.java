package com.example.julia.feedme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia on 09-Oct-17.
 */

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView rv;

    List<Receta> recetas;

    Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        rv = (RecyclerView) findViewById (R.id.recycler);

        rv.setLayoutManager(new LinearLayoutManager(this));

        recetas = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapter = new Adapter(recetas);
        rv.setAdapter(adapter);
        //getRef() obtiene una referencia, como no le pase nonguna probablemente falle aca.
        database.getReference().getRef().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recetas.removeAll(recetas);
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()
                     ) {
                    Receta receta =snapshot.getValue(Receta.class);
                    recetas.add(receta);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
