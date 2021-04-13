package co.edu.uac.apmoviles.sqliteuniversidad;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EstudianteAdapter extends RecyclerView.Adapter<EstudianteAdapter.EstudiantesViewHolder> {
    ArrayList<Estudiante> listaEstudiante;
    RecyclerView recyclerEstudiante;
    public EstudianteController db;

    public EstudianteAdapter(EstudianteController db, RecyclerView recyclerEstudiante) {
        this.db = db;
        this.recyclerEstudiante = recyclerEstudiante;
        this.generateListEstudents();
    }

    public void generateListEstudents() {
        this.listaEstudiante = new ArrayList<>();

        Cursor cursor = db.allEstudiantes();
        while (cursor.moveToNext())
            listaEstudiante.add(new Estudiante(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        this.recyclerEstudiante.setAdapter(this);
    }

    @NonNull
    @Override
    public EstudiantesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_estudiantes, null, false);
        return new EstudiantesViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull EstudiantesViewHolder holder, int position) {
        holder.codigo.setText(listaEstudiante.get(position).getCodigo());
        holder.nombre.setText(listaEstudiante.get(position).getNombre());
        holder.programa.setText(listaEstudiante.get(position).getPrograma());
    }

    @Override
    public int getItemCount() {
        return listaEstudiante.size();
    }

    public class EstudiantesViewHolder extends RecyclerView.ViewHolder {
        TextView codigo, nombre, programa;
        Button btnDelete;
        EstudianteAdapter estudentAdapter;

        public EstudiantesViewHolder(final View itemView, final EstudianteAdapter estudentAdapter) {
            super(itemView);
            this.estudentAdapter = estudentAdapter;
            codigo = (TextView) itemView.findViewById(R.id.textDocumento);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            programa = (TextView) itemView.findViewById(R.id.textTelefono);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    estudentAdapter.db.deleteByCode(codigo.getText().toString());
                    estudentAdapter.generateListEstudents();
                }
            });
        }
    }
}
