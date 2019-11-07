package com.example.pokemonroomdb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.pokemonroomdb.entity.Pokemon;
import com.example.pokemonroomdb.view.MainViewModel;
import com.example.pokemonroomdb.view.PokemonAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pokemon pokemon = new Pokemon();
                pokemon.setNombre("Pokemoneh");
                viewModel.insert(pokemon);
            }
        });

        RecyclerView rvList = findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        final PokemonAdapter adapter = new PokemonAdapter(this);
        rvList.setAdapter(adapter);

        //viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.getPokemon().observe(this, new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(@Nullable final List<Pokemon> pokemons) {
                adapter.setPokemons(pokemons);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
