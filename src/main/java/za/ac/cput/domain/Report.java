package za.ac.cput.domain;

import java.time.LocalDateTime;

/*
 Report.java
 Report Entity
 Author: Nolwazi Zulu (220118876)
 Date: 16 March 2026
*/

public class Report {

    private Long reportId;
    private String reason;
    private LocalDateTime reportDate;
    private User reporter;
    private User reportedUser;

    private Report() {
    }

    private Report(Builder builder) {
        this.reportId = builder.reportId;
        this.reason = builder.reason;
        this.reportDate = builder.reportDate;
        this.reporter = builder.reporter;
        this.reportedUser = builder.reportedUser;
    }

    public void submitReport(){
        
    }

    @Override
    public String toString() {
        return "Report [reportId=" + reportId + ", reason=" + reason + ", reportDate=" + reportDate + ", reporter="
                + reporter + ", reportedUser=" + reportedUser + "]";
    }

    public Long getReportId() {
        return reportId;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public User getReporter() {
        return reporter;
    }

    public User getReportedUser() {
        return reportedUser;
    }

    public static class Builder {

        private Long reportId;
        private String reason;
        private LocalDateTime reportDate;
        private User reporter;
        private User reportedUser;

        public Builder setReportId(Long reportId) {
            this.reportId = reportId;
            return this;
        }

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder setReportDate(LocalDateTime reportDate) {
            this.reportDate = reportDate;
            return this;
        }

        public Builder setReporter(User reporter) {
            this.reporter = reporter;
            return this;
        }

        public Builder setReportedUser(User reportedUser) {
            this.reportedUser = reportedUser;
            return this;
        }

        public Builder copy(Report report){
            this.reportId = report.reportId;
            this.reason = report.reason;
            this.reportDate = report.reportDate;
            this.reporter = report.reporter;
            this.reportedUser = report.reportedUser;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}