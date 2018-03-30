/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author alexf
 */
public abstract class GenericAbstract<T> implements GenericDAO<T>{

    
    Class<T> entityM;

    public GenericAbstract(Class<T> entityM) {
        this.entityM = entityM;
    }
    
    
    protected abstract EntityManager getEM();
    
    
    
    
    @Override
    public List<T> getAll() {
       
        CriteriaQuery cq = getEM().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityM));
        List<T> lista=getEM().createQuery(cq).getResultList();
        
        getEM().clear();
        
        return lista;
        
    }

    @Override
    public void create(T t) {
        
        try{
        getEM().getTransaction().begin();
        getEM().persist(t);
        }catch(Exception e){
        getEM().getTransaction().rollback();
            System.err.println("Error al crear: "+e.getMessage());    
        }finally{
        getEM().getTransaction().commit();
            System.out.println("Guardado Correctamente!");
            getEM().clear();
        }
    }

    @Override
    public void update(T t, Object id) {
        
        
        getEM().merge(t);
    
    }

    @Override
    public void delete(Object id) {
       
      T t = getEM().find(entityM, id);
       
      getEM().remove(t);
       
    }
    
}
