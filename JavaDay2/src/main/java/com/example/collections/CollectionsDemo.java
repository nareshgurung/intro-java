package com.example.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsDemo {
public static void main(String[] args) {

	//lists
	List<User> userArrayList = new ArrayList<User>();

	//to add to an arralis twe use.add()
	userArrayList.add(new User("summer", "smith", "sssuertime"));
	userArrayList.add(new User("Jerry", "smith", "jsmith"));
	userArrayList.add(new User("Rick", "smith", "ricksmith"));
	
	// we can use these just like array
	for(int i= 0 ; i<userArrayList.size(); i++) {
		System.out.println(userArrayList.get(i));
	}
	List<User> linklistIterator= new LinkedList<User>();
	
	linklistIterator.add(new User("summer", "smith", "sssuertime"));
	linklistIterator.add(new User("Jerry", "smith", "jsmith"));
	linklistIterator.add(new User("Rick", "smith", "ricksmith"));
	
	Iterator<User> iter = linklistIterator.iterator();
	
	System.out.println("lisnkedlist eterator");
	
	while(iter.hasNext()) {
	System.out.println(iter.next());
	}
	System.out.println();
	
	//Sets
	Set<User> userSet = new HashSet<User>();
	User beth = new User("Beth", "Smith", "beths");
	
	userSet.add(beth);
	//Lets see  what happens if we try to add her twice
	//userSet.add(beth); //This wil lnot add beth a second time
	userSet.add(new User("summer", "smith", "sssuertime"));
	userSet.add(new User("Jerry", "smith", "jsmith"));
	userSet.add(new User("Rick", "smith", "ricksmith"));
	
	System.out.println("Looping throiugh the set");
	for(User user: userSet) {
		System.out.println(user);
	}
	System.out.println();
	
	//Queue and Deqeue
	ArrayDeque<User> userQueue = new ArrayDeque<User>();
	
	// to add a user to the front of the queue use push
	userQueue.push(beth);
	System.out.println(userQueue);
	
	//if we want to add a user to the end of the queue use add
	userQueue.add(new User("jerry", "Smith", "jsmith"));
	System.out.println(userQueue);
	userQueue.push(new User("Rick", "Sanchez", "Ricketrick"));
	System.out.println(userQueue);
	userQueue.add(new User("RSummer", "Smith", "ssumerTime"));
	System.out.println(userQueue);
	
	System.out.println(".....");
//	// we use.pop() to remove an element from the front of the qeue
	User rick = userQueue.pop();
	System.out.println(userQueue);
	
	//We can user removeLast() or .pollLast() will grab the element from the end of the queue
	User summer = userQueue.removeLast();
	System.out.println(userQueue);
	
	System.out.println();
	
	Map<String,User> userMap = new HashMap<String, User>();
	//Use .put() to add to a map 
	userMap.put("Summer", summer);
	userMap.put("Beth", beth);
	userMap.put("Rick", beth);
	
	//use .get(key) to retrieve an element from the map 
	System.out.println(userMap.get("Summer"));
	
	//you cannot directly iterate over a map, but you can iterate over the entrySet 
	//keySet, and the values
	
	Iterator<User> mapValues = userMap.values().iterator();
	while(mapValues.hasNext()) {
		System.out.println(mapValues.next());
	}
	System.out.println();
	
	//The Collections class has useful methods that we can use on collections, includding sorting 
	// In order for collections.sort to work, the object beign sorted in the collection must 
	//implement comparable
	Collections.sort(userArrayList);
	System.out.println(userArrayList);
	System.out.println();
	
//	 treeSet will sort the lements based on the 
	Set<User> userTree = new TreeSet<User>(new UserComparator());
	userTree.add(new User("jerry", "Smith", "jsmith"));
	userTree.add(new User("Rick", "sanchez", "ricketyrick"));
	userTree.add(beth);
	userTree.add(summer);
	userTree.add(new User("morty", "smith", "passdawg"));
	System.out.println(userTree);
	
		
	}
}