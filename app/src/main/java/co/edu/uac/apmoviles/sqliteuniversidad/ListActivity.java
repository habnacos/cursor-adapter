package co.edu.uac.apmoviles.sqliteuniversidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerEstudiante = findViewById(R.id.recyclerEstudiante);
        recyclerEstudiante.setLayoutManager(new LinearLayoutManager(this));
        final EstudianteAdapter adapter = new EstudianteAdapter(new EstudianteController(getApplicationContext()), recyclerEstudiante);

        Button btnFind = findViewById(R.id.btnFind);
        final TextView textCode = findViewById(R.id.textCode);

        textCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(), textCode.getText().toString(), Toast.LENGTH_SHORT).show();
                adapter.setCode(textCode.getText().toString());
                adapter.generateListEstudents();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.setCode(textCode.getText().toString());
                adapter.generateListEstudents();
            }
        });
    }
}
