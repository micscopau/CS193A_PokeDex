package paulygon.pokedex;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleFragment;


public class DetailsFragment extends SimpleFragment {


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SimpleActivity activity = getSimpleActivity();

        //initialization code
        //Todo: display the relevant pokemons information

        //Lecture Code
        String pokemonName = activity.getStringExtra("pokemon_name", "Charmander");
        setPokemonName(pokemonName);

        /* //Clone Code
        Intent intent = activity.getIntent();
        String pokeName = intent.getStringExtra("pokemon_name");

        if (pokeName == null) {
            pokeName = "Charmander";
        }

        setPokemonName(pokeName);
        */
    }

    public void setPokemonName(String pokemonName) {
        SimpleActivity activity = getSimpleActivity();
        int imageID = activity.getResourceId(pokemonName.toLowerCase(), "drawable");
        int fileID = activity.getResourceId(pokemonName.toLowerCase(), "raw");

        String fileText = activity.readFileText(fileID);

        activity.$TV(R.id.pokemon_name).setText(pokemonName);
        activity.$IV(R.id.pokemon_image).setImageResource(imageID);
        activity.$TV(R.id.pokemon_details).setText(fileText);

        /* //Clone Code
        SimpleActivity activity = (SimpleActivity) getActivity();

        //pokename = pikachu
        //-pikachu appear on big font
        TextView nameTextView = (TextView) activity.findViewById(R.id.pokemon_name);
        nameTextView.setText(pokeName);

        //display pikachu image in imageview (r.drawable.pikachu)
        ImageView imageView = (ImageView) activity.findViewById(R.id.pokemon_image);
        int pokeID = getResources().getIdentifier(
                pokeName.toLowerCase(), "drawable", activity.getPackageName() //CHECK THIS LATER
        );
        imageView.setImageResource(pokeID);

        //want details about pikachu to appear in small font (res/raw/pikachu.txt)
        //r.raw.pikachu
        int fileID = getResources().getIdentifier(
                pokeName.toLowerCase(), "raw", activity.getPackageName() //CHECK THIS LATER
        );

        String fileText = activity.readFileText(fileID);
        TextView pokeDetails = (TextView) activity.findViewById(R.id.pokemon_details);
        pokeDetails.setText(fileText);
        */
    }
}
