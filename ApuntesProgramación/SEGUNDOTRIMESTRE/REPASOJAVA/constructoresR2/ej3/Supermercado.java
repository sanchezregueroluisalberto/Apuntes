package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej3;

import java.util.ArrayList;

/**
 * Gestiona la coleccion de productos de un supermercado.
 * 
 * <p>
 * Esta clase permite administrar el inventario mediante un ArrayList,
 * operaciones de imtroduccion, busqueda, venta y generacion
 * automatica de productos.
 * </p>
 * 
 * @author Guillermo Jimenez
 */
public class Supermercado {

    /** Lista que almacena los objetos de tipo Producto en el supermercado. */
    ArrayList<Producto> supermercado;

    /**
     * Constructor que inicializa la lista del supermercado.
     */
    Supermercado() {
        this.supermercado = new ArrayList<>();
    }

    /**
     * Genera un listado visual de todos los productos en el inventario.
     * 
     * @return Cadena de texto con la representación de cada producto línea a línea.
     */
    @Override
    public String toString() {
        String market = "";

        for (Producto producto : supermercado) {
            market += producto + "\n";
        }

        return market;
    }

    /**
     * Añade un producto al inventario si no se encuentra ya registrado.
     * 
     * @param producto El objeto Producto que se desea añadir.
     */
    public void aniadirProducto(Producto producto) {
        if (!supermercado.contains(producto)) {
            supermercado.add(producto);
        }

    }

    /**
     * Buscamos el producto que queremos buscar y lo validamos
     * 
     * @param scannerOption   Scanner
     * @param productoAbuscar Producto que uqeremos buscar
     * @return nos devuelve el producto que hemos buscado en el array
     */
    public Producto buscarProductoId(String productoAbuscar) {
        Producto productoEncontrado = null;

        for (Producto producto : supermercado) {
            // Solo entramos si el ID coincide Y aún no hemos asignado un resultado
            if (producto.getId().equalsIgnoreCase(productoAbuscar) && productoEncontrado == null) {
                productoEncontrado = producto;
            }
        }

        if (productoEncontrado == null) {
            System.out.println("Error: Ese producto no existe en el mercado.");
        }
        return productoEncontrado;

    }

    /**
     * Procesa la venta de un producto reduciendo su cantidad en stock.
     * 
     * <p>
     * Valida si la cantidad a vender es superior al stock disponible.
     * Si hay suficiente, actualiza el stock del producto.
     * </p>
     * 
     * @param producto       El objeto Producto que se va a vender.
     * @param cantidadVender La cantidad de unidades que el usuario desea comprar.
     */
    public void venderProducto(Producto producto, int cantidadVender) {
        int stockActual = producto.getCantidadStock();
        if (stockActual < cantidadVender) {
            System.out.println("No puedes vender tanta cantidad de ese producto, hay: " + stockActual);
        } else {
            int stockVenta = stockActual - cantidadVender;
            producto.setCantidadStock(stockVenta);
            System.out.println("Stock " + producto.getNombre() + ":" + stockVenta);
        }
    }

    /**
     * Genera productos de forma masiva con datos aleatorios utilizando la clase
     * FakerProductos.
     * 
     * @param cantidadGenerar El número de productos que se van a crear e insertar.
     * @return El ArrayList de productos actualizado con los nuevos elementos.
     */
    public ArrayList<Producto> productoAleatorio(int cantidadGenerar) {
        final int STOCKMIN = 0, STOCKMAX = 250;
        final double PRECIOMAX = 150.00, PRECIOMIN = 2.00;
        for (int i = 0; i < cantidadGenerar; i++) {
            Producto productonuevo = new Producto("", FakerProductos.nombreProducto(),
                    FakerProductos.descripcion(),
                    FakerProductos.precio(PRECIOMAX, PRECIOMIN),
                    FakerProductos.entero(STOCKMIN, STOCKMAX));
            supermercado.add(productonuevo);

        }

        return supermercado;

    }

}