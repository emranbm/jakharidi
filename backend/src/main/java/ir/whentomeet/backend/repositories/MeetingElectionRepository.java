package ir.whentomeet.backend.repositories;

import ir.whentomeet.backend.models.MeetingElection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingElectionRepository extends JpaRepository<MeetingElection, Long> {
}
