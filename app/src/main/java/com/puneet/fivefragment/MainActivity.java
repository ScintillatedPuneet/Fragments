package com.puneet.fivefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();
    Button btn;
Boolean buttonEnabled=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"In method onCreate");

         // Close the app

        btn = findViewById(R.id.show_fragment_button);
        btn.setEnabled(buttonEnabled);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = new Fragment1();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.fragment_container, fragment).commit();
                    fragmentTransaction.addToBackStack(null);
                    btn.setEnabled(false);
                }
            });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"In method onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"In method onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"In method onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"In method onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"In method onDestroy");
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
            btn.setEnabled(true);


        }
    }
}