package com.stp.memory;

public class TMemory<T extends Number> {

    private T FNumber;
    private boolean FState;

    private void setDefaultFNumber(){
        if (this.FNumber instanceof Integer){
            this.FNumber = (T) Integer.valueOf(0);
        } else if (this.FNumber instanceof Double){
            this.FNumber = (T) Double.valueOf(0);
        }
        else if (this.FNumber instanceof Float){
            this.FNumber = (T) Float.valueOf(0);
        }
        else if (this.FNumber instanceof Long){
            this.FNumber = (T) Long.valueOf(0);
        }
        else if (this.FNumber instanceof Short){
            this.FNumber = (T) Short.valueOf((short) 0);
        }
        else if (this.FNumber instanceof Byte){
            this.FNumber = (T) Byte.valueOf((byte)0);
        }
    }

    public TMemory(){
        setDefaultFNumber();
        this.FState = false;
    }

    public T getFNumber() {
        this.FState = true;
        return FNumber;
    }

    public void setFNumber(T FNumber) {
        this.FNumber = FNumber;
        this.FState = true;
    }

    public boolean getState(){
        return FState;
    }

    public void setFState(boolean FState) {
        this.FState = FState;
    }

    public void addFNumber(T secondNumber){

        double result = this.FNumber.doubleValue() + secondNumber.doubleValue();

        if (this.FNumber instanceof Integer){
            this.FNumber = (T) Integer.valueOf((int)result);
        } else if (this.FNumber instanceof Double){
            this.FNumber = (T) Double.valueOf(result);
        }
        else if (this.FNumber instanceof Float){
            this.FNumber = (T) Float.valueOf((float)result);
        }
        else if (this.FNumber instanceof Long){
            this.FNumber = (T) Long.valueOf((long)result);
        }
        else if (this.FNumber instanceof Short){
            this.FNumber = (T) Short.valueOf((short)result);
        }
        else if (this.FNumber instanceof Byte){
            this.FNumber = (T) Byte.valueOf((byte)result);
        }
        this.FState = true;
    }

    public void clearFNumber(){
        setDefaultFNumber();
        this.FState = false;
    }

    public String returnFState(){
        if (this.FState){
            return "True";
        }
        else return "False";
    }
}
