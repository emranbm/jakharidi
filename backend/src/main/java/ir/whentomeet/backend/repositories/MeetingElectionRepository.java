package ir.whentomeet.backend.repositories;

import ir.whentomeet.backend.models.TimespanElection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingElectionRepository extends JpaRepository<TimespanElection, Long> {
}
