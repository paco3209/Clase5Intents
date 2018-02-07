package com.example.ernesto.clase4intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> listaSugerencia = new ArrayList<String>();


        listaSugerencia.add("Argelia");
        listaSugerencia.add("Argentina");
        listaSugerencia.add("Ardksjak");

        ArrayAdapter<String> sug = new ArrayAdapter<String>(this,android.R.layout.test_list_item, listaSugerencia);

        AutoCompleteTextView text = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        text.setAdapter(sug);





        List<String> lista = new ArrayList<String>();
        lista.add("https://news.ycombinator.com/news");
        lista.add("https://www.taringa.net/pagina2");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lista);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        final String elementoSeleccionado = (String)spinner.getSelectedItem();

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editText = (EditText)findViewById(R.id.editText);
        String s = editText.getText().toString();

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String elementoSeleccionado = (String)spinner.getSelectedItem();

        Intent i = new Intent(Intent.ACTION_VIEW);

        i.setData(Uri.parse(elementoSeleccionado));

        startActivity(Intent.createChooser(i,"Elija Navegador"));
      /*  Log.d("act","se hizo click!");

        EditText editText = (EditText)findViewById(R.id.editText);
        String s = editText.getText().toString();

        Intent i = new Intent(this,Pantalla2Activity.class);
        i.putExtra("texto",s);


        startActivityForResult(i,0); */
    } // fin onclick

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("activity1","llego respuesta");

        if(requestCode==0 && resultCode==RESULT_OK && data!=null)
        {
            String msg = data.getExtras().getString("dato1");
            Log.d("activity1",msg);

        }


    }

} // fin activity
