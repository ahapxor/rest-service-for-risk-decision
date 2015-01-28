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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecisionDto that = (DecisionDto) o;

        if (accepted != that.accepted) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (accepted ? 1 : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }
}
