package com.example.tp2bonus;
import android.os.Bundle;

        import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class AjoutPlanetFragment extends DialogFragment {

    EditText Nom, Taille;
    Button Ajouter;

    public AjoutPlanetFragment() {
    }
    public static AjoutPlanetFragment newInstance() {
        AjoutPlanetFragment fragment = new AjoutPlanetFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_frag_ajout_planet, container, false);
        Nom = view.findViewById(R.id.nom_planete);
        Taille = view.findViewById(R.id.Taille_planete);
        Ajouter = view.findViewById(R.id.ajout_planet);
        Ajouter.setOnClickListener(v -> {
            Boolean flag = true;

            String name = Nom.getText().toString();
            if (!name.matches("[a-z A-Z]+")) {
                Toast.makeText(getContext(), getString(R.string.nom_invalide), Toast.LENGTH_SHORT).show();
                flag = false;
            }

            String sizeAsString = Taille.getText().toString();
            if (!sizeAsString.matches("[0-9]+")) {
                Toast.makeText(getContext(), getString(R.string.taille_invalide), Toast.LENGTH_SHORT).show();
                flag = false;
            }

            if (flag) {
                Integer size = Integer.parseInt(sizeAsString);
                MainActivity ma = (MainActivity) getActivity();
                new Thread((Runnable) () -> {
                    Planete new_planet = new Planete(name, size);
                    ma.DaoPlanete.insert(new_planet);
                    ma.planets.add(new_planet);
                    ma.mRecyclerView.post(() -> ma.getmAdapter().notifyDataSetChanged());
                }).start();
                getDialog().dismiss();
            }
        });

        return view;
    }
}