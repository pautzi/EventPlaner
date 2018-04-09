package web;

import facade.*;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

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

    public IndexController() {

    }

    @PostConstruct
    private void init() {

    }
}
