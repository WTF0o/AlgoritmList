package com.company;

/*
13.	Создать список из заданного количества элементов.
Выполнить циклический сдвиг этого списка на N элементов вправо или влево.
 */

public class MyList<T> {

    private T value;
    private MyList head;
    private MyList tail;
    private MyList next;
    private MyList previous;
    private int index;
    public static int length = 0;

    public T getValue() {
        return value;
    }

    public MyList(T value, int pLength, MyList pTail) {
        this.value = value;
        this.index = pLength;
        this.previous = pTail;
    }

    public MyList() {

    }

    public void add(T value) {
        MyList list = new MyList(value, length, tail);

        if (head == null) head = list;
        else tail.next = list;

        tail = list;

        ++length;
    }

    public void printAll() {
        MyList currentList = head;
        for (int i = 0; i < length; i++) {
            System.out.print(currentList.value);
            currentList = currentList.next;
        }
    }

    public T getByIndex(int pIndex) {
        MyList currentList = head;
        for (int i = 0; i < length; i++)
            if (currentList.index == pIndex) return (T) currentList.value;
            else currentList = currentList.next;

        return null;
    }

    public void removeByIndex(int pIndex) {

        MyList currentList = head;
        MyList previous = null;
        MyList next = currentList.next;

        for (int i = 0; i < length; i++)

            if (currentList.index == pIndex) {
                if (previous != null && next != null) previous.next = next;
                else if (previous != null && next == null) previous.next = null;
                else value = null;

                --length;
                break;
            }

        previous = currentList;
        currentList = currentList.next;
        next = currentList.next;

    }

    public void removeByValue(T pValue) {

        MyList currentList = head;
        MyList previous = null;
        MyList next = currentList.next;

        for (int i = 0; i < length; i++) {

            if (currentList.value == pValue) {
                if (previous != null && next != null) previous.next = next;
                else if (previous != null && next == null) previous.next = null;
                else value = null;

                --length;
                break;
            }

            previous = currentList;
            currentList = currentList.next;
            next = currentList.next;
        }

    }

    public void shift(int n, boolean left) {
        if (left) shiftLeft(n);
        else shiftRight(n);
    }

    private void shiftRight(int n) {
        MyList currentList;
        MyList previousList;

        for (int i = 0; i < n; i++) {
            currentList = tail;
            previousList = tail.previous;
            for (int j = 0; j < length - 1; j++) {
                swapValueLists(currentList, previousList);
                currentList = currentList.previous;
                previousList = previousList.previous;
            }
        }
    }

    private void shiftLeft(int n) {
        MyList currentList;
        MyList nextList;

        for (int i = 0; i < n; i++) {
            currentList = head;
            nextList = head.next;
            for (int j = 0; j < length - 1; j++) {
                swapValueLists(currentList, nextList);
                currentList = currentList.next;
                nextList = nextList.next;
            }
        }
    }

    private void swapValueLists(MyList listA, MyList listB) {
        T buffer = (T) listA.value;

        buffer = (T) listA.value;
        listA.value = listB.value;
        listB.value = buffer;
    }

}
