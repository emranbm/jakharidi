package ir.whentomeet.backend;

import ir.whentomeet.backend.models.MeetingElection;
import ir.whentomeet.backend.repositories.MeetingElectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MeetingElectionEntityTest {

    @Autowired
    private MeetingElectionRepository meetingElectionRepo;

    @Test
    void newlyCreatedEntityHasCode() {
        MeetingElection meetingElection = new MeetingElection("A meeting");
        assertEquals(MeetingElection.CODE_LENGTH, meetingElection.getCode().length());
    }

    @Test
    void entityCantSaveWithoutCodeAndTitle() {
        MeetingElection meetingElection = new MeetingElection();
        assertNull(meetingElection.getCode());
        assertNull(meetingElection.getTitle());
        try {
            meetingElectionRepo.save(meetingElection);
            fail("Expected not being able to save the entity. But it got saved!");
        } catch (TransactionSystemException e) {
        }
    }

    @Test
    void differentInstancesHaveDifferentCodes(){
        MeetingElection meetingElection1 = new MeetingElection("A meeting");
        MeetingElection meetingElection2 = new MeetingElection("A meeting");
        assertNotEquals(meetingElection1.getCode(), meetingElection2.getCode());
    }
}
