package co.edu.uac.apmoviles.sqliteuniversidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class EstudianteController {
    private BaseDatos bd;
    private Context c;

    public EstudianteController(Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }

    public long agregarEstudiante(Estudiante e){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(DefDB.col_codigo, e.getCodigo().trim());
            cv.put(DefDB.col_nombre, e.getNombre().trim());
            cv.put(DefDB.col_programa, e.getPrograma().trim());
            long id = sql.insert(DefDB.tabla_est,null,cv);
            return id;
        }
        catch (Exception ex){
            return 0;
        }
    }

    public Cursor allEstudiantes(){
        SQLiteDatabase data = bd.getReadableDatabase();
        Cursor cur = data.rawQuery( "Select * from " + DefDB.tabla_est,null);
        if (cur != null)
            cur.moveToFirst();
        return cur;
    }

    public Cursor findEstudentByCode(String code){
        SQLiteDatabase data = bd.getReadableDatabase();
        code = "'%"+code.trim()+"%'";
        Cursor cur = data.rawQuery( "Select * from " + DefDB.tabla_est +" WHERE `"+DefDB.col_codigo+"` LIKE " + code, null);
        if (cur != null)
            cur.moveToFirst();
        return cur;
    }

    public boolean deleteByCode(String code){
        SQLiteDatabase db = bd.getReadableDatabase();
        return db.delete(DefDB.tabla_est, DefDB.col_codigo+"=?", new String[]{code}) > 0;
    }
}
