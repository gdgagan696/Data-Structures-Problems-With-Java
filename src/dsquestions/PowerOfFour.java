package dsquestions;

public class PowerOfFour {

	private static boolean isPowerOfFour(int num) {
		if (num == 0) {
			return false;
		}
		int pow = (int) (Math.log(num) / Math.log(4));
		if (num == Math.pow(4, pow)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isPowerofFour_BitManipulation(int num) {
		int count=0;
		for(int i=0;i<32;i++) {
			if(((num>>>i) & 1)!=0){
				count++;
				if(i%2==1) {
					return false;
				}
			}
		}
		return count==1;
		
	}
	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerofFour_BitManipulation(116));

	}

}
