package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ReflectionClassAnalyzer {

    public static void main(String[] args) {

        // eject ClassName from commandLine or Console
        String className;
        if (args.length > 0) {
            className = args[0];
        }else{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Class Name: ");
            className = in.next();
        }

        try {
            Class cl = Class.forName(className);
            Class superCl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0 ) System.out.print(modifiers + " ");
            System.out.print("class " + cl.getName());
            // add SuperClass except Object
            if (superCl != null && superCl != Object.class)
                System.out.println(" extends " + superCl.getName());
            // add Interfaces
            Class[] interfacesCl = cl.getInterfaces();
            if (interfacesCl != null){
                System.out.print(" impements ");
                StringBuilder str = new StringBuilder();
                for (Class t : interfacesCl)
                    str.append(t.getName() + ", ");
                str.delete(str.length()-2, str.length());
                System.out.print(str.toString());
            }

            System.out.print("\n{\n");
            System.out.println("//constructor");
            printConstructors(cl);
            System.out.println("\n//methods");
            printMethods(cl);
            System.out.println("\n//fields");
            printFields(cl);
            System.out.println("}");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void printConstructors(Class cl){

        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors){
            String name = c.getName();
            StringBuilder str = new StringBuilder(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length()>0) str.append(modifiers + " ");
            str.append(name + "(");
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) str.append(", ");
                str.append(paramTypes[i].getName());
            }
            str.append(");");
            System.out.println(str.toString());
        }

    }

    public static void printMethods(Class cl){
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods){

            Class returnType = m.getReturnType();
            String name = m.getName();

            StringBuilder str = new StringBuilder(" ");

            String modifiers = Modifier.toString(m.getModifiers());

            if (modifiers.length() > 0) str.append(modifiers + " ");

            str.append(returnType.getName() + " ");
            str.append(name + "(");
            //parameter's type
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i>0) str.append(", ");
                str.append(paramTypes[i].getName());
            }
            str.append(")");
            Class[] exceptions = m.getExceptionTypes();
            for (int i = 0; i < exceptions.length; i++) {
                if (i == 0) str.append(" throws ");
                if (i > 0) str.append(", ");
                str.append(exceptions[i].getName());
            }
            str.append(";");
            System.out.println(str.toString());


        }
    }

    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields){
            StringBuilder str = new StringBuilder(" ");
            Class type = f.getType();
            String name = f.getName();
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length()>0) str.append(modifiers + " ");
            str.append(type.getName() + " " + name + ";");
            System.out.println(str.toString());
        }
    }
}
