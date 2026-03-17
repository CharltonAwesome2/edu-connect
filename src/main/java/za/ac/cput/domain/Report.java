package za.ac.cput.domain;

/*
 Report.java
 Report Entity
 Author: Nolwazi Zulu (220118876)
 Date: 16 March 2026
*/

public class Report {

    private Long reportId;
    private String reportType;
    private String description;
    private String dateGenerated;

    private Report(){}

    private Report(Builder builder){
        this.reportId = builder.reportId;
        this.reportType = builder.reportType;
        this.description = builder.description;
        this.dateGenerated = builder.dateGenerated;
    }

    public Long getReportId() {
        return reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public String getDescription() {
        return description;
    }

    public String getDateGenerated() {
        return dateGenerated;
    }

    public static class Builder {

        private Long reportId;
        private String reportType;
        private String description;
        private String dateGenerated;

        public Builder setReportId(Long reportId){
            this.reportId = reportId;
            return this;
        }

        public Builder setReportType(String reportType){
            this.reportType = reportType;
            return this;
        }

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public Builder setDateGenerated(String dateGenerated){
            this.dateGenerated = dateGenerated;
            return this;
        }

        public Report build(){
            return new Report(this);
        }
    }
}