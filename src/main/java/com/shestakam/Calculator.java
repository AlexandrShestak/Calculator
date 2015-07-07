package com.shestakam;

/**
 * Created by alexandr on 1.7.15.
 */
public class Calculator {

    private Number memory;
    private boolean isOperationEnteredBefore;
    private Number onIndicator;
    private Number currentNumber;
    private Number helpNumber;
    private int countOperands;
    private String operation;
    private String helpOperation;

    public Calculator() {
        operation = new String();
        countOperands = 0;
        memory = 0;
        helpOperation = null;
        helpNumber = 0;
    }

    public void setOperand(Number number) {
        countOperands++;
        if (countOperands >= 2){
            helpNumber = currentNumber;
        }
        if (helpOperation==null)
            helpNumber = onIndicator;
        onIndicator = number;
        currentNumber = number;

    }



    public void setOperation(String act){
        if(helpOperation != null) {
            if (act.equals("=")) {
                operation = act;

                if (helpOperation.equals("+")) {
                    performPlusOperation(act);
                    helpOperation = "+";
                    return;
                }
                if (helpOperation.equals("-")) {
                    performMinusOperation(act);
                    helpOperation = "-";
                    return;
                }
                if (helpOperation.equals("*")) {
                    performMultiplyOperation(act);
                    helpOperation = "*";
                    return;
                }
                if (helpOperation.equals("/")) {
                    performDivisionOperation(act);
                    helpOperation = "/";
                    return;
                }
            }
            else
                helpOperation = null;
        }


        if (isOperationEnteredBefore){

            if (operation.equals("+")){
                performPlusOperation(act);
                return;
            }
            if (operation.equals("-")){
                performMinusOperation(act);
                return;
            }
            if (operation.equals("*")){
                performMultiplyOperation(act);
                return;
            }
            if (operation.equals("/")){
                performDivisionOperation(act);
                return;
            }
            if (act.equals("=")){
                isOperationEnteredBefore = false;
                if (operation.equals("+")){
                    performPlusOperation(act);
                    return;
                }
                if (operation.equals("-")){
                    performMinusOperation(act);
                    return;
                }
                if (operation.equals("*")){
                    performMultiplyOperation(act);
                    return;
                }
                if (operation.equals("/")){
                    performDivisionOperation(act);
                    return;
                }
            }
        } else{
            operation = act;
            isOperationEnteredBefore = true;
        }

    }


    public Number getIndicator(){
        return onIndicator;
    }


    public void memoryStore(){
        memory = getIndicator();
    }

    public Number memoryRead(){
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

    private void performPlusOperation(String currentOperation){
        if(currentOperation.equals("=")) {
            isOperationEnteredBefore = false;
            helpOperation = operation;

        }
        operation = currentOperation;
        if (countOperands == 1){
            Number result = currentNumber.doubleValue() + onIndicator.doubleValue();
            onIndicator = result;
            return;
        }else{
            Number result = currentNumber.doubleValue() + helpNumber.doubleValue();
            onIndicator = result;
            countOperands--;
            return;
        }
    }

    private void performMinusOperation(String currentOperation){
        if(currentOperation.equals("=")) {
            isOperationEnteredBefore = false;
            helpOperation = operation;
        }
        operation = currentOperation;
        if (countOperands == 1){
            Number result =  onIndicator.doubleValue() - currentNumber.doubleValue();
            onIndicator = result;
            return;
        }else{
            Number result = helpNumber.doubleValue() - currentNumber.doubleValue() ;
            onIndicator = result;
            countOperands--;
            return;
        }
    }

    private void performMultiplyOperation(String currentOperation){
        if(currentOperation.equals("=")) {
            isOperationEnteredBefore = false;
            helpOperation = operation;
        }
        operation = currentOperation;
        if (countOperands == 1){
            Number result =  onIndicator.doubleValue() * currentNumber.doubleValue();
            onIndicator = result;
            return;
        }else{
            Number result = helpNumber.doubleValue() * currentNumber.doubleValue() ;
            onIndicator = result;
            countOperands--;
            return;
        }
    }

    private void performDivisionOperation(String currentOperation){
        if(currentOperation.equals("=")) {
            isOperationEnteredBefore = false;
            helpOperation = operation;
        }
        operation = currentOperation;
        if (countOperands == 1){
            Number result =  onIndicator.doubleValue() / currentNumber.doubleValue();
            onIndicator = result;
            return;
        }else{
            Number result = helpNumber.doubleValue() / currentNumber.doubleValue() ;
            onIndicator = result;
            countOperands--;
            return;
        }
    }


}
