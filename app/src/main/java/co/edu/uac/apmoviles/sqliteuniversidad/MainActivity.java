package co.edu.uac.apmoviles.sqliteuniversidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText codigo, nombre, programa;
    Button guardar, cancelar, listado;
  //  BaseDatos bd;
    Estudiante e;
    EstudianteController ec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codigo = findViewById(R.id.edtcodigo);
        nombre = findViewById(R.id.edtnombre);
        programa = findViewById(R.id.edtprograma);
        guardar = findViewById(R.id.btnguardar);
        cancelar = findViewById(R.id.btncancelar);
        listado = findViewById(R.id.btnlistado);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
        listado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnguardar:
                ec = new EstudianteController(this);
                e = new Estudiante(codigo.getText().toString(), nombre.getText().toString(), programa.getText().toString());
                ec.agregarEstudiante(e);
                Toast.makeText(this, "Estudiante Agregado", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnlistado:
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                break;
        }
    }
}
