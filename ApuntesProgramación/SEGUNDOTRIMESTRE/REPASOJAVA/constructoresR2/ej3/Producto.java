package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej3;

/**
 * Representa un producto dentro del inventario de un supermercado.
 * 
 * <p>
 * Esta clase almacena la informacion de un articulo
 * </p>
 * 
 * @author Guillermo Jimenez
 */
public class Producto {
    private final String cabeceraId = "PID-";
    private static int numId = 0;
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadStock;

    /**
     * Constructor para la clase Producto.
     * 
     * <p>
     * Incrementa el contador estático para asignar un ID unico autogenerado
     * al producto siguiendo el formato "PID-n".
     * </p>
     * 
     * @param id            Identificador base (no utilizado directamente para el
     *                      atributo id final).
     * @param nombre        Nombre del producto.
     * @param descripcion   Descripcion detallada del articulo.
     * @param precio        Precio de venta al publico.
     * @param cantidadStock Unidades disponibles inicialmente.
     */
    Producto(String id, String nombre, String descripcion, double precio, int cantidadStock) {
        numId++;
        this.id = cabeceraId + numId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        setPrecio(precio);
        this.cantidadStock = cantidadStock;

    }

    /**
     * Genera una representación textual del producto en lenguaje humano.
     * 
     * @return Cadena de texto formateada con los datos del producto.
     */
    @Override
    public String toString() {
        String mensajeToString = "ID: " + id + " |" + nombre + " | Descripcion: " + descripcion + " | Precio: " + precio
                + " | Stock: " + cantidadStock;
        return mensajeToString;
    }

    /**
     * Establece el identificador del producto.
     * 
     * @param id Nuevo identificador.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador único del producto.
     * 
     * @return El ID del producto.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre Nombre comercial.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece la descripcion del producto.
     * 
     * @param descripcion Detalles del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del producto.
     * 
     * @return La descripción actual.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece el precio del producto.
     * 
     * <p>
     * Incluye una validacion para asegurar que el precio no sea negativo.
     * </p>
     * 
     * @param precio Valor numerico del precio.
     */
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    /**
     * Obtiene el precio actual del producto.
     * 
     * @return El precio de venta.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece la cantidad de unidades en stock.
     * 
     * @param cantidadStock Número de unidades disponibles.
     */
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    /**
     * Obtiene la cantidad actual de unidades en stock.
     * 
     * @return El stock disponible.
     */
    public int getCantidadStock() {
        return cantidadStock;
    }
}