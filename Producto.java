public class Producto {
    private String Nombre;
    private double Precio;
    private int Stock;
    // Asignamos valores al producto y asignamos constructores
    public Producto(String nombre, double precio, int stock) 
    {   //Constructores
        this.Nombre = nombre;
        this.Precio = precio;
        this.Stock = stock;
    }
    // Agregamos el metodo get para devolver el nombre, precio y stock
    public String getNombre() 
    {
        return Nombre;
    }

    public double getPrecio() 
    {
        return Precio;
    }

    public int getStock() 
    {
        return Stock;
    }

    public void DisminuirStock(int Cantidad) 
    {   // Si la cantidad es menor o igual al stock, se disminuye el stock
        if (Cantidad <= Stock) 
        {
            Stock -= Cantidad;
        } 
        else // Si no, se muestra un mensaje de error
        {
            System.out.println("Stock insuficiente para el producto: " + Nombre);
        }
    }

    @Override
    public String toString() 
    {
        return "Producto: " + Nombre + ", Precio: S/ " + Precio + " - Stock: " + Stock;
    }
}
