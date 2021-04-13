package co.edu.uac.apmoviles.sqliteuniversidad;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EstudianteAdapter extends RecyclerView.Adapter<EstudianteAdapter.EstudiantesViewHolder> {
    ArrayList<Estudiante> listaEstudiante;

    public EstudianteAdapter(ArrayList<Estudiante> listaUsuario) {
        this.listaEstudiante = listaUsuario;
    }

    @NonNull
    @Override
    public EstudiantesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_estudiantes, null, false);
        return new EstudiantesViewHolder(view);
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

        public EstudiantesViewHolder(View itemView) {
            super(itemView);
            codigo = (TextView) itemView.findViewById(R.id.textDocumento);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            programa = (TextView) itemView.findViewById(R.id.textTelefono);
        }
    }
}
