package paulygon.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import stanford.androidlib.SimpleActivity;

public class PokedexActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
    }

    public void pokemonClick(View view){

        String tag = view.getTag().toString();

        if(isPortrait()){
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("pokemon_name", tag);
            startActivity(intent);
        } else {
            //Landscape mode; update fragment
            DetailsFragment frag = (DetailsFragment)
                    getFragmentManager()
                            .findFragmentById(R.id.frag_details);
            frag.setPokemonName(tag);
        }


    }}
