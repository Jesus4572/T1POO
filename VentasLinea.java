import java.util.ArrayList; //Nos permite usar listas 
import java.util.Scanner;//Nos permite leer entradas del usuario

public class VentasLinea 
{
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static ArrayList<Venta> listaVentas = new ArrayList<>();
    
    public static void main(String[] args) 
    {
         // Se agregan los productos a la lista
        listaProductos.add(new Producto("Laptop", 2500.0, 10));
        listaProductos.add(new Producto("Mouse", 25.0, 50));
        listaProductos.add(new Producto("Camara", 80.0, 30));
        listaProductos.add(new Producto("Audifonos", 30.0, 30));
        listaProductos.add(new Producto("Teclado", 45.0, 30));
        listaProductos.add(new Producto("Monitor", 450.0, 20));
        listaProductos.add(new Producto("Impresora", 1045.0, 10));
        listaProductos.add(new Producto("CPU", 500.0, 30));


        Scanner sc = new Scanner(System.in);
        int opcion;
        //El do While se repite hasta el usuario elija la opcion para salir
        do {
            // Menú principal
            System.out.println("\n====== SISTEMA DE VENTAS EN LÍNEA ======");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Realizar compra");
            System.out.println("3. Mostrar historial de ventas");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    realizarCompra(sc);
                    break;
                case 3:
                    mostrarHistorialVentas();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarProductos() 
    {
        System.out.println("\n------ LISTA DE PRODUCTOS ------");
        for (int i = 0; i < listaProductos.size(); i++) 
        {
            System.out.println(i + ". " + listaProductos.get(i));
        }
    }

    public static void realizarCompra(Scanner sc) 
    {
        mostrarProductos();
        System.out.print("\nIngrese el número del producto a comprar: ");
        int indice = sc.nextInt();
        // Validamos que el indice exista en la lista
        if (indice < 0 || indice >= listaProductos.size()) 
        {
            System.out.println("Producto no válido.");
            return;
        }

        Producto p = listaProductos.get(indice);
        System.out.print("Ingrese cantidad a comprar: ");
        int Cantidad = sc.nextInt();
        //Si no hay stock suficiente no se puede realizar la compra
        if (Cantidad > p.getStock()) {
        System.out.println(" ----No hay stock suficiente.---");
        return;
        }
        else //Si hay stock suficiente se realiza la compra
        {
            System.out.println(" ---Stock disponible.---");
            p.DisminuirStock(Cantidad);

            // Calculamos el total
            double Total = Cantidad * p.getPrecio();

            // Registramos la venta
            listaVentas.add(new Venta(p.getNombre(), Cantidad, Total));
            System.out.println("Compra realizada con éxito. Total: S/. " + Total);
        }
    }

    public static void mostrarHistorialVentas() 
    {
        System.out.println("\n------ HISTORIAL DE VENTAS ------");
        for (Venta v : listaVentas) // Recorremos la lista de ventas y las mostramos
        {
            System.out.println(v);
        }
    }
}
    

