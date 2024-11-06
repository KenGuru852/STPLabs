package com.stp.tset;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TSet<T extends Number> implements Iterable<T> {

    private Set<T> tset;

    public Set<T> getTset() {
        return tset;
    }

    public void setTset(Set<T> tset) {
        this.tset = tset;
    }

    public TSet() {
        tset = new LinkedHashSet<>();
    }

    public int size() {
        return tset.size();
    }

    public boolean isEmpty() {
        return tset.isEmpty();
    }

    public boolean contains(Object d) {
        return tset.contains(d);
    }

    public boolean add(T d) {
        return tset.add(d);
    }

    public boolean remove(Object d) {
        return tset.remove(d);
    }

    public void clear() {
        tset.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return tset.iterator();
    }

    public TSet<T> combine(TSet<T> q) {
        TSet<T> newTSet = new TSet<>();

        for (T it : tset) {
            newTSet.add(it);
        }

        for (T it : q) {
            newTSet.add(it);
        }
        return newTSet;
    }

    public T getElement(int j) {
        if (j < 0 || j >= tset.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + j);
        }
        int index = 0;
        for (T it : tset) {
            if (index == j) {
                return it;
            }
            index++;
        }
        return null;
    }

    public TSet<T> subtract(TSet<T> q) {
        TSet<T> subtractedTSet = new TSet<>();
        for (var it : tset) {
            if (!q.contains(it)) {
                subtractedTSet.add(it);
            }
        }
        return subtractedTSet;
    }

    public TSet<T> multiple(TSet<T> q){
        TSet<T> multiplyedTSet = new TSet<>();
        for (var it : tset){
            multiplyedTSet.add(it);
        }
        for (var it : q){
            multiplyedTSet.add(it);
        }
        return multiplyedTSet;
    }
}