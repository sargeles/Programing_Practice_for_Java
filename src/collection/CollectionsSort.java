package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {      
	    public static void main(String[] args) {  
	        List<String> lists = new ArrayList<String>();  
	        List<A> list = new ArrayList<A>();  
	        List<B> listB = new ArrayList<B>();  
	        lists.add("5");  
	        lists.add("2");  
	        lists.add("9");  
	        //lists�еĶ���String ������compareTo���������Կ���ֱ�ӵ���sort����������Ȼ˳�����򣬼���������  
	        Collections.sort(lists);  
	          
	        A aa = new A();  
	        aa.setName("aa");  
	        aa.setOrder(1);  
	        A bb = new A();  
	        bb.setName("bb");  
	        bb.setOrder(2);  
	        list.add(bb);  
	        list.add(aa);  
	        //list�еĶ���Aʵ��Comparable�ӿ�  
	        Collections.sort(list);  
	          
	        B ab = new B();  
	        ab.setName("ab");  
	        ab.setOrder("1");  
	        B ba = new B();  
	        ba.setName("ba");  
	        ba.setOrder("2");  
	        listB.add(ba);  
	        listB.add(ab);  
	        //����Collections.sort���ط�����ʵ��  
	        Collections.sort(listB,new Comparator<B>(){  
	            @Override  
	            public int compare(B b1, B b2) {  
	                return b1.getOrder().compareTo(b2.getOrder());  
	            }  
	              
	        });  
	          
	        System.out.println(lists);  
	        System.out.println(list);  
	        System.out.println(listB);  
	          
	    }  
	  
	}  
	  
	class A implements Comparable<A>{  
	    private String name;  
	    private Integer order;  
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	      
	    public Integer getOrder() {  
	        return order;  
	    }  
	    public void setOrder(Integer order) {  
	        this.order = order;  
	    }  
	    @Override  
	    public String toString() {  
	        return "name is "+name+" order is "+order;  
	    }  
	    @Override  
	    public int compareTo(A a) {  
	        return this.order.compareTo(a.getOrder());  
	    }  
	      
	}  
	  
	class B{  
	    private String name;  
	    private String order;  
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	    public String getOrder() {  
	        return order;  
	    }  
	    public void setOrder(String order) {  
	        this.order = order;  
	    }  
	    @Override  
	    public String toString() {  
	        return "name is "+name+" order is "+order;  
	    }  
	}  

