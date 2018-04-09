package buisness;

import entity.*;
import facade.*;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private void init() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("14/7/2018");
        Date b = sdf.parse("17/7/2018");
        actFacade.create(new Act(1997,"Green Day","Rock"));
        actFacade.create(new Act(2002,"A Day To Remember","Post Hardcore"));
        actFacade.create(new Act(1970,"Guns n Roses","Rock"));
        actFacade.create(new Act(1970,"Metallica","Rock"));
        actFacade.create(new Act(2003,"Billy Talent","Rock"));
        actFacade.create(new Act(2005,"Bring me the Horizon","Metall Core"));
        actFacade.create(new Act(2010,"Falling in Reverse","Post Hardcore"));
        actFacade.create(new Act(1997,"Linkin Park","Rock"));

        festivalFacade.create(new Festival("Nova Rock",b,d));
        d = sdf.parse("4/7/2018");
        b = sdf.parse("7/7/2018");
        festivalFacade.create(new Festival("Rock am Ring",b,d));


        stageFacade.create(new Stage("Red Stage","Rock","Rock",festivalFacade.findById(1)));
        stageFacade.create(new Stage("Blue Stage","Alternative","Alternative",festivalFacade.findById(1)));

        timetableFacade.create(new Timetable("Monday", stageFacade.findById(1)));
        timetableFacade.create(new Timetable("Monday", stageFacade.findById(2)));

        playtimeFacade.create(new Playtime(17.30, timetableFacade.findById(1), actFacade.findById(1)));
        playtimeFacade.create(new Playtime(19.00, timetableFacade.findById(1), actFacade.findById(3)));
        playtimeFacade.create(new Playtime(20.30, timetableFacade.findById(1), actFacade.findById(4)));
        playtimeFacade.create(new Playtime(22.30, timetableFacade.findById(1), actFacade.findById(7)));

        playtimeFacade.create(new Playtime(17.30, timetableFacade.findById(2), actFacade.findById(2)));
        playtimeFacade.create(new Playtime(19.00, timetableFacade.findById(2), actFacade.findById(5)));
        playtimeFacade.create(new Playtime(20.30, timetableFacade.findById(2), actFacade.findById(6)));
        playtimeFacade.create(new Playtime(22.30, timetableFacade.findById(2), actFacade.findById(8)));


    }
}