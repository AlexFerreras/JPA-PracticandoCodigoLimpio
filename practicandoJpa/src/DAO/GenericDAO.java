/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author alexf
 */
public interface GenericDAO<T> {
    
    public List<T> getAll();
    
    public void create(T t);
    
    public void update(T t,Object id);
    
    public void delete (Object id);
    
    
}
