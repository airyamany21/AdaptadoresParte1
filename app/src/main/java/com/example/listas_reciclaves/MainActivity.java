package com.example.listas_reciclaves;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializar Animes
        List<Anime> items =new ArrayList<>();

        items.add(new Anime(R.drawable.angel,"Angel Beats",230));
        items.add(new Anime(R.drawable.death,"Death note",230));
        items.add(new Anime(R.drawable.fate,"Fate Stay Night",230));
        items.add(new Anime(R.drawable.nhk,"nhk",230));
        items.add(new Anime(R.drawable.suzumiya,"suzumiya",230));

        // Obtener el Recycler
        recycler=(RecyclerView)findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        //Usar un administrador para LinearLayout
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        //Crear un nuevo adpatador
        adapter =new AnimeAdapter(items);
        recycler.setAdapter(adapter);


        //RecyclerView.ViewHolder compartir= findViewById(R.id.holder);


    }

}