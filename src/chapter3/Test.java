package chapter3;

public class Test {
    public static void main(String[] args) {
        String a = "aaa";
        String b = a;
        String c = new String("aaa");

        System.out.println(a.equals(b)); // true
        System.out.println(a==b); // true
        System.out.println(a==c); // false
        System.out.println(a.equals(c)); // true
    }
}
