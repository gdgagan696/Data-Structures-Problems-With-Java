package dsquestions.stacks;

public class BackSpaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int size = s1.length();
            if (ch == '#' && size > 0) {
                s1.deleteCharAt(size - 1);
            } else if(ch!='#') {
                s1.append(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            int size = s2.length();
            if (ch == '#' && size > 0) {
                s2.deleteCharAt(size - 1);
            } else if(ch!='#') {
                s2.append(ch);
            }
        }
        return s1.toString().equals(s2.toString());
    }

    public static void main(String[]args){
        System.out.println(backspaceCompare("y#fo##f","y#f#o##f"));
    }
}
