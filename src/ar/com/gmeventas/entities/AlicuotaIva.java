/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.entities;

/**
 *
 * @author Mario
 */
public class AlicuotaIva {
    private Long id;
    private Integer codigo;
    private Float alicuota;

    public AlicuotaIva() {
    }

    public AlicuotaIva(Long id, Integer codigo, Float alicuota) {
        this.id = id;
        this.codigo = codigo;
        this.alicuota = alicuota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Float getAlicuota() {
        return alicuota;
    }

    public void setAlicuota(Float alicuota) {
        this.alicuota = alicuota;
    }
    
    
}
