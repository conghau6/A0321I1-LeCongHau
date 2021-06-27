package _5_access_modifier_static_method_static_property.thuc_hanh.access_modifier._private;

class A{
    private int data = 40;
    private void msg(){
        System.out.println("Hello java");
    }
}
public class Simple {
    public static void main(String[] args) {
        A obj = new A();
//        System.out.println(obj.data); //Compile time error
//        obj.msg(); //Compile time error
    }
}
