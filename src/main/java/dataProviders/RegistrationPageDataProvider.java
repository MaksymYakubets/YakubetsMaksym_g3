package dataProviders;

import com.github.javafaker.Faker;
import model.AccountBuilder;
import org.testng.annotations.DataProvider;

public class RegistrationPageDataProvider {
    public Faker faker = new Faker();

    @DataProvider
    public Object[][] registrationNewUser() {
        return new Object[][]{
                {
                        new AccountBuilder()
                                .withGender("1")
                                .withFirstCustomerName(faker.name().firstName())
                                .withLastCustomerName(faker.name().lastName())
                                .withEmail(faker.number().digits(5)+faker.internet().emailAddress())
                                .withPassword(faker.internet().password(8, 12, true, true))
                                .withBirthDay("10")
                                .withBirthdayMonth("3")
                                .withBirthdayYear("1985")
                                .withFirstName(faker.name().firstName())
                                .withLastName(faker.name().lastName())
                                .withCompany(faker.company().name())
                                .withAddress1(faker.address().streetName())
                                .withAddress2(faker.address().streetName())
                                .withCity(faker.address().cityName())
                                .withState("New York")
                                .withPostCode(faker.number().digits(5))
                                .withCountry("United States")
                                .withPhoneMobile(faker.number().digits(10))
                                .withAlias(faker.name().username())
                                .build()
                }
        };
    }
}
