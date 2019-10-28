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
import org.hibernate.Transaction;
import sv.edu.udb.www.entities.Autores;

/**
 *
 * @author criss
 */
public class AutoresModel {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public int insertarAutor(Autores autor){
        Session ses = factory.openSession();
        try{
            Transaction tran = ses.beginTransaction();
            ses.save(autor);
            tran.commit();
            ses.close();
            return 1;
        }catch(Exception e){
            System.out.println(e.getMessage());
            ses.close();
            return 0;
        }
    }
    
    public List<Autores> listarAutores(){
         Session ses = factory.openSession();
         try{
             Query consulta = ses.createQuery("SELECT e FROM Autores e");
             List<Autores> lista = consulta.list();
             ses.close();
             return lista;
         }catch(Exception e){
             ses.close();
             return null;
         }
    }
    
    public Autores obtenerAutor(String codigo){
        Session ses = factory.openSession();
        try{
            Autores autor = (Autores) ses.get(Autores.class,codigo);
            ses.close();
            return autor;
        }catch(Exception e){
            ses.close();
            return null;
        }
    }
    
    
    public int modificarAutor(Autores autor){
        Session ses = factory.openSession();
        try{
            Transaction tran = ses.beginTransaction();
            ses.update(autor);
            tran.commit();
            ses.close();
            return 1;
        }catch(Exception e){
            System.out.println(e.getMessage());
            ses.close();
            return 0;
        }
            
   }
    
    public int eliminarAutor(String id){
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try{
            Autores autor = (Autores) ses.get(Autores.class, id);
            if(autor !=null){
                Transaction tran = ses.beginTransaction();
                ses.delete(autor);
                tran.commit();
                filasAfectadas = 1;
            }
            ses.close();
            return filasAfectadas;
        }catch(Exception e){
            ses.close();
            return 0;
        }
    }
    
}
