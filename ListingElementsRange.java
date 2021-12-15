package uni;
import java.util.Arrays;
public class ListingElementsRange {
	static void printMissing(int ar[], int low, int high)
	{
		Arrays.sort(ar);
		
		int index = ceilindex(ar, low, 0, ar.length - 1);
		int x = low;

		while (index < ar.length && x <= high) {
			
			if (ar[index] != x) {
				System.out.print(x + " ");
			}
			else
				index++;
			x++;
		}
		while (x <= high) {
			System.out.print(x + " ");
			x++;
		}
	}
	static int ceilindex(int ar[], int val, int low, int high)
	{

		if (val < ar[0])
			return 0;
		if (val > ar[ar.length - 1])
			return ar.length;

		int mid = (low + high) / 2;
		if (ar[mid] == val)
			return mid;
		if (ar[mid] < val) {
			if (mid + 1 < high && ar[mid + 1] >= val)
				return mid + 1;
			return ceilindex(ar, val, mid + 1, high);
		}
		else {
			if (mid - 1 >= low && ar[mid - 1] < val)
				return mid;
			return ceilindex(ar, val, low, mid - 1);
		}
	}
	public static void main(String[] args)
	{
		int arr[] = { 1, 3, 5, 4 };
		int low = 1, high = 10;
		printMissing(arr, low, high);
	}


}
