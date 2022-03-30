package ir.whentomeet.backend;

import ir.whentomeet.backend.models.TimespanElection;
import ir.whentomeet.backend.repositories.MeetingElectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TimespanElectionEntityTest {

    @Autowired
    private MeetingElectionRepository meetingElectionRepo;

    @Test
    void newlyCreatedEntityHasCode() {
        TimespanElection timespanElection = new TimespanElection("A meeting");
        assertEquals(TimespanElection.CODE_LENGTH, timespanElection.getCode().length());
    }

    @Test
    void entityCantSaveWithoutCodeAndTitle() {
        TimespanElection timespanElection = new TimespanElection();
        assertNull(timespanElection.getCode());
        assertNull(timespanElection.getTitle());
        try {
            meetingElectionRepo.save(timespanElection);
            fail("Expected not being able to save the entity. But it got saved!");
        } catch (TransactionSystemException e) {
        }
    }

    @Test
    void differentInstancesHaveDifferentCodes(){
        TimespanElection timespanElection1 = new TimespanElection("A meeting");
        TimespanElection timespanElection2 = new TimespanElection("A meeting");
        assertNotEquals(timespanElection1.getCode(), timespanElection2.getCode());
    }
}
