package com.example.day10;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    public static void main(String[] args) {
        Pair<String, String> pair1 = new Pair<>("key1", "jello");
        System.out.println(pair1.getKey());
        System.out.println(pair1.getValue());
    }
}
