package com.example.pokemonroomdb.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonroomdb.R;
import com.example.pokemonroomdb.entity.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private LayoutInflater inflater;
    private List<Pokemon> pokemonList;
    private int contador = 0;

    public PokemonAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("xyzyx", "onCreateViewHolder: " + contador);
        contador++;
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Log.v("xyzyx", "onBindViewHolder: " + contador);
        if (pokemonList != null) {
            Pokemon current = pokemonList.get(position);
            holder.tvItem.setText(current.toString());
        } else {
            holder.tvItem.setText("No user available");
        }
    }

    @Override
    public int getItemCount() {
        Log.v("xyzyx", "getItemCount: " + contador);
        int elementos = 0;
        if(pokemonList != null) {
            elementos = pokemonList.size();
        }
        return elementos;
    }

    public void setPokemons(List<Pokemon> pokemonList){
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvItem;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
