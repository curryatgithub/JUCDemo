interface Foo{
    public void sayHello();
}
//测试Git push
public class Test{
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("sayHello");
            }
        };
        foo.sayHello();
    }
}