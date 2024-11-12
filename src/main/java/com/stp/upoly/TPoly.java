package com.stp.upoly;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TPoly {

    private List<TMember> polynom;

    public TPoly() {
        polynom = new ArrayList<>();
        TMember zeroMember = new TMember();
        polynom.add(zeroMember);
    }

    public TPoly(int c, int n) {
        polynom = new ArrayList<>();
        TMember newMember = new TMember(c, n);
        polynom.add(newMember);
    }

    public int findPolyDegree() {
        return polynom.getFirst().getFdegree();
    }

    public int findPolyCoeff(int n) {
        if (polynom.getFirst().getFdegree() == 0 && polynom.getFirst().getFcoeff() == 0) {
            throw new ArithmeticException("Полином нулевой");
        } else {
            for (var it : polynom) {
                if (it.getFdegree() == n) {
                    return it.getFcoeff();
                }
            }
        }
        return 0;
    }

    public void clear() {
        polynom.clear();
        polynom.add(new TMember());
    }

    public TPoly addPolynom(TPoly q) {
        TPoly answer = new TPoly();
        answer.polynom = this.polynom;

        for (int i = 0; i < q.getPolynom().size(); i++) {
            boolean isFoundDegree = false;
            for (int j = 0; j < answer.getPolynom().size(); j++) {

                int a = q.getPolynom().get(i).getFdegree();
                int b = answer.getPolynom().get(j).getFdegree();
                int aCoeff = answer.getPolynom().get(j).getFcoeff();
                int bCoeff = q.getPolynom().get(i).getFcoeff();
                if (a == b) {
                    isFoundDegree = true;
                    answer.getPolynom().get(j).setFcoeff(aCoeff + bCoeff);
                    break;
                }
            }
            if (!isFoundDegree){
                answer.polynom.add(q.getPolynom().get(i));
            }
        }
        answer.transformation();
        return answer;
    }

    public TPoly mulPolynom(TPoly q) {
        TPoly answer = new TPoly();
        answer.polynom = new ArrayList<>();

        for (TMember thisMember : this.polynom) {
            for (TMember qMember : q.getPolynom()) {
                int newCoeff = thisMember.getFcoeff() * qMember.getFcoeff();
                int newDegree = thisMember.getFdegree() + qMember.getFdegree();
                TMember newMember = new TMember(newCoeff, newDegree);

                boolean isFoundDegree = false;
                for (TMember aMember : answer.getPolynom()) {
                    if (aMember.getFdegree() == newDegree) {
                        isFoundDegree = true;
                        aMember.setFcoeff(aMember.getFcoeff() + newCoeff);
                        break;
                    }
                }
                if (!isFoundDegree) {
                    answer.polynom.add(newMember);
                }
            }
        }
        answer.transformation();
        return answer;
    }

    public TPoly subPolynom(TPoly q) {
        TPoly answer = new TPoly();
        answer.polynom = this.polynom;

        for (int i = 0; i < q.getPolynom().size(); i++) {
            boolean isFoundDegree = false;
            for (int j = 0; j < answer.getPolynom().size(); j++) {

                int a = q.getPolynom().get(i).getFdegree();
                int b = answer.getPolynom().get(j).getFdegree();
                int aCoeff = answer.getPolynom().get(j).getFcoeff();
                int bCoeff = q.getPolynom().get(i).getFcoeff();
                if (a == b) {
                    isFoundDegree = true;
                    answer.getPolynom().get(j).setFcoeff(aCoeff - bCoeff);
                    break;
                }
            }
            if (!isFoundDegree){
                answer.polynom.add(new TMember(-q.getPolynom().get(i).getFcoeff(), q.getPolynom().get(i).getFdegree()));
            }
        }
        answer.transformation();
        return answer;
    }

    public TPoly minusPolinom() {
        TPoly answer = new TPoly();
        answer.polynom = new ArrayList<>();

        for (TMember member : this.polynom) {
            answer.polynom.add(new TMember(-member.getFcoeff(), member.getFdegree()));
        }

        return answer;
    }

    public boolean isEqual(TPoly q){
        if (q.getPolynom().size() != this.getPolynom().size()) return false;

        for (int i = 0; i < q.getPolynom().size(); i++){
            TMember qMember = q.getPolynom().get(i);
            TMember pMember = this.getPolynom().get(i);
            if ((qMember.getFdegree() != pMember.getFdegree()) || (qMember.getFcoeff() != pMember.getFcoeff())){
                return false;
            }
        }
        return true;
    }

    public TPoly diffPoly(){
        TPoly answer = new TPoly();
        for (var it : this.polynom){
            TMember diffs = it.findDiff();
            answer.polynom.add(diffs);
        }
        answer.transformation();
        return answer;
    }

    public int calculate(int x){
        int answer = 0;
        for (var it : polynom){
            answer += it.getFcoeff() * ((int) Math.pow(x, it.getFdegree()));
        }
        return answer;
    }

    public TMember foundByInd(int i){
        return polynom.get(i);
    }

    public void transformation() {
        polynom.sort(Comparator.comparingInt(TMember::getFdegree).reversed());
    }

    public List<TMember> getPolynom() {
        return polynom;
    }

    public void setPolynom(List<TMember> polynom) {
        this.polynom = polynom;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for (TMember member : polynom) {
            if (member.getFcoeff() != 0) {
                if (!isFirst && member.getFcoeff() > 0) {
                    sb.append(" + ");
                } else if (member.getFcoeff() < 0) {
                    sb.append(" - ");
                    member.setFcoeff(-member.getFcoeff());
                }
                sb.append(member.toString());
                isFirst = false;
            }
        }
        return sb.toString();
    }

}
