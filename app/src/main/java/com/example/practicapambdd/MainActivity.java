package com.example.practicapambdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        bd.close();
        Toast.makeText(this, "sel almaceno producto", Toast.LENGTH_SHORT).show();
    }

    public void consultar(View v)
    {
        SQLiteDatabase bd=admin.getWritableDatabase();
        String codigo=txtCodigo.getText().toString();
        Cursor fila=bd.rawQuery("select nombre,precio,cantidad from producto where codigo='"+codigo+"'",null);
        if(fila.moveToFirst())
        {
            txtNombre.setText(fila.getString(0));
            txtPrecio.setText(fila.getString(1));
            txtCantidad.setText(fila.getString(2));

        }
        else
        {
            Toast.makeText(this, "No existe id", Toast.LENGTH_SHORT).show();
            txtCodigo.setText("");
            txtNombre.setText("");
            txtPrecio.setText("");
            txtCantidad.setText("");
        }

        bd.close();
    }

    public void borrar(View v)
    {
        SQLiteDatabase bd=admin.getWritableDatabase();
        String codigo=txtCodigo.getText().toString();
        int cant=bd.delete("producto","codigo='"+codigo+"'",null);
        if(cant==1);
        {
            Toast.makeText(this, "se elimino el producto", Toast.LENGTH_SHORT).show();
            txtCodigo.setText("");
            txtNombre.setText("");
            txtPrecio.setText("");
            txtCantidad.setText("");
        }

        bd.close();
    }


    public void Modificar(View v)
    {
        SQLiteDatabase bd=admin.getWritableDatabase();
        String codigo=txtCodigo.getText().toString();
        ContentValues registro= new ContentValues();
        registro.put("nombre",txtNombre.getText().toString());
        registro.put("precio",Double.parseDouble(txtPrecio.getText().toString()));
        registro.put("cantidad",Integer.parseInt(txtCantidad.getText().toString()));
        int cantidad=bd.update("producto",registro,"codigo='"+codigo+"'",null);
        if(cantidad==1)
        {
            Toast.makeText(this, "Se modifico el producto"+txtNombre.getText().toString(), Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this, "No existe el producto", Toast.LENGTH_SHORT).show();
        }

        bd.close();

    }

    public void LimpiarDatos()
    {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }




}