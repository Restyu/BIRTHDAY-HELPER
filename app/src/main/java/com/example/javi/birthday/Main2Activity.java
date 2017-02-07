package com.example.javi.birthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        view = (TextView)findViewById(R.id.vista);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null)
        {
            String tx = (String) b.get("perfil");
            view.setText(tx);
        }
    }
}
