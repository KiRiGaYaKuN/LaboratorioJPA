/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.entity.Clase;
import co.edu.unipiloto.student.entity.ClasePK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian-patino
 */
@Local
public interface ClaseFacadeLocal {

    void create(Clase clase);

    void edit(Clase clase);

    void remove(Clase clase);

    Clase find(Object id);

    List<Clase> findAll();

    List<Clase> findRange(int[] range);

    int count();
    
    boolean insertarClase(int codigoEstudiante, int codigoCurso, int codigo, int nota);
    
    Clase consultaClase(ClasePK pk);
}
