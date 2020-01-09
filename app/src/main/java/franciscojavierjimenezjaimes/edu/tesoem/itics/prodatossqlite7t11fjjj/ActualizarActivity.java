package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj.BaseDatos.DatosHelper;
import franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj.DatosGS.*;

public class ActualizarActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    EditText acttxtnombre, acttxtedad, acttxtcorreo, acttxtcurp;
    String[] datosgrid;
    GridView GridView;
    int vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        acttxtnombre = findViewById(R.id.acttxtnombre);
        acttxtedad = findViewById(R.id.acttxtedad);
        acttxtcorreo = findViewById(R.id.acttxtcorreo);
        acttxtcurp = findViewById(R.id.acttxtcurp);

        GridView = findViewById(R.id.GridView);
        GridView.setOnItemClickListener(this);

        llenado();

    }

    public void llenado() {
        DatosHelper conexion = new DatosHelper(this);
        List lista = conexion.llenarGridView();
        datosgrid = new String[lista.size() * 5];
        int counter = 0;
        for (Object datos : lista) {
            DatosGS element = (DatosGS) datos;
            datosgrid[counter] = String.valueOf(element.getId());
            datosgrid[counter + 1] = element.getNombre();
            datosgrid[counter + 2] = String.valueOf(element.getEdad());
            datosgrid[counter + 3] = element.getCorreo();
            datosgrid[counter + 4] = element.getCurp();

            counter += 5;
        }
        for (int i = 0; i < datosgrid.length; i++) {
            if (datosgrid[i] == null) {
                datosgrid[i] = "-";
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosgrid);
        GridView.setAdapter(adapter);
    }


    public boolean number(String value) {
        try {
            int p = Integer.valueOf(value);

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (number(datosgrid[position])) {
            vid = Integer.valueOf(datosgrid[position]);
            acttxtnombre.setText((datosgrid[position + 1]));
            acttxtedad.setText((datosgrid[position + 2]));
            acttxtcorreo.setText((datosgrid[position + 3]));
            acttxtcurp.setText((datosgrid[position + 4]));


        }
    }

    public void back(View view) {
        Intent back = new Intent(this, MenuActivity.class);
        startActivity(back);
        Toast.makeText(this, "Seleccionaste Opcion regresar.", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void btnupdate(View view) {
        if (view.getId() == findViewById(R.id.drop).getId()){
            DatosGS datosGS = new DatosGS();
            DatosHelper conn = new DatosHelper(this);
            datosGS.setId(vid);
            datosGS.setNombre(acttxtnombre.getText().toString());
            datosGS.setEdad(Integer.parseInt(acttxtedad.getText().toString()));
            datosGS.setCorreo(acttxtcorreo.getText().toString());
            datosGS.setCurp(acttxtcurp.getText().toString());

            if (conn.Update(datosGS)){
                Toast.makeText(this,"Se actualizo el dato :D",Toast.LENGTH_SHORT).show();
                acttxtnombre.setText("");
                acttxtedad.setText("");
                acttxtcorreo.setText("");
                acttxtcurp.setText("");
                llenado();
            }else {
                Toast.makeText(this,"Error al actualizar",Toast.LENGTH_SHORT).show();

            }



        }

    }
}