package paulygon.pokedex;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleFragment;



public class PokedexFragment extends SimpleFragment {


    public PokedexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokedex, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //set up event listeners

        SimpleActivity activity = getSimpleActivity(); //doing this because of way stanford library is written
        activity.$IB(R.id.android_is_kind_of_dumb).setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v){
            pokemonClick(v);
            }
        });
    }

    /*
        * callend when the user clicks on any of the pokemon image buttons.
        * displays a DetailsActivity when in portrait mode, and
        * displays a DetailsFragment when in landscape mode.
     */
    public void pokemonClick(View view) {
        ImageButton button = (ImageButton) view;
        String tag = button.getTag().toString();

        //Launch DetailsActivity
        SimpleActivity activity = getSimpleActivity();

        if(activity.isPortrait()) {
            activity.startActivity(DetailsActivity.class, "pokemon_name", tag);
        }
        else {
            //Landscape mode; update fragment

            // Code from lecture
            DetailsFragment frag = (DetailsFragment) activity.getFragmentManager().findFragmentById(R.id.frag_details);

            frag.setPokemonName(tag);

            /*  //Code from clone with updated id
            DetailsFragment frag = (DetailsFragment)
                    getFragmentManager()
                            .findFragmentById(R.id.frag_details);
            frag.setPokemonName(tag);
            */
            }
    }

}
