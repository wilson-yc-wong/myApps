package net.myapp.app.ranking.api.service;

import net.myapp.app.ranking.model.Exclusion;
import net.myapp.app.ranking.model.Report;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by chunwyc on 28/2/2018.
 */
public interface WebVisitCountService {
    List<Report> getReportOfTopWebSites(LocalDate from, LocalDate to, int topCount);
    void setExclusion(List<Exclusion> exclusions);
}
