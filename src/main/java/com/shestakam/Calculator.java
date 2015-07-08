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

    public void callOperation(String act){
        if(helpOperation != null) {
            if (act.equals("=")) {
                operation = act;
                String tempOperation = new String(helpOperation);
                performOperation(helpOperation, act);
                helpOperation = tempOperation;
                return;
            }
            else
                helpOperation = null;
        }
        if (isOperationEnteredBefore){
            if (!act.equals("=")) {
                performOperation(operation, act);
                return;

            } else  {
                isOperationEnteredBefore = false;
                performOperation(operation, act);
                return;
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

    private void performOperation(String previousOperation, String currentOperation){
        if(currentOperation.equals("=")) {
            isOperationEnteredBefore = false;
            helpOperation = operation;
        }
        operation = currentOperation;
        if (countOperands == 1){
            Number result = null;
            switch(previousOperation){
                case "+":
                    result =  onIndicator.doubleValue() + currentNumber.doubleValue();
                    break;
                case "-":
                    result =  onIndicator.doubleValue() - currentNumber.doubleValue();
                    break;
                case "*":
                    result =  onIndicator.doubleValue() * currentNumber.doubleValue();
                    break;
                case "/":
                    result =  onIndicator.doubleValue() / currentNumber.doubleValue();
                    break;
            }
            onIndicator = result;
            return;
        }else{
            Number result = null;
            switch(previousOperation){
                case "+":
                    result =  helpNumber.doubleValue() + currentNumber.doubleValue() ;
                    break;
                case "-":
                    result =  helpNumber.doubleValue() - currentNumber.doubleValue() ;
                    break;
                case "*":
                    result =  helpNumber.doubleValue() * currentNumber.doubleValue() ;
                    break;
                case "/":
                    result =  helpNumber.doubleValue() / currentNumber.doubleValue() ;
                    break;
            }
            onIndicator = result;
            countOperands--;
            return;
        }
    }
}
