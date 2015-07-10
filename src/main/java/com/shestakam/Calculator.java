package com.shestakam;

/**
 * Created by alexandr on 1.7.15.
 */
public class Calculator {

    private Number memory;
    private boolean isOperationEnteredBefore;
    private Number onIndicator;
    private Number currentNumber;
    private Number previousNumber;
    private String operation;
    private String helpOperation;
    private boolean isOperandSendJustNow;

    public Calculator() {
        operation = new String();
        memory = 0;
        helpOperation = null;
        previousNumber = 0;
        isOperandSendJustNow = false;
    }

    public void setOperand(Number number) {
        isOperandSendJustNow = true;
        if (isOperandSendJustNow){
            previousNumber = currentNumber;
        }
        if (helpOperation==null)
            previousNumber = onIndicator;
        onIndicator = number;
        currentNumber = number;
    }

    public void callOperation(String act){

        if (isOperationEnteredBefore){
            if (act.equals("=")) {
                if (operation.equals("=")) {
                    //  =   =
                    if(isOperandSendJustNow)
                        performOperation(helpOperation,previousNumber,onIndicator);
                    else
                        performOperation(helpOperation, currentNumber,onIndicator);
                    operation = act;
                    isOperandSendJustNow = false;
                    return;
                }else{
                    // *  =
                    helpOperation = operation;
                    if(isOperandSendJustNow)
                        performOperation(operation, currentNumber,previousNumber);
                    else
                        performOperation(operation, currentNumber,currentNumber);
                    operation = act;
                    isOperandSendJustNow = false;
                    return;
                }
            } else  {
                if(operation.equals("=")){
                    operation = act;
                    currentNumber = onIndicator;
                    isOperandSendJustNow = false;
                    return;

                }else{
                    if (!isOperandSendJustNow) {
                        operation = act;
                        isOperandSendJustNow = false;
                        return;
                    }
                    performOperation(operation,currentNumber,previousNumber);
                    operation = act;
                    isOperandSendJustNow = false;
                    return;
                }
            }
        } else{
            operation = act;
            isOperationEnteredBefore = true;
            isOperandSendJustNow = false;
        }
    }

    public Number getIndicator(){
        return onIndicator;
    }

    public void memoryStore(){

        memory = getIndicator();
    }

    public Number memoryRead(){
        isOperandSendJustNow = true;
        previousNumber = currentNumber;
        if(memory == null){
            onIndicator = 0;
            currentNumber = 0;
            return 0;
        }
        onIndicator = memory;
        currentNumber = memory;
        return memory;
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

    private void performOperation(String operation, Number operand1,Number operand2){
        Number result = null;
        switch(operation){
            case "+":
                result =  operand2.doubleValue() + operand1.doubleValue();
                break;
            case "-":
                result =  operand2.doubleValue() - operand1.doubleValue();
                break;
            case "*":
                result =  operand2.doubleValue() * operand1.doubleValue();
                break;
            case "/":
                result =  operand2.doubleValue() / operand1.doubleValue();
                break;
        }
        onIndicator = result;
    }
}
