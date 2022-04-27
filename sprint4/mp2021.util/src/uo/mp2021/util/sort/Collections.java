package uo.mp2021.util.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Collections {
	
	public static<T> void sort(java.util.List<T> list) {
		List<T> sorted = new ArrayList<T>();
		for (T element : list) {
			int pos = findPositionInSorted(element, sorted);
			sorted.add(pos, element);
		}
		copyInList(sorted, list);
	}
	
	public static<T> void sort(List<T> list, Comparator<T> comparator) {
		List<T> sorted = new java.util.ArrayList<T>();
		for (T element : list) {
			int pos = findPositionInSorted(element, sorted, comparator);
			sorted.add(pos, element);
		}
		copyInList(sorted, list);
	}

	@SuppressWarnings("unchecked")
	private static<T> int findPositionInSorted(T element, List<T> sorted) {
		for (int i = 0; i <sorted.size(); i++) {
			if (((Comparable<T>) sorted.get(i)).compareTo(element) > 0) {
				return i;
			}
			
		}
		return sorted.size();
	}
	
	private static<T> int findPositionInSorted(T element, List<T> sorted, Comparator<T> comparator) {
		for (int i = 0; i <sorted.size(); i++) {
			if (comparator.compare(sorted.get(i), element) > 0) {
				return i;
			}
			
		}
		return sorted.size();
	}
	
	private static<T> void copyInList(List<T> origin, List<T> destination) {
		destination.clear();
		for (T element : origin) {
			destination.add(element);
		}
		
	}
	
}
