 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import controlador.Conexion;
import java.sql.PreparedStatement;
import java.time.Clock;
import java.util.*;
/**
 *
 * @author Hogar
 */
public class Validar extends Conexion {
    
  
     public boolean validarTipo(String usuario,String contraseña) {
		
         PreparedStatement pst = null;
         ResultSet rs = null;
         
         
         try {
                String sql = "SELECT * FROM usuario WHERE usuarios = ? and contraseña= ? " ;
                pst=getConexion().prepareStatement(sql);
                pst.setString(1, usuario);
                pst.setString(2, contraseña);
                rs=pst.executeQuery();
                
                if (rs.absolute(1)) {
                 return true;
             }
                
         } catch (Exception e) {
             
             System.err.println(" error "+ e);
         }finally{
             try {
                 if (getConexion()!=null)getConexion().close(); {
                 if (pst!=null) pst.close();{
                 if (rs!=null)rs.close(); {
                     
                 }
    
                 }
             }
             } catch (Exception e) {
             }
             
         }
         return false;
       
     
     } 
     
    public boolean REGISTRARUSU(String nombre,String apellido,String correo,String telefono,String usuarios,String contraseña) {
        
    PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuario VALUES(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, correo);
                ps.setString(4, telefono);
                ps.setString(5, usuarios);
                ps.setString(6, contraseña);
            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
 
           }
        }
     }

   
    public static void main(String[] args) {
        Validar va =new Validar();
        Scanner sc =new Scanner(System.in);
        String nombre;
        String apellido;
        String correo;
        String telefono ;
        String usuario;
        String contraseña;
        System.out.println(" in nombre");
        nombre=sc.nextLine();
        System.out.println(" in apellido");
        apellido=sc.nextLine();
        System.out.println(" in correo");
        correo=sc.nextLine();
        System.out.println(" in telefono");
        telefono=sc.nextLine();
        System.out.println(" in usu");
        usuario=sc.nextLine();
        System.out.println(" in contaseña");
        contraseña=sc.nextLine();
        if (va.REGISTRARUSU(nombre, apellido, correo, telefono, usuario, contraseña)) {
            
            System.out.println("registrado");
        }
        
    }
   
}

