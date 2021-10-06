package ua.kiev.prog;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Faker faker = new Faker();

        String name = faker.phoneNumber().phoneNumber();

        String streetAddress = faker.address().streetAddress();
        System.out.println(name);
    }
}
