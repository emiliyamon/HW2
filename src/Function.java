/**
 * Represents a function
 */
abstract class Function {

    /**
     * Calculates the value of the function at the given x-coordinate
     *
     * @param x the x-coordinate at which to evaluate the function
     * @return the value of the function at the specified x-coordinate
     */
    public abstract double valueAt(double x);


    /**
     * Returns a string representation of the function in a specific format
     *
     * @return a string representation of the function
     */
    public abstract String toString();


    /**
     * calculates the derivative of the function
     *
     * @return the derivative of the function
     */
    public abstract Function derivative();


    /**
     * Finds the root of the function using the bisectionMethod method
     *
     * @param a the lower bound
     * @param b the upper bound
     * @param epsilon the desired accuracy of the root approximation
     * @return the approximated root of the function
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        // assumptions:
        // function is continuous in [a,b]
        // f(a) * f(b) < 0
        // there is only one root in [a,b]

        double left = a;
        double right = b;
        while (right - left >= epsilon) {
            double mid = (left + right) / 2.0;
            if (this.valueAt(mid) == 0) {
                return mid;
            } else if (this.valueAt(left) * this.valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2.0;
    }

    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10,-5));
    }


    /**
     * Finds the root of the function using the Newton-Raphson method
     *
     * @param a the initial value
     * @param epsilon the desired accuracy of the root approximation
     * @return the approximated root of the function
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;
        double fx0 = this.valueAt(x);
        Function dfx = this.derivative();
        double dfx0 = dfx.valueAt(x);
        double deltaX = fx0 / dfx0;

        while (Math.abs(deltaX) >= epsilon) {
            x -= deltaX;
            fx0 = this.valueAt(x);
            dfx0 = dfx.valueAt(x);
            deltaX = fx0 / dfx0;
        }

        return x;
    }

    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }


    /**
     * Computes the Taylor polynomial of the function up to the specified degree.
     *
     * @param n the degree of the Taylor polynomial
     * @return the Taylor polynomial
     */
    public Function taylorPolynomial(int n) {
        double[] coefficients = new double[n + 1];
        coefficients[0] = this.valueAt(0);

        for (int i = 1; i < n + 1; i++) {
            Function f = this;
            for (int j = 0; j < i; j++) {
                f = f.derivative();
            }

            double termCoefficient = f.valueAt(0) / factorial(i);
            coefficients[i] = termCoefficient;
        }
        return new Polynomial(coefficients);
    }


    /**
     * Calculates the factorial of a given number
     *
     * @param n number to calculate the factorial of
     * @return the result of the calculation
     */
    public static double factorial(int n) {
        if (n==0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
