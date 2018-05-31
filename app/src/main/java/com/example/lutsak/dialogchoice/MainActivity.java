package com.example.lutsak.dialogchoice;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String FRAGMENT_TAG = "Dialog fragment";

    private TextView mCitySelect;
    private DialogFragment mDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, ">> onCreate");

        mCitySelect = findViewById(R.id.text_city);
        mCitySelect.setOnClickListener(this);

        Log.d(LOG_TAG, "<< onCreate");
    }

    @Override
    public void onClick(View v) {
        Log.d(LOG_TAG, "onClick");
        if (v.getId() == R.id.text_city){
            mDialogFragment = new Dialog();
            mDialogFragment.show(getSupportFragmentManager(), FRAGMENT_TAG);
        }
    }
}
