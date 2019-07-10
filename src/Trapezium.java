public class Trapezium extends Geometric{
    private double lengthOfUpSide, lengthOfLeftSide;
    private double lengthOfLowSide, lengthOfRightSide;
    private double height;
    private double area;

    public Trapezium(double lengthOfUpSide, double lengthOfLowSide, double lengthOfLeftSide, double lengthOfRightSide) {
        this.lengthOfUpSide = lengthOfUpSide;
        this.lengthOfLowSide = lengthOfLowSide;
        this.lengthOfLeftSide = lengthOfLeftSide;
        this.lengthOfRightSide = lengthOfRightSide;
    }

    public double getLengthOfUpSide(){
        return lengthOfUpSide;
    }

    public void setLengthOfUpSide(float lengthOfUpSide){
        this.lengthOfUpSide = lengthOfUpSide;
    }

    public double getLengthOfLowSide(){
        return lengthOfLowSide;
    }

    public void setLengthOfLowSide(float lengthOfLowSide){
        this.lengthOfLowSide = lengthOfLowSide;
    }

    public double getLengthOfLeftSide(){
        return lengthOfLeftSide;
    }

    public void setLengthOfLeftSide(double lengthOfLeftSide){
        this.lengthOfLeftSide = lengthOfLeftSide;
    }

    public double getLengthOfRightSide(){
        return lengthOfRightSide;
    }

    public void setLengthOfRightSide(double lengthOfRightSide){
        this.lengthOfRightSide = lengthOfRightSide;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setLengthOfUpSide(double lengthOfUpSide) {
        this.lengthOfUpSide = lengthOfUpSide;
    }

    public void setLengthOfLowSide(double lengthOfLowSide) {
        this.lengthOfLowSide = lengthOfLowSide;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double calculateArea(){
        double a= lengthOfLowSide /37.7952755905511, b= lengthOfUpSide /37.7952755905511, h = height/37.7952755905511;
        return ((a+b)/2)* calcHeight();
    }
    public double calcHeight() {
        double a = lengthOfLeftSide /37.7952755905511,
               b = lengthOfUpSide/37.7952755905511,
               c = lengthOfRightSide /37.7952755905511,
               d = lengthOfLowSide/37.7952755905511;
        return Math.sqrt(a*a - Math.pow((  (Math.pow((d-b),2)+a*a-c*c )/(2*(d-b) ) ),2));
    }

    @Override
    public String toString(){
        return ("Трапеція зі сторонами : "
                +(double) Math.round((lengthOfUpSide/37.7952755905511)*100)/100 + "(см), "
                +(double) Math.round((lengthOfLowSide/37.7952755905511)*100)/100 + "(см), "
                +(double) Math.round((lengthOfLeftSide/37.7952755905511)*100)/100 + "(см), "
                +(double) Math.round((lengthOfRightSide/37.7952755905511)*100)/100+ "(см), висота = "
                +(double) Math.round((calcHeight())*100)/100)+"(см), а площа : "
                +(double) Math.round(calculateArea()*100)/100+"(см).        Колір - "+getColor();
    }
}
