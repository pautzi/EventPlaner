package buisness;

import facade.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class InitBean {

    @Inject
    private ActFacade actFacade;

    @Inject
    private FestivalFacade festivalFacade;

    @Inject
    private PlaytimeFacade playtimeFacade;

    @Inject
    private StageFacade stageFacade;

    @Inject
    private TimetableFacade timetableFacade;

    public InitBean() {

    }

    @PostConstruct
    private void init(){

    }
}