package facade;


import entity.Timetable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TimetableFacade {
    @PersistenceContext
    private EntityManager em;

    public void create(Timetable timetable){em.persist(timetable);}

    public Timetable findById(long id) {return em.find(Timetable.class,id);}

    public Timetable update(Timetable timetable){ return this.em.merge(timetable);}

    public void delete(long id){
        Timetable entity = this.em.find(Timetable.class,id);
        if(entity!=null)
            this.em.remove(entity);
    }

}