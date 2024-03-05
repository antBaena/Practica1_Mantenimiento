package bank;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class BankTest {
    BankAccount bank;
    @BeforeEach
    void setUp() {
        bank = new BankAccount(0);
    }

    @Test
    public void testPayment() {


        // Act
        int cantidad = 10000;
        bank.deposit(cantidad);

        // Assert
        assertEquals(cantidad, bank.getBalance());
    }

   
}