ciclista: dni(PRIMARY KEY), nombre, nacionalidad, fNacimiento
prueba: nombre, año, etapas, kmTotales, (nombre, año)PRIMARY KEY, ganador(FOREIGN KEY REFERENCES Ciclista(id))
equipo: nombre(PRIMARY KEY), nacionalidad, director
ciclista_equipo: idCiclista FOREIGN KEY REFERENCES ciclista(id), idEquipo FOREIGN KEY REFERENCES equipo(id), Finicio, Ffin
prueba_equipo: (nombre, año PRIMARY KEY)FOREIGN KEY REFERENCES prueba(nombre, año), equipo FOREIGN KEY REFERENCES equipo(nombre), puesto

