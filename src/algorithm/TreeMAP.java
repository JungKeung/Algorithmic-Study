package algorithm;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMAP {
	public static void main(String[] args) {
		 Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
//		 Map<Integer,Integer> map = new TreeMap<Integer,Integer>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				
//				return o1-o2;
//			}
//		
//	    
//	    });

		
		 	map.put(-2, 13);
	        map.put(0,11);
	        map.put(-1, 14);
	        map.put(1, 14);
	        
	        Iterator<Integer> it = map.keySet().iterator();
	        while(it.hasNext()) {
	        	int key = it.next();
	        	System.out.println(key +":"+ map.get(key));
	        }
	}
	
	
}
