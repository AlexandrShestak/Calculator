package com.shestakam;

/**
 * Created by alexandr on 1.7.15.
 */
public class Operands {
    private Double operand1;
    private Double operand2;

    public Operands() {
        operand1 = null;
        operand2 = null;
    }

    public void clear(){
        operand1 = null;
        operand2 = null;
    }

    public boolean isFirstOperandEntered(){
        if (operand1 == null)
            return false;
        else
            return true;
    }

    public boolean isSecondOperandEntered(){
        if (operand2 == null)
            return false;
        else
            return true;
    }

    public Double getOperand1() {
        return operand1;
    }

    public void setOperand1(Double operand1) {
        this.operand1 = operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public void setOperand2(Double operand2) {
        this.operand2 = operand2;
    }
}
