package com.example.redbog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.redbog.AVL.AVLTree;
import com.example.redbog.clases.ListAdapter2;
import com.example.redbog.clases.Reporte;
import com.example.redbog.stack.StackRef;
import com.example.redbog.queue.Cola;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class TodosLosReportes extends AppCompatActivity {

    //Declaracion de variables-------------------------------------
    StackRef<Reporte> todosReportesStack;
    Cola<Reporte> todosReportesCola;
    List<Reporte> todosReportesLista;


    String celular;
    Dialog dialog;
    Spinner filtroSpinner;
    String respuestaFiltro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {




        //Crecion de array para filtros-----------------------------------------------------
        setContentView(R.layout.activity_todos_los_reportes);
        ArrayList<String> filtros= new ArrayList<>();

        filtros.add("Todos los reportes");
        filtros.add("Día");
        filtros.add("Fechas");
        filtros.add("Localidad");
        filtros.add("Tipo acto ilicito");

        super.onCreate(savedInstanceState);
        celular = getIntent().getStringExtra("celular");

        //El array se asigna a el drop-down adapter--------------------------------------------
        filtroSpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, filtros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filtroSpinner.setAdapter(adapter);

        //click listener en drop down menu----------------------------------------------
        filtroSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                respuestaFiltro = adapterView.getItemAtPosition(i).toString();
                if(respuestaFiltro == "Fechas"){


                    MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.dateRangePicker();
                    builder.setTitleText("Select date or range of dates");
                    final MaterialDatePicker materialDatePicker = builder.build();
                    materialDatePicker.show(getSupportFragmentManager(),"Date_picker");
                    materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
                        @Override public void onPositiveButtonClick(Pair<Long,Long> selection) {
                            //le sumo 100000000 porque por alguna razon siempre retorna una dia menos al seleciconado
                            Long startDate = selection.first + 100000000;
                            Long endDate = selection.second +  100000000;
                            String dateFormatStart="";
                            String dateFormatEnd="";
                            String[] arr = getDate(startDate,"yyyy/MM/dd").split("/");
                            String[] arr2 = getDate(endDate,"yyyy/MM/dd").split("/");
                            for(int i =0; i< arr.length;i++){
                                dateFormatStart += arr[i];
                            }
                            for(int i =0; i< arr.length;i++){
                                dateFormatEnd += arr2[i];
                            }
                            //Toast(dateFormatEnd);
                            AVLTree tree2 = llenarAVL(todosReportesLista,0);
                            List reportesGenerales = new ArrayList<>();

                            for(int i =0; i <= Integer.parseInt(dateFormatEnd)-Integer.parseInt(dateFormatStart); i++ ){

                                if(tree2.find(Integer.parseInt(dateFormatStart) + i) !=null){
                                    Toast(String.valueOf("entro al if" + dateFormatStart + i));
                                    List filtroPorDia = tree2.find(Integer.parseInt(dateFormatStart) +i).reportes;
                                    reportesGenerales.addAll(filtroPorDia);

                                }else{
                                    continue;

                                }

                            }
                            if(!reportesGenerales.isEmpty()){
                                init(reportesGenerales);

                            }else{
                                openAlert();
                            }


                        }
                    });

                }
                if(respuestaFiltro == "Día"){
                    MaterialDatePicker.Builder  builder = MaterialDatePicker.Builder.datePicker();
                    MaterialDatePicker materialDatePicker = builder.build();
                    materialDatePicker.show(getSupportFragmentManager(),"Date_picker");
                    materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                        @Override
                        public void onPositiveButtonClick(Object selection) {
                            Long id = (Long)selection;
                            Long startDate = id + 100000000;
                            String dateFormat="";
                            String[] arr = getDate(startDate,"yyyy/MM/dd").split("/");
                            for(int i =0; i< arr.length;i++){
                                dateFormat += arr[i];
                            }
                            Toast(dateFormat);

                            AVLTree tree2 = llenarAVL(todosReportesLista,0);

                            if(tree2.find(Integer.parseInt(dateFormat)) !=null){
                                List filtroPorDia = tree2.find(Integer.parseInt(dateFormat)).reportes;
                                init(filtroPorDia);
                                Toast(String.valueOf(filtroPorDia.size()));


                            }else{
                                Toast("No se encontraron reportes en la fecha selecionada");
                                openAlert();
                            }
                            Toast(String.valueOf(todosReportesLista.size()));


                        }

                    });



                }
                if(respuestaFiltro == "Todos los reportes"){
                    init(todosReportesLista);
                }if(respuestaFiltro == "Localidad"){
                    Toast("ENTRO A LAS LOCALIDADES");

                    volver(this);






                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dialog = new Dialog(this);
        todosReportesCola = llenarCola();
        Toast.makeText(this, "empty queue" + todosReportesCola.empty(), Toast.LENGTH_SHORT).show();
        ColaLista(todosReportesCola);
        //init(todosReportesLista);


    }

    public Cola<Reporte> llenarCola(){
        todosReportesCola = new Cola<Reporte>();
        Reporte reporte;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,9);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select * from reporte ",null);
        while(fila.moveToNext()){
            Toast.makeText(this,"texto" +fila.getString(4),Toast.LENGTH_SHORT).show();
            //String nombre, String reporte, String fecha, String hora, String localidad, String tipologia
            reporte = new Reporte(fila.getString(7), fila.getString(4),fila.getString(5),fila.getString(6),fila.getString(3),fila.getString(2),fila.getInt(0),fila.getInt(8));
            todosReportesCola.enqueue(reporte);
        }

        return todosReportesCola;

    }


    public static AVLTree llenarAVL(List<Reporte> reportes, int puntero){
        AVLTree tree = new AVLTree();
        int j =0;
        int janterior=0;
        int nodoDef = puntero;
        List<Reporte> prueba = new ArrayList();

        j = reportes.get(puntero).getDateId();
        for(int i =puntero; i< reportes.size();){

            int nodo = reportes.get(i).getDateId();

            if(j == nodo){

                System.out.printf("valor j: %d, valor nodo: %d, valor iteracion: %d\n", j,nodo, i);
                prueba.add(reportes.get(i));
                i++;
                if(j== nodo & i == reportes.size()){
                    tree.root = tree.insert(tree.root,((Reporte) prueba.get(0)).getDateId(),prueba);
                }

            }else
            if(j!=nodo)
            {


                puntero =i;
                //funcion(reportes, puntero);
                j = reportes.get(i).getDateId();
                //System.out.printf("prueba en 0: %d", prueba.get(0).getDateId());
                tree.root = tree.insert(tree.root,((Reporte) prueba.get(0)).getDateId(),prueba);

                prueba = new ArrayList();



            }





        }
        return tree;


    }


    public void ColaLista(Cola<Reporte> cola){
        todosReportesLista = new ArrayList<>();
        while(!cola.empty()){
            todosReportesLista.add(cola.dequeue());
        }

    }
    public void Toast(String n){
        Toast.makeText(this, "fecha inico " + n, Toast.LENGTH_SHORT).show();
    }

    public void init(List reportes) {
        ListAdapter2 listAdapter2 = new ListAdapter2(reportes, this);
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(listAdapter2);
    }

    public static String getDate(long milliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(milliSeconds);
        return dateString;

    }
    private void openAlert() {

        dialog.setContentView(R.layout.not_found);
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

    public void volver(AdapterView.OnItemSelectedListener view){
        Intent irLogin  =  new Intent(this,reportesLocalidad.class);
        //irLogin.putReportesArrayListExtra("todosReportesLista",todosReportesLista);
        startActivity(irLogin);
    }


}