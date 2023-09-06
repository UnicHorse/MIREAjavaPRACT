import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //TestAuthor.startAuthor();
        //TestBall.startBall();
        //TestPointAndCircle.startPointAndCircle();
        TestShop.testShop();
    }

    static class Author {
        private String name;
        private String email;
        private char gender;

        Author(String _name, String _email, char _gender) {
            name = _name;
            email = _email;
            gender = _gender;
        }

        String getName() {
            return name;
        }

        String getEmail() {
            return email;
        }

        char getGender() {
            return gender;
        }

        void setEmail(String _email) {
            email = _email;
        }

        @Override
        public String toString() {
            return String.format("Author{%s,%s,%c}", name, email, gender);
        }
    }

    static class TestAuthor {
        public static void startAuthor() {
            String name, email;
            char gender;

            System.out.println("Enter name: ");
            name = sc.nextLine();
            System.out.println("Enter email: ");
            email = sc.nextLine();
            System.out.println("Enter gender: ");
            gender = sc.nextLine().charAt(0);
            Author author = new Author(name, email, gender);
            System.out.println(author.getName());
            System.out.println(author.getEmail());
            System.out.println(author.getGender());
            System.out.println("Enter new email: ");
            String nemail = sc.nextLine();
            author.setEmail(nemail);
            System.out.println(author.getEmail());
            System.out.println();
            System.out.println(author.toString());
        }
    }

    static class Ball {
        private double x = 0.0;
        private double y = 0.0;

        Ball() {
        }

        Ball(double _x, double _y) {
            x = _x;
            y = _y;
        }

        double getX() {
            return x;
        }

        void setX(double _x) {
            x = _x;
        }

        double getY() {
            return y;
        }

        void setY(double _y) {
            y = _y;
        }

        void setXY(double _x, double _y) {
            x = _x;
            y = _y;
        }

        void move(double xDisp, double yDisp) {
            x += xDisp;
            y += yDisp;
        }

        @Override
        public String toString() {
            return String.format("Ball x is %f and y is %f", x, y);
        }
    }

    static class TestBall {
        public static void startBall() {
            Ball ball = new Ball(10, 10);
            System.out.println(ball.getX());
            ball.setX(14);
            System.out.println(ball.getX());
            System.out.println(ball.getY());
            ball.setY(18);
            System.out.println(ball.getY());
            ball.setXY(13, 15);
            System.out.println(ball.getX());
            System.out.println(ball.getY());
            System.out.println(ball.toString());
            ball.move(4, -3);
            System.out.println(ball.toString());
        }
    }

    static class Point {
        private double x = 0.0;
        private double y = 0.0;

        Point(double _x, double _y) {
            x = _x;
            y = _y;
        }

        void setX(double _x) {
            x = _x;
        }

        void setY(double _y) {
            y = _y;
        }

        double getX() {
            return x;
        }

        double getY() {
            return y;
        }
    }

    static class Circle {
        Point center;
        ArrayList<Point> points = new ArrayList<>(10);

        Circle(double x, double y) {
            center = new Point(x, y);
        }

        public void addPoint(double x, double y) {
            points.add(new Point(x, y));
        }
    }

    public class TestPointAndCircle {
        public static void startPointAndCircle() {
            int size = 0;
            ArrayList<Circle> circles = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                circles.add(new Circle(15, 20));
                size++;
            }
        }
    }

    interface sh{
        public void addComputer(String model, int price);
        public ArrayList<Computer> searchComputer(String model, int price);
        public void search();
    }
    interface pc{
        public String getModel();
        public int getPrice();
    }
    static class Computer implements pc{
        private String model;
        private int price;

        Computer(String _model, int _price) {
            model = _model;
            price = _price;
        }
        @Override
        public String getModel(){return model;}
        @Override
        public int getPrice(){return price;}
    }

    static class Shop implements sh{
        ArrayList<Computer> computers = new ArrayList<>();
        @Override
        public void addComputer(String model, int price){
            computers.add(new Computer(model, price));
        }
        @Override
        public ArrayList<Computer> searchComputer(String model, int price){
            ArrayList<Computer> result = new ArrayList<>();
            for(Computer item: computers){
                if(item.getModel() == model || item.getPrice() == price){
                    result.add(item);
                }
            }
            return result;
        }
        @Override
        public void search(){
            System.out.println("Enter model name: ");
            String model = sc.nextLine();
            System.out.println("Enter price: ");
            int price = sc.nextInt();
            for(Computer item: searchComputer(model, price)){
                System.out.printf("Model: %s, Price: %d", item.model, item.price);
            }
        }
    }

    static class TestShop{
        public static void testShop() {
            Shop shop = new Shop();
            shop.addComputer("apple", 1000);
            shop.addComputer("win7", 1000);
            shop.addComputer("win10", 1300);
            shop.search();
        }
    }

    
}
