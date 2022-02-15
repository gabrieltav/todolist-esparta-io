package teste_de_logica_distinct;

/**
 * 
 * @author Gabriel Tavares
 * Class Solution
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {2, 1, 1, 2, 3, 1}; // values ​​from my array
		int array_size = array.length;
		System.out.println("Distinct elements: " +  getDistinctElements(array, array_size) + " ");
	}
	
	static int getDistinctElements(int array[], int array_size) {
		int result = 1;
		
		for (int i = 1; i < array_size; i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if(array[i] == array[j]) {
					break;
				}
			}
			if (i == j) {
				result ++;
			}
		}
		return result;
    }
}
