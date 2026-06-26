package za.ac.cput.factory;

/*
SubjectFactory.java
Subject Factory class
Author: Reotshepile Stock (230875807)
Date: 23 March 2026
*/

import za.ac.cput.domain.Subject;
import za.ac.cput.util.HelperUtil;

import java.util.UUID;

public class SubjectFactory {

    public static Subject createSubject(String subjectName) {

        String subjectId = UUID.randomUUID().toString();

        if (HelperUtil.isNullOrEmpty(subjectName)) {
            return null;
        }

        return new Subject.Builder()
                .setSubjectId(Long.parseLong(subjectId.substring(0, 5).replaceAll("[^0-9]", "1")))
                .setSubjectName(subjectName)
                .build();
    }
}

/*
    CS: 25-03-2026
    Code added from https://github.com/CharltonAwesome2/edu-connect/pull/50
*/