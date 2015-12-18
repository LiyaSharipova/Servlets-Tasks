import java.lang.reflect.Field;

/**
 * Created by Baths on 24.11.2015.
 */
public class MyThread extends Thread {
    @interface Author{
        String name();
        String year();
    }
    protected String s;
    @Author(name = "",year = "")
    @Override
    public void run (){
        System.out.println("THREAD IS COMING! ");
    }

    public static void main(String[] args) {
//        (new MyThread()).start();
        String s=new String();
        Class c=s.getClass();
        Class c1=MyThread.class;
        Class c2=Author.class;
        Field[] fields = c1.getFields(); for (Field field : fields) { System.out.println(field.getName()); System.out.println(field.getType()); }
//        System.out.println(c2.isAnnotation());
    }
}
