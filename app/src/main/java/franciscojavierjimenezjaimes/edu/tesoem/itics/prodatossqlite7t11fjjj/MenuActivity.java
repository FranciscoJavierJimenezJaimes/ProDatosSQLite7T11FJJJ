package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
   /*private ViewPager viewPager;
    private adaptador madaptador;
    private  CardTransformer mCardTransoformer;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

      /*  viewPager = findViewById(R.id.viewpager);
        madaptador = new adaptador();

        madaptador.addCardItem(new carditem(R.string.btnadd,R.string.btnsel,R.string.btnupd,R.string.btndel));
        madaptador.addCardItem(new carditem(R.string.btnadd,R.string.btnsel,R.string.btnupd,R.string.btndel));
        madaptador.addCardItem(new carditem(R.string.btnadd,R.string.btnsel,R.string.btnupd,R.string.btndel));
        madaptador.addCardItem(new carditem(R.string.btnadd,R.string.btnsel,R.string.btnupd,R.string.btndel));

        mCardTransoformer = new CardTransformer(viewPager, madaptador);
        viewPager.setAdapter(madaptador);
        viewPager.setOffscreenPageLimit(4);*/
    }
        public void agregarscreen(View view) {
            Intent agregarscreen = new Intent(this, AgregarActivity.class);
            startActivity(agregarscreen);
            Toast.makeText(this, "Seleccionaste Opcion Agregar.", Toast.LENGTH_SHORT).show();
            finish();
        }
        public void Listarscreen(View view) {
            Intent Listarscreen = new Intent(this, ListarActivity.class);
            startActivity(Listarscreen);
            Toast.makeText(this, "Seleccionaste Opcion Listar.", Toast.LENGTH_SHORT).show();
            finish();
        }
        public void Updatescreen(View view) {
            Intent Updatescreen = new Intent(this, ActualizarActivity.class);
            startActivity(Updatescreen);
            Toast.makeText(this, "Seleccionaste Opcion Actualizar.", Toast.LENGTH_SHORT).show();
            finish();
        }
        public void Deletescreen(View view) {
            Intent Deletescreen = new Intent(this, EliminarActivity.class);
            startActivity(Deletescreen);
            Toast.makeText(this, "Seleccionaste Opcion Eliminar.", Toast.LENGTH_SHORT).show();
            finish();
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
