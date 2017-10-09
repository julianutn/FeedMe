package com.example.julia.feedme;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by julia on 09-Oct-17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.RecetasViewHolder>{
    List<Receta> recetas;

    public Adapter(List<Receta> recetas) {
        this.recetas = recetas;
    }

    @Override
    public RecetasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);
        RecetasViewHolder holder= new RecetasViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecetasViewHolder holder, int position) {
        Receta receta= recetas.get(position);
        holder.TextViewNombre.setText(receta.getNombre());
        holder.TextViewTiempo.setText(receta.getTiempo());

    }

    @Override
    public int getItemCount() {
       return recetas.size();
    }

    public static class RecetasViewHolder extends RecyclerView.ViewHolder{

        TextView TextViewNombre, TextViewTiempo;
        public RecetasViewHolder(View itemView) {
            super(itemView);
            TextViewNombre = (TextView) itemView.findViewById(R.id.text_view_nombre);
            TextViewTiempo =(TextView) itemView.findViewById(R.id.text_view_tiempo);

        }
    }
}
