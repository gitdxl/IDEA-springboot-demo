package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.clone;

public class MyHashTable implements Cloneable{
    Entry entrys[] = new Entry[2];
    class Entry implements Cloneable{
        String key;
        String value;
        Entry next;

        public Entry(String key, String value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        protected Entry clone() throws CloneNotSupportedException {
            Entry clone = (Entry) super.clone();
            clone.next = next == null ? null : next.clone();
            return clone;
        }
    }

    @Override
    public MyHashTable clone() throws CloneNotSupportedException {
        MyHashTable clone = (MyHashTable) super.clone();
        for (int i = 0; i < clone.entrys.length; i++) {
            clone.entrys[i] = clone.entrys[i].clone();
        }
        return clone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MyHashTable ht = new MyHashTable();
        MyHashTable.Entry e02 =  ht.new Entry("02","02",null);
        MyHashTable.Entry e01 =  ht.new Entry("02","02",e02);
        MyHashTable.Entry e12 =  ht.new Entry("02","02",null);
        MyHashTable.Entry e11 =  ht.new Entry("02","02",e12);
        ht.entrys[0] = e01;
        ht.entrys[1] = e11;
        MyHashTable clone = ht.clone();

    }

}
class AA extends MyHashTable implements Cloneable{

}
