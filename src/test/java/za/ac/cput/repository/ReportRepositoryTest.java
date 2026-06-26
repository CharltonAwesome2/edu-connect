package za.ac.cput.repository;

/*ReportRepositoryTest.java
Report Repository Test Entity
Author : Nolwazi Zulu(220118876) 
Date : 27 March 2026 
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.User;
import za.ac.cput.factory.ReportFactory;
// import za.ac.cput.repository.impl.ReportRepositoryImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReportRepositoryTest {

    private ReportRepository repository;
    private Report report;

    @BeforeEach
    void setUp() {
        repository = ReportRepository.getRepository();

        report = ReportFactory.createReport(
                "Test report",
                LocalDateTime.now(),
                new User(),
                new User()
        );
    }

    @Test
    void create() {
        Report created = repository.create(report);
        assertNotNull(created);
    }

    @Test
    void read() {
        repository.create(report);
        Report read = repository.read(report.getReportId());
        assertNotNull(read);
    }

    @Test
    void update() {
        repository.create(report);

        Report updated = new Report.Builder()
                .copy(report)
                // .set("Updated Report")
                .build();

        Report result = repository.update(updated);
        assertNotNull(result);
        assertEquals("Updated Report", result.getReason());
    }

    @Test
    void delete() {
        repository.create(report);
        boolean deleted = repository.delete(report.getReportId());
        assertTrue(deleted);
    }
}
