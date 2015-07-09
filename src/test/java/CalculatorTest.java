import com.shestakam.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alexandr on 1.7.15.
 */
public class CalculatorTest {

    @Test
    public void testGetIndicator(){
        Calculator calculator = new Calculator();
        calculator.setOperand(3);
        calculator.callOperation("+");
        calculator.setOperand(12);
        Number expected = 12;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testPlusOperation(){
        Calculator calculator = new Calculator();
        calculator.setOperand(3);
        calculator.callOperation("+");
        calculator.setOperand(12);
        Number expected = 15;
        calculator.callOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testMultiplyOperation(){
        Calculator calculator = new Calculator();
        calculator.setOperand(12);
        calculator.callOperation("*");
        Number expected = 144;
        calculator.callOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testMinusOperation(){
        Calculator calculator = new Calculator();
        calculator.setOperand(18.4);
        calculator.callOperation("-");
        calculator.setOperand(2.1);
        Number expected = 16.3;
        calculator.callOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testDivisionOperation(){
        Calculator calculator = new Calculator();
        calculator.setOperand(155);
        calculator.callOperation("/");
        calculator.setOperand(5);
        Number expected = 31;
        calculator.callOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testMemoryStoreReadOperations(){
        Calculator calculator = new Calculator();
        calculator.setOperand(15);
        calculator.callOperation("-");
        calculator.setOperand(5);
        calculator.callOperation("=");
        calculator.callOperation("*");
        calculator.callOperation("=");
        calculator.memoryStore();
        calculator.setOperand(2);
        calculator.memoryRead();
        calculator.callOperation("*");
        calculator.setOperand(2);
        calculator.callOperation("=");
        Number expected = 200;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }


    @Test
    public void testMemoryReadStoreMultiplyOnYourselfOperations(){
        Calculator calculator = new Calculator();
        calculator.setOperand(15);
        calculator.callOperation("-");
        calculator.setOperand(5);
        calculator.callOperation("=");
        calculator.memoryStore();
        calculator.setOperand(1);
        calculator.setOperand(1);
        calculator.setOperand(1);
        calculator.memoryRead();
        calculator.callOperation("*");
        Number expected = 100;
        calculator.callOperation("=");
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testTripleEquals() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("*");
        calculator.setOperand(3);
        calculator.callOperation("=");
        calculator.callOperation("=");
        calculator.callOperation("=");
        Number expected = 54;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testGetIndicatorWithAnotherOperations() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("+");
        calculator.setOperand(3);
        calculator.callOperation("/");
        calculator.setOperand(5);
        Number expected = 5;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testPlusAndMinusOperationsTogether() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("+");
        calculator.setOperand(3);
        calculator.callOperation("/");
        calculator.setOperand(5);
        calculator.callOperation("=");
        Number expected = 1;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testTwoIndependentOperations() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("+");
        calculator.setOperand(3);
        calculator.callOperation("=");
        calculator.setOperand(2);
        calculator.callOperation("+");
        calculator.setOperand(3);
        calculator.callOperation("=");
        Number expected = 5;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testStrangeOperation() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("+");
        calculator.setOperand(3);
        calculator.callOperation("=");
        calculator.setOperand(4);
        calculator.callOperation("=");
        Number expected = 7;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testFourOperationsOneAfterAnother() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("+");
        calculator.setOperand(3);
        calculator.callOperation("*");
        calculator.setOperand(5);
        calculator.callOperation("-");
        calculator.setOperand(7);
        calculator.callOperation("/");
        calculator.setOperand(2);
        calculator.callOperation("=");
        Number expected = 9;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testManyOperations() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("+");
        calculator.callOperation("-");
        calculator.callOperation("/");
        calculator.callOperation("*");
        Number expected = 2;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }

    @Test
    public void testManyOperations2() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("+");
        calculator.setOperand(3);
        calculator.callOperation("=");
        calculator.callOperation("*");
        calculator.setOperand(2);
        calculator.callOperation("=");
        Number expected = 10;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);

    }

    @Test
    public void testDivOnZero() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.callOperation("/");
        calculator.setOperand(0);
        calculator.callOperation("=");
        Number expected = Double.POSITIVE_INFINITY;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testClearMemory() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.memoryStore();
        calculator.setOperand(3);
        calculator.memoryRead();
        calculator.memoryClear();
        calculator.memoryRead();
        Number expected = 0;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }

    @Test
    public void testMemoryAdd() throws Exception {
        Calculator calculator = new Calculator();
        calculator.setOperand(2);
        calculator.memoryStore();
        calculator.setOperand(3);
        calculator.memoryAdd();
        calculator.memoryRead();
        Number expected = 5;
        Number actual = calculator.getIndicator();
        Assert.assertEquals(expected.doubleValue(),actual.doubleValue(),0.01);
    }


}
