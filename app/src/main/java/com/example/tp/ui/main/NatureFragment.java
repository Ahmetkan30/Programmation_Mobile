package com.example.tp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tp.R;

public class NatureFragment extends Fragment {
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static NatureFragment newInstance(int position, String title) {
        NatureFragment fragment = new NatureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutID;
        View view;
        if( page == 0 ){
            layoutID = R.layout.menu;
            view = inflater.inflate(R.layout.menu, container, false);
            int[] imagesID = new int[]{R.id.hiver,R.id.printemps,R.id.ete,R.id.automne};
            for(int i=0;i<imagesID.length;i++){
                ImageView img = (ImageView)view.findViewById(imagesID[i]);
                img.setClickable(true);
                int position = i+1;
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((ViewPager)getActivity().findViewById(R.id.view_pager)).setCurrentItem(position);
                    }
                });
            }
        } else {
            layoutID = R.layout.fragment_main;
            view = inflater.inflate(R.layout.fragment_main, container, false);
            ImageView image = (ImageView) view.findViewById(R.id.imageView);
            switch (page){
                case 1:
                    image.setImageResource(R.drawable.hiver);
                    break;
                case 2:
                    image.setImageResource(R.drawable.printemps);
                    break;
                case 3:
                    image.setImageResource(R.drawable.ete);
                    break;
                case 4:
                    image.setImageResource(R.drawable.automne);
                    break;
            }
        }
        return view;
    }
}