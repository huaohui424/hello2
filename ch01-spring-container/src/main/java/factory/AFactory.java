package factory;

public class AFactory {
    private static A ainstance = new A();

    public static A createA(){
        return ainstance;
    }

    public A createB(){
        return ainstance;
    }

}
