package com.example.viewgif;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String show = "Show";
    String hide = "Hide";

    ViewGif gifView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifView = (ViewGif)findViewById(R.id.viewGif);

        button = (Button) findViewById(R.id.buttonShowHide);
        button.setText(show);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(gifView.getVisibility() == View.INVISIBLE) {
                    if(button.getText().toString().equals(show)) {
                        gifView.setVisibility(View.VISIBLE);
                        button.setText(hide);
                    } else {
                        button.setText(show);
                    }
                } else {
                    if (button.getText().toString().equals(hide)) {
                        gifView.setVisibility(View.INVISIBLE);
                        button.setText(show);
                    } else {
                        button.setText(hide);
                    }
                }
            }
        });
    }
}