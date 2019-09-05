package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("java",25));
        personList.add(new Person("python",12));
        personList.add(new Person("goLang",8));
        personList.add(new Person("js",16));
        personList.add(new Person("c",42));
        personList.add(new Person("c++",32));
        personList.add(new Person("j",19));

        System.out.println(personList.stream().filter(person -> person.getAge()<30).map(person -> person.getName()
        ).collect(Collectors.toList()));
    }
}
