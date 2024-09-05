package telran.cars.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.cars.dao.Garage;
import telran.cars.dao.GarageImpl;
import telran.cars.model.Car;

class GarageTest {
	Garage garage;
	Car[] cars;

	@BeforeEach
	void setUp() throws Exception {
		
		garage = new GarageImpl(5);
		cars = new Car[4];
		cars[0] = new Car("CC5678DD", "Mustang", "Ford", 5.0, "Blue");
		cars[1] = new Car("EE9101FF", "Civic", "Honda", 1.8, "Black");
		cars[2] = new Car("GG1122HH", "Corolla", "Toyota", 1.6, "White");
		cars[3] = new Car("OO9900PP", "Accord", "Honda", 2.4, "Silver");
		for (int i = 0; i < cars.length; i++) {
			garage.addCar(cars[i]);
		}
	}

	@Test
	void testGarageImpl() {
		garage = new GarageImpl(1);
		assertNotNull(garage);
	}

	@Test
	void testAddCar() {
		assertFalse(garage.addCar(cars[0]));
		assertTrue(garage.addCar(new Car("YY3344ZZ", "X5", "BMW", 3.0, "Red")));
		assertFalse(garage.addCar(new Car("EF7788GH", "Q7", "Audi", 3.0, "Grey")));
	}

	@Test
	void testRemoveCar() {
		assertNull(garage.removeCar("1111111"));
		assertEquals(cars[1], garage.removeCar("EE9101FF"));
	}

	@Test
	void testFindCarByRegNumber() {
		Car car = garage.findCarByRegNumber("EE9101FF");
		assertEquals(cars[1], car);
		// TODO mutable
		assertEquals(cars[1].getColor(), car.getColor());
		assertEquals(cars[1].getEngine(), car.getEngine());
		assertEquals(cars[1], garage.findCarByRegNumber(new String("EE9101FF")));
		assertNull(garage.findCarByRegNumber(new String("1111111")));
	}

	@Test
	public void testFindCarsByModel() {
		Car[] expecteds = { cars[2] };
		Car[] actuals = garage.findCarsByModel(new String("Corolla"));
		assertArrayEquals(expecteds, actuals);

		Car[] expecteds1 = {};
		actuals = garage.findCarsByModel(new String("Q7"));
		assertArrayEquals(expecteds1, actuals);
	}

	@Test
	public void testFindCarsByCompany() {
		Car[] expecteds = { cars[1], cars[3] };
		Car[] actuals = garage.findCarsByCompany("Honda");
		assertArrayEquals(expecteds, actuals);

		Car[] expecteds1 = {};
		actuals = garage.findCarsByCompany(new String("Zeekr"));
		assertArrayEquals(expecteds1, actuals);
	}

	@Test
	public void testFindCarsByEngine() {
		Car[] expecteds = { cars[1], cars[2] };
		Car[] actuals = garage.findCarsByEngine(1.5, 2.0);
		assertArrayEquals(expecteds, actuals);

		Car[] expecteds1 = {};
		actuals = garage.findCarsByEngine(0.4, 0.8);
		assertArrayEquals(expecteds1, actuals);
	}

	@Test
	public void testFindCarsByColor() {
		Car[] expecteds = { cars[0] };
		Car[] actuals = garage.findCarsByColor(new String("Blue"));
		assertArrayEquals(expecteds, actuals);

		Car[] expecteds1 = {};
		actuals = garage.findCarsByColor("Yellow");
		assertArrayEquals(expecteds1, actuals);
	}

}
