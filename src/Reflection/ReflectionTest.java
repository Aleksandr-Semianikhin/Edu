package Reflection;

import java.util.Date;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String test = "test";
        Class classTest = test.getClass();
        System.out.println("Class method getName(): ");
        System.out.println(classTest.getName());
        System.out.println("Class method getCanonicalName(): ");
        System.out.println(classTest.getCanonicalName());

        String className = "java.util.Date";
        Class cl1 = Class.forName(className);
        System.out.println(cl1.getName());

        Class cl2 = Date.class;
        Class cl3 = boolean.class;
        Class cl4 = int.class;
        Class cl5 = Double[].class;
        Class cl6 = double[].class;
        System.out.println("getName() for Double[].class");
        System.out.println(cl5.getName());
        System.out.println("getName() for double[].class");
        System.out.println(cl6.getName());
        System.out.println(Integer[].class.getName());
        System.out.println(int[].class.getName());
        System.out.println(Float[].class.getName());
        System.out.println(float[].class.getName());
        Class clInt1 = Integer[].class;
        Class clInt2 = Integer[].class;
        Integer[] a1 = new Integer[100];
        Number[] a2 = new Number[50];
        System.out.println(a1.getClass() == a2.getClass());
        System.out.println(clInt1 == clInt2);
        System.out.println(clInt1.getClass() == clInt2.getClass());

        Date date = (Date)cl2.newInstance();
        System.out.println("Date: ");
        System.out.println(date);

        TestWithoutNoArgumentConstructor test1 = new TestWithoutNoArgumentConstructor("TestWitArg");
        try{
            TestWithoutNoArgumentConstructor test2 = test1.getClass().newInstance();
            System.out.println(test1);
            System.out.println(test2);
            TestWithoutNoArgumentConstructor test3 = test1.getClass().getConstructor(String.class).newInstance
                    ("Test with class Constructor");
            System.out.println(test3);


        }catch (Exception e){
            System.out.println("Exception: Don't have constructor without arguments");
        }
    }
}

class TestWithoutNoArgumentConstructor {
    String arg1;

    public TestWithoutNoArgumentConstructor(String arg1) {
        this.arg1 = arg1;
    }

    public TestWithoutNoArgumentConstructor(){
        this.arg1 = "Without Argument";
    }

    @Override
    public String toString() {
        return "TestWithoutNoArgumentConstructor{" +
                "arg1='" + arg1 + '\'' +
                '}';
    }
}
