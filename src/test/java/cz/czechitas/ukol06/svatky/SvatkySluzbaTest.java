package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Month;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {
  private SvatkySluzba svatkySluzba;

  @BeforeEach
  void setUp() throws IOException {
    svatkySluzba = new SvatkySluzba();
  }

  @Test
  void vyhledatSvatkyKeDniJednoJmeno() {
    List<String> result = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(Month.JUNE, 8));
    assertEquals(1, result.size());
    assertEquals("Medard", result.get(0));
  }

  @Test
  void vyhledatSvatkyKeDniViceJmen() {
    List<String> result = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(Month.FEBRUARY, 21));
    assertTrue(result.size() > 1);
    assertEquals("Lenka", result.get(0));
    assertEquals("Eleonora", result.get(1));
  }

  @Test
  void vyhledatSvatkyKeDniNikdoNemaSvatek() {
    List<String> result = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(Month.JANUARY, 1));
    assertTrue(result.isEmpty());
  }

}
