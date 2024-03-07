package bank;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    BankAccount bank;

    @BeforeEach
    void setUp() {
        bank = new BankAccount(0);
    }

    @DisplayName("El metodo deposit debe añadir el dinero indicado a la cuenta")
    @Test
    public void Deposit_IntMoney_AddMoneyToBalance() {

        // Act
        int cantidad = 10000;
        bank.deposit(cantidad);

        // Assert
        assertEquals(cantidad, bank.getBalance());
    }

    @DisplayName("El metodo deposit debe laz una excepcion al introducir una cantidad negativa de dinero")
    @Test
    public void Deposit_NegativeIntMoney_ThrowsException() {

        int cantidad = -10000;

        assertThrows(IllegalArgumentException.class, () -> {
            bank.deposit(cantidad);
        });
    }

    @DisplayName("El metodo withdraw debe retirar el dinero indicado de la cuenta")
    @Test
    public void Withdraw_IntMoney_removeMoneyFromBalance() {

        // Act
        int cantidad = 10000;
        bank.deposit(cantidad);
        bank.withdraw(cantidad);

        // Assert
        assertEquals(0, bank.getBalance());
    }

    @DisplayName("El metodo withdraw debe laz una excepcion al introducir una cantidad negativa de dinero")
    @Test
    public void Withdraw_NegativeIntMoney_ThrowsException() {

        int cantidad = -10000;

        assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw(cantidad);
        });
    }

}