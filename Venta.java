import java.time.LocalDateTime;//Nos permite trabajar con fechas y horas exactas

public class Venta 
{
    private String Producto;
    private int Cantidad;
    private double Total;
    private LocalDateTime FechaVenta;

    public Venta(String producto, int cantidad, double total) 
    {
        this.Producto = producto;
        this.Cantidad = cantidad;
        this.Total = total;
        this.FechaVenta = LocalDateTime.now();//Registra la fecha y hora actual
    }

    @Override
    public String toString() 
    {
        return "Venta de " + Cantidad + "x " 
        + Producto + " por un total de S/. " 
        + Total + " realizada el " 
        + FechaVenta;           
    }
}
