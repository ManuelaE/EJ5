package com.example.estudiante.ej5;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NoticiaAdapter extends BaseAdapter {

    ArrayList<Noticias> noticias;
    Activity activity;


    public NoticiaAdapter(Activity activity){
        this.activity = activity;
        noticias = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int i) {
        return noticias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //Generar un renglón por objeto
    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();

        View renglon = inflater.inflate(R.layout.renglon, null, false);
        TextView itemTitulo = renglon.findViewById(R.id.item_titulo);
        TextView itemFecha = renglon.findViewById(R.id.item_fecha);
        TextView itemDescripcion = renglon.findViewById(R.id.item_descripcion);
        Button itemAction = renglon.findViewById(R.id.item_action);

        itemTitulo.setText(noticias.get(position).getTitulo());
        itemFecha.setText(noticias.get(position).getFecha());
        itemDescripcion.setText(noticias.get(position).getDescripcion());
        itemAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText( activity, "POS" + position, Toast.LENGTH_SHORT).show();
                // noticias.remove(position);
                // notifyDataSetChanged();

                Intent intent = new Intent(activity, NoticiaView.class);
                activity.startActivity(intent);
            }
        });

        return renglon;
    }

    public void agregarNoticias(Noticias noticia){
        noticias.add(noticia);
        notifyDataSetChanged();
    }
}
