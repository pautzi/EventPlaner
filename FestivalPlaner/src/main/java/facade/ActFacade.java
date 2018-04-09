package facade;

import entity.Act;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ActFacade {
    @PersistenceContext
    private EntityManager em;

    public void create(Act act){em.persist(act);}

    public Act findById(long id) {return em.find(Act.class,id);}

    public Act update(Act act){ return this.em.merge(act);}

    public void delete(long id){
        Act entity = this.em.find(Act.class,id);
        if(entity!=null)
            this.em.remove(entity);
    }

}
