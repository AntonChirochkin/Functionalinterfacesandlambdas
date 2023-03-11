import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;


public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1() {
        System.out.println("Задача №1");

        // Создаем несколько объектов класса
        Number number1 = new Number(-24);
        Number number2 = new Number(10);
        Number number3 = new Number(23);
        Number number4 = new Number(9);
        Number number5 = new Number(29);
        Number number6 = new Number(-78);
        Number number7 = new Number(-96);
        Number number8 = new Number(765);
        Number number9 = new Number(1000);
        Number number10 = new Number(-7);


        // Создаем список
        List<Number> list = new ArrayList<>();

        // Наполняем список объектами
        list.add(number1);
        list.add(number2);
        list.add(number3);
        list.add(number4);
        list.add(number5);
        list.add(number6);
        list.add(number7);
        list.add(number8);
        list.add(number9);
        list.add(number10);

//        list.removeIf(new Predicate<Number>() {
//            @Override
//            public boolean test(Number number) {
//                return number.getNumber() < 0;
//            }
//        });
        list.removeIf(number -> number.getNumber() < 0);

        for (Number number : list) {
            System.out.println(number);
        }
    }

    public static void task2() {
        System.out.println();
        System.out.println("Задача №2");
        Person person1 = new Person("Иванов Иван Иванович");
        Person person2 = new Person("Сидоров Сергей Иванович");
        Person person3 = new Person("Петров Алексей Владимирович");
        Person person4 = new Person("Громов Александр Сергеевич");
        Person person5 = new Person("Исаев Лев Борисович");

        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

//        Consumer<Person> consumer = new Consumer<Person>() {
//            @Override
//            public void accept(Person person) {
//                System.out.println("Приветствую уважаемый " + person.getName() + "!");
//            }
//        };
        Consumer<Person> consumer = (Person person) -> {
            System.out.println("Приветствую уважаемый " + person.getName() + "!");
        };
        // вывод через лямбду
        for (Person person : people) {
            consumer.accept(person);
        }
    }

    public static void task3() {
        System.out.println();
        System.out.println("Задача №3");

        DoubleNumber doubleNumber1 = new DoubleNumber(3.4d);
        DoubleNumber doubleNumber2 = new DoubleNumber(17.7d);
        DoubleNumber doubleNumber3 = new DoubleNumber(67.4d);
        DoubleNumber doubleNumber4 = new DoubleNumber(45.14d);
        DoubleNumber doubleNumber5 = new DoubleNumber(80.41d);

        List<DoubleNumber> list = new ArrayList<>();
        list.add(doubleNumber1);
        list.add(doubleNumber2);
        list.add(doubleNumber3);
        list.add(doubleNumber4);
        list.add(doubleNumber5);

//        Function<DoubleNumber, Long> function = new Function<DoubleNumber, Long>() {
//            @Override
//            public Long apply(DoubleNumber doubleNumber) {
//                return (long) doubleNumber.getNum();
//            }
//        };

        Function<DoubleNumber, Long> function = doubleNumber -> {
            return (long) doubleNumber.getNum();
        };

        for (DoubleNumber doubleNumber : list) {
            System.out.println(function.apply(doubleNumber));
        }
    }

    public static void task4() {
        System.out.println();
        System.out.println("Задача №4");
        Supplier<Integer> randomNumber = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                int num = random.nextInt(100); // Максимальное число для диапазона от 0 до 100
                return num;
            }
        };

        Supplier<Integer> randomNumber1 = () -> {
            Random random = new Random();
            int num = random.nextInt(100); // Максимальное число для диапазона от 0 до 100
            return num;
        };
        System.out.println(randomNumber1.get());
    }

    public static void task5() {
        System.out.println();
        System.out.println("Задача №5");
        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer < 0) {
                    return false;
                }
                return true;
            }
        };
        Function<Integer, Integer> function3 = x -> Math.round(x);
        Function<Integer, Double> function4 = x -> Math.pow(x, 2);
        System.out.println(ternaryOperator(predicate1, function3, function4).apply(9));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}