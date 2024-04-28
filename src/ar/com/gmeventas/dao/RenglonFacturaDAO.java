/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.IvaVentas;
import ar.com.gmeventas.entities.RenglonFactura;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class RenglonFacturaDAO extends GenericDAO{
    
    
    public List<RenglonFactura> getRenglonFacturaFromIvaVentas(IvaVentas idIva) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<RenglonFactura> renglones = null;
        StringBuffer sb = new StringBuffer();
        sb.append("from RenglonFactura rf ");
        sb.append("where rf.ivaVentas = :idIva ");
//        sb.append("and rf.fechaPeriodo = :anio ");
//        sb.append("order by ic.fechaPeriodo asc");
        
        Query query = session.createQuery(sb.toString());
        query.setParameter("idIva",  idIva );
//        query.setParameter("anio", anio);
        
        renglones = (List<RenglonFactura>) query.list();
                
        return renglones;
    }
    
    public List<RenglonFactura> getRenglonesActivosEntreFechas(Date d1, Date d2) {
        List<RenglonFactura> rfc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFactura.class);
        Criteria criteria1 = criteria.createCriteria("ivaVentas");
        criteria1.add(Restrictions.between("fecha", d1, d2));
//        criteria.add(Restrictions.eq("anulado", false));
        rfc = criteria.list();
        return rfc;
    }
}
