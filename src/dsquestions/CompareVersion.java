package dsquestions;

public class CompareVersion {

	private static int compareVersion(String version1, String version2) {
		String[] version1Array = version1.split("\\.");
		String[] version2Array = version2.split("\\.");

		if (Integer.parseInt(version1Array[0]) > Integer.parseInt(version2Array[0])) {
			return 1;
		}
		if (Integer.parseInt(version1Array[0]) < Integer.parseInt(version2Array[0])) {
			return -1;
		}

		int i = 1;
		while (i < version1Array.length && i < version2Array.length) {
			int n1 = Integer.parseInt(version1Array[i]);
			int n2 = Integer.parseInt(version2Array[i]);
			if (n1 > n2) {
				return 1;
			} else if (n1 < n2) {
				return -1;
			}
			i++;

		}
		if (i == version1Array.length && i == version2Array.length) {
			return 0;
		}
		if (i < version1Array.length) {
			while (i < version1Array.length) {
				if (Integer.parseInt(version1Array[i]) != 0)
					return 1;
				i++;
			}
		} else if (i < version2Array.length) {
			while (i < version2Array.length) {
				if (Integer.parseInt(version2Array[i]) != 0)
					return -1;
				i++;
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		System.out.println(compareVersion("0.1", "1.1"));

	}

}
