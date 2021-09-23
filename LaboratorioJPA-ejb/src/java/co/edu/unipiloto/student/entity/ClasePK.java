/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cristian-patino
 */
@Embeddable
public class ClasePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESTUDIANTE")
    private int codigoEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CURSO")
    private int codigoCurso;

    public ClasePK() {
    }

    public ClasePK(int codigoEstudiante, int codigoCurso) {
        this.codigoEstudiante = codigoEstudiante;
        this.codigoCurso = codigoCurso;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEstudiante;
        hash += (int) codigoCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasePK)) {
            return false;
        }
        ClasePK other = (ClasePK) object;
        if (this.codigoEstudiante != other.codigoEstudiante) {
            return false;
        }
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.entity.ClasePK[ codigoEstudiante=" + codigoEstudiante + ", codigoCurso=" + codigoCurso + " ]";
    }
    
}
