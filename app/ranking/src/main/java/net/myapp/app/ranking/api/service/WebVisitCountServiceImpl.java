package net.myapp.app.ranking.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.myapp.app.ranking.api.repository.ExclusionRepository;
import net.myapp.app.ranking.api.repository.WebSiteRepository;
import net.myapp.app.ranking.model.Exclusion;
import net.myapp.app.ranking.model.Report;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunwyc on 28/2/2018.
 */
@Service("webVisitCountService")
public class WebVisitCountServiceImpl implements WebVisitCountService {
    @Autowired
    private WebSiteRepository wsRepository;
    @Autowired
    private ExclusionRepository exRepository;

    public List<Report> getReportOfTopWebSites(LocalDate from, LocalDate to, int topCount) {
        List<Report> reports = new ArrayList();

        if(topCount>0) {
            reports = wsRepository.findTopWebSites((from==null?null:Date.valueOf(from)), (to==null?null:Date.valueOf(to)), topCount);
        }

        return reports;
    }

    public void setExclusion(List<Exclusion> newExclusions) {
        List<Exclusion> ex = exRepository.findByEnableTrue();

        if(!(ex.containsAll(newExclusions) && newExclusions.containsAll(ex))) {
            exRepository.disableAll();
            for(Exclusion e : newExclusions) {
                exRepository.save(e);
            }
        }
    }

}
