package business.models;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	private String street;
	private String city;
	private String state;
	private String zip;
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public StringProperty getStreetProperty() {
		return new SimpleStringProperty(this.street);
	}
    public StringProperty getZipProperty() {
		return new SimpleStringProperty(this.zip);
	}
    public StringProperty getCityProperty() {
		return new SimpleStringProperty(this.city);
	}

	public StringProperty getStateProperty() {
		return new SimpleStringProperty(this.state);
	}
	
}
