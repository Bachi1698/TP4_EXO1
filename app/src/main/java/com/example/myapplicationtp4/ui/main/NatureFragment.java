package com.example.myapplicationtp4.ui.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplicationtp4.MainActivity;
import com.example.myapplicationtp4.R;


/**
 * une instance de NatureFragment contient ici juste un label
 */
public class NatureFragment extends Fragment {
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;
    private int page;
    private int image;
    static MainActivity activity;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";
    private static final String ARG_SECTION_IMAGE = "image_page";


    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static NatureFragment newInstance(int position, String title, int saison, int image) {
        NatureFragment fragment = new NatureFragment();
        /**activity = (MainActivity) mContext;*/
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        args.putInt(ARG_SECTION_IMAGE, image);
        fragment.setArguments(args);
        return fragment;
    }



    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
        image = getArguments().getInt(ARG_SECTION_IMAGE);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
        tvLabel.setText(page + " -- " + title);
        if (page==0 || page==1 || page==2 || page==3){
            ImageView imageV = (ImageView)view.findViewById(R.id.imageView);
            imageV.setImageResource(image);
        }

        if (page==4) {
            ImageView imageVI = (ImageView) view.findViewById(R.id.imageView1);
            imageVI.setImageResource(R.drawable.hiver);
            imageVI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity a= (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(2);
                }
            });
            ImageView imageVI1 = (ImageView) view.findViewById(R.id.imageView2);
            imageVI1.setImageResource(R.drawable.printemps);
            imageVI1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity a= (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(3);
                }
            });
            ImageView imageVI2 = (ImageView) view.findViewById(R.id.imageView3);
            imageVI2.setImageResource(R.drawable.ete);
            imageVI2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity a= (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(1);
                }
            });
            ImageView imageVI3 = (ImageView) view.findViewById(R.id.imageView4);
            imageVI3.setImageResource(R.drawable.autone);
            imageVI3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity a= (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(0);
                }
            });
        }
        return view;
    }
}

