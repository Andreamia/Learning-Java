import java.util.Scanner;
// sort array elements in ascending order by Insertion Sort method
public class SortInsertionAscend {

	public static void main(String[] args) {
		
		int a[] = {31, 41, 59, 26, 41, 58}; //{5, 2, 4, 6, 1, 3};
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		
		int value, previousIndex;
		
		for (int currentIndex = 1; currentIndex < a.length; currentIndex++) {
			value = a[currentIndex];
			previousIndex = currentIndex - 1;
			
			while (previousIndex >= 0 && a[previousIndex] > value) {
				a[previousIndex + 1] = a[previousIndex];
				previousIndex--;
			}
			a[previousIndex+1] = value;
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();

	}

}
