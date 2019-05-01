import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

       Set<Person> set = new HashSet<Person>();

        set.add(new Person ("52", "Neeee"));
        set.add(new Person ("65", "xs"));
        set.add(new Person ("100", "xxx"));

        Iterator<Person> it = set.iterator();

        while(it.hasNext())
        {
            Person person = it.next();
            System.out.println(person);

        }




    }

    private static class Person
    {
        String id;
        String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}
