package com.shestakam;

/**
 * Created by alexandr on 1.7.15.
 */
public class Calculator {

    private Operands operands;
    private Number memory;
    private Action action;

    public Calculator() {
        operands = new Operands();
        action = new Action();
        memory = 0;
    }

    public void setOperand(Number number){
        if (operands.isFirstOperandEntered())
            operands.setOperand2(number.doubleValue());
        else
            operands.setOperand1(number.doubleValue());
    }

    public void setOperation(String act){
        if ( act.equals("=")){
            action.setEqualsAction(true);
        }
        else
            action.setOperationAction(act);


    }
    public Number getIndicator(){
        if ( action.getEqualsAction()) {
            if (operands.isSecondOperandEntered()) {
                if (action.getOperationAction().equals("+")) {
                    Number result = operands.getOperand1() + operands.getOperand2();
                    clear();
                    return result;
                } else if (action.getOperationAction().equals("-")) {
                    Number result = operands.getOperand1() - operands.getOperand2();
                    clear();
                    return result;
                } else if (action.getOperationAction().equals("/")) {
                    Number result = operands.getOperand1() / operands.getOperand2();
                    clear();
                    return result;
                } else if (action.getOperationAction().equals("*")) {
                    Number result = operands.getOperand1() * operands.getOperand2();
                    clear();
                    return result;
                }
            } else {
                if (action.getOperationAction().equals("+")) {
                    Number result = operands.getOperand1() + operands.getOperand1();
                    return result;
                } else if (action.getOperationAction().equals("-")) {
                    Number result = operands.getOperand1() - operands.getOperand1();
                    return result;
                } else if (action.getOperationAction().equals("/")) {
                    Number result = operands.getOperand1() / operands.getOperand1();
                    return result;
                } else if (action.getOperationAction().equals("*")) {
                    Number result = operands.getOperand1() * operands.getOperand1();
                    return result;
                }
            }
        }else {
            if (operands.isSecondOperandEntered()) {
                Number result = operands.getOperand2();
                clear();
                return result;
            } else {
                Number result = operands.getOperand1();
                clear();
                return result;
            }
        }

        return 0;
    }

    public void clear(){
        operands.clear();
        action.clear();
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
