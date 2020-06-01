package generics;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Generics07Reflection {

    public static void main(String[] args) {

           Class<Person> personClass=Person.class;
           System.out.println(personClass);



           Class personClass2=null;
           try{
               personClass2=Class.forName("generics.Person");
           }catch (ClassNotFoundException e)
           {
               System.out.println(e.getException());
           }
           System.out.println(personClass2.getName());



            Class<Person> personClass3=null;
            try{
                personClass3=(Class<Person>)Class.forName("generics.Person");
            }catch (ClassNotFoundException e)
            {
                System.out.println(e.getException());
            }
            System.out.println(personClass3.getName()+" "+personClass3.getPackageName());

            System.out.println("Getting fields -->");
            Field[] fields=personClass3.getDeclaredFields();
            for (Field field:fields) {
                field.setAccessible(true);
                System.out.println(field.getName()+"-"+field.getType());

            }

            System.out.println("Getting methods -->");
            Method[] methods=personClass3.getDeclaredMethods();
            for (Method method:methods) {
                method.setAccessible(true);
                System.out.println(method.getName()+"-"+method.getReturnType());
            }


            System.out.println("Class Declared 4th Time -->");
            Class<Person> personClass4=null;
            try{
                personClass4=(Class<Person>)Class.forName("generics.Man");
            }catch (ClassNotFoundException e)
            {
                System.out.println(e.getException());
            }
            System.out.println(personClass4.getSuperclass().getName());
            Class[] class1=personClass4.getInterfaces();
            for (Class class2:class1) {
                System.out.println(class2.getName());
            }
            methods=personClass4.getDeclaredMethods();
            for (Method method:methods) {
                method.setAccessible(true);
                if (method.isAnnotationPresent(MyAnnotation.class))
                    System.out.println("Annotated Method :->"+method.getName()+"-"+method.getReturnType());
            }

    }
}

class  Person{

    private int age;
    private String name;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class Man implements Comparable<Person>, Serializable {

    private int height;
    private String name;

    private int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    @MyAnnotation(name="myannotation")
    public String returnName(){
        return name;
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation{
    public String name();
}
