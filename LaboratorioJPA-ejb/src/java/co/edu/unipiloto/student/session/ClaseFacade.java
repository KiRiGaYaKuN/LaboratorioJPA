/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.entity.Clase;
import co.edu.unipiloto.student.entity.ClasePK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cristian-patino
 */
@Stateless
public class ClaseFacade extends AbstractFacade<Clase> implements ClaseFacadeLocal {

    @PersistenceContext(unitName = "LaboratorioJPA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClaseFacade() {
        super(Clase.class);
    }

    @Override
    public boolean insertarClase(int codigoEstudiante, int codigoCurso, int codigo, int nota) {
        ClasePK pk = new ClasePK(codigoEstudiante, codigoCurso);
        if(consultaClase(pk)!=null){
            return false;
        }else{
            Clase cl = new Clase(pk,codigo,nota);
            em.persist(cl);
            return true;
        }
    }

    @Override
    public Clase consultaClase(ClasePK pk) {
        return em.find(Clase.class, pk);
    }
    
}
