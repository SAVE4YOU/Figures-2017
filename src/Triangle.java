public class Triangle extends Geometric {
    private double a,b,c;
    private double area;
    private String color;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double calculateArea() {
        double p = (a/37.7952755905511+b/37.7952755905511+c/37.7952755905511)/2;
        return Math.sqrt(p*(p-a/37.7952755905511)*(p-b/37.7952755905511)*(p-c/37.7952755905511));
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString(){
        return "Трикутник рівнобедренний зі сторонами :" +
                (double)Math.round((a /37.7952755905511)*100)/100 + "(см), "+
                (double)Math.round((b /37.7952755905511)*100)/100 +"(см), "+
                (double)Math.round((c /37.7952755905511)*100)/100 + "(см), та його площа : "+
                (double)Math.round(calculateArea()*100)/100 +"(см).        Колір - "+getColor();
    }
}
