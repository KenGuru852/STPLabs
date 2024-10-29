package com.stp.processor;

public class TOprtn {

    private String operation;

    public TOprtn(){
        operation = "None";
    }

    public void setOperation(String operation) {
        if (operation.equals("Add") || operation.equals("Sub") || operation.equals("Mul")
        || operation.equals("Div") || operation.equals("None")){
            this.operation = String.valueOf(operation);
        } else this.operation = "None";
    }

    public String getOperation() {
        return operation;
    }
}
