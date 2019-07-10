public class Square extends Geometric{
    private double lengthOfSide;
    private String color;
    private double area;

    @Override
    public double getLengthOfSide() {
        return lengthOfSide;
    }

    public void setLengthOfSide(float lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public Square(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public double calculateArea(){
        return Math.pow((lengthOfSide /37.7952755905511),2);
    }

    public void setLengthOfSide(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString(){
        return "Квадрат зі стороною : "
                +(double)Math.round((lengthOfSide /37.7952755905511)*100)/100+"(см) має площу : "
                +(double)Math.round((calculateArea())*100)/100+"(см).        Колір - "+getColor();
    }
}
