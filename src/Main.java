import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        // количество несовершеннолетних
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Несовершеннолетних: " + count);

        // фамилии призывников
        List<String> recruit = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() <= 27)
                .map(Person :: getFamily)
                .collect(Collectors.toList());
        recruit.forEach(System.out::println);

        //отсортиров. по фамилии работоспособные ж/м



    }
}