## Ejercicio3 SQL

### -- 1. Recupera los nombres de los equipos y su ciudad, usando alias para los nombres de las columnas.

SELECT nombre AS 'Nombre del Equipo', ciudad AS 'Sede del Club'
FROM equipos;

### -- 2. Muestra los nombres de los jugadores y puntos por juego, ordenados de mayor a menor.

SELECT nombre, puntos_por_juego
FROM jugadores
ORDER BY puntos_por_juego DESC;

### -- 3. Recupera los nombres de los equipos y la longitud de sus nombres, ordenados por esta longitud de mayor a menor.

SELECT nombre, LENGTH(nombre) AS longitud_nombre
FROM equipos
ORDER BY longitud_nombre DESC;

### -- 4. Muestra los nombres de las ciudades y la suma total de campeonatos ganados por equipos en cada ciudad, ordenados por la suma de mayor a menor.

SELECT ciudad, SUM(campeonatos) AS total_campeonatos
FROM equipos
GROUP BY ciudad
ORDER BY total_campeonatos DESC;

## Ejercicio4 SQL

### -- 1. Encuentra el número total de empleados por departamento.

SELECT departamento, COUNT(*) AS total_empleados
FROM empleado
GROUP BY departamento;

### -- 2. Calcula el salario promedio por ciudad, mostrando solo las ciudades con un salario promedio mayor a 4000.

SELECT ciudad, AVG(salario) AS salario_promedio
FROM empleado
GROUP BY ciudad
HAVING AVG(salario) > 4000;

### -- 3. Encuentra el total de ventas por cada cliente.

SELECT cliente, SUM(importe) AS total_comprado
FROM venta
GROUP BY cliente
ORDER BY total_comprado DESC;

### -- 4. Muestra los departamentos con más de 3 empleados.

SELECT departamento
FROM empleado
GROUP BY departamento
HAVING COUNT(*) > 3;

### -- 5. Calcula el promedio de edad de los empleados por ciudad.

SELECT ciudad, AVG(edad) AS edad_promedio
FROM empleado
GROUP BY ciudad;

### -- 6. Muestra las ciudades en las que hay empleados, sin duplicados.

SELECT DISTINCT ciudad 
FROM empleado;

## --7
select count(*) as numero_de_ventas, SUM(importe) as total_importe from venta;

## --8
