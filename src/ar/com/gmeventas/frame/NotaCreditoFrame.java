/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.frame;

import ar.com.gmeventas.entities.Cliente;
import ar.com.gmeventas.entities.Configuracion;
import ar.com.gmeventas.entities.IvaVentas;
import ar.com.gmeventas.entities.Producto;
import ar.com.gmeventas.entities.RenglonFactura;
import ar.com.gmeventas.entities.TicketTime;
import ar.com.gmeventas.main.MainFrame;
import ar.com.gmeventas.services.ConfiguracionService;
import ar.com.gmeventas.services.IvaVentasService;
import ar.com.gmeventas.services.ProductoService;
import ar.com.gmeventas.services.RenglonFacturaService;
import ar.com.gmeventas.services.TicketTimeService;
import ar.com.gmeventas.util.UtilFrame;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.rint;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class NotaCreditoFrame extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("#0.00");
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final Integer puntoVta = 5;
    private IvaVentas iv;
    private Date ultimaFechaNc;
    private Date fecha = new Date();
    private ActiveXComponent wsaa = new ActiveXComponent("WSAA");
    private String wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
    private String userdir = "c:/ventasDA/crt";
    private TicketTime tkt;
    private String token;
    private String sign;
    private String tipoComprob;
    private Integer comprobanteNumero = 0;
    private int hora = 0;
    private int minutos = 0;
    private int segundos = 0;
    private int tst = 0; // 1 es test

    /**
     * Creates new form NotaCreditoFrame
     */
    public NotaCreditoFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        limpiarCampos();
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
        numeroFacturaTxt = new javax.swing.JTextField();
        totalTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        confirmaBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fechaNcTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GENERAR NOTA DE CREDITO");

        jLabel1.setText("NUMERO FACTURA:");

        numeroFacturaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numeroFacturaTxt.setText("NUMERO");
        numeroFacturaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroFacturaTxtKeyPressed(evt);
            }
        });

        totalTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalTxt.setText("IMPORTE");

        jLabel2.setText("FECHA:");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");

        jLabel3.setText("TOTAL:");

        confirmaBtn.setText("CONFIRMAR");
        confirmaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("FECHA DE LA NOTA DE CREDITO:");

        fechaNcTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaNcTxt.setText("FECHA NC");
        fechaNcTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaNcTxtKeyPressed(evt);
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
                        .addComponent(confirmaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numeroFacturaTxt)
                                    .addComponent(totalTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(fechaTxt, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(fechaNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numeroFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fechaNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmaBtn)
                    .addComponent(volverBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numeroFacturaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroFacturaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            llenarFrame();
        }
    }//GEN-LAST:event_numeroFacturaTxtKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void confirmaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaBtnActionPerformed
        confirma();
    }//GEN-LAST:event_confirmaBtnActionPerformed

    private void fechaNcTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaNcTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaNcTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                JOptionPane.showMessageDialog(this, "CONFIRME LA NOTA DE CREDITO\n    CON EL BOTON DE ABAJO");
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaNcTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaNcTxtKeyPressed

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
            java.util.logging.Logger.getLogger(NotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotaCreditoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmaBtn;
    private javax.swing.JTextField fechaNcTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField numeroFacturaTxt;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarFrame() {
        if (!numeroFacturaTxt.getText().isEmpty()) {
            Integer num = Integer.valueOf(numeroFacturaTxt.getText());
            try {
                iv = new IvaVentasService().getFacturaByNumero("B", puntoVta, num);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (iv != null) {
                fechaTxt.setText(sdf.format(iv.getFecha()));
                totalTxt.setText(df.format(iv.getTotal()));
            }
            fechaNcTxt.requestFocus();
        }
    }

    private void limpiarCampos() {
        totalTxt.setText("");
        totalTxt.setEditable(false);
        fechaTxt.setText("");
        fechaTxt.setEditable(false);
        numeroFacturaTxt.setText("");
        fechaNcTxt.setText("");
        numeroFacturaTxt.requestFocus();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void confirma() {
        Configuracion config = null;
        try {
            config = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        int numf;
        if (config.getNumeroNotaCreditoB() != null) {
            numf = config.getNumeroNotaCreditoB();
        } else {
            numf = 0;
        }
        Cliente cli = iv.getCliente();
//        List<Factura> fact = null;
//        try {
//            fact = new FcService().getAllFacturasActivas();
//        } catch (Exception ex) {
//            Logger.getLogger(FacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (fact != null && !fact.isEmpty()) {
//            for (Factura f : fact) {
        Long caeLong = 0L;
        Date caeVencim = new Date();
        List<RenglonFactura> renglo2 = null;
        String letra = "B";
        try {
            renglo2 = new RenglonFacturaService().getAllRenglonFacturaFromIvaVentas(iv);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        int tim = 0;
        Date fws = new Date();
        try {
            fws = sdf.parse(fechaNcTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        ultimaFechaNc = fws;
        if (tst == 0) {
            // asignar cae AFIP

            try {
                LibraryLoader.loadJacobLibrary();
                wsaa = new ActiveXComponent("WSAA");
                System.out.println(Dispatch.get(wsaa, "InstallDir").toString()
                        + " "
                        + Dispatch.get(wsaa, "Version").toString()
                );
                Calendar cal = Calendar.getInstance();
                fecha = cal.getTime();
                hora = cal.get(Calendar.HOUR_OF_DAY);
                minutos = cal.get(Calendar.MINUTE);
                segundos = cal.get(Calendar.SECOND);
                tkt = new TicketTimeService().getTicketById(1L);
                if (fecha != tkt.getFecha()) {
                    solicitarNuevoTicket();
                } else if (hora != tkt.getHora()) {
                    if (hora == tkt.getHora() + 1) {
                        if (minutos > tkt.getMinuto()) {
                            solicitarNuevoTicket();
                        } else {
                            int xMinuto = 60 - tkt.getMinuto();
                            if ((xMinuto + minutos) > 30) {
                                solicitarNuevoTicket();
                            }
                        }
                    } else {
                        solicitarNuevoTicket();
                    }
                } else if (minutos - tkt.getMinuto() > 30) {
                    solicitarNuevoTicket();
                }
                ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
                Dispatch.put(wsfev1, "Cuit", new Variant("20249273253"));
                Dispatch.put(wsfev1, "Token", new Variant(token));
                Dispatch.put(wsfev1, "Sign", new Variant(sign));
                String cache = "";
                wsdl = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL";
                Dispatch.call(wsfev1, "Conectar",
                        new Variant(cache),
                        new Variant(wsdl)
                );
                String tipo_cbte = "8";
                tipoComprob = tipo_cbte;
                String pto_vta = String.valueOf(puntoVta); // Sucursal declarada WS
                String sucursalFacturaPapel = "000" + pto_vta;
                Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                        new Variant(tipo_cbte),
                        new Variant(pto_vta));
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//                        System.out.println(wsfev1);
//                        //JOptionPane.showMessageDialog(this, "Ult.Comprb." + ult.toString());
//                        System.out.println("Ult.Comprb." + ult.toString());
                numf = Integer.valueOf(ult.toString());
                comprobanteNumero = Integer.parseInt(ult.toString());
                if (numf != comprobanteNumero) {
                    JOptionPane.showMessageDialog(this, "No coinciden los numeros");
                    return;
                }
//                        System.out.println(numf);
//                        System.exit(0);
                String fechaWs = new SimpleDateFormat("yyyyMMdd").format(fws);
                String concepto = "1";// producto 
//                String cui = cli.getCuit();
                String cuit1 = "0"; //cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
                String tipoD = String.valueOf(cli.getTipo());
                String tipo_doc = tipoD, nro_doc = cuit1; //tipo y numero
                int cbte_nro = Integer.parseInt(ult.toString()) + 1,
                        cbt_desde = cbte_nro,
                        cbt_hasta = cbte_nro;
                String numeroFacturaPapel = String.valueOf(cbte_nro);
                numf = cbte_nro;
                comprobanteNumero = cbte_nro;
                int largo = ("00000000" + numeroFacturaPapel).length();
                numeroFacturaPapel = ("00000000" + numeroFacturaPapel).substring(largo - 8, largo);
                Double importeAbono = iv.getTotal(); //100.50
                String imp_total = df.format(importeAbono).toString().replaceAll("\\,", "\\.");//"124.00";
                String imp_tot_conc = "0.00";
                String imp_neto = df.format(iv.getGravado()).toString().replaceAll("\\,", "\\.");
                String imp_iva = df.format(iv.getIva()).toString().replaceAll("\\,", "\\.");
                int internos = (int) rint(iv.getImpuesto() * 100);
                String imp_trib = "", imp_op_ex = "0";
                if (internos > 0) {
                    imp_trib = df.format(iv.getImpuesto()).toString().replaceAll("\\,", "\\.");
                } else {
                    imp_trib = "0.00";
                }
                System.out.println("");
                String fecha_cbte = fechaWs, fecha_venc_pago = "";
                String fecha_serv_desde = "", fecha_serv_hasta = "";
                String moneda_id = "PES", moneda_ctz = "1.000";

                int xxx = 1;
                if (xxx != 0) {
                    Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                            new Variant(concepto), new Variant(tipo_doc),
                            new Variant(nro_doc), new Variant(tipo_cbte),
                            new Variant(pto_vta),
                            new Variant(cbt_desde), new Variant(cbt_hasta),
                            new Variant(imp_total), new Variant(imp_tot_conc),
                            new Variant(imp_neto), new Variant(imp_iva),
                            new Variant(imp_trib), new Variant(imp_op_ex),
                            new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                            new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                            new Variant(moneda_id), new Variant(moneda_ctz));

                    Variant cbte_asoc_tipo = new Variant(iv.getTipoDoc()),
                            cbte_asoc_pto_vta = new Variant(puntoVta),
                            cbte_asoc_nro = new Variant(iv.getNumeroFactura().toString());
                    Dispatch.call(wsfev1, "AgregarCmpAsoc",
                            cbte_asoc_tipo, cbte_asoc_pto_vta, cbte_asoc_nro);
//                }

                    if (internos > 0) {
                        // 99 es otros impuestos "Otros Impuestos"
                        // 04 impuestos internos "Impuestos Internos"
                        Variant tributo_id = new Variant(04),
                                tributo_desc = new Variant("Impuestos Internos"),
                                tributo_base_imp = new Variant("0.00"),
                                tributo_alic = new Variant("0.00"),
                                tributo_importe = new Variant(imp_trib);
                        Dispatch.call(wsfev1, "AgregarTributo",
                                tributo_id, tributo_desc, tributo_base_imp,
                                tributo_alic, tributo_importe);
                    }
                    Variant iva_id = new Variant(5),
                            iva_base_imp = new Variant(imp_neto),
                            iva_importe = new Variant(imp_iva);
                    Dispatch.call(wsfev1, "AgregarIva",
                            iva_id, iva_base_imp, iva_importe);
                    Dispatch.put(wsfev1, "Reprocesar", new Variant(false));
                    Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                    String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                    String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                    excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                    String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                    String obs = Dispatch.get(wsfev1, "Obs").toString();
                    String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                    //caeVencim = sd.parse(vto);
                    String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                    if (!resultado.equals("A")) {
                        JOptionPane.showMessageDialog(this, "Obs: " + obs + "\nError: " + errmsg);
                        return;
                    }
                    if (vto != "" && vto != null) {
                        caeVencim = sd.parse(vto);
                        String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                    }
                    caeLong = Long.valueOf(cae.toString());
                    String ruta1 = "c:/ventasDA/cmprbt/" + tipoComprob //cmprbt
                            + "B" + sucursalFacturaPapel
                            + numeroFacturaPapel + ".xm1";
                    String ruta2 = "c:/ventasDA/cmprbt/" + tipoComprob
                            + "B" + sucursalFacturaPapel
                            + numeroFacturaPapel + ".xm2";
                    File archivo1 = new File(ruta1);
                    File archivo2 = new File(ruta2);
                    BufferedWriter bw1, bw2;
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
//                        e.printStackTrace();
                return;
            }
        }
        // FIN ASIGNAR CAE AFIP
        IvaVentas iv2 = new IvaVentas();
        iv2.setCae(caeLong);
        iv2.setCliente(iv.getCliente());
        iv2.setDescuentoGlobal(0.0);
        iv2.setExento(0.0);
        iv2.setFecha(fws);
        iv2.setFechaCae(caeVencim);
        iv2.setGravado(iv.getGravado());
        iv2.setGravado0(0.0);
        iv2.setGravado10_5(0.0);
        iv2.setGravado27(0.0);
        iv2.setImpuesto(iv.getImpuesto());
        iv2.setIva(iv.getIva());
        iv2.setIva0(0.0);
        iv2.setIva10_5(0.0);
        iv2.setIva27(0.0);
        iv2.setLetra(letra);
        iv2.setLetraReferencia("B");
        iv2.setNoGravado(0.0);
        //numf += 1;
        iv2.setNumeroFactura(numf);
        iv2.setTipoDoc(8);
        iv2.setNumeroFacturaReferencia(iv.getNumeroFactura());
        iv2.setNumeroSucursal(5);
        iv2.setNumeroSucursalReferencia(5);
        iv2.setTotal(iv.getTotal());
        try {
            iv2 = new IvaVentasService().saveIvaVentas(iv2);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        config.setNumeroNotaCreditoB(numf);
        config.setUltimaFecha(ultimaFechaNc);
        try {
            new ConfiguracionService().updateConfiguracion(config);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        int nu = 0;
        for (RenglonFactura r : renglo2) {
            nu += 1;
            RenglonFactura rf = new RenglonFactura();
            rf.setCantidad(r.getCantidad());
            rf.setDescripcion(r.getProducto().getDetalle());
            rf.setDescuento(0.0);
            rf.setExento(0.0);
            rf.setGravado(r.getGravado());
            rf.setGravado0(0.0);
            rf.setGravado10_5(0.0);
            rf.setGravado27(0.0);
            rf.setImpuesto(r.getImpuesto());
            rf.setItemNro(nu);
            rf.setIva(r.getIva());
            rf.setIva0(0.0);
            rf.setIva27(0.0);
            rf.setIva10_5(0.0);
            rf.setIvaVentas(iv2);
            rf.setNoGravado(0.0);
            rf.setProducto(r.getProducto());
            rf.setSugerido(r.getSugerido());
            rf.setTotal(r.getTotal());
            if (r.getCostoG() != null) {
                rf.setCostoG(r.getCostoG());
            } else {
                rf.setCostoG(0.0);
            }
            if (r.getCostoI() != null) {
                rf.setCostoI(r.getCostoI());
            } else {
                rf.setCostoI(0.0);
            }
            try {
                new RenglonFacturaService().saveRenglon(rf);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
//                    config.setNumeroFacturaB(numf);
//                    config.setUltimaFecha(ultimaFechaFc);
//                    try {
//                        new ConfiguracionService().updateConfiguracion(config);
//                    } catch (Exception ex) {
//                        Logger.getLogger(FacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
//                    }
            Producto pro1 = r.getProducto();
            Float fl = pro1.getStock();
            fl += r.getCantidad();
            pro1.setStock(fl);
            try {
                new ProductoService().updateProducto(pro1);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(this, "NOTA DE CREDITO GENERADA CORRECTAMENTE");
        limpiarCampos();
    }

    private void solicitarNuevoTicket() {
        wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
        System.out.println("autenticar");
        Dispatch.call(wsaa, "Autenticar",
                new Variant("wsfe"),
                new Variant(userdir + "/dario2023_290f8f532bf779a9.crt"),
                new Variant(userdir + "/clave_privada_20249273253_202305142338.key"),
//                new Variant("c:/ventasF/crt/fernando2023_3c09a0deb45cc8fa.crt"),
//                new Variant("c:/ventasF/crt/clave_privada_20250844922_202304144101.key"),
                new Variant(wsdl));
        System.out.println("autenticado");
        String excepcion = Dispatch.get(wsaa, "Excepcion").toString();
        token = Dispatch.get(wsaa, "Token").toString();
        sign = Dispatch.get(wsaa, "Sign").toString();
        System.out.println(token);
        System.out.println(sign);
//        System.exit(0);
        tkt.setFecha(fecha);
        tkt.setHora(hora);
        tkt.setMinuto(minutos);
        tkt.setSegundo(segundos);
        try {
            new TicketTimeService().updateTicket(tkt);
        } catch (Exception ex) {
            Logger.getLogger(FacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo guardar nuevo Ticket");
        }
    }
}