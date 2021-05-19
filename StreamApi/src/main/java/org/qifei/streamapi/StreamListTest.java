package org.qifei.streamapi;

import oqg.qifei.entity.*;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 9:56
 * @Description
 */
public class StreamListTest {
    @Test
    public void MapToWarpper() {
        // int -> Integer
        List<Integer> list1 = Arrays.asList(1, 2, 3, 3, 5, 6);
        int[] ints = list1.stream().mapToInt(item -> item).toArray();
        int sum = list1.stream().mapToInt(s -> s).sum();
        IntSummaryStatistics statistics = list1.stream().mapToInt(s -> s).summaryStatistics();
        statistics.getAverage();
        statistics.getCount();
        //statistics.accept(1);
        statistics.getMax();
        statistics.getMin();
        statistics.getSum();
        //statistics.combine(new IntSummaryStatistics());

        Integer sum1 = list1.stream().collect(Collectors.summingInt(i -> i));
        int sum2 = list1.stream().reduce(0, (acc, com) -> acc + com).intValue();
        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);


    }

    @Test
    public void parentDefaultUsed() {
        Parent parent = new ParentImpl();
        parent.welcome();
        assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void childOverrideDefault() {
        Child child = new ChildImpl();
        child.welcome();
        assertEquals("Child: Hi!", child.getLastMessage());
    }

    @Test
    public void concreteBeatsDefault() {
        Parent parent = new OverridingParent();
        parent.welcome();
        assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void concreteBeatsCloserDefault() {
        Child child = new OverridingChild();
        child.welcome();
        assertEquals("Class Parent: Hi!", child.getLastMessage());
    }

    @Test
    public void test1() {
        Teacher t1 = new Teacher() {
            {
                setAge(12);
                setName("Azir");
                setSchool(new ArrayList<School>() {
                    {
                        add(new School(5, "A"));
                        add(new School(6, "B"));
                        add(new School(4, "Z"));
                    }
                });
            }
        };

        Teacher t2 = new Teacher() {
            {
                setAge(15);
                setName("Temmo");
                setSchool(new ArrayList<School>() {
                    {
                        add(new School(7, "C"));
                        add(new School(8, "D"));
                        add(new School(9, "E"));
                    }
                });
            }
        };
        Stream<Teacher> teachers = Arrays.asList(t1, t2).stream();
        Function<Teacher, Long> getCount = teacher -> teacher.getSchool().stream().count();
        Optional<Teacher> optional = teachers.collect(minBy(comparing(getCount)));
        Teacher teacher = optional.get();
        System.out.println(teacher);

    }

    @Test
    public void partitioningBy() {
        List<School> schools = new ArrayList<School>() {
            {
                add(new School(5, "A", true));
                add(new School(5, "C", false));
                add(new School(6, "B", true));
                add(new School(4, "Z", true));
            }
        };
        Map<Boolean, List<School>> collect = schools.stream().collect(Collectors.groupingBy(School::getPrivate));
        Map<Boolean, List<School>> collect1 = schools.stream().collect(Collectors.partitioningBy(School::getPrivate));
        Map<Boolean, List<School>> collect2 = schools.stream().collect(Collectors.partitioningBy(school -> school.getMembers() > 2));
        System.out.println(collect.equals(collect1));

    }

    @Test
    public void test2() {
        List<School> schools = new ArrayList<School>() {
            {
                add(new School(5, "A", true));
                add(new School(5, "C", false));
                add(new School(7, "C", true));
                add(new School(4, "C", false));
                add(new School(6, "B", true));
                add(new School(4, "Z", true));
                add(new School(5, "Z", false));
            }
        };
        Map<String, Long> collect = schools.stream().collect(groupingBy(school -> school.getName(), counting()));
        System.out.println(collect);
    }

    @Test
    public void testStringCombiner() {
        List<School> schools = new ArrayList<School>() {
            {
                add(new School(5, "A", true));
                add(new School(5, "C", false));
                add(new School(7, "C", true));
                add(new School(4, "C", false));
                add(new School(6, "B", true));
                add(new School(4, "Z", true));
                add(new School(5, "Z", false));
            }
        };
        String collect = schools.stream().map(School::getName).collect(joining());
        String collect11 = schools.parallelStream().map(School::getName).collect(joining(", ", "[", "]"));
        String collect1 = schools.stream().map(School::getName).collect(new StringCollector(",", "[", "]"));
        String collect2 = schools.stream().map(School::getName).reduce(new StringCombiner(",", "[", "]"), StringCombiner::add, StringCombiner::merge).toString();
//        String collect22 = schools.parallelStream().map(School::getName).reduce(new StringCombiner(",", "[", "]"), StringCombiner::add, StringCombiner::merge).toString(); // 有问题
        StringBuilder reduced = schools.stream().map(School::getName).reduce(new StringBuilder(), (builder, name) -> {
            if (builder.length() > 0) {
                builder.append(",");
            }
            builder.append(name);
            return builder;
        }, (left, right) -> left.append(right));
        reduced.insert(0, "[");
        reduced.append("]");
        String collect3 = reduced.toString();

        System.out.println(collect);
        System.out.println(collect11);
        System.out.println(collect1);
        System.out.println(collect2);
//        System.out.println(collect22);
        System.out.println(collect3);
    }

    @Test
    public void test3() {
        String s = "";
        Objects.requireNonNull(s, "s 不能为null"); // s = null -> java.lang.NullPointerException: s 不能为null
    }

    @Test
    public void test4() {
        String[] strings = new String[8];
        System.out.println(strings.length);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testParallelStream() {
        int[] ints = IntStream.range(0, 100).parallel().filter(i -> i > 50).toArray();
        System.out.println(Arrays.toString(ints));
        System.out.println(ints.length);

    }

    @Test
    public void test5() {
        double[] values = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
        int n = 4;
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n - 1;//3
        double[] avgs = IntStream.range(start, sums.length).mapToDouble(i -> {
            double prefix = i == start ? 0 : sums[i - n];
            return (sums[i] - prefix) / n;
        }).toArray();
        System.out.println(Arrays.toString(sums));
        System.out.println(Arrays.toString(avgs));
    }

    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        list.stream().peek(i -> {
            System.out.println(i);
        }).collect(Collectors.toSet()); // peek操作可用于中间操作，类似forEach,但会返回stream,用于后续操作

        Teacher t1 = new Teacher();
        t1.startTeaching(name -> {
            if (name.contains("11")) {
                System.out.println("We made it!");
            }
        });

    }

    @Test
    public void test7() {
        ThreadLocal<DateFormat> localFormatter = ThreadLocal.withInitial(() -> new SimpleDateFormat());
        DateFormat dateFormat = localFormatter.get();

    }

    @Test
    public void test8() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,7,8,2,4,2,65,8,9,7,45,655634,232);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.forEach(item -> {
            list1.add(item);
        });
        list.parallelStream().forEach(item -> {
            System.out.println(item);
            list2.add(item);
        });
        System.out.println("******" + list.size());
        System.out.println("******" + list1.size());
        System.out.println("******" + list2.size());
    }

    @Test
    public void test9() throws InterruptedException {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers =
                new ArrayList<>(Arrays.asList(intArray));
        List<Integer> parallelStorage = new ArrayList<>();//Collections.synchronizedList(new ArrayList<>());
        listOfIntegers
                .parallelStream()
                // Don't do this! It uses a stateful lambda expression.
                .map(e -> {
                    parallelStorage.add(e);
                    return e;
                })
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Sleep 5 sec");
        TimeUnit.SECONDS.sleep(5);
        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));

    }

    @Test
    public void test10() {
        String[] arr=new String[6];

        System.out.println(arr);
        System.out.println(Arrays.asList(arr));
    }

}
