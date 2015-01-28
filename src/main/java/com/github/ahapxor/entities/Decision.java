package com.github.ahapxor.entities;

public abstract class Decision {
    final private boolean accepted;
    final private Reason reason;

    public Decision(boolean accepted, Reason reason) {
        this.accepted = accepted;
        this.reason = reason;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Reason getReason() {
        return reason;
    }

    public enum Reason {
        ok, amount, debt
    }

    public static Decision OK = new DecisionOk();
    public static Decision DEBT = new DecisionDebt();
    public static Decision AMOUNT = new DecisionAmount();
}

