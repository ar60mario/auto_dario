/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.frame;

import ar.com.gmeventas.entities.Configuracion;
import ar.com.gmeventas.entities.ConfiguracionTop;
import ar.com.gmeventas.entities.Producto;
import ar.com.gmeventas.entities.ProductoTop;
import ar.com.gmeventas.main.MainFrame;
import ar.com.gmeventas.services.ConfiguracionService;
import ar.com.gmeventas.services.ConfiguracionTopService;
import ar.com.gmeventas.services.ProductoService;
import ar.com.gmeventas.services.ProductoTopService;
import ar.com.gmeventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class AbmProductosTopInactivosFrame extends javax.swing.JFrame {

    private List<ProductoTop> productos = null;
    private DecimalFormat df = new DecimalFormat("#0.00");
    /**
     * Creates new form AbmProductosTopFrame
     */
    public AbmProductosTopInactivosFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        modificarBtn.setVisible(false);
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        modificarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        activarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ABM PRODUCTOS UTILIZADOS ELIMINADOS");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden", "Código", "Detalle", "Activo", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(350);
        }

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        activarBtn.setText("Activar");
        activarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(activarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarBtn)
                    .addComponent(volverBtn)
                    .addComponent(activarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        modificar();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void activarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarBtnActionPerformed
        int row = tablaProductos.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN PRODUCTO PARA ACTIVAR");
            return;
        }
        ProductoTop p = productos.get(row);
        p.setActivo(true);
        int a = JOptionPane.showConfirmDialog(this, "CONFIRMA ACTIVAR PRODUCTO?", 
                "Atención", JOptionPane.YES_NO_OPTION);
        if(a==0){
            try {
                new ProductoTopService().updateProductoTop(p);
            } catch (Exception ex) {
                Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        UtilFrame.limpiarTabla(tablaProductos);
        llenarTabla();
    }//GEN-LAST:event_activarBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmProductosTopInactivosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        productos = null;
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Float pIva=0F;
        if (cfg!=null){
            pIva=cfg.getIva();
        }
        try {
            productos = new ProductoTopService().getAllProductoTopInactivos();
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (productos != null && !productos.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaProductos.getModel();
            for (ProductoTop p : productos) {
                Object ob[] = new Object[5];
                ob[0] = p.getOrden();
                ob[1] = p.getCodigo();
                Producto prd = null;
                try {
                    prd = new ProductoService().getProductoByCodigo(p.getCodigo());
                } catch (Exception ex) {
                    Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (prd != null) {
                    ob[2] = prd.getDetalle();
                    ob[4] = df.format((prd.getPrecio() + prd.getImpuesto())*(1+pIva/100));
                }
                if (p.getActivo()) {
                    ob[3] = "Activo";
                } else {
                    ob[3] = "Inactivo";
                }
                tbl.addRow(ob);
            }
            tablaProductos.setModel(tbl);
        }
    }

    private void modificar() {
        int row = tablaProductos.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar que producto modificar");
            return;
        }
        ProductoTop p = productos.get(row);
        ModificarProductoTopFrame mptf = new ModificarProductoTopFrame(p);
        mptf.setVisible(true);
        this.dispose();
    }

    private void volver() {
        int o = 0;
        for (ProductoTop p : productos) {
            p.setOrden(o);
            o += 1;
            try {
                new ProductoTopService().updateProductoTop(p);
            } catch (Exception ex) {
                Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ConfiguracionTop cf = null;
        try {
            cf = new ConfiguracionTopService().getConfigTopById(1);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cf.setOrderMaximo(o);
        try {
            new ConfiguracionTopService().updateConfigTop(cf);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopInactivosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }
}
