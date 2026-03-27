package za.ac.cput.repository;

// package za.ac.cput.repository.impl;

/* ReportRepositoryImpl.java
Report Repository Impl Entity 
Author : Nolwazi Zulu (220118876)
Date : 27 March 2026
*/

import za.ac.cput.domain.Report;
// import za.ac.cput.repository.ReportRepository;

import java.util.HashMap;
import java.util.Map;

public class ReportRepository implements IRepository<Report, Long> {

    private static ReportRepository repository = null;
    private Map<Long, Report> reportDB;

    private ReportRepository() {
        reportDB = new HashMap<>();
    }

    public static ReportRepository getRepository() {
        if (repository == null) {
            repository = new ReportRepository();
        }
        return repository;
    }

    @Override
    public Report create(Report report) {
        reportDB.put(report.getReportId(), report);
        return report;
    }

    @Override
    public Report read(Long id) {
        return reportDB.get(id);
    }

    @Override
    public Report update(Report report) {
        if (reportDB.containsKey(report.getReportId())) {
            reportDB.put(report.getReportId(), report);
            return report;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        reportDB.remove(id);
        return true;
    }
}
