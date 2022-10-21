/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingse
 */
@Entity
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByEstudianteId", query = "SELECT e FROM Estudiante e WHERE e.estudianteId = :estudianteId"),
    @NamedQuery(name = "Estudiante.findByFirstname", query = "SELECT e FROM Estudiante e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Estudiante.findByLastname", query = "SELECT e FROM Estudiante e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Estudiante.findByYearlevel", query = "SELECT e FROM Estudiante e WHERE e.yearlevel = :yearlevel")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTUDIANTE_ID")
    private Integer estudianteId;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "YEARLEVEL")
    private Integer yearlevel;

    public Estudiante() {
    }

    public Estudiante(Integer estudianteId, String firstname, String lastname, Integer yearlevel) {
        this.estudianteId = estudianteId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearlevel = yearlevel;
    }
    
    

    public Estudiante(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getYearlevel() {
        return yearlevel;
    }

    public void setYearlevel(Integer yearlevel) {
        this.yearlevel = yearlevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteId != null ? estudianteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudianteId == null && other.estudianteId != null) || (this.estudianteId != null && !this.estudianteId.equals(other.estudianteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entitys.Estudiante[ estudianteId=" + estudianteId + " ]";
    }
    
}
