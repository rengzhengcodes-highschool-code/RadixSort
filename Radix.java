public class Radix {

	public static int nth (int n, int col) {
		return Math.abs((n / (int)Math.pow(10, col)) % 10);
	}

	public static int length (int n) {
		if (n == 0) {//Accounts for logbase(0) which is always undefined (returns POSITIVE_INFINITY in the function's case.
			return 1;
		} else {
			return (int)(Math.log10(Math.abs(n)) + 1);//log10 isn't real on negative n.
		}
	}

	public static void merge (SortableLinkedList original, SortableLinkedList[] buckets) {
		for (SortableLinkedList bucket : buckets) {
			original.extend(bucket);
		}
	}

}
