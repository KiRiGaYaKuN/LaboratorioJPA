/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian-patino
 */
@Entity
@Table(name = "CLASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByCodigoEstudiante", query = "SELECT c FROM Clase c WHERE c.clasePK.codigoEstudiante = :codigoEstudiante"),
    @NamedQuery(name = "Clase.findByCodigoCurso", query = "SELECT c FROM Clase c WHERE c.clasePK.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "Clase.findByCodigo", query = "SELECT c FROM Clase c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Clase.findByNota", query = "SELECT c FROM Clase c WHERE c.nota = :nota")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClasePK clasePK;
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "NOTA")
    private Integer nota;
    @JoinColumn(name = "CODIGO_CURSO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "CODIGO_ESTUDIANTE", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Clase() {
    }

    public Clase(ClasePK clasePK, int codigo, int nota) {
        this.clasePK = clasePK;
        this.codigo = codigo;
        this.nota = nota;
    }

    public Clase(int codigoEstudiante, int codigoCurso) {
        this.clasePK = new ClasePK(codigoEstudiante, codigoCurso);
    }    

    public ClasePK getClasePK() {
        return clasePK;
    }

    public void setClasePK(ClasePK clasePK) {
        this.clasePK = clasePK;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clasePK != null ? clasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.clasePK == null && other.clasePK != null) || (this.clasePK != null && !this.clasePK.equals(other.clasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.entity.Clase[ clasePK=" + clasePK + " ]";
    }
    
}
