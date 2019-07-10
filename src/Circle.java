public class Circle extends Geometric{
    private double diameter;
    private double radius = diameter/2;
    private double area;
    private String color;

    public Circle(double diameter, double radius) {
        this.diameter = diameter;
        this.radius = radius;
    }
    @Override
    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
       return area;
    }
    public double calculateArea(){
        return Math.PI * Math.pow(radius/37.7952755905511,2);
    }

    @Override
    public String toString(){
        return "Коло, його діаметр = "
                +(double)Math.round((diameter/37.7952755905511)*100)/100+"(cм), радіус = "
                +(double)Math.round((radius/37.7952755905511)*100)/100+"(см), а площа = "
                +(double)Math.round((calculateArea())*100)/100+"(см).        Колір - "+getColor();
    }
}
