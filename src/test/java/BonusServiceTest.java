import org.example.BonusService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 100;
        boolean registered = false;
        long expected = 1;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 100000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateCancellationOfPurchaseForRegistered() {
        BonusService service = new BonusService();

        long amount = -10000;
        boolean registered = true;
        long expected = -300;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateCancellationOfPurchaseForUnregistered() {
        BonusService service = new BonusService();

        long amount = -3000;
        boolean registered = true;
        long expected = -90;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

}