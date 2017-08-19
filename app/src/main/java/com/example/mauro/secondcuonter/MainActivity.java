package com.example.mauro.secondcuonter;

import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER_VALUE = "COUNTER_VALUE";
    private static final String TAG = "MainActivityTAG_";
    private static final String BOOL_VALUE = "BOOL_VALUE";
    @BindView(R.id.a_main_tv)
    TextView textView;

    private Handler handler;
    private int counter;
    private boolean isEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        handler = new Handler();

        if (savedInstanceState != null){
            Log.d(TAG, "onCreate: " + counter);
            isEnable = savedInstanceState.getBoolean(BOOL_VALUE);
            if(isEnable){
                handler.post(data);
            }
            counter = savedInstanceState.getInt(COUNTER_VALUE);
            showCounter();
        }
    }

    public void startCounter(View view) {
        handler.post(data);
        isEnable = true;
    }

    private final Runnable data = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, 1000);
            counter++;
            showCounter();
        }
    };

    private void showCounter() {
        textView.setText(String.valueOf(counter));
    }

    public void stopCounter(View view) {
        handler.removeCallbacks(data);
        isEnable = false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: " + counter + "," + isEnable);
        outState.putInt(COUNTER_VALUE, counter);
        outState.putBoolean(BOOL_VALUE, isEnable);
    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.d(TAG, "onRestoreInstanceState: " + counter + "," + isEnable);
//        counter = savedInstanceState.getInt(COUNTER_VALUE);
//        isEnable = savedInstanceState.getBoolean(BOOL_VALUE);
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

}
