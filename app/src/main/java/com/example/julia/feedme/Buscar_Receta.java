package com.example.julia.feedme;

import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Buscar_Receta extends AppCompatActivity {
    private TextView mensajeTextView;
    private EditText mensajeEditText;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensajeRef = ref.child("recetas");
    DatabaseReference recetaRef = mensajeRef.child("0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar__receta);

        mensajeTextView = (TextView) findViewById(R.id.mensajeTextView);
        mensajeEditText = (EditText) findViewById(R.id.mensajeEditText);
    }

    @Override
    protected void onStart() {
        super.onStart();

        recetaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               Receta unaReceta = dataSnapshot.getValue(Receta.class);
                Log.i("datos", dataSnapshot.toString());
                //mensajeTextView.setText(Valor);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}