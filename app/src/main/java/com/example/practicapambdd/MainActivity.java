package com.example.practicapambdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements IConstantes {
    EditText txtCodigo,txtNombre,txtPrecio,txtCantidad;
    adminSQLiteOpenHelper admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enlazarDatos();
    }

    public void enlazarDatos (){

        txtCodigo=findViewById(R.id.txtCodigo);
        txtNombre=findViewById(R.id.txtNombre);
        txtPrecio=findViewById(R.id.txtPrecio);
        txtCantidad=findViewById(R.id.txtCantidad);

        admin= new adminSQLiteOpenHelper(this,BDD,null,VERSION);


    }

    public void agregar(View v)
    {
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("nombre",txtNombre.getText().toString());
        registro.put("precio",Double.parseDouble(txtPrecio.getText().toString()));
        registro.put("cantidad",Integer.parseInt(txtCantidad.getText().toString()));
        bd.insert(TBL_PRODUCTO,null,registro);
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");

    }


}