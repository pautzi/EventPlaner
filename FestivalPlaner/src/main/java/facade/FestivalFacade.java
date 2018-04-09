package facade;

import entity.Festival;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FestivalFacade {
    @PersistenceContext
    private EntityManager em;

    public void create(Festival festival){em.persist(festival);}

    public Festival findById(long id) {return em.find(Festival.class,id);}

    public Festival update(Festival festival){ return this.em.merge(festival);}

    public void delete(long id){
        Festival entity = this.em.find(Festival.class,id);
        if(entity!=null)
            this.em.remove(entity);
    }

}