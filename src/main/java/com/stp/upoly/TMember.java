package com.stp.upoly;

import com.stp.Main;

public class TMember {

    private int fcoeff;
    private int fdegree;

    public TMember(){
        this.fcoeff = 0;
        this.fdegree = 0;
    }

    public TMember(int c, int n){
        this.fcoeff = c;
        this.fdegree = n;
    }

    public int calculate(int x){
        int powResult = (int) Math.pow(x, this.fdegree);
        return this.fcoeff * powResult;
    }

    public boolean isEqual(TMember q){
        if (q.fcoeff == this.fcoeff && q.fdegree == this.fdegree){
            return true;
        }
        return false;
    }

    public TMember findDiff(){
        TMember answer = new TMember();

        if (this.fdegree == 0){
            return new TMember();
        }

        answer.fcoeff = this.fcoeff * this.fdegree;
        answer.fdegree = this.fdegree - 1;
        return answer;
    }

    public int getFcoeff() {
        return fcoeff;
    }

    public void setFcoeff(int c) {
        this.fcoeff = c;
    }

    public int getFdegree() {
        return fdegree;
    }

    public void setFdegree(int n) {
        this.fdegree = n;
    }

    @Override
    public String toString() {
        if (fdegree == 0) {
            return String.valueOf(fcoeff);
        } else if (fdegree == 1) {
            return fcoeff + "x";
        } else {
            return fcoeff + "x^" + fdegree;
        }
    }
}
