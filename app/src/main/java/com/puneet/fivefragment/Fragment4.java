package com.puneet.fivefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_4, container, false);
        Button switchtofive = view.findViewById(R.id.btn_switchto5);
        switchtofive.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Fragment5 fragment5 = new Fragment5();
              FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
              fragmentTransaction.replace(R.id.fragment_container,fragment5,"fragment5");
              fragmentTransaction.addToBackStack("5th fragment");
              fragmentTransaction.commit();
          }
      });


        return  view;
    }
}