import com.shestakam.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alexandr on 1.7.15.
 */
public class CalculatorTest {

   /* @Test
    public void setOperandTest(){
        Calculator calculator = new Calculator();

    }*/

    /*@Test
    public void callOperationTest(){
        Calculator calculator = new Calculator();

    }*/

    @Test
    public void testOperation1(){
        Calculator calculator = new Calculator();
        calculator.setOperand(3);
        calculator.setOperation("+");
        calculator.setOperand(12);
        Number expected = 15;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

   }

    @Test
    public void testOperation2(){
        Calculator calculator = new Calculator();
        calculator.setOperand(3);
        calculator.setOperation("+");
        Number expected = 6;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testOperation3(){
        Calculator calculator = new Calculator();
        calculator.setOperand(12);
        calculator.setOperation("*");
        Number expected = 144;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testOperation4(){
        Calculator calculator = new Calculator();
        calculator.setOperand(18.4);
        calculator.setOperation("-");
        calculator.setOperand(2.1);
        Number expected = 16.3;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testOperation5(){
        Calculator calculator = new Calculator();
        calculator.setOperand(155);
        calculator.setOperation("/");
        calculator.setOperand(5);
        Number expected = 31;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

}
