package web;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import entity.Festival;
import entity.Playtime;
import entity.Stage;
import facade.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Console;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Named
@ApplicationScoped
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

    private List<Festival> festivalList;

    private List<Stage> stageList;

    private List<Playtime> forStage;

    private Festival selectedFestival;

    private Stage selectedStage;

    private Playtime selectedPlaytime;
    private List<Playtime> ownTimetable;
    private Playtime toDeletePlaytime;
    public List<Festival> getFestivalList() {
        return festivalList;
    }

    public void setFestivalList(List<Festival> festivalList) {
        this.festivalList = festivalList;
    }

    public List<Stage> getStageList() {
            return stageList;
    }

    public void setStageList(List<Stage> stageList) {

        this.stageList = stageList;
    }

    public List<Playtime> getForStage() {
        return forStage;
    }

    public void setForStage(List<Playtime> forStage) {
        this.forStage = forStage;
    }

    public Festival getSelectedFestival() {
        return selectedFestival;
    }

    public void setSelectedFestival(Festival selectedFestival) {
        System.out.println("test");
        System.out.println(selectedFestival.getId());
        this.forStage = null;
        stageList = stageFacade.findAll(selectedFestival.getId());
        this.selectedFestival = selectedFestival;
        this.selectedStage = null;
    }

    public Stage getSelectedStage() {
        return selectedStage;
    }

    public void setSelectedStage(Stage selectedStage) {
        System.out.println("Stage");
        this.selectedStage = selectedStage;
        update();
    }

    public Playtime getSelectedPlaytime() {
        return selectedPlaytime;
    }

    public void setSelectedPlaytime(Playtime selectedPlaytime) {
        this.selectedPlaytime = selectedPlaytime;
        updtateOwnForm();
    }

    public List<Playtime> getOwnTimetable() {
        return ownTimetable;
    }

    public void setOwnTimetable(List<Playtime> ownTimetable) {
        this.ownTimetable = ownTimetable;
    }

    public Playtime getToDeletePlaytime() {
        return toDeletePlaytime;
    }

    public void setToDeletePlaytime(Playtime toDeletePlaytime) {
        this.toDeletePlaytime = toDeletePlaytime;
        deleteFromOwn();
    }

    @PostConstruct
    public void init(){
        festivalList = festivalFacade.findAllFestivals();
        ownTimetable = new LinkedList<>();
    }

    public void update(){
        this.forStage = playtimeFacade.findAllConcertsForStage(this.selectedStage.getId());
    }

    public void updtateOwnForm(){
        this.ownTimetable.add(selectedPlaytime);
    }
    public void deleteFromOwn(){
        this.ownTimetable.remove(toDeletePlaytime);
    }


}
