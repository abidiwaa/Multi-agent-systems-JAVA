import java.awt.*;
public class TestBalls{
    public static void main(String [] args) {
        Point p1 = new Point(3,4);
        Point p2 = new Point(5,6);
        Point p3 = new Point(6,-1);
        Point p4 = new Point(4,2);
        Point p5 = new Point(5,1);
        Ball b1 = new Ball(p1);
        Ball b2 = new Ball(p2);
        Ball b3 = new Ball(p3);
        Ball b4 = new Ball(p4);
        Ball b5 = new Ball(p5);
        Ball[] tab={b1,b2,b3,b4,b5};
        Balls balles = new Balls(tab);
        System.out.printf(balles.toString());
        balles.translatewithnocondition(1,1);
        System.out.printf(balles.toString());
        balles.reInit();
        System.out.printf(balles.toString());
}
}
