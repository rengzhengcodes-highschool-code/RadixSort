public class Radix {

	public static int nth (int n, int col) {
		return (n / (int)Math.pow(10, col - 1)) % 10;
	}

	public static int length (int n) {
		return (int)Math.log10(n);
	}

	public static void merge (MyLinkedList original, MyLinkedList[] buckets) {
		for (MyLinkedList bucket : buckets) {
			original.extend(bucket);
		}
	}

}
