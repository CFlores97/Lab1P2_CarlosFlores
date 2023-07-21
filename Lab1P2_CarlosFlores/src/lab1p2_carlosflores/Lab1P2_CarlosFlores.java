package lab1p2_carlosflores;

import java.util.Scanner;

public class Lab1P2_CarlosFlores {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("1. Newton Raphson\n2. Serie Taylor\n3. Salir");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    ///TODO: Vertice
                    //TODO: Operaciones
                    //TODO: Recursiva

                    System.out.println("Ingrese el valor de a: ");
                    int a = sc.nextInt();

                    System.out.println("Ingrese el valor de b: ");
                    int b = sc.nextInt();

                    System.out.println("Ingrese el valor de c: ");
                    int c = sc.nextInt();

                    while (a == 0) {
                        System.out.println("El valor de a no puede ser 0!\nIntente nuevamente: ");
                        a = sc.nextInt();
                    }
                    double vertex = vertice(a, b);

                    double desp1 = desplazamientoNeg(vertex);
                    double desp2 = desplazamientoPos(vertex);

                    double acum = 0;

                    double raiz1 = newtonRaptson1(a, b, c, desp1, 0);
                    double raiz2 = newtonRaptson2(a, b, c, desp2, 0);

                    System.out.println("Raiz 1 encontrada: " + raiz1);
                    System.out.println("Raiz 2 encontrada: " + raiz2);

                    break;
                case 2:
                    //TODO: validar
                    System.out.println("Ingrese un limite\nUtilizar preferiblemente limite 100!");
                    int lim = sc.nextInt();

                    System.out.println("Ingrese el valor de x");
                    int x = sc.nextInt();
                    double acumSenx = 0;
                    double acumCosx = 0;
                    double acumTanx = 0;

                    double resTanx = 0;

                    double resSenx = senX(x, lim, 0, acumSenx);
                    double resCosx = cosX(x, lim, 0, acumCosx);

                    if (x > 90) { 
                        resTanx = 0;
                        System.out.println("tangente: " + resTanx + " valor es mayor que pi...");
                    } else {
                        resTanx = tanX(x, lim, 1, acumTanx);
                        System.out.println("tangente: " + resTanx);
                    }

                    System.out.println("seno: " + resSenx);
                    System.out.println("coseno: " + resCosx);
                    

                    break;

                case 3:
                    running = false;
                    break;

                default:
                    break;
            }

        }
    }

    //metodos
    static double factorial(double number) {
        double answer = 1;
        for (int i = 0; i < number; i++) {
            answer *= number - i;
        }
        return answer;
    }

    static double calcNum(int a, int b, int c, double x) {
        return (a * Math.pow(x, 2)) + (b * x) + c;
    }

    static double calcDen(int a, int b, double x) {
        return (2 * a * x) + b;
    }

    static double vertice(int a, int b) {
        return (double) (-b) / (double) (2 * a);
    }

    static double desplazamientoNeg(double vertice) {
        return vertice - 200;
    }

    static double desplazamientoPos(double vertice) {
        return vertice + 200;
    }

    static double newtonRaptson1(int a, int b, int c, double desplazamiento, int d) {
        if (d == 100) {
            return desplazamiento;
        } else {
            desplazamiento = desplazamiento - (calcNum(a, b, c, desplazamiento) / calcDen(a, b, desplazamiento));
            return newtonRaptson1(a, b, c, desplazamiento, d + 1);
        }
    }

    static double newtonRaptson2(int a, int b, int c, double desplazamiento, int d) {
        if (d == 100) {
            return desplazamiento;
        } else {
            desplazamiento = desplazamiento - (calcNum(a, b, c, desplazamiento) / calcDen(a, b, desplazamiento));
            return newtonRaptson2(a, b, c, desplazamiento, d + 1);
        }
    }

    static double senX(int x, int lim, int c, double acum) {

        if (c == lim) {
            return acum;
        } else {
            double numerador = Math.pow(-1, c);
            double denominador = factorial((2 * c) + 1);
            acum += (numerador / denominador) * Math.pow(x, (2 * c) + 1);
            return senX(x, lim, c + 1, acum);

        }

    }

    static double cosX(int x, int lim, int c, double acum) {

        if (c == lim) {
            return acum;
        } else {
            double numerador = Math.pow((-1), c);
            double denominador = factorial(2 * c);

            acum += (numerador / denominador) * Math.pow(x, 2 * c);
            return cosX(x, lim, c + 1, acum);
        }

    }

    static double tanX(int x, int lim, int c, double acum) {

        if (c == lim) {
            return acum;
        } else {
            double numerador = Math.pow(2, c) * Math.pow(-4, c) * 1 + Math.pow(-4, c);
            double denominador = factorial(2 * c);

            acum += (numerador / denominador) * Math.pow(x, 2 * c - 1);
            return tanX(x, lim, c + 1, acum);
        }

    }

}
