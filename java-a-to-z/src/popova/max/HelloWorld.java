package popova.max;

public class HelloWorld {

    static String str = "Value 1";

    public static void changeIt(String s) {
        str = s;
    }

    public static void main(String[] args) {
        changeIt("Value 2");
        System.out.println(str);
    }
}