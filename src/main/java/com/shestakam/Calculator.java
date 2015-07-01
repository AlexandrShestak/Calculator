package com.shestakam;

/**
 * Created by alexandr on 1.7.15.
 */
public class Calculator {

    private Operands operands;
    private String action;

    public Calculator() {
        operands = new Operands();
        action = new String();
    }

    public void setOperand(Number number){
        if (operands.isFirstOperandEntered())
            operands.setOperand2(number.doubleValue());
        else
            operands.setOperand1(number.doubleValue());
    }

    public void setOperation(String act){
        action = act;
    }
    public Number getIndicator(){
        if(operands.isSecondOperandEntered()) {
            if (action == "+") {
                return operands.getOperand1() + operands.getOperand2();
            } else if (action == "-") {
                return operands.getOperand1() - operands.getOperand2();
            } else if (action == "/") {
                return operands.getOperand1() / operands.getOperand2();
            } else if (action == "*") {
                return operands.getOperand1() * operands.getOperand2();
            }
        } else{
            if (action == "+") {
                return operands.getOperand1() + operands.getOperand1();
            } else if (action == "-") {
                return operands.getOperand1() - operands.getOperand1();
            } else if (action == "/") {
                return operands.getOperand1() / operands.getOperand1();
            } else if (action == "*") {
                return operands.getOperand1() * operands.getOperand1();
            }

        }

        return 0;
    }

    public void clear(){
        operands.clear();
        action = null;
    }
}
