/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.entities;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class CompraStock implements Comparable<CompraStock> {

    private Long id;
    private Date fecha;
    private Integer codigo;
    private String detalle;
    private Float cantidad;
    private Float impuesto;
    private Double gravado;
    private Double iva;

    public CompraStock() {
    }

    public CompraStock(Long id, Date fecha, Integer codigo, String detalle, Float cantidad, Float impuesto, Double gravado, Double iva) {
        this.id = id;
        this.fecha = fecha;
        this.codigo = codigo;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.impuesto = impuesto;
        this.gravado = gravado;
        this.iva = iva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    @Override
    public int compareTo(CompraStock o) {
        String a = this.getDetalle();
        String b = o.getDetalle();
        return a.compareTo(b);
    }

}
