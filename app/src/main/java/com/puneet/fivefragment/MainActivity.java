package com.puneet.fivefragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();
    Button btn;
    LinearLayout expandableview;
    CardView arrow_btn;
    CardView cardView;

    Button arow;
Boolean buttonEnabled=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"In method onCreate");

        expandableview = findViewById(R.id.linear_layout);
        arrow_btn = findViewById(R.id.card_view);
        cardView = findViewById(R.id.card_view);
        arow =findViewById(R.id.arrow);

        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(expandableview.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandableview.setVisibility(View.VISIBLE);
                    arow.setBackgroundResource(R.drawable.baseline_arrow_back_ios_24);
                }else {
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandableview.setVisibility(View.GONE);
                    arow.setBackgroundResource(R.drawable.baseline_arrow_forward_ios_24);
                }
            }
        });


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
    public void onAttachFragment(android.app.Fragment fragment) {
        Log.i(TAG,"In method OnAttachedFragments");
        super.onAttachFragment(fragment);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        Log.i(TAG,"In method OnCreateView");
        return super.onCreateView(name, context, attrs);

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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"in method onSavedInstance");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"In method OnRestoreInstanceState");
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