package com.shestakam;

/**
 * Created by alexandr on 1.7.15.
 */
public class Calculator {

    private Operands operands;
    private Number memory;
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
            if (action.equals("+")) {
                Number result = operands.getOperand1() + operands.getOperand2();
                clear();
                return result;
            } else if (action.equals("-")) {
                Number result = operands.getOperand1() - operands.getOperand2();
                clear();
                return result;
            } else if (action.equals("/")) {
                Number result = operands.getOperand1() / operands.getOperand2();
                clear();
                return result;
            } else if (action.equals("*")){
                Number result = operands.getOperand1() * operands.getOperand2();
                clear();
                return result;
            }
        } else{
            if (action.equals("+")) {
                Number result = operands.getOperand1() + operands.getOperand1();
                return result;
            } else if (action.equals("-")){
                Number result = operands.getOperand1() - operands.getOperand1();
                return result;
            } else if (action.equals("/")) {
                Number result = operands.getOperand1() / operands.getOperand1();
                return result;
            } else if (action.equals("*")) {
                Number result = operands.getOperand1() * operands.getOperand2();
                return result;
            }
        }

        return 0;
    }

    public void clear(){
        operands.clear();
        action = null;
    }

    public void memoryStore(){
        memory = getIndicator();
    }

    public Number memoryRead(){
        if (operands.isFirstOperandEntered()) {
            operands.setOperand2(memory.doubleValue());
        } else {
            operands.setOperand1(memory.doubleValue());
        }

        return 0;
    }

    public void memoryAdd(){
        memory = memory.doubleValue() + getIndicator().doubleValue();
    }

    public void memoryClear(){
        memory = null;
    }

    public boolean memoryIsEmpty(){
        if (memory == null){
            return true;
        }
        return false;
    }
}
