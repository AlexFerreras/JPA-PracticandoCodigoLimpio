/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Services;

import DAO.GenericAbstract;
import Models.Entities.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexf
 */
public class ClienteDAOImpl extends GenericAbstract<Cliente>{

   EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistensPU");
   
   EntityManager em= emf.createEntityManager();
    
    public ClienteDAOImpl() {
        super(Cliente.class);
    }

    @Override
    protected EntityManager getEM() {
       return em;
    }
    
    
    public Cliente find(int id){
    
    return getEM().find(Cliente.class,id);
    }
    
}
