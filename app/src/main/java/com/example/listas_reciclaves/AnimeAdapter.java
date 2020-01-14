package com.example.listas_reciclaves;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeHolder> {

    private List<Anime> items;

    public AnimeAdapter(List<Anime> items) {
        this.items = items;
    }

    public class AnimeHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;
        public ImageView compartir;

        public AnimeHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen);
            nombre = itemView.findViewById(R.id.nombre);
            visitas = itemView.findViewById(R.id.visitas);
            compartir = itemView.findViewById(R.id.compartir);
        }
    }

    @NonNull
    @Override
    public AnimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mi_renglon, parent, false);
        return new AnimeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeHolder holder, final int position) {

        holder.imagen.setImageResource(items.get(position).getImagen());
        holder.nombre.setText((CharSequence) items.get(position).getNombre());
        holder.visitas.setText("Visitas" + String.valueOf(items.get(position).getVisitas()));

        holder.compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                //share.putExtra(Intent.EXTRA_TEXT,items.get(position).getNombre());
                //share.putExtra(Intent.EXTRA_SUBJECT,"Pizza Time");
                //intent.putExtra(Intent.EXTRA_TEXT,"https://www.facebook.com");
                //intent.putExtra(Intent.EXTRA_TEXT,"https://www.facebook.com");
                //intent.putExtra(Intent.EXTRA_TEXT, items.get(position).getImagen());

                intent.putExtra(Intent.EXTRA_TEXT, items.get(position).getNombre());
                Intent compartirTexto = Intent.createChooser(intent, null);
                v.getContext().startActivity(compartirTexto);

                // startActivity(Intent.createChooser(share,"Compartir Enlace"));
            }
        });
    }

    @Override
    public int getItemCount() {

        return items.size();

    }

}
