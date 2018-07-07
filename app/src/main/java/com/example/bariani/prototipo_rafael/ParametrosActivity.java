package com.example.bariani.prototipo_rafael;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bariani.prototipo_rafael.modelo.Parametros;

public class ParametrosActivity extends AppCompatActivity {

    private ParametrosHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_parametros, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_parametro_ok:

                Parametros parametros = (Parametros) helper.getPam();

                Intent intentFazGraph = new Intent(ParametrosActivity.this, GraficosMP.class);
                intentFazGraph.putExtra("parametros", parametros);
                startActivity(intentFazGraph);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
