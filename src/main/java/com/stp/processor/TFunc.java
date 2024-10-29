package com.stp.processor;

public class TFunc {

    private String function;

    public TFunc(){
        function = "None";
    }

    public void setFunction(String function) {
        if (function.equals("Rev") || function.equals("Sqr")){
            this.function = String.valueOf(function);
        } else this.function = "None";
    }

    public String getFunction() {
        return function;
    }

}
