package cn.people.test.controller;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * @author guling
 * @ClassName: TestStream
 * @Description: 测试流(这里用一句话描述这个类的作用)
 * @date 2019/2/1 15:36
 */

public class TestStream
{
    @Test
    public void testStream(){

        List<String> objects = Arrays.asList(new String("123"),new String("1234"),new String("1235"),new String("1236"));
        objects.stream().limit(2).map(x -> {
            System.out.println(x);
            return  x;
        }).collect(Collectors.toList());
    }


    @Test
    public  void  testfile(){
        List<User> users = Arrays.asList(new User("feng", 1), new User("feng", 2),
            new User("feng", 3), new User("feng", 4), new User("feng", 5));
        users.stream().filter(user -> user.getName() == "feng").collect(
            Collectors.toList()).forEach(s -> {
                System.out.println(s);
        });

        users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void testStreamfile(){
        List<User> users = Arrays.asList(new User("feng11", 15), new User("feng1", 21),
            new User("feng4", 3), new User("feng3", 14), new User("feng2", 5));

        users.stream().sorted(Comparator.comparing(user -> {
            return user.getAge();
        })).collect(Collectors.toList()).forEach(x->{

        });



        //users.stream().filter().collect(Collectors.toList()).forEach(System.out::println);

    }
}
class User{
    private  String name;

    private  Integer age;

    public User(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    public User() { }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    @Override public String toString()
    {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
