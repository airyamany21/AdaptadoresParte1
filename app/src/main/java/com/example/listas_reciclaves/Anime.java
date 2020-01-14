package com.example.listas_reciclaves;

import lombok.Data;

@Data
public class Anime {

    private int imagen;
    private String nombre;
    private int visitas;
    //private int compartir;

    public Anime(int imagen,String nombre, int visitas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.visitas = visitas;
    }
}
