/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.util;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mario
 */
public class UtilTabla extends DefaultTableCellRenderer {

    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderer1 = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderer2 = new DefaultTableCellRenderer();
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        cellRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        cellRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderer2.setHorizontalAlignment(SwingConstants.LEFT);
        jtable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer2);
        jtable.getColumnModel().getColumn(0).setCellRenderer(cellRenderer2);
        jtable.getColumnModel().getColumn(1).setCellRenderer(cellRenderer1);
        jtable.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        jtable.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
        jtable.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
        jtable.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);
//        jtable.getColumnModel().getColumn(8).setCellRenderer(cellRenderer);
//        jtable.getColumnModel().getColumn(9).setCellRenderer(cellRenderer);
        
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
}
