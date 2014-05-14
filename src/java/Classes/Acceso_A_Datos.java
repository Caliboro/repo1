/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;
import java.sql.*;
/**
 *
 * @author roxana
 */
public class Acceso_A_Datos {
    
    protected Connection con;
    protected Statement stmt;
    private String ServerName="localhost";
    private String PortNumber="3306";
    private String DataBaseName="inv_RuinedPig";
    private String url="jdbc:mysql://localhost:3306/"+DataBaseName;
    private String UserName="root";
    private String Password="123";
    
    private String ErrString;
    
    public Acceso_A_Datos(){
    }

    private String getUrl() {
        return url;
    }
    
    public Connection Conectar(){
        con = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(getUrl(), UserName, Password);
        stmt = con.createStatement();
        System.out.println("conectado!!!!!! WIIIIIIIIII SOMOS FELISHES!!!!! todo esta cachilupi!! ");
        }
        catch(Exception ex){
        ErrString="Error mientras se conectaba a servidor";
        System.out.println(ErrString + " Detalles: " + ex);
        }
        return con;
    }
    
    public void Desconectar(){
        
        try{
        stmt.close();
        con.close();
        }
        catch(Exception ex){
        System.out.println(ex);
        }
        
    }

    public Statement getStmt() {
        return this.stmt;
    }
    
    public static void main (String args[]){
    Acceso_A_Datos AAD = new Acceso_A_Datos(); 
    AAD.Conectar();
    }
       
    
}
