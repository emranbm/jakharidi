package ir.whentomeet.backend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ir.whentomeet.backend.utils.StringUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
public class MeetingElection {

    public static final int CODE_LENGTH = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String code;
    @NotNull
    private String title;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant lastModifiedDate;


    public MeetingElection() {
    }

    public MeetingElection(String title) {
        this.title = title;
        autoAssignRandomCode();
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void autoAssignRandomCode() {
        code = StringUtils.generateRandomString(CODE_LENGTH);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }
}
