package za.ac.cput.domain;

// SubjectClass.java
//Subject model class
//Author:Reotshepile Stock (230875807)
//Date:17 March 2026

public class Subject {

    private Long subjectId;
    private String subjectName;

    
    private Subject(Builder builder) {
        this.subjectId = builder.subjectId;
        this.subjectName = builder.subjectName;
    }

    
    public Long getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    
    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    public static class Builder {

        private Long subjectId;
        private String subjectName;

        public Builder setSubjectId(Long subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }
}
