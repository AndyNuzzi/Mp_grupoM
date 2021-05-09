package Client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LogInManageTest {

    public Access doOperation(int loginOption) {
        Access access = null;
        switch (loginOption) {
            case 1:
                access = new LogIn();
                break;
            case 2:
                access = new RegisterAsClient();
                break;
        }
        return access;
    }

    @Test
    public void doOperationTest() {
        boolean passed = true;
        if (!this.doOperation(1).getClass().getSimpleName().equals("LogIn"))
            passed = false;
        if (!this.doOperation(2).getClass().getSimpleName().equals("RegisterAsClient"))
            passed = false;
        if (this.doOperation(3) != null)
            passed = false;
        assertTrue (passed);
    }
}
