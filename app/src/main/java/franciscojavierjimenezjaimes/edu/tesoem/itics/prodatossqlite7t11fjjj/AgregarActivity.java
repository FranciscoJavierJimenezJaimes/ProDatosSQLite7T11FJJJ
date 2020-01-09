package franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj.BaseDatos.DatosConexion;
import franciscojavierjimenezjaimes.edu.tesoem.itics.prodatossqlite7t11fjjj.BaseDatos.DatosHelper;

public class AgregarActivity extends AppCompatActivity {
    EditText txtnombre, txtedad, txtcorreo, txtcurp;
    ImageView mimageView;
    final int REQUEST_CODE_GALLERY = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtcorreo = findViewById(R.id.txtcorreo);
        txtcurp = findViewById(R.id.txtcurp);
        mimageView = findViewById(R.id.ima);

        mimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(AgregarActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY);
            }
        });

    }
        public void Registrar (View view){
            ContentValues contentValues = new ContentValues();
            DatosConexion datosConexion = new DatosConexion(this);
            datosConexion.open();

            //contentValues.put(DatosHelper.TablaDatos.COLUMNA_NOMBRE,txtnombre.getText().toString());
            //contentValues.put(DatosHelper.TablaDatos.COLUMNA_EDAD,txtedad.getText().toString());
            //contentValues.put(DatosHelper.TablaDatos.COLUMNA_CORREO,txtcorreo.getText().toString());
            //contentValues.put(DatosHelper.TablaDatos.COLUMNA_CURP,txtcurp.getText().toString());

            contentValues.put("Nombre", txtnombre.getText().toString());
            contentValues.put("Edad", txtedad.getText().toString());
            contentValues.put("Correo", txtcorreo.getText().toString());
            contentValues.put("Curp", txtcurp.getText().toString());


            if (datosConexion.Insertar(contentValues)) {
                Toast.makeText(this, "Se Agergo el dato :D", Toast.LENGTH_SHORT).show();
                txtnombre.setText("");
                txtedad.setText("");
                txtcorreo.setText("");
                txtcurp.setText("");


            } else {
                Toast.makeText(this, "Error al Agregar", Toast.LENGTH_SHORT).show();

            }
        }
            public void MenuPrincipal (View view){
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Regresando al menu prinicipal", Toast.LENGTH_SHORT).show();
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
    public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
                                             @NonNull int[] grantResults){
        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
            }
        } else {
            Toast.makeText(this, "no tienes permisos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY && requestCode == RESULT_OK){
            Uri imageUri = data.getData();
            CropImage.activity(imageUri).setGuidelines(CropImageView.Guidelines.ON).setAspectRatio(1,1).start(this);

        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (requestCode == RESULT_OK){
                Uri resultUri = result.getUri();
            }else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error =result.getError();
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
