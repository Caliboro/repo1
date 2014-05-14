
package Classes;

import Classes.Acceso_A_Datos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Acceso_Productos extends Acceso_A_Datos{
    
private int Codigo_Producto;
private String Tipo_Producto;
private int Cantidad;
private double Precio;
private String Titulo;
private String Nombre_Banda;
private ResultSet RS;

    public Acceso_Productos(){
        Conectar();
    }

    public int getCodigo_Producto() {
        return Codigo_Producto;
    }
    public String getTipo_Producto() {
        return Tipo_Producto;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public double getPrecio() {
        return Precio;
    }
    public String getTitulo() {
        return Titulo;
    }
    public String getNombre_Banda() {
        return Nombre_Banda;
    }

    public void setCodigo_Producto(int Codigo_Producto) {
        this.Codigo_Producto = Codigo_Producto;
    }
    public void setTipo_Producto(String Tipo_Producto) {
        this.Tipo_Producto = Tipo_Producto;
    }
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    public void setNombre_Banda(String Nombre_Banda) {
        this.Nombre_Banda = Nombre_Banda;
    }
    
    public ResultSet RescatarDatos(){
        
        try{
        getStmt();
        RS = stmt.executeQuery("SELECT * FROM PRODUCTO");
        return RS;
        }
        catch(Exception ex){
        System.out.println(ex);
        return null;
        }
        
    }
    
   public ResultSet RescatarDatos_filtro(String banda){
        
        try{
        getStmt();
        RS = stmt.executeQuery("SELECT * FROM PRODUCTO WHERE NOMBRE_BANDA = '"+banda+"'");
        return RS;
        }
        catch(Exception ex){
        System.out.println(ex);
        return null;
        }
        
    }
    
}
