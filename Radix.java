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

	public static void radixSortSimple(SortableLinkedList data) {
		SortableLinkedList[] buckets = new SortableLinkedList[10];
		int run = 0;
		int runs = 1;

		for (int index = 0; data.size() > 0;) {
			int currentVal = data.remove(index);
			runs = Math.max(length(currentVal), runs);

			buckets[nth(currentVal, run)].add(currentVal);//Adds the currentValue to the correct bucket.
		}

		run++;
		merge(data, buckets);

		for (; run < runs; run++) {
			buckets = new SortableLinkedList[10];

			for (int index = 0; data.size() > 0;) {
				int currentVal = data.remove(index);
				buckets[nth(currentVal, run)].add(currentVal);//Adds the currentValue to the correct bucket.
			}

			merge(data, buckets);
		}
	}

}
