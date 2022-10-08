package com.example.redbog.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.redbog.R;
import com.example.redbog.RecyclerViewClickInterface;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Reporte> reporte ;
    private LayoutInflater mInflater;
    private Context contexto;
    private ListAdapter listAdapter;
    private RecyclerViewClickInterface recyclerViewClickInterface;

    public ListAdapter(List<Reporte> reporte, Context contexto,RecyclerViewClickInterface recyclerViewClickInterface){
        this.mInflater = LayoutInflater.from(contexto);
        this.contexto = contexto;
        this.reporte = reporte;
        this.recyclerViewClickInterface = recyclerViewClickInterface;

    }

    @Override
    public int getItemCount(){
        return reporte.size();
       /* return 0;*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.activity_list_element,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(reporte.get(position));
    }

    public void setItems(List<Reporte> reportes){
        reporte = reportes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, tipologia,comentario,fecha_hora,id;
        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            tipologia =itemView.findViewById(R.id.tipologia);
            comentario =itemView.findViewById(R.id.comentario);
            fecha_hora =itemView.findViewById(R.id.fecha_hora);
            id =  itemView.findViewById(R.id.ID);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickInterface.onItemClick(getAdapterPosition());

                }
            });


        }
        void bindData(final Reporte reporte){
            name.setText(reporte.getNombre());
            tipologia.setText(reporte.getTipologia());
            comentario.setText(reporte.getReporte());
            fecha_hora.setText(reporte.getFecha());
            String idString = String.valueOf(reporte.getId());
            id.setText(idString);
        }

    }




}
