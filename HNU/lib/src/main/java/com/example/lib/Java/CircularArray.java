package com.example.lib.Java;

import java.util.Iterator;

/**
 * Created by martinwang on 2018/9/2.
 */

public class CircularArray<T> implements Iterable<T> {
    private T[] items;
    private int head = 0;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator<T>(this);
    }

    private class CircularArrayIterator<E> implements Iterator<E> {
        private int _current = -1;
        private E[] _items;

        public CircularArrayIterator(CircularArray<E> array) {
            _items = array.items;
        }

        @Override
        public boolean hasNext() {
            return _current < items.length - 1;
        }

        @Override
        public E next() {
            _current++;
            E item= (E)_items[convert(_current)];
            return item;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException("..");
        }
    }
}
