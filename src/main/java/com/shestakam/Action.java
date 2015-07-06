package com.shestakam;

/**
 * Created by alexandr on 6.7.15.
 */
public class Action {
    private String operationAction;
    private Boolean equalsAction;

    public Action() {
        operationAction = null;
        equalsAction = false;
    }

    public String getOperationAction() {
        return operationAction;
    }

    public void setOperationAction(String operationAction) {
        this.operationAction = operationAction;
    }

    public void setEqualsAction(Boolean equalsAction) {
        this.equalsAction = equalsAction;
    }

    public Boolean getEqualsAction() {
        return equalsAction;
    }

    public void clear() {
        operationAction = null;
        equalsAction = false;
    }
}
