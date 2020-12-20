
package com.mycompany.sistemdistribuido2020.principal;

import com.mycompany.sistemdistribuido2020.entidades.Producto;
import com.mycompany.sistemdistribuido2020.session.ProductoJpaController;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    public static void main(String[] args) {
        
        //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXIÓN 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        
        // LA CLASE CONTROLADORA RECIBE DE PARAMETRO UNA CADENA DE CONEXIÓN
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        //CREAMOS UN NUEVO PRODUCTO
        
        Producto p = new Producto();

        p.setCodigo(1);
        p.setNombre("Software ERP");
        Double d1 = 5000.99;
        BigDecimal db1 = BigDecimal.valueOf(d1);
        p.setPrecio(db1);
        p.setDetalle("Para la EPN");
        
        try {
            //Ejecutar metodo clase controladora
            pjc.create(p);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
