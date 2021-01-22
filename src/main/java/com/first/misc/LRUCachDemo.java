package com.first.misc;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCachDemo {
 public static void main(String aa[]){
     LRUCache<String, String> lruCache = new LRUCache<>(3);
     lruCache.cacheable("test", "test");
     lruCache.cacheable("test1", "test1");
     lruCache.cacheable("test2", "test2");
     lruCache.cacheable("test3", "test3");
     lruCache.cacheable("test4", "test4");
     lruCache.cacheable("test", "test");


     System.out.println(lruCache.toString());

     CustomLRUCache ccach = new CustomLRUCache(3);
     ccach.cacheable("test", "test");
     ccach.cacheable("test1", "test1");
     ccach.cacheable("test2", "test2");
     ccach.cacheable("test3", "test3");
     ccach.cacheable("test4", "test4");
     ccach.cacheable("test", "test");

     System.out.println(ccach.toString());
 }
}

class LRUCache<K, T>{
    private Map<K,T> cache;
    private int windowSize;

    public LRUCache( final int windowSize) {
        this.windowSize = windowSize;
        this.cache = new LinkedHashMap<K, T>(){

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, T> eldest) {
                return size() > windowSize;
            }
        };

    }


    // put data in cache
    public void cacheable(K key, T data){
        // check key is exist of not if exist than remove and again add to make it recently used
        // remove element if window size is exhaust
        if(cache.containsKey(key)){
            cache.remove(key);
        }

        cache.put(key,data);

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "cache=" + cache.toString() +
                ", windowSize=" + windowSize +
                '}';
    }
}

// just customize the Linked HashMap
class CustomLRUCache<K, T> extends LinkedHashMap<K, T>{
    private int windowSize;

    public CustomLRUCache( final int windowSize) {
        this.windowSize = windowSize;


    }
    @Override
    protected  boolean removeEldestEntry(Map.Entry<K,T> eldest) {
        return  size()>windowSize;
    }
    // put data in cache
    public void cacheable(K key, T data){
        // check key is exist of not if exist than remove and again add to make it recently used
        // remove element if window size is exhaust
        if(containsKey(key)){
           remove(key);
        }
        put(key,data);

    }

}


