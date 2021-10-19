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
                                .withGender("Mr.")
                                .withFirstCustomerName("Maxym")
                                .withLastCustomerName("Yakubets")
                                .withEmail(faker.internet().emailAddress())
                                .withPassword(faker.internet().password(8, 12, true, true))
                                .withBirthDay("10")
                                .withBirthdayMonth("3")
                                .withBirthdayYear("1985")
                                .withFirstName("Max")
                                .withLastName("Yakubets")
                                .withCompany("Raif")
                                .withAddress1("Kyiv-street, 14")
                                .withAddress2("Kyiv-street, 14")
                                .withCity("New York")
                                .withState("New York")
                                .withPostCode(faker.number().digits(5))
                                .withCountry("United States")
                                .withPhoneMobile(faker.number().digits(10))
                                .withAlias("Hello!")
                                .build()
                }
        };
    }
}
