package com.shestakam;

/**
 * Created by alexandr on 1.7.15.
 */
public class Calculator {

    private Operands operands;
    private Number memory;
    private Action action;
    private boolean isOperationEnteredBefore;
   // private Number helpNumber;
    private Number onIndicator;
    private Number currentNumber;
    private Number helpNumber;
    private int count;
    private String operation;
    private String helpOperation;

    public Calculator() {
        operation = new String();
        count = 0;
        operands = new Operands();
        action = new Action();
        memory = 0;
        helpOperation = null;
        helpNumber = 0;
    }

    public void setOperand(Number number) {
        count++;
        if (count == 2){
            helpNumber = currentNumber;
        }
        helpNumber = onIndicator;
        onIndicator = number;
        currentNumber = number;

     /*   if (operands.isFirstOperandEntered() & operands.isSecondOperandEntered()){
            Number temp = operands.getOperand2();
            operands.setOperand1(temp.doubleValue());
            operands.setOperand2(number.doubleValue());
            return;
        }
        if (operands.isFirstOperandEntered() & !operands.isSecondOperandEntered()){
            operands.setOperand2(number.doubleValue());
            return;
        }
        if (!operands.isFirstOperandEntered() & !operands.isSecondOperandEntered()) {
            operands.setOperand1(number.doubleValue());

        }*/
    }



    public void setOperation(String act){
        if(helpOperation != null) {
            if (act.equals("=")) {
                operation = act;
                if (helpOperation.equals("+")) {
                    operation = act;
                    if (count == 1) {
                        Number result = currentNumber.doubleValue() + onIndicator.doubleValue();
                        onIndicator = result;
                        return;
                    } else {
                        Number result = currentNumber.doubleValue() + helpNumber.doubleValue();
                        onIndicator = result;
                        count--;
                        return;
                    }
                }
                if (helpOperation.equals("-")) {
                    operation = act;
                    if (count == 1) {
                        Number result = onIndicator.doubleValue() - currentNumber.doubleValue();
                        onIndicator = result;
                        return;
                    } else {
                        Number result = helpNumber.doubleValue() - currentNumber.doubleValue();
                        onIndicator = result;
                        count--;
                        return;
                    }
                }
                if (helpOperation.equals("*")) {
                    operation = act;
                    if (count == 1) {
                        Number result = onIndicator.doubleValue() * currentNumber.doubleValue();
                        onIndicator = result;
                        return;
                    } else {
                        Number result = helpNumber.doubleValue() * currentNumber.doubleValue();
                        onIndicator = result;
                        count--;
                        return;
                    }
                }
                if (helpOperation.equals("/")) {
                    operation = act;
                    if (count == 1) {
                        Number result = onIndicator.doubleValue() / currentNumber.doubleValue();
                        onIndicator = result;
                        return;
                    } else {
                        Number result = helpNumber.doubleValue() / currentNumber.doubleValue();
                        onIndicator = result;
                        count--;
                        return;
                    }
                }
            }
            else
                helpOperation = null;
        }


        if (isOperationEnteredBefore){
            if (operation.equals("+")){
                if(act.equals("=")) {
                    isOperationEnteredBefore = false;
                    helpOperation = operation;
                }
                operation = act;
                if (count == 1){
                    Number result = currentNumber.doubleValue() + onIndicator.doubleValue();
                    onIndicator = result;
                    return;
                }else{
                    Number result = currentNumber.doubleValue() + helpNumber.doubleValue();
                    onIndicator = result;
                    count--;
                    return;
                }
            }
            if (operation.equals("-")){
                if(act.equals("=")) {
                    isOperationEnteredBefore = false;
                    helpOperation = operation;
                }
                operation = act;
                if (count == 1){
                    Number result =  onIndicator.doubleValue() - currentNumber.doubleValue();
                    onIndicator = result;
                    return;
                }else{
                    Number result = helpNumber.doubleValue() - currentNumber.doubleValue() ;
                    onIndicator = result;
                    count--;
                    return;
                }
            }
            if (operation.equals("*")){
                if(act.equals("=")) {
                    isOperationEnteredBefore = false;
                    helpOperation = operation;
                }
                operation = act;
                if (count == 1){
                    Number result =  onIndicator.doubleValue() * currentNumber.doubleValue();
                    onIndicator = result;
                    return;
                }else{
                    Number result = helpNumber.doubleValue() * currentNumber.doubleValue() ;
                    onIndicator = result;
                    count--;
                    return;
                }
            }
            if (operation.equals("/")){
                if(act.equals("=")) {
                    isOperationEnteredBefore = false;
                    helpOperation = operation;
                }
                operation = act;
                if (count == 1){
                    Number result =  onIndicator.doubleValue() / currentNumber.doubleValue();
                    onIndicator = result;
                    return;
                }else{
                    Number result = helpNumber.doubleValue() / currentNumber.doubleValue() ;
                    onIndicator = result;
                    count--;
                    return;
                }
            }
            if (act.equals("=")){
                isOperationEnteredBefore = false;
                //helpOperation = operation;
                if (operation.equals("+")){
                    operation = act;
                    if (count == 1){
                        Number result = currentNumber.doubleValue() + onIndicator.doubleValue();
                        onIndicator = result;
                        return;
                    }else{
                        Number result = currentNumber.doubleValue() + helpNumber.doubleValue();
                        onIndicator = result;
                        count--;
                        return;
                    }
                }
                if (operation.equals("-")){
                    operation = act;
                    if (count == 1){
                        Number result =  onIndicator.doubleValue() - currentNumber.doubleValue();
                        onIndicator = result;
                        return;
                    }else{
                        Number result = helpNumber.doubleValue() - currentNumber.doubleValue() ;
                        onIndicator = result;
                        count--;
                        return;
                    }
                }
                if (operation.equals("*")){
                    operation = act;
                    if (count == 1){
                        Number result =  onIndicator.doubleValue() * currentNumber.doubleValue();
                        onIndicator = result;
                        return;
                    }else{
                        Number result = helpNumber.doubleValue() * currentNumber.doubleValue() ;
                        onIndicator = result;
                        count--;
                        return;
                    }
                }
                if (operation.equals("/")){
                    operation = act;
                    if (count == 1){
                        Number result =  onIndicator.doubleValue() / currentNumber.doubleValue();
                        onIndicator = result;
                        return;
                    }else{
                        Number result = helpNumber.doubleValue() / currentNumber.doubleValue() ;
                        onIndicator = result;
                        count--;
                        return;
                    }
                }
              /*  if (operation.equals("=")){
                    operation = act;
                    if (helpOperation.equals("+")){
                        operation = act;
                        if (count == 1){
                            Number result = currentNumber.doubleValue() + onIndicator.doubleValue();
                            onIndicator = result;
                            return;
                        }else{
                            Number result = currentNumber.doubleValue() + helpNumber.doubleValue();
                            onIndicator = result;
                            count--;
                            return;
                        }
                    }
                    if (helpOperation.equals("-")){
                        operation = act;
                        if (count == 1){
                            Number result =  onIndicator.doubleValue() - currentNumber.doubleValue();
                            onIndicator = result;
                            return;
                        }else{
                            Number result = helpNumber.doubleValue() - currentNumber.doubleValue() ;
                            onIndicator = result;
                            count--;
                            return;
                        }
                    }
                    if (helpOperation.equals("*")){
                        operation = act;
                        if (count == 1){
                            Number result =  onIndicator.doubleValue() * currentNumber.doubleValue();
                            onIndicator = result;
                            return;
                        }else{
                            Number result = helpNumber.doubleValue() * currentNumber.doubleValue() ;
                            onIndicator = result;
                            count--;
                            return;
                        }
                    }
                    if (helpOperation.equals("/")){
                        operation = act;
                        if (count == 1){
                            Number result =  onIndicator.doubleValue() / currentNumber.doubleValue();
                            onIndicator = result;
                            return;
                        }else{
                            Number result = helpNumber.doubleValue() / currentNumber.doubleValue() ;
                            onIndicator = result;
                            count--;
                            return;
                        }
                    }
                }
*/
            }




        } else{
            operation = act;
            isOperationEnteredBefore = true;
        }



    }
    public Number getIndicator(){
        return onIndicator;
    }

    public void clear(){
        operands.clear();
        action.clear();
    }

    public void memoryStore(){
        memory = getIndicator();
    }

    public Number memoryRead(){
        /*if (operands.isFirstOperandEntered()) {
            operands.setOperand2(memory.doubleValue());
        } else {
            operands.setOperand1(memory.doubleValue());
        }*/
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
}
