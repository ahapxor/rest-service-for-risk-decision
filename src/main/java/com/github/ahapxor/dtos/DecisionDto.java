package com.github.ahapxor.dtos;


public class DecisionDto {
    final private boolean accepted;
    final private String reason;

    public DecisionDto(boolean accepted, String reason) {
        this.accepted = accepted;
        this.reason = reason;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getReason() {
        return reason;
    }
}
