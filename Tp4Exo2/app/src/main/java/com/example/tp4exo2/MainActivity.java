package com.example.tp4exo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnPaypal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager framan = getSupportFragmentManager();
                SimpleDialogFragment simpleDialogFragment = SimpleDialogFragment.newInstance(R.layout.paypal);
                simpleDialogFragment.show(framan, "fragment_simple_dialog");
            }
        });

        findViewById(R.id.BtnCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager framan = getSupportFragmentManager();
                SimpleDialogFragment simpleDialogFragment = SimpleDialogFragment.newInstance(R.layout.card);
                simpleDialogFragment.show(framan, "fragment_simple_dialog");
            }
        });
    }

    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}