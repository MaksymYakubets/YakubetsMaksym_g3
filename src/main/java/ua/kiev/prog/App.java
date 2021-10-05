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
       String faker =  new Faker().name().firstName()+new Faker().name().lastName()+
               new Faker().random()+"@gmail.com";
        System.out.println(faker.toString());
    }
}
