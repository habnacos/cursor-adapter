package co.edu.uac.apmoviles.sqliteuniversidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    private ListView lista;
    private EstudianteController db;
    private EstudianteAdapter adapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = new EstudianteController(getApplicationContext());
        lista = findViewById(R.id.listEstudiante);

        cursor = db.allEstudiantes();
        if (cursor.moveToFirst()) {
            adapter = new EstudianteAdapter(this, cursor, 0);
            lista.setAdapter(adapter);
        }
    }
}
