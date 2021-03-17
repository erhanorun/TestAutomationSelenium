package gittigidiyor;

import org.junit.Test;

public class Tests extends BaseTest{
    TaskMethods taskMethods;

    @Test
    public void testWorkAssignment(){
        taskMethods = new TaskMethods(driver);
        taskMethods.navigateToMainPage();
        taskMethods.login();
        taskMethods.moveTo2ndPage();
        taskMethods.addProductToCart();
    }

}
