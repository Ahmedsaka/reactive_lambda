import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Reaction {

    public static void main(String[] args) {
        final List<Person> personList = listOfPersons(200);

        personList.stream()
                .filter(person -> person.getSex().equals(Sex.FEMALE))
                .map(Person::toString)
                .forEach(System.out::println);


        System.out.println(
                personList.stream()
                        .filter(person -> person.getSex().equals(Sex.MALE))
                        .count()
        );

        System.out.println(
                personList.stream()
                        .mapToInt(Person::getAge)
                .sum() / personList.size()
        );
    }

    private static String stringUtils(){
        return RandomStringUtils.random(10, true, false);
    }

    private static List<Person> listOfPersons(int num){
        List<Person>  people = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int age = i + 10;
            String mail = ".email.com";
            if (i%2 == 0){
                people.add(new Person(stringUtils(), String.format("%s%s", stringUtils(), mail), age, Sex.MALE));
            }else {
                people.add(new Person(stringUtils(), String.format("%s%s", stringUtils(), mail), age, Sex.FEMALE));
            }
        }
        return people;
    }
}

class Person{
    private String name;
    private String email;
    private Integer age;
    private Sex sex;

    public Person(String name, String email, Integer age, Sex sex) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }
}
