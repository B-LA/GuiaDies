/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.edu.udb.www.entities.Generos;

/**
 *
 * @author neon
 */
public class GenerosModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public List<Generos> listarGeneros(){
        Session ses = factory.openSession();
        try{
            Query consulta = ses.createQuery("SELECT g FROM Generos g");
            List<Generos> lista = consulta.list();
            ses.close();
            return lista;
        }catch(Exception e){
            ses.close();
            return null;
        }
    }
    
}
