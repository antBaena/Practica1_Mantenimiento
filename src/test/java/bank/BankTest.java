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
    public void Withdraw_IntMoney_RemoveMoneyFromBalance() {

        // Act
        int cantidad = 10000;
        bank.deposit(cantidad);
        bank.withdraw(cantidad);

        // Assert
        assertEquals(0, bank.getBalance());
    }

    @DisplayName("El metodo withdraw debe retornar false al pedir retirar mas dinero del existente en la cuenta")
    @Test
    public void Withdraw_IntMoney_ReturnFalse() {

        // Act
        int cantidad = 10000;
        bank.deposit(cantidad);

        // Assert
        assertFalse(bank.withdraw(cantidad + 1));
    }

    @DisplayName("El metodo withdraw debe laz una excepcion al introducir una cantidad negativa de dinero")
    @Test
    public void Withdraw_NegativeIntMoney_ThrowsException() {

        int cantidad = -10000;

        assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw(cantidad);
        });
    }

    @DisplayName("El metodo pending debe devolver el monto total si el mes actual es el primero del prestamo")
    @Test
    public void Pending_BeginMonth_ReturnFullRemeaning() {
        // Arrange
        double total_amount = 10000;
        double interest = 0.001;
        int months = 12;
        int currentMonth = 0;

        // Act
        double result = bank.pending(total_amount, interest, months, currentMonth);

        // Assert
        assertEquals(total_amount, (double) result);
    }

    @DisplayName("El metodo pending debe devolver 0 si el mes actual es el ultimo mes del prestamo")
    @Test
    public void Pending_EndMonth_ReturnZeroRemeaning() {
        // Arrange
        double total_amount = 10000;
        double interest = 0.001;
        int months = 12;
        int currentMonth = 12;

        // Act
        double result = bank.pending(total_amount, interest, months, currentMonth);

        // Assert
        assertEquals(0, (int) result);
    }

    // @DisplayName("El metodo payment y pending deben devolver el mismo resultado
    // para los mismos parametros")
    // @Test
    // public void testPaymentAndPending() {
    // // Arrange
    // double total_amount = 10000;
    // double interest = 0.001;
    // int months = 10;
    // int currentMonth = months / 2;

    // // Act
    // double paymentPerMonth = bank.payment(total_amount, interest, months);
    // double total = paymentPerMonth * months;

    // double pendingResult = bank.pending(total, interest, months, currentMonth);
    // // Assert
    // assertEquals(pendingResult, total / 2);
    // }

    @Test
    public void testPaymentWithZeroInterest() {
        // Arrange
        BankAccount bank = new BankAccount(10);
        double total_amount = 10000;
        double interest = 0.00000001;
        int months = 12;

        // Act
        double result = bank.payment(total_amount, interest, months);

        // Assert
        assertEquals(total_amount, (int) (result * months));
    }
}