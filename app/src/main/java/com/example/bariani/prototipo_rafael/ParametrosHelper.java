package com.example.bariani.prototipo_rafael;

import android.widget.EditText;

import com.example.bariani.prototipo_rafael.modelo.Parametros;

public class ParametrosHelper {
    private long id;
    private final EditText campoPam1;
    private final EditText campoPam2;
    private final EditText campoPam3;

    private Parametros parametros;

    public ParametrosHelper(ParametrosActivity activity) {
        // Pegando dados do .xml
        campoPam1 = (EditText) activity.findViewById(R.id.parametro_1);
        campoPam2 = (EditText) activity.findViewById(R.id.parametro_2);
        campoPam3 = (EditText) activity.findViewById(R.id.parametro_3);
        parametros = new Parametros();
    }

    public Parametros getPam() {

        parametros.setPam1(Float.valueOf(campoPam1.getText().toString()));
        parametros.setPam2(Float.valueOf(campoPam2.getText().toString()));
        parametros.setPam3(Float.valueOf(campoPam3.getText().toString()));

        return parametros;
    }


}
