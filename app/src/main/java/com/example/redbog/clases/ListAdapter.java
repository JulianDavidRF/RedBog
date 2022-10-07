package com.example.redbog.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.redbog.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Reporte> reporte ;
    private LayoutInflater mInflater;
    private Context contexto;

    public ListAdapter(List<Reporte> reporte, Context contexto){
        this.mInflater = LayoutInflater.from(contexto);
        this.contexto = contexto;
        this.reporte = reporte;

    }

    @Override
    public int getItemCount(){
        return reporte.size();
       /* return 0;*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.activity_list_element2,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(reporte.get(position));
    }

    public void setItems(List<Reporte> reportes){
        reporte = reportes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, tipologia,comentario,fecha_hora;
        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            tipologia =itemView.findViewById(R.id.tipologia);
            comentario =itemView.findViewById(R.id.comentario);
            fecha_hora =itemView.findViewById(R.id.fecha_hora);

        }
        void bindData(final Reporte reporte){
            name.setText(reporte.getNombre());
            tipologia.setText(reporte.getTipologia());
            comentario.setText(reporte.getReporte());
            fecha_hora.setText(reporte.getFecha());
        }
    }




}
