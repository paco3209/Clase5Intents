package com.example.ernesto.clase4intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla2Activity
        extends AppCompatActivity
        implements View.OnClickListener{

    //public final static String KEY_TEXTO = "texto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        Intent i = getIntent();
        Bundle b = i.getExtras();
        String s = b.getString("texto");

        TextView t = (TextView) findViewById(R.id.textView);
        t.setText(s);

        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent();
        i.putExtra("dato1","mensaje desde actv2");
        i.putExtra("dato2",27);
        setResult(RESULT_OK,i);
        finish();
    }
}
