Hashtable和ConcurrentHashMap都支持并发操作，主要差异就是Hashtable不支持在循环中remove()元素。

说明Hashtable在获得了Iterator对象后，不允许更改其结构，否则出现java.util.ConcurrentModificationException异常
但是ConcurrentHashMap却支持这个功能。
成功但不支持排序
LinkedHashMap虽然能支持顺序性，但又不支持并发。
而又要求排序的情况就可以使用ConcurrentSkipListMap

