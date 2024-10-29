package com.stp.processor;

import com.stp.memory.TMemory;

import static com.stp.processor.TFuncService.functionChooser;
import static com.stp.processor.TOprntService.operationChooser;

public class TProc<T extends Number> {

    private T lop_Res;
    private T rop;
    private TOprtn operation;

    private void setDefaultFNumber(){
        if (this.lop_Res instanceof Integer){
            this.lop_Res = (T) Integer.valueOf(0);
            this.rop = (T) Integer.valueOf(0);
        } else if (this.lop_Res instanceof Double){
            this.lop_Res = (T) Double.valueOf(0);
            this.rop = (T) Double.valueOf(0);
        }
        else if (this.lop_Res instanceof Float){
            this.lop_Res = (T) Float.valueOf(0);
            this.rop = (T) Float.valueOf(0);
        }
        else if (this.lop_Res instanceof Long){
            this.lop_Res = (T) Long.valueOf(0);
            this.rop = (T) Long.valueOf(0);
        }
        else if (this.lop_Res instanceof Short){
            this.lop_Res = (T) Short.valueOf((short) 0);
            this.rop = (T) Short.valueOf((short) 0);
        }
        else if (this.lop_Res instanceof Byte){
            this.lop_Res = (T) Byte.valueOf((byte)0);
            this.rop = (T) Byte.valueOf((byte)0);
        }
    }

    public void setOper(String oper) {
        this.operation.setOperation(oper);
    }

    public String getOper() {
        return this.operation.getOperation();
    }

    public void setLop_Res(T lop_Res) {
        this.lop_Res = lop_Res;
    }

    public T getLop_Res() {
        return lop_Res;
    }

    public void setRop(T rop) {
        this.rop = rop;
    }

    public T getRop() {
        return rop;
    }

    public TProc(){
        setDefaultFNumber();
        operation = new TOprtn();
    }

    public void resetProc(){
        setDefaultFNumber();
        resetOperation();
    }

    public void resetOperation(){
        setOper("None");
    }

    public void performOperation(){
        this.lop_Res = (T) operationChooser(getLop_Res(), getRop(), operation);
    }

    public void performFunction(TFunc func){
        this.rop = (T) functionChooser(rop, func);
    }
}
