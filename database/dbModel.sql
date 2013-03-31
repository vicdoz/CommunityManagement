CREATE TABLE ReciboInmueble (
       idRecibo INTEGER NOT NULL
     , FechaPago DATE
     , Importe FLOAT
     , PRIMARY KEY (idRecibo)
);

CREATE TABLE Concepto (
       ClaveConcepto INTEGER NOT NULL
     , Descripcion CHAR(50)
     , PRIMARY KEY (ClaveConcepto)
);

CREATE TABLE Propietario (
       NIF CHAR(9) NOT NULL
     , Nombre CHAR(50)
     , Direccion CHAR(50)
     , Poblacion CHAR(50)
     , Telefono CHAR(9)
     , Observaciones CHAR(50)
     , FechaAlta DATE
     , Entidad INTEGER
     , NumeroCuenta INTEGER
     , PRIMARY KEY (NIF)
);

CREATE TABLE NotaInformativa (
       idNotaInformativa INTEGER NOT NULL
     , FechaCalculo DATE
     , ImporteNota FLOAT
     , idRecibo INTEGER NOT NULL
     , PRIMARY KEY (idNotaInformativa)
     , CONSTRAINT FK_NotaInformativa_1 FOREIGN KEY (idRecibo)
                  REFERENCES ReciboInmueble (idRecibo) ON DELETE CASCADE
);

CREATE TABLE LineaFactura (
       ImporteLinea FLOAT NOT NULL
     , Observacion CHAR(50)
     , ClaveConcepto INTEGER NOT NULL
     , idLinea INTEGER
     , PRIMARY KEY (ImporteLinea)
     , CONSTRAINT FK_LineaFactura_1 FOREIGN KEY (ClaveConcepto)
                  REFERENCES Concepto (ClaveConcepto)
);

CREATE TABLE Inmueble (
       IdInmueble INTEGER NOT NULL
     , Escalera CHAR(10)
     , Piso CHAR(10)
     , Puerta CHAR(10)
     , Porcentaje FLOAT
     , NIF CHAR(9) NOT NULL
     , idRecibo INTEGER NOT NULL
     , PRIMARY KEY (IdInmueble)
     , CONSTRAINT FK_Inmueble_3 FOREIGN KEY (NIF)
                  REFERENCES Propietario (NIF)
     , CONSTRAINT FK_Inmueble_2 FOREIGN KEY (idRecibo)
                  REFERENCES ReciboInmueble (idRecibo)
);

CREATE TABLE Factura (
       NumFactura INTEGER NOT NULL
     , FechaFactura DATE
     , idNotaInformativa INTEGER NOT NULL
     , ImporteLinea FLOAT NOT NULL
     , PRIMARY KEY (NumFactura)
     , CONSTRAINT FK_Factura_2 FOREIGN KEY (idNotaInformativa)
                  REFERENCES NotaInformativa (idNotaInformativa)
     , CONSTRAINT FK_Factura_3 FOREIGN KEY (ImporteLinea)
                  REFERENCES LineaFactura (ImporteLinea) ON DELETE CASCADE
);

CREATE TABLE Comunidad (
       Calle CHAR(50)
     , MaxRecibosPendientes INTEGER
     , Estado CHAR(25)
     , idNotaInformativa INTEGER
     , NumFactura INTEGER
     , IdInmueble INTEGER NOT NULL
     , idComunidad INTEGER NOT NULL
     , PRIMARY KEY (idComunidad)
     , CONSTRAINT FK_Comunidad_4 FOREIGN KEY (NumFactura)
                  REFERENCES Factura (NumFactura)
     , CONSTRAINT FK_Comunidad_2 FOREIGN KEY (idNotaInformativa)
                  REFERENCES NotaInformativa (idNotaInformativa)
     , CONSTRAINT FK_Comunidad_3 FOREIGN KEY (IdInmueble)
                  REFERENCES Inmueble (IdInmueble) ON DELETE CASCADE

);