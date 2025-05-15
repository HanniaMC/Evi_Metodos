package Evi_Metodos;
import java.util.Scanner;

public class Biseccion {

    // Función que se va a evaluar
    public static double funcion(double x) {
        return Math.pow(x, 3) - x - 2; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingresa el valor de a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingresa el valor de b: ");
        double b = scanner.nextDouble();

        System.out.print("Ingresa el número máximo de iteraciones: ");
        int maxIteraciones = scanner.nextInt();

        double tolerancia = 0.0001;

        // Verificación de condición inicial
        if (funcion(a) * funcion(b) >= 0) {
            System.out.println("Error: La función no cambia de signo entre a y b.");
            System.exit(1);
        }

        double c = a;
        int iteracion = 0;

        System.out.println("\nIteración\t a\t\t b\t\t c\t\t f(c)");
        while ((b - a) >= tolerancia && iteracion < maxIteraciones) {
            c = (a + b) / 2;
            double fc = funcion(c);

            System.out.printf("%d\t\t %.6f\t %.6f\t %.6f\t %.6f\n", iteracion + 1, a, b, c, fc);

            // Si la función evaluada en c es muy cercana a cero, terminamos
            if (Math.abs(fc) < tolerancia) {
                break;
            }

            // Decidir en qué subintervalo continuar
            if (funcion(a) * fc < 0) {
                b = c;
            } else {
                a = c;
            }

            iteracion++;
        }

        // Mostrar el resultado final
        System.out.println("\nLa raíz aproximada es: " + c);
        scanner.close();
    }
}
