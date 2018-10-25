package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.awt.Point;
import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class convertedFigure {

    private final StringProperty name;
    private final DoubleProperty area;
    private final DoubleProperty center_of_gravity; //почему не массив?
    private final DoubleProperty perimeter;
    private final StringProperty type;
    private final DoubleProperty radius;
    private final ArrayList<Point> Points;
    private final IntegerProperty typeCode;

    /**
     * Default constructor.
     */
    public convertedFigure() {
        this(null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param name
     */
    public convertedFigure(String name) {
        this.name = new SimpleStringProperty(name);

        // Some initial dummy data, just for convenient testing.
        this.area = new SimpleDoubleProperty();
        this.center_of_gravity = new SimpleDoubleProperty();
        this.perimeter = new SimpleDoubleProperty();
        this.type = new SimpleStringProperty();
        this.Points = new ArrayList<Point>();
        this.radius = new SimpleDoubleProperty();
        this.typeCode = new SimpleIntegerProperty();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public Double getArea() {
        return area.get();
    }

    public void setArea(Double area) {
        this.area.set(area);
    }

    public DoubleProperty areaProperty() {
        return area;
    }

    public Double getCenter() {
        return center_of_gravity.get();
    }

    public void setCenter(Double center_of_gravity) {
        this.center_of_gravity.set(center_of_gravity);
    }

    public DoubleProperty centerProperty() {
        return center_of_gravity;
    }

    public double getPerimeter() {
        return perimeter.get();
    }

    public void setPerimeter(double perimeter) {
        this.perimeter.set(perimeter);
    }

    public DoubleProperty perimeterProperty() {
        return perimeter;
    }    
    
    public double getRadius() {
        return radius.get();
    }
    
    public void setRadius(double radius) {
        this.radius.set(radius);
    }
    
    public DoubleProperty radiusProperty() {
		return radius;
	}
    
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }    
    
    //управление списком точек    
	public Point getPoint(Integer a) {
    	return Points.get(a);
    }
    
    public void addPoint(int x, int y) {
    	Point point = new Point(x, y);
    	this.Points.add(point);
    }
    
    public void clearPoints() {
    	this.Points.clear();
    }
    
    public Double getCoordX(Point point) {
    	Double coordX;    	
    	coordX = point.getX();
    	return coordX;
    }
    
    public Double getCoordY(Point point) {
    	Double coordY;    	
    	coordY = point.getY();
    	return coordY;
    }    
    //конец блока управления списком
    
	public IntegerProperty typeCodeProperty() {
		return typeCode;
	}
	
	public int getTypeCode() {
        return typeCode.get();
    }
    
    public void setTypeCode(int typeCode) {
        this.typeCode.set(typeCode);
    }
}