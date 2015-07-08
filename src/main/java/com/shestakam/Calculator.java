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
    private Number helpNumberToEquals;
    private int countOperands;
    private String operation;
    private String helpOperation;
    private boolean forStrangeTest;

    public Calculator() {
        operation = new String();
        countOperands = 0;
        memory = 0;
        helpOperation = null;
        previousNumber = 0;
        helpNumberToEquals = 0;
        forStrangeTest = false;
    }

    public void setOperand(Number number) {
        forStrangeTest = true;
        countOperands++;
        if (countOperands >= 2){
            previousNumber = currentNumber;
        }
        if (helpOperation==null)
            previousNumber = onIndicator;
        onIndicator = number;
        currentNumber = number;
    }

    public void callOperation(String act){

        if (isOperationEnteredBefore){
            if (!act.equals("=")) {

                if(!operation.equals("=")){
                    if (!forStrangeTest)
                        countOperands = 1;
                    performOperation(operation,currentNumber,previousNumber);
                    operation = act;

                    forStrangeTest = false;
                    return;
                }else{
                    operation = act;
                    /*if (!forStrangeTest)
                        countOperands = 1;*/
                    currentNumber = onIndicator;
                    forStrangeTest = false;
                    return;
                }

            } else  {  // это если пришло =



                if (!operation.equals("=")) {
                    helpOperation = operation;
                    if (!forStrangeTest)
                        countOperands = 1;
                    performOperation(operation, currentNumber,previousNumber);
                    operation = act;
                    forStrangeTest = false;
                    return;
                }else{ // =   =
                    if(forStrangeTest)
                        performOperation(helpOperation,previousNumber,onIndicator);
                    else
                        performOperation(helpOperation, currentNumber,onIndicator);

                    //performOperation(helpOperation, currentNumber,onIndicator);
                    operation = act;
                    forStrangeTest = false;
                    return;
                }
            }
        } else{
            operation = act;
            isOperationEnteredBefore = true;
            forStrangeTest = false;
        }
    }

    public Number getIndicator(){
        return onIndicator;
    }

    public void memoryStore(){
        countOperands++;
        memory = getIndicator();
    }

    public Number memoryRead(){
        forStrangeTest = true;
        previousNumber = currentNumber;
        onIndicator = memory;
        currentNumber = memory;
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

    private void performOperation(String operation, Number operand1,Number operand2){
        if (countOperands == 1){
            Number result = null;
            switch(operation){
                case "+":
                    result =  operand1.doubleValue() + operand1.doubleValue();
                    break;
                case "-":
                    result =  operand1.doubleValue() - operand1.doubleValue();
                    break;
                case "*":
                    result =  operand1.doubleValue() * operand1.doubleValue();
                    break;
                case "/":
                    result =  operand1.doubleValue() / operand1.doubleValue();
                    break;
            }
            onIndicator = result;
            return;
        }else{
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
}
