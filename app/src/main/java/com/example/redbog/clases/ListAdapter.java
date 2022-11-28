package com.example.redbog.clases;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.redbog.EditarReporte;
import com.example.redbog.R;
import com.example.redbog.RecyclerViewClickInterface;
import com.example.redbog.misReportesActivity;

import java.util.List;

public class ListAdapter  extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Reporte> reporte ;
    private LayoutInflater mInflater;
    private Context contexto;
    private ListAdapter listAdapter;
    private RecyclerViewClickInterface recyclerViewClickInterface;
    Dialog dialog;



    public ListAdapter(List<Reporte> reporte, Context contexto,RecyclerViewClickInterface recyclerViewClickInterface){
        this.mInflater = LayoutInflater.from(contexto);
        this.contexto = contexto;
        this.reporte = reporte;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
        this.dialog = new Dialog(contexto);


    }
    private void openAlert() {

        dialog.setContentView(R.layout.activity_alert_message);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView close = dialog.findViewById(R.id.close_icon);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }

        });


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
        TextView name, tipologia,comentario,fecha_hora,editar_reporte;
        ImageView btn;
        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            tipologia =itemView.findViewById(R.id.tipologia);
            comentario =itemView.findViewById(R.id.comentario);
            fecha_hora =itemView.findViewById(R.id.fecha_hora);
            btn =  itemView.findViewById(R.id.delete_icon);
            editar_reporte = itemView.findViewById(R.id.editar_reporte);


            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickInterface.onItemClick(getAdapterPosition());

                }
            });*/
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickInterface.onItemClickEliminar(getAdapterPosition());
                    openAlert();

                }
            });
            editar_reporte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickInterface.onItemClickEditar(getAdapterPosition());

                }
            });






        }
        void bindData(final Reporte reporte){
            name.setText(reporte.getNombre());
            tipologia.setText(reporte.getLocalidad() + " en " +reporte.getTipologia());
            comentario.setText(reporte.getReporte());
            fecha_hora.setText(reporte.getFecha());
            String idString = String.valueOf(reporte.getId());




        }


    }





}
