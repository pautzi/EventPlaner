package facade;

import entity.Playtime;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlaytimeFacade {
    @PersistenceContext
    private EntityManager em;

    public void create(Playtime playtime){em.persist(playtime);}

    public Playtime findById(long id) {return em.find(Playtime.class,id);}

    public Playtime update(Playtime playtime){ return this.em.merge(playtime);}

    public void delete(long id){
        Playtime entity = this.em.find(Playtime.class,id);
        if(entity!=null)
            this.em.remove(entity);
    }

}