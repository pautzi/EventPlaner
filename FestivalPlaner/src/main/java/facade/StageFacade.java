package facade;

import entity.Stage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StageFacade {
    @PersistenceContext
    private EntityManager em;

    public void create(Stage stage){em.persist(stage);}

    public Stage findById(long id) {return em.find(Stage.class,id);}

    public Stage update(Stage stage){ return this.em.merge(stage);}

    public void delete(long id){
        Stage entity = this.em.find(Stage.class,id);
        if(entity!=null)
            this.em.remove(entity);
    }

}