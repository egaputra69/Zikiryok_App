package com.example.zikiryoklite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ZikirActivity extends AppCompatActivity {

    Button btAdder;
    TextView titleView, timesZikir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zikir);

        titleView = findViewById(R.id.title_zikir);
        Intent get = this.getIntent();
        String titleZikir = get.getStringExtra("title");
        titleView.setText(titleZikir);

        btAdder = findViewById(R.id.bt_adder);
        timesZikir = findViewById(R.id.times_zikir);

        btAdder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Szikir = timesZikir.getText().toString();
                int Izikir = Integer.parseInt(Szikir);
                int jumlah = Izikir + 1;

                timesZikir.setText(String.valueOf(jumlah));
            }
        });
    }
}