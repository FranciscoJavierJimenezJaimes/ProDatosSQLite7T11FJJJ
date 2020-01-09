package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj.BaseDatos.DatosConexion;
import franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj.BaseDatos.DatosHelper;
import franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj.DatosGS.*;

public class EliminarActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView Etxtnombre, Etxtedad, Etxtcorreo, Etxtcurp;
    String[] datosgrid;
    android.widget.GridView GridView;
    int vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        Etxtnombre = findViewById(R.id.Etxtnombre);
        Etxtedad = findViewById(R.id.Etxtedad);
        Etxtcorreo = findViewById(R.id.Etxtcorreo);
        Etxtcurp = findViewById(R.id.Etxtcurp);

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
            int P = Integer.valueOf(value);

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (number(datosgrid[position])) {
            vid = Integer.valueOf(datosgrid[position]);
            Etxtnombre.setText((datosgrid[position + 1]));
            Etxtedad.setText((datosgrid[position + 2]));
            Etxtcorreo.setText((datosgrid[position + 3]));
            Etxtcurp.setText((datosgrid[position + 4]));

        }
    }

    public void back(View view) {
        Intent back = new Intent(this, MenuActivity.class);
        startActivity(back);
        Toast.makeText(this, "Seleccionaste Opcion regresar.", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void btndelete(View view) {
        if (view.getId() == findViewById(R.id.drop).getId()) {
            DatosGS datosGS = new DatosGS();
            DatosHelper con = new DatosHelper(this);
            datosGS.setId(vid);
            datosGS.setNombre(Etxtnombre.getText().toString());
            datosGS.setEdad(Integer.parseInt(Etxtedad.getText().toString()));
            datosGS.setCorreo(Etxtcorreo.getText().toString());
            datosGS.setCurp(Etxtcurp.getText().toString());

            if (con.Delete(datosGS)) {
                Toast.makeText(this, "Se Elimino el dato Felicidades", Toast.LENGTH_SHORT).show();

                Etxtnombre.setText("");
                Etxtedad.setText("");
                Etxtcorreo.setText("");
                Etxtcurp.setText("");

                llenado();
            } else {
                Toast.makeText(this, "Error al Eliminar", Toast.LENGTH_SHORT).show();

            }


        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.Acercade) {
            Toast.makeText(this, "Acerca De.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AcercadeActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
}