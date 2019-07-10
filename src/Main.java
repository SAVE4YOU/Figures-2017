import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    int numberOfFigures = (int) (1+Math.random()*10);
    int indent =100; // відступ між рядками тексту
    double arrX[] = new double[5]; // масиви для малюнку
    double arrY[] = new double[5];//
    Color[] colors = new Color[6];
    String[] nameForColors = {"Синій","Чорний","Червоний","Зелений","Оранжевий","Коричневий"};
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Group root = new Group();
        Canvas canvas = new Canvas(700, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        gc.strokeLine(0,90,715,90);

        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(407);
        primaryStage.setWidth(710);
        primaryStage.setResizable(false);
        primaryStage.setTitle("My Test");
        primaryStage.show();
        Geometric[] arr = new Geometric[numberOfFigures];

        colors[0] = new Color(0,0,1,1);
        colors[1] = new Color( 0, 0,0 ,1);
        colors[2] = new Color( 1,0 ,0 ,1);
        colors[3] = new Color( 0,1 , 0,1);
        colors[4] = new Color( 1,0.6 , 0,1);
        colors[5] = new Color(0.6 ,0.3 ,0.2 ,1);
        //Кольори не повністю рандомні, щоб виглядало більш менш нормально

        int randomColor;
        int x=15,y=25;
        for(int i = 0; i<numberOfFigures;i++) {
            int randKey = (int) (1 + Math.random() * 4);
            arr[i]=(createRandomFigure(randKey));
            if(arr[i] instanceof Circle) {
                randomColor = (int) (1+Math.random()*5);
                arr[i].setColor(nameForColors[randomColor]);
                gc.setFill(colors[randomColor]);
                gc.fillOval(x,y,arr[i].getDiameter(),arr[i].getDiameter());
                x+=60;
            }
            else if(arr[i] instanceof Square) {
                randomColor = (int) (1+Math.random()*5);
                arr[i].setColor(nameForColors[randomColor]);
                gc.setFill(colors[randomColor]);
                gc.fillRoundRect(x, y, arr[i].getLengthOfSide(), arr[i].getLengthOfSide(), 0, 0);
                x+=60;
            }
            else if(arr[i] instanceof Triangle) {
                randomColor = (int) (1+Math.random()*5);
                arr[i].setColor(nameForColors[randomColor]);
                gc.setFill(colors[randomColor]);
                double endX = x+15 + (Math.cos(Math.toRadians(120)) * arr[i].getA());
                double endY = y + (Math.sin(Math.toRadians(120)) * arr[i].getA());
                double end2x = x+15 +(Math.cos(Math.toRadians(60)) * arr[i].getA());
                double end2Y = y + (Math.sin(Math.toRadians(60)) * arr[i].getA());
                double arrX1[] = new double[4];
                double arrY1[] = new double[4];
                arrX1[0] = x+15; arrX1[1] = endX; arrX1[2]=end2x; arrX1[3]=x+15;
                arrY1[0] = y; arrY1[1] = endY; arrY1[2]=end2Y; arrY1[3]=y;
                gc.fillPolygon(arrX1, arrY1, 3);
                x+=60;
            }
            else{
                randomColor = (int) (1+Math.random()*5);
                arr[i].setColor(nameForColors[randomColor]);
                gc.setFill(colors[randomColor]);
                if(i==0) x+=10; // щоб малюнок на заступав за край
                else x+=20;    //
                double angle = 100+Math.random()*30;
                double endX = x + (Math.cos(Math.toRadians(0)) * arr[i].getLengthOfUpSide());
                double endY = y+10 + (Math.sin(Math.toRadians(0)) * arr[i].getLengthOfUpSide());
                double end2x = x +(Math.cos(Math.toRadians(angle)) * arr[i].getLengthOfLeftSide());
                double end2Y = y+10 + (Math.sin(Math.toRadians(angle)) * arr[i].getLengthOfLeftSide());
                double end3x = end2x +(Math.cos(Math.toRadians(0)) * arr[i].getLengthOfLowSide());
                double end3Y = end2Y + (Math.sin(Math.toRadians(0)) * arr[i].getLengthOfLowSide());

                arrX[0] = endX; arrX[1] = x; arrX[2] = end2x; arrX[3] = end3x; arrX[4] = endX;
                arrY[0] = y+10; arrY[1] = endY; arrY[2] = end2Y; arrY[3] = end3Y; arrY[4] = endY;
                gc.fillPolygon(arrX, arrY, 4);
                x+=50;
            }
                Label label = new Label(arr[i].toString());
                label.setLayoutX(10);
                label.setLayoutY(indent);
                indent +=16;
                root.getChildren().add(label);
        }
    }

    public Geometric createRandomFigure(int randKey){
        double temp;
        Geometric result = null;
        switch(randKey){
            case 1:
                Square square = new Square(35+Math.random()*15);
                result = square;
                break;
            case 2:
                temp =35+Math.random()*15;
                Triangle triangle = new Triangle(temp,temp,temp);
                result = triangle;
                break;
            case 3:
                temp = 35+Math.random()*15;
                Circle circle = new Circle(temp,temp/2);
                result = circle;
                break;
            case 4:
                Trapezium trapezium = new Trapezium(25+ Math.random()*10,40+ Math.random()*10,30+Math.random()*15,30+Math.random()*15);
                result = trapezium;
                break;
        }
        return result;
    }
}