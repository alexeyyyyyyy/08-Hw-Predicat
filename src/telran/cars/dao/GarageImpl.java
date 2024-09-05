package telran.cars.dao;

import java.util.function.Predicate;

import telran.cars.model.Car;

public class GarageImpl implements Garage {
	Car[] cars;
	int size;

	public GarageImpl(int capacity) {
		cars = new Car[capacity];
	}

	@Override
	public boolean addCar(Car car) {
		if (car == null || size == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
			return false;
		}
		cars[size] = car;
		size++;
		return true;
	}

	@Override
	public Car removeCar(String regNumber) {
		for (int i = 0; i < size; i++) {
			if (cars[i].getRegNumber() == regNumber) {
				Car victim = cars[i];
				cars[i] = cars[size - 1];
				cars[size - 1] = null;
				size--;
				return victim;
			}
		}
		return null;
	}

	@Override
	public Car findCarByRegNumber(String regNumber) {
		for (int i = 0; i < size; i++) {
			if (cars[i].getRegNumber().equals(regNumber)) {
				return cars[i];
			}
		}
		return null;
	}
	

	 @Override
	    public Car[] findCarsByModel(String model) {
	       
	        Predicate<Car> PredicateModel = car -> car.getModel().equals(model);
	       
	        return findCarsByPredicate(PredicateModel);
	    }

	 @Override
	    public Car[] findCarsByCompany(String company) {
	        
	        Predicate<Car> PredicateCompany = car -> car.getCompany().equals(company);
	       
	        return findCarsByPredicate(PredicateCompany);
	    }

	@Override
	public Car[] findCarsByEngine(double min, double max) {
		
		Predicate<Car> PredicateEngine = car -> {
			double EngineMinAndMax = car.getEngine();
			return EngineMinAndMax >= min && EngineMinAndMax < max;
		};
		
		return findCarsByPredicate(PredicateEngine);
	}

		
//		Car[] res;
//		int counter = 0;
//		for (int i = 0; i < size; i++) {
//			if (cars[i].getEngine() >= min && cars[i].getEngine() < max) {
//				counter++;
//			}
//		}
//		res = new Car[counter];
//		int j = 0;
//		for (int i = 0; i < size; i++) {
//			if (cars[i].getEngine() >= min && cars[i].getEngine() < max) {
//				res[j++] = cars[i];
//			}
//		}
//		return res;
	

	private Car[] findCarsByPredicate(Predicate<Car> predicate) {
		Car[] res;
		int counter = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(cars[i])) {
				counter++;
			}
		}
		res = new Car[counter];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(cars[i])) {
				res[j++] = cars[i];
			}
		}
		return res;
	}

	@Override
	public Car[] findCarsByColor(String color) {
//		Predicate<Car> predicateForColor = new Predicate<Car>() {
//
//			@Override
//			public boolean test(Car t) {
//				return t.getColor().equals(color);
//			}
//		};
//		return findCarsByPredicate(predicateForColor);

		return findCarsByPredicate((t) -> t.getColor().equals(color));
	}

}
