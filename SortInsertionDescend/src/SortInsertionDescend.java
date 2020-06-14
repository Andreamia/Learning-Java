import java.util.Scanner;

public class SortInsertionDescend {

	public static void main(String[] args) {
		int[] a = {31, 41, 59, 26, 41, 58}; // {5, 2, 4, 6, 1, 3};
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		
		int value, previousIndex;
		
		for (int i = 1; i < a.length; i++) {
			value = a[i];
			previousIndex = i - 1;
			while(previousIndex >=0 && a[previousIndex] < value) {
				a[previousIndex + 1] = a[previousIndex];
				previousIndex--;
			}
			a[previousIndex + 1] = value;
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
	}

}
