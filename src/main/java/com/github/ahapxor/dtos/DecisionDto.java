package com.github.ahapxor.dtos;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DecisionDto {
    final private boolean accepted;
    final private String reason;

    @JsonCreator public DecisionDto(@JsonProperty("accepted") boolean accepted,
                                    @JsonProperty("reason") String reason) {
        this.accepted = accepted;
        this.reason = reason;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "DecisionDto{" +
                "accepted=" + accepted +
                ", reason='" + reason + '\'' +
                '}';
    }
}
