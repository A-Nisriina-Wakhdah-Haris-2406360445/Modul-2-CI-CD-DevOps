package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
  Car car;

  @BeforeEach
  void setUp() {
    this.car = new Car();
    this.car.setCarId("123-456");
    this.car.setCarName("Toyota");
    this.car.setCarQuantity(12);
    this.car.setCarColor("Black");
  }

  @Test
  void testGetCarId() {
    // positive case
    assertEquals("123-456", this.car.getCarId());

    // negative case
    car.setCarId(null);
    assertNull(car.getCarId());
    assertNotEquals("000-111", null);
  }

  @Test
  void testGetCarName() {

    // positive case
    assertEquals("Toyota", this.car.getCarName());

    // negative case
    car.setCarName(null);
    assertNull(car.getCarName());
    assertNotEquals("Toyota", null);
  }

  @Test
  void testGetCarQuantity() {

    // positive case
    assertEquals(12, this.car.getCarQuantity());

    // negative case
    car.setCarQuantity(0);
    assertEquals(0, this.car.getCarQuantity());
    assertNotEquals(5, this.car.getCarQuantity());
  }

  @Test
  void testGetCarColor() {

    // positive case
    assertEquals("Black", this.car.getCarColor());

    // negative case
    car.setCarColor(null);
    assertNull(this.car.getCarColor());
    assertNotEquals("Black", null);
  }
}
