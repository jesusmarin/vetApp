/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marin.vet.facade;

import com.marin.vet.entidad.Mucosa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JesusMarin
 */
@Stateless
public class MucosaFacade extends AbstractFacade<Mucosa> {
    @PersistenceContext(unitName = "appVeterinariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MucosaFacade() {
        super(Mucosa.class);
    }
    
}
