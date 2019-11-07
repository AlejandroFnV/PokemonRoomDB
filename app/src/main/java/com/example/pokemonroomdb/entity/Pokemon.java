package com.example.pokemonroomdb.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pokemon")
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "altura")
    private String altura;

    @ColumnInfo(name = "peso")
    private String peso;

    @ColumnInfo(name = "sexo")
    private String sexo;

    @ColumnInfo(name = "categoría")
    private String categoría;

    @ColumnInfo(name = "habilidad")
    private String habilidad;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                ", sexo='" + sexo + '\'' +
                ", categoría='" + categoría + '\'' +
                ", habilidad='" + habilidad + '\'' +
                '}';
    }
}
