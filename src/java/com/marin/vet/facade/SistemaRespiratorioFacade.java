/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marin.vet.facade;

import com.marin.vet.entidad.SistemaRespiratorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JesusMarin
 */
@Stateless
public class SistemaRespiratorioFacade extends AbstractFacade<SistemaRespiratorio> {
    @PersistenceContext(unitName = "appVeterinariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SistemaRespiratorioFacade() {
        super(SistemaRespiratorio.class);
    }
    
}
