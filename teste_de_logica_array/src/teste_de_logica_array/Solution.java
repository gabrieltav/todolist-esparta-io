package teste_de_logica_array;

/**
 * 
 * @author Gabriel Tavares
 * Class Solution
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {9, 3, 9, 3, 9, 7, 9}; // values ​​from my array
        int array_size = array.length; // counts the size of my array! Which in this case is equal to 7 = {[0],[1],[2],[3],[4],[5],[6]}
        System.out.println("Element that has no pair: " + getAnElementHasNoPair(array, array_size) + " ");
	}
	
	static int getAnElementHasNoPair(int array[], int array_size)
    {
        // method responsible for traversing all elements 
		// of the array and returns the element that occurs only once
        int result = array[0];
        for (int i = 1; i < array_size; i++)
        	result = result ^ array[i];
     
        return result;
    }
}
