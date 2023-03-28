package com.puneet.fivefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        Button switchSecondfrag = view.findViewById(R.id.btn_switchto2);

        switchSecondfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment2 secondFragment = new Fragment2();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container, secondFragment, "secondFragment");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}

