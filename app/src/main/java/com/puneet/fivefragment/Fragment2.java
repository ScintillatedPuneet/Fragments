package com.puneet.fivefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Fragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       /* Toast.makeText(getActivity(),"Welcome to Fragment 2!",Toast.LENGTH_SHORT).show();*/
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_2, container, false);

        Button switchtofragthree = view.findViewById(R.id.btn_switchto3);

        switchtofragthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment3 fragment3 = new Fragment3();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.fragment_container,fragment3,"Fragment three");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}