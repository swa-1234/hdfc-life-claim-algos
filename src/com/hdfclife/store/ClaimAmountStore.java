package com.hdfclife.store;

import com.hdfclife.exception.InvalidIndexException;
import com.hdfclife.exception.StoreFullException;

import java.util.Arrays;

public class ClaimAmountStore {

    private int[] data;
    private int size;
    private int lastShiftCount;

    public ClaimAmountStore() {
        data = new int[16];
        size = 0;
        lastShiftCount = 0;
    }

    public void add(int amount) {
        if (size == data.length) {
            throw new StoreFullException("Store is full");
        }

        data[size] = amount;
        size++;
    }

    public void insert(int index, int amount) {

        if (index < 0 || index > size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        if (size == data.length) {
            throw new StoreFullException("Store is full");
        }

        lastShiftCount = 0;

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
            lastShiftCount++;
        }

        data[index] = amount;
        size++;
    }

    public void delete(int index) {

        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;

        data[size] = 0;
    }

    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public int getLastShiftCount() {
        return lastShiftCount;
    }

    public int getSize() {
        return size;
    }
}
