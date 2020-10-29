package edu.project.divantelecom.model;

import java.time.LocalDateTime;
import edu.project.divantelecom.model.Subscriber;

public class callDestination {
    private String cdId;
    private int countryCode;
    private int operatorCode;
    private int number;
    private String description;
    private LocalDateTime callStart;
    private LocalDateTime callStop;

    public callDestination(String cdId, int countryCode, int operatorCode, int number, String description, LocalDateTime callStart, LocalDateTime callStop) {
        this.cdId = cdId;
        this.countryCode = countryCode;
        this.operatorCode = operatorCode;
        this.number = number;
        this.description = description;
        this.callStart = callStart;
        this.callStop = callStop;
    }
}
