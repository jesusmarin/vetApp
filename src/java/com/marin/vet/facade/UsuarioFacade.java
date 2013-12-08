package com.marin.vet.facade;

import com.marin.vet.entidad.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author JesusMarin
 */
@Stateless
public class UsuarioFacade implements Serializable {

    @PersistenceContext(unitName = "appVeterinariaPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void create(Usuario entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Usuario entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Usuario entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public Usuario find(Object id) {
        return getEntityManager().find(Usuario.class, id);
    }

    public List<Usuario> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Usuario.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<Usuario> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Usuario.class));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<Usuario> rt = cq.from(Usuario.class);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public Usuario buscarUsuarioPorId(String docId) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> consulta = cb.createQuery(Usuario.class);
            Root<Usuario> usuario = consulta.from(Usuario.class);
            consulta.select(usuario)
                    .where(cb.equal(usuario.get("docIdentidad"), docId));
            Query q = getEntityManager().createQuery(consulta);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
