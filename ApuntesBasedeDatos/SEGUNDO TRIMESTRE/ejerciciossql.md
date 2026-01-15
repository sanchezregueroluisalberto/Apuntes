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


## Ejercicio 5 SQL

-- Ejercicios de Funciones de Texto
-- 1. Concatenar nombres y apellidos de los ciudadanos en un único campo "nombre_completo".
Select CONCAT(nombre, " ", apellido) as nombre_completo from Ciudadano
-- 2. Obtener las primeras 3 letras de los nombres de los ciudadanos.
Select left(nombre, 3) from Ciudadano
-- 3. Calcular la longitud de los nombres de los ciudadanos.
Select length(nombre) as longitud_nombre from Ciudadano
-- 4. Reemplazar la palabra "hospitales" por "clínicas" en las descripciones de actividades.
Select replace(descripcion, 'hospitales', 'clínicas') as actividades from Actividad
-- 5. Eliminar espacios al inicio y al final de los nombres de los ministerios.
Select trim(nombre) from Ministerio

-- Ejercicios de Funciones NuEXTRACTméricas
-- 6. Redondear el presupuesto de las actividades a millones.
select descripcion, round(presupuesto_asignado/1000000) as millones from actividad
-- 7. Calcular la diferencia entre los ingresos anuales de cada ciudadano y el promedio de ingresos.
select nombre, ingresos_anuales, ingresos_anuales - (select avg(ingresos_anuales) from Ciudadano) as diferencia_promedio_ingresos from Ciudadano
-- 8. Obtener el entero más cercano hacia abajo y hacia arriba de los presupuestos de los ministerios.
select presupuesto, floor(presupuesto) as entero_abajo, ceil(presupuesto) as entero_arriba from Ministerio
-- 9. Generar un número aleatorio para asignar un identificador único temporal a cada actividad.
SELECT id, descripcion, FLOOR(RAND() * 1000000) + 1 AS identificador_temporal FROM Actividad;
-- Ejercicios de Funciones de Fecha y Hora

-- 11. Formatear las fechas de inicio y fin de las actividades en formato "DD-MM-YYYY".
SELECT descripcion, DATE_FORMAT(fecha_inicio, "%d-%m-%Y") as inicio_formateado,
DATE_FORMAT(fecha_fin, "%d-%m-%Y") as fin_formateado from Actividad;
-- 12. Calcular cuántos días faltan para que termine cada actividad.
SELECT descripcion, DATEDIFF(fecha_fin, CURDATE()) AS dias_restantes FROM Actividad;
-- 13. Extraer el mes y el año de las fechas de nacimiento de los ciudadanos.
select nombre, apellido, month(fecha_nacimiento) as mes_nacimiento, year(fecha_nacimiento) as año_nacimiento from Ciudadano
-- Para mi la mejor es:

-- 14. Filtrar ciudadanos nacidos después del año 1990.
select * from Ciudadano where fecha_nacimiento > 1-1-1991

-- 15. Calcular el tiempo total en días que dura cada actividad gubernamental.
select descripcion, datediff(fecha_fin, fecha_inicio) as duracion_actividad from Actividad
