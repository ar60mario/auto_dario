/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.frame;

import ar.com.gmeventas.entities.AlicuotaIva;
import ar.com.gmeventas.entities.Cliente;
import ar.com.gmeventas.entities.Configuracion;
import ar.com.gmeventas.entities.ConfiguracionTop;
import ar.com.gmeventas.entities.Domicilio;
import ar.com.gmeventas.entities.TicketTime;
import ar.com.gmeventas.main.MainFrame;
import ar.com.gmeventas.services.AlicuotaIvaService;
import ar.com.gmeventas.services.ClienteService;
import ar.com.gmeventas.services.ConfiguracionService;
import ar.com.gmeventas.services.ConfiguracionTopService;
import ar.com.gmeventas.services.TicketTimeService;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class ModificarConfiguracionTopFrame extends javax.swing.JFrame {

    private DecimalFormat df = new DecimalFormat("#0.00");
    private ConfiguracionTop ct = null;

    /**
     * Creates new form ModificarConfiguracionTopFrame
     */
    public ModificarConfiguracionTopFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        mostrarMaximo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        maximoTxt = new javax.swing.JTextField();
        grabarBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CONFIGURACION");

        jLabel1.setText("Importe Máximo de Factura:");

        maximoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        maximoTxt.setText("IMPORTE CIG");

        grabarBtn.setText("Grabar");
        grabarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(grabarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(maximoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maximoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grabarBtn)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grabarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarBtnActionPerformed
        grabar();
    }//GEN-LAST:event_grabarBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        volver();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarConfiguracionTopFrame().setVisible(true);
            }
        });
    }

    private void mostrarMaximo() {
        ct = null;
        int c = 0;
        try {
            ct = new ConfiguracionTopService().getConfigTopById(1);
        } catch (Exception ex) {
//            Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "ERROR LEYENDO LOS DATOS Nro.158");
            c = 1;
        }
        if (ct == null) {
            ConfiguracionTop cf = new ConfiguracionTop();
            cf.setId(1);
            cf.setImporteMaximo(1D);
            cf.setImporteMaximoPanificados(0D);
            cf.setOrderMaximo(1);
            try {
                new ConfiguracionTopService().saveConfigTop(cf);
            } catch (Exception ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ROORO GUARDANDO CONFIGURACION Nro.169");
            }
            c = 1;
        }
        if (c == 1) {
            Configuracion cf = new Configuracion();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_u;
            try {
                fecha_u = sdf.parse("01/01/2022");
            } catch (ParseException ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR FECHA NO SOPORTADA Nro. 180");
                return;
            }
            cf.setId(1L);
            cf.setIva(21F);
            cf.setIvaPan(0F);
            cf.setNumeroFacturaA(0);
            cf.setNumeroFacturaB(0);
            cf.setNumeroPedido(0);
            cf.setNumeroRecibo(0);
            cf.setNumeroRemito(0);
            cf.setSucursalA(0);
            cf.setSucursalB(2);
            cf.setUltimaFecha(fecha_u);
            cf.setUltimaFechaPanificados(fecha_u);
            try {
                new ConfiguracionService().saveConfiguracion(cf);
            } catch (Exception ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR GRABANDO CONFIGURACION Nro.199");
                return;
            }
            AlicuotaIva ai = new AlicuotaIva();
            ai.setAlicuota(0F);
            ai.setCodigo(3);
            try {
                new AlicuotaIvaService().saveAlicuotaIva(ai);
            } catch (Exception ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR GRABANDO CONFIGURACION Nro.214");
                return;
            }
            ai.setAlicuota(10.5F);
            ai.setCodigo(4);
            try {
                new AlicuotaIvaService().saveAlicuotaIva(ai);
            } catch (Exception ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR GRABANDO CONFIGURACION Nro.222");
            }
            ai.setAlicuota(21F);
            ai.setCodigo(5);
            try {
                new AlicuotaIvaService().saveAlicuotaIva(ai);
            } catch (Exception ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR GRABANDO CONFIGURACION Nro.230");
            }
            ai.setAlicuota(27F);
            ai.setCodigo(6);
            try {
                new AlicuotaIvaService().saveAlicuotaIva(ai);
            } catch (Exception ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR GRABANDO CONFIGURACION Nro.238");
            }
            Cliente cl = new Cliente();
            cl.setActivo(true);
            cl.setCategoriaDeIva(99);
            cl.setCodigo("1");
            cl.setCuit("00-00000000-0");
            cl.setDescuento(0F);
            Domicilio dm = new Domicilio();
            dm.setCalle("MIGUEL CANE");
            dm.setNumero("3104");
            dm.setPiso("");
            dm.setDepartamento("");
            dm.setLocalidad("SAN FERNANDO");
            dm.setProvincia("BUENOS AIRES");
            cl.setDomicilio(dm);
            try {
                new ClienteService().saveCliente(cl);
            } catch (Exception ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            TicketTime tt = new TicketTime();
            tt.setFecha(fecha_u);
            tt.setHora(1);
            tt.setMinuto(1);
            tt.setSegundo(1);
            tt.setSign("");
            tt.setToken("");
            try {
                new TicketTimeService().updateTicket(tt);
            } catch (Exception ex) {
                Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(this, "CONFIGURACION CREADA CORRECTAMENTE - INGRESE NUEVAMENTE");
            System.exit(0);
        }
        maximoTxt.setText(df.format(ct.getImporteMaximo()));
        if (ct.getImporteMaximoPanificados() != null) {
//        maximoPanTxt.setText(df.format(ct.getImporteMaximoPanificados()));
        } else {
//            maximoPanTxt.setText("0,00");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton grabarBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField maximoTxt;
    // End of variables declaration//GEN-END:variables

    private void grabar() {
        Double importe = Double.valueOf(maximoTxt.getText().replace(",", "."));
//        Double importe2 = Double.valueOf(maximoPanTxt.getText().replace(",", "."));
        ct.setImporteMaximo(importe);
//        ct.setImporteMaximoPanificados(importe2);
        try {
            new ConfiguracionTopService().updateConfigTop(ct);
            JOptionPane.showMessageDialog(this, "IMPORTES ACTUALIZADOS");
            volver();
        } catch (Exception ex) {
            Logger.getLogger(ModificarConfiguracionTopFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }
}
