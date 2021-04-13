package co.edu.uac.apmoviles.sqliteuniversidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<Estudiante> listaEstudiante;
    private RecyclerView recyclerEstudiante;
    private EstudianteController db;
    private EstudianteAdapter adapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listaEstudiante = new ArrayList<>();
        db = new EstudianteController(getApplicationContext());
        recyclerEstudiante = findViewById(R.id.recyclerEstudiante);
        recyclerEstudiante.setLayoutManager(new LinearLayoutManager(this));

        cursor = db.allEstudiantes();
        while (cursor.moveToNext())
            listaEstudiante.add(new Estudiante(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        EstudianteAdapter adapter = new EstudianteAdapter(listaEstudiante);
        recyclerEstudiante.setAdapter(adapter);
    }
}
