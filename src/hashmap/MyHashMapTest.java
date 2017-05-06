package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MyHashMapTest {

    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(null, 90);
        map.put(null, 95);
        
      Iterator iter = map.entrySet().iterator();
      while (iter.hasNext()) {
      Map.Entry entry = (Map.Entry) iter.next();
      Object key = entry.getKey();
      Object val = entry.getValue();
      System.out.println(""+key+val);
      }
    
        System.out.println(map.get(1));
        System.out.println(map.put(2, 85));
        System.out.println(map.get(2));
        System.out.println(map.get(null));
    }
}