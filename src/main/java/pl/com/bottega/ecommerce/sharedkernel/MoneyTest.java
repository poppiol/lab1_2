package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void multiplyTwoPositiveMoney() {
        Money money = new Money(5,"EUR");
        Money money1 = new Money(50, "EUR");
        assertThat(money.multiplyBy(10), is(money1));
    }

    @Test
    public void multiplyTwoNegativeMoney() {
        Money money = new Money(-5,"EUR");
        Money money1 = new Money(-50, "EUR");
        assertThat(money.multiplyBy(10), is(money1));
    }

    @Test
    public void addTwoPositiveMoney() {
        Money money = new Money(5,"EUR");
        Money money1 = new Money(10, "EUR");
        assertThat(money.add(money), is(money1));
    }

    @Test
    public void addTwoNegativeMoney() {
        Money money = new Money(-5,"EUR");
        Money money1 = new Money(-10, "EUR");
        assertThat(money.add(money), is(money1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTwoMoneyWithWrongCurrencyCode() {
        Money money = new Money(-5,"USD");
        Money money1 = new Money(-10, "EUR");
        money.add(money1);
    }

    @Test
    public void substractTwoPositiveMoney() {
        Money money = new Money(5,"EUR");
        Money money1 = new Money(0, "EUR");
        assertThat(money.subtract(money), is(money1));
    }

    @Test
    public void substractTwoNegativeMoney() {
        Money money = new Money(-5,"EUR");
        Money money1 = new Money(0, "EUR");
        assertThat(money.subtract(money), is(money1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void substractTwoMoneyWithWrongCurrencyCode() {
        Money money = new Money(5,"EUR");
        Money money1 = new Money(10, "USD");
        money.subtract(money1);
    }

    @Test
    public void moneyIsGratherThanMoney1() {
        Money money = new Money(15,"EUR");
        Money money1 = new Money(10, "EUR");
        assertThat(money.greaterThan(money1), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void moneyIsGratherThanMoney1WithWrongCurrencyCode() {
        Money money = new Money(15,"EUR");
        Money money1 = new Money(10, "USD");
        money.greaterThan(money1);
    }

    @Test
    public void moneyIsGratherThanMoney1ShouldReturnFalse() {
        Money money = new Money(5,"EUR");
        Money money1 = new Money(10, "EUR");
        assertThat(money.greaterThan(money1), is(false));
    }

    @Test
    public void moneyIsLessThanMoney1() {
        Money money = new Money(5,"EUR");
        Money money1 = new Money(10, "EUR");
        assertThat(money.lessThan(money1), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void moneyIsLessThanMoney1WithWrongCurrencyCode() {
        Money money = new Money(15,"EUR");
        Money money1 = new Money(10, "USD");
        money.lessThan(money1);
    }

    @Test
    public void moneyIsLessThanMoney1ShouldReturnFalse() {
        Money money = new Money(15,"EUR");
        Money money1 = new Money(10, "EUR");
        assertThat(money.lessThan(money1), is(false));
    }

    @Test
    public void moneyIsEqualsMoney1() {
        Money money = new Money(10,"EUR");
        Money money1 = new Money(10, "EUR");
        assertThat(money.lessOrEquals(money1), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void moneyIsEqualsMoney1WithWrongCurrencyCode() {
        Money money = new Money(10,"EUR");
        Money money1 = new Money(10, "USD");
        money.lessOrEquals(money1);
    }


}
