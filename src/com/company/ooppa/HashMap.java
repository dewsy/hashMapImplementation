package com.company.ooppa;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class HashMap<Integer, V> {

    class KeyValue {
        public Integer key;
        public V value;

        public KeyValue(Integer key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private int bucketSize = 16;

    private LinkedList<KeyValue>[] elements = new LinkedList[bucketSize];

    public void add(Integer key, V value) {
        int position = getHash(key);
        if (elements[position] == null) {
            elements[position] = new LinkedList<>();
        }
        LinkedList list = elements[position];
        keyExistenceTester(key, list);
        list.add(new KeyValue(key, value));
        System.out.println(value.toString() +" added!");
        resizeIfNeeded();
    }

    private void keyExistenceTester(Integer key, LinkedList<KeyValue> elements) {
        for (KeyValue keyValue : elements) {
            if (keyValue.key == key) {
                throw new KeyAlreadyExistsException();
            }
        }
    }

    public V getValue(Integer key) {
        int position = getHash(key);
        LinkedList list = elements[position];
        Iterator<KeyValue> iterator = list.iterator();
        while (iterator.hasNext()) {
            KeyValue current = iterator.next();
            if (current.key.equals(key)){
                return current.value;
            }
        }
        throw new NoSuchElementException();
    }

    private int getHash(Integer key) {
        int keyButPrimitive = java.lang.Integer.parseInt(key.toString()); //Java Y U DO THIS?!?!
        return keyButPrimitive % bucketSize;
    }

    private void resizeIfNeeded() {
        if (this.size() > bucketSize * 2 || this.size() < bucketSize / 2) {
            LinkedList<KeyValue> all = kVCollector(elements);
            bucketSize = all.size() > bucketSize * 2 ? bucketSize * 2 : bucketSize / 2;
            elements = new LinkedList[bucketSize];
            for (KeyValue kv : all) {
                this.add(kv.key, kv.value);
            }
        }
        System.out.println("Resized!");
    }


    private int size(){
        int returnNumber = 0;
        for (LinkedList<KeyValue> kv : elements) {
            if (kv != null) {
                returnNumber += kv.size();
            }
        }
        return returnNumber;
    }

    private LinkedList<KeyValue> kVCollector(LinkedList<KeyValue>[] elements) {
        LinkedList<KeyValue> allElements = new LinkedList<>();
        for (LinkedList<KeyValue> list : elements) {
            if (list != null) {
                for (KeyValue kv : list) {
                    allElements.add(kv);
                }
            }
        }
        return allElements;
        }

}
