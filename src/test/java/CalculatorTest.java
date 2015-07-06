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
        Number expected = 12;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

   }
    @Test
    public void testOperation1_2(){
        Calculator calculator = new Calculator();
        calculator.setOperand(3);
        calculator.setOperation("+");
        calculator.setOperand(12);
        Number expected = 15;
        calculator.setOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }

    @Test
    public void testOperation2(){
        Calculator calculator = new Calculator();
        calculator.setOperand(3);
        calculator.setOperation("+");
        Number expected = 3;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testOperation2_2(){
        Calculator calculator = new Calculator();
        calculator.setOperand(3);
        calculator.setOperation("+");
        Number expected = 6;
        calculator.setOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testOperation3(){
        Calculator calculator = new Calculator();
        calculator.setOperand(12);
        calculator.setOperation("*");
        Number expected = 12;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }


    @Test
    public void testOperation3_2(){
        Calculator calculator = new Calculator();
        calculator.setOperand(12);
        calculator.setOperation("*");
        Number expected = 144;
        calculator.setOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testOperation4(){
        Calculator calculator = new Calculator();
        calculator.setOperand(18.4);
        calculator.setOperation("-");
        calculator.setOperand(2.1);
        Number expected = 2.1;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testOperation4_2(){
        Calculator calculator = new Calculator();
        calculator.setOperand(18.4);
        calculator.setOperation("-");
        calculator.setOperand(2.1);
        Number expected = 16.3;
        calculator.setOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }
    @Test
    public void testOperation5(){
        Calculator calculator = new Calculator();
        calculator.setOperand(155);
        calculator.setOperation("/");
        calculator.setOperand(5);
        Number expected = 5;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testOperation5_2(){
        Calculator calculator = new Calculator();
        calculator.setOperand(155);
        calculator.setOperation("/");
        calculator.setOperand(5);
        Number expected = 31;
        calculator.setOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void memoryTest(){
        Calculator calculator = new Calculator();
        calculator.setOperand(15);
        calculator.setOperation("-");
        calculator.setOperand(5);
        calculator.memoryStore();
        calculator.memoryRead();
        calculator.setOperation("*");
        Number expected = 50;
        calculator.setOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void memoryTest_2(){
        Calculator calculator = new Calculator();
        calculator.setOperand(15);
        calculator.setOperation("-");
        calculator.setOperand(5);
        calculator.setOperation("=");
        calculator.memoryStore();
        calculator.memoryRead();
        calculator.setOperation("*");
        Number expected = 100;
        calculator.setOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testFromMatvei1() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.setOperation("*");
        calculator.setOperand(3);
        calculator.setOperation("=");
        calculator.setOperation("=");
        calculator.setOperation("=");
        Number expected = 54;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }

    @Test
    public void testFromMatvei2() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.setOperation("+");
        calculator.setOperand(3);
        calculator.setOperation("/");
        calculator.setOperand(5);
        Number expected = 5;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }

    @Test
    public void testFromMatvei3() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.setOperation("+");
        calculator.setOperand(3);
        calculator.setOperation("/");
        calculator.setOperand(5);
        calculator.setOperation("=");
        Number expected = 1;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }

    @Test
    public void testFromMatvei4() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.setOperation("+");
        calculator.setOperand(3);
        calculator.setOperation("=");
        calculator.setOperand(2);
        calculator.setOperation("+");
        calculator.setOperand(3);
        calculator.setOperation("=");
        Number expected = 5;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }


    @Test
    public void testFromMatvei5() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(3);
        calculator.setOperation("+");
        calculator.setOperand(3);
        calculator.setOperation("=");

        Number expected = 6;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }

    @Test
    public void testFromMatvei6() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.setOperation("+");
        calculator.setOperand(3);
        calculator.setOperation("=");
        calculator.setOperand(4);
        calculator.setOperation("=");
        Number expected = 7;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }







}
