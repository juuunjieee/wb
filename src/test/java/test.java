import com.ulwx.tool.SnowflakeIdWorker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	 
	public static <T> List<T> compare(T[] t1, T[] t2) {
		List<T> list1 = Arrays.asList(t1);
		List<T> list2 = new ArrayList<T>();
		for (T t : t2) {
		if (!list1.contains(t)) {
		list2.add(t);
		}
		}
		return list2;
		}
	
	
	public static <T> List<T> compare(T[] t1, T[] t2,T[] t3) {
		List<T> list1 = Arrays.asList(t1);
		List<T> list2 = new ArrayList<T>();
		List<T> list3 = Arrays.asList(t3);
		List<T> list4 = new ArrayList<T>();
		
		for (T t : t2) {
			if (!list1.contains(t)) {
			list2.add(t);
			}
		}
		
		for (T t : list1) {
			list2.add(t);
		}
		
	/*	for (T t : list3) {
			if (!list2.contains(t)) {
				list4.add(t);
			}
		}
		for (T t : list2) {
			list4.add(t);
		}*/
		
		return list2;
	}
	 public static void main(String[] args) throws Exception { 
		 
		/* List<Integer> list2 = compare(new Integer[] {1, 2, 3, 1, 1}, new Integer[] {0, 0, 0, 0, 1},
				 new Integer[] {0, 0, 0, 0, 1});
		 //1 2,3,4,5,7,8
		 Integer[] a = new Integer[] {1, 2, 3, 1, 1};
		 Integer[] b = new Integer[] {5,4};
		 Integer[] c = new Integer[] {12,1,2,4};
		 
		 Integer[] result = concatAll(a,b,c); 
		 for(int i=0;i<result.length;i++){
			 System.out.print(","+result[i]);
		 }*/
		 
		System.out.println(SnowflakeIdWorker.instance.nextId());
		
		
	 }    
	 public static <T> T[] concatAll(T[] first, T[]... rest) {  
		  int totalLength = first.length;  
		  for (T[] array : rest) {  
		    totalLength += array.length;  
		  }  
		  T[] result = Arrays.copyOf(first, totalLength);  
		  int offset = first.length;  
		  for (T[] array : rest) {  
		    System.arraycopy(array, 0, result, offset, array.length);  
		    offset += array.length;  
		  }  
		  return result;  
		} 
}
