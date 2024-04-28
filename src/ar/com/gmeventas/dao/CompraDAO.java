/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.Compra;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.Date;
//import org.hibernate.classic.Session;
import org.hibernate.Session;
import org.hibernate.Criteria;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CompraDAO extends GenericDAO{

    public List<Compra> getAllCompraOrdenado() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Compra.class);
        criteria.addOrder(Order.asc("fecha"));
        return (List<Compra>) criteria.list();
    }
    
    public List<Compra> getCompraPorComprobante(String nro) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Compra.class);
        criteria.add(Restrictions.eq("comprobante", nro));
        criteria.addOrder(Order.asc("fecha"));
        return (List<Compra>) criteria.list();
    }
    
    public List<Compra> getComprasEntreFechas(Date de, Date al) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Compra.class);
        criteria.add(Restrictions.between("fecha", de, al));
        return (List<Compra>) criteria.list();
    }
}
