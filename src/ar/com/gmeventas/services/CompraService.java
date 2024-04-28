package ar.com.gmeventas.services;

import ar.com.gmeventas.bo.CompraBO;
import ar.com.gmeventas.entities.Compra;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompraService {
    
    public void deleteCompra(Compra cliente) throws Exception{
       Session session = HibernateUtils.getSessionFactory().getCurrentSession();
       Transaction tx = session.beginTransaction();
       try{
          new CompraBO().deleteCliente(cliente);
          tx.commit();
       }
       catch(Exception ex){
           tx.rollback();
           throw new Exception (ex);
       }
    }

    public void saveCompra(Compra compra) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CompraBO().saveCompra(compra);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<Compra> getAllCompras() throws Exception {
        List<Compra> compras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            compras = new CompraBO().getAllCompra();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return compras;
    }

    public void updateCompra(Compra compra) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CompraBO().updateCompra(compra);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Compra> getCompraOrdenado() throws Exception{
        List<Compra> compras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            compras = new CompraBO().getComprasOrdenado();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return compras;
    }
    
    public List<Compra> getCompraPorComprobante(String nro) throws Exception{
        List<Compra> compras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            compras = new CompraBO().getCompraPorComprobante(nro);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return compras;
    }
    
    public List<Compra> getComprasEntreFechas(Date de, Date al) throws Exception {
        List<Compra> compras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            compras = new CompraBO().getComprasEntreFechas(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return compras;
    }
}
