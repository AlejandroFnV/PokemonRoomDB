package com.example.pokemonroomdb.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pokemonroomdb.dao.PokemonDAO;
import com.example.pokemonroomdb.entity.Pokemon;


@Database(entities = {Pokemon.class}, version = 1, exportSchema = false)
public abstract class PokemonDatabase extends RoomDatabase {

    public abstract PokemonDAO getUserDAO();

    private static volatile PokemonDatabase INSTANCIA;

    public static PokemonDatabase getDatabase(final Context context) {
        if (INSTANCIA == null) {
            synchronized (PokemonDatabase.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                            PokemonDatabase.class, "pokemon.sqlite")
                            .build();
                }
            }
        }
        return INSTANCIA;
    }
}
