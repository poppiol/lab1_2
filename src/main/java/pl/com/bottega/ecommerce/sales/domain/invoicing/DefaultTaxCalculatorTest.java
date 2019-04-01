package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DefaultTaxCalculatorTest {

    DefaultTaxCalculator taxCalc;

    @Before
    public void createTax() {
        taxCalc = new DefaultTaxCalculator();
    }

    @Test
    public void calculateTaxFOOD() {
        ProductData pd = new ProductData(Id.generate(), new Money(20, Money.DEFAULT_CURRENCY), "test", ProductType.FOOD, new Date());
        RequestItem ri = new RequestItem(pd, 20, new Money(10, Money.DEFAULT_CURRENCY));
        Tax tax = taxCalc.calculateTax(ri);
        assertThat(tax.getDescription(), is("7% (F)"));
    }

    @Test
    public void calculateTaxDRUG() {
        ProductData pd = new ProductData(Id.generate(), new Money(20, Money.DEFAULT_CURRENCY), "test", ProductType.DRUG, new Date());
        RequestItem ri = new RequestItem(pd, 20, new Money(10, Money.DEFAULT_CURRENCY));
        Tax tax = taxCalc.calculateTax(ri);
        assertThat(tax.getDescription(), is("5% (D)"));
    }

    @Test
    public void calculateTaxSTANDARD() {
        ProductData pd = new ProductData(Id.generate(), new Money(20, Money.DEFAULT_CURRENCY), "test", ProductType.STANDARD, new Date());
        RequestItem ri = new RequestItem(pd, 20, new Money(10, Money.DEFAULT_CURRENCY));
        Tax tax = taxCalc.calculateTax(ri);
        assertThat(tax.getDescription(), is("23%"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateTaxDefault() {
        ProductData pd = new ProductData(Id.generate(), new Money(20, Money.DEFAULT_CURRENCY), "test", ProductType.OTHER, new Date());
        RequestItem ri = new RequestItem(pd, 20, new Money(10, Money.DEFAULT_CURRENCY));
        taxCalc.calculateTax(ri);
    }


}
