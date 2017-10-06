package array;

public class array_605 {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int max = 0;
		int count = 0;
		int i = 0;
		while (i < flowerbed.length ) {
			while (i < flowerbed.length  && flowerbed[i] == 0) {
				count++;
				i++;
			}
			while (count > 0) {
				if (i - count == 0 || i == flowerbed.length)
					max += count / 2;
				else
					max += (count + 1) / 2 - 1;
				count=0;
			}
			
			while (i < flowerbed.length&& flowerbed[i] != 0)
				i++;
		}
		return n <= max;

	}

	public static void main(String[] args) {
		int[] a = {0};
		System.out.println(canPlaceFlowers(a, 1));
	}

}
