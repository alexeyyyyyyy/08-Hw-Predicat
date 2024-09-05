package telran.cars.model;

import telran.cars.model.Car;

public class Car {
	private String regNumber;
	private String model;
	private String company;
	private double engine;
	private String color;

	public Car(String regNumber, String model, String company, double engine, String color) {
		this.regNumber = regNumber;
		this.model = model;
		this.company = company;
		this.engine = engine;
		this.color = color;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public String getCompany() {
		return company;
	}

	public double getEngine() {
		return engine;
	}

	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", model=" + model + ", company=" + company + ", engine=" + engine
				+ ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regNumber == null) ? 0 : regNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car other = (Car) obj;
		if (regNumber == null) {
			if (other.regNumber != null) {
				return false;
			}
		} else if (!regNumber.equals(other.regNumber)) {
			return false;
		}
		return true;
	}
}
