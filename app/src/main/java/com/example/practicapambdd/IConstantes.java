package com.example.practicapambdd;

public interface IConstantes {

    String BDD="PracticaPam.db";

    String TBL_PRODUCTO="producto";

    String TBL_PRODUCTO_DLL="CREATE TABLE producto (\n" +
            "    codigo   INTEGER        PRIMARY KEY AUTOINCREMENT\n" +
            "                            NOT NULL\n" +
            "                            UNIQUE,\n" +
            "    nombre   VARCHAR (100)  NOT NULL\n" +
            "                            UNIQUE,\n" +
            "    precio   NUMERIC (9, 2) NOT NULL,\n" +
            "    cantidad INTEGER        NOT NULL\n" +
            ");\n";

    int VERSION=1;

}
