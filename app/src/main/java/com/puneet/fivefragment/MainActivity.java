package com.puneet.fivefragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();
    Button btn;
    LinearLayout expandableview;
    CardView cardView;
    CardView arrow_btn;
    LinearLayout btn_fold;

    Button arow;
Boolean buttonEnabled=true;
    GestureDetector gestureDetector;
    GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "In method onCreate");
        CardView cardView = findViewById(R.id.card_view);
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                // Hide card view
                if (cardView.getVisibility() == View.VISIBLE) {
                    ObjectAnimator animator = ObjectAnimator.ofFloat(cardView, "translationX", 0f, -cardView.getWidth());
                    animator.setDuration(500); // Set animation duration in milliseconds

                    // Set listener to hide view after animation completes
                    animator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cardView.setVisibility(View.GONE);
                            cardView.setTranslationX(0f); // Reset alpha for next use
                        }
                    });

                    // Start animation
                    animator.start();

                    return true;

                } else{
                    cardView.setTranslationX(-cardView.getWidth()); // Set initial translation
                    cardView.setVisibility(View.VISIBLE);

                    // Create animator to show CardView
                    ObjectAnimator animator = ObjectAnimator.ofFloat(cardView, "translationX", -cardView.getWidth(), 0f);
                    animator.setDuration(500);

                    // Start animation
                    animator.start();

                    return true;
                    }
                }


        });


        TextView agent_name = findViewById(R.id.txt_agent_name);
        TextView home = findViewById(R.id.txt_home);
        TextView notification = findViewById(R.id.txt_notification);
        TextView message = findViewById(R.id.txt_message);
        TextView upcoming_tours = findViewById(R.id.txt_upcoming_tours);
        TextView completed_tours = findViewById(R.id.txt_completed_tours);
        TextView daynight_mode = findViewById(R.id.txt_daymode);
        TextView logout = findViewById(R.id.txt_logout);

        LinearLayout linearLayout1 = findViewById(R.id.profile_image);
        LinearLayout linearLayout2 = findViewById(R.id.home_btn);
        LinearLayout linearLayout3 = findViewById(R.id.reminder_btn);
        LinearLayout linearLayout4 = findViewById(R.id.notification_btn);
        LinearLayout linearLayout5 = findViewById(R.id.upcoming_tour_btn);
        LinearLayout linearLayout6 = findViewById(R.id.completed_tour_btn);
        LinearLayout linearLayout7 = findViewById(R.id.mode_btn);
        LinearLayout linearLayout8 = findViewById(R.id.logout_btn);




        arrow_btn = findViewById(R.id.card_view);
        btn_fold = findViewById(R.id.btn_fold);
        arow =findViewById(R.id.arrow);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearLayout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btn_fold.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
           if(agent_name.getVisibility()==View.VISIBLE) {
               agent_name.setVisibility(View.GONE);
               home.setVisibility(View.GONE);
               notification.setVisibility(View.GONE);
               message.setVisibility(View.GONE);
               upcoming_tours.setVisibility(View.GONE);
               completed_tours.setVisibility(View.GONE);
               daynight_mode.setVisibility(View.GONE);
               logout.setVisibility(View.GONE);

           }else {
               agent_name.setVisibility(View.VISIBLE);
               home.setVisibility(View.VISIBLE);
               notification.setVisibility(View.VISIBLE);
               message.setVisibility(View.VISIBLE);
               upcoming_tours.setVisibility(View.VISIBLE);
               completed_tours.setVisibility(View.VISIBLE);
               daynight_mode.setVisibility(View.VISIBLE);
               logout.setVisibility(View.VISIBLE);
           }




            } /*{
                View[] viewsToHide = {
                        findViewById(R.id.txt_agent_name),
                        findViewById(R.id.txt_home),
                        findViewById(R.id.txt_notification),
                        findViewById(R.id.txt_message),
                        findViewById(R.id.txt_upcoming_tours),
                        findViewById(R.id.txt_completed_tours),
                        findViewById(R.id.txt_daymode),
                        findViewById(R.id.txt_logout)
                };
*//*                if(v.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    viewsToHide.setVisibility(View.VISIBLE);
                    arow.setBackgroundResource(R.drawable.baseline_arrow_back_ios_24);
                }else {
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    hideTextViews().setVisibility(View.GONE);
                    arow.setBackgroundResource(R.drawable.baseline_arrow_forward_ios_24);
                }*//*
                    viewsToHide.animate().alpha(0f).setDuration(500).withEndAction(() -> v.setVisibility(View.GONE)).start();
                    for (View view : viewsToHide) {
                        view.animate().alpha(0f).setDuration(500).withEndAction(() -> view.setVisibility(View.GONE)).start();

                    }
                    }*/
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
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    /*public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }*/

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }*/


       /* agent_name.setVisibility(View.GONE);
        home.setVisibility(View.GONE);
        notification.setVisibility(View.GONE);
        message.setVisibility(View.GONE);
        upcoming_tours.setVisibility(View.GONE);
        completed_tours.setVisibility(View.GONE);
        daynight_mode.setVisibility(View.GONE);
        logout.setVisibility(View.GONE);*/

/*
    LinearLayout linearLayout1 = findViewById(R.id.profile_image);
    LinearLayout linearLayout2 = findViewById(R.id.home_btn);
    LinearLayout linearLayout3 = findViewById(R.id.reminder_btn);
    LinearLayout linearLayout4 = findViewById(R.id.notification_btn);
    LinearLayout linearLayout5 = findViewById(R.id.upcoming_tour_btn);
    LinearLayout linearLayout6 = findViewById(R.id.completed_tour_btn);
    LinearLayout linearLayout7 = findViewById(R.id.mode_btn);
    LinearLayout linearLayout8 = findViewById(R.id.logout_btn);*/
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