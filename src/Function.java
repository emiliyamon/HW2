abstract class Function {

    public abstract double valueAt(double x);

    public abstract String toString();

    public abstract Function derivative();

    public double bisectionMethod(double a, double b, double epsilon) {
        // assumptions:
        // function is continuous in [a,b]
        // f(a) * f(b) < 0
        // there is only one root in [a,b]

        double left = a;
        double right = b;
        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            if (this.valueAt(left) * this.valueAt(right) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2;
    }

    public double bisectionMethod(double a, double b) {
        double left = a;
        double right = b;
        double epsilon = 0.00001;
        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            if (this.valueAt(left) * this.valueAt(right) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2;
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;

        do {
            double fx0 = this.valueAt(x);
            Function dfx = this.derivative();
            double dfx0 = dfx.valueAt(x);
            x -= fx0 / dfx0;
        } while (this.valueAt(x) < epsilon);

        return x;
    }

    public double newtonRaphsonMethod(double a) {
        double x = a;
        double epsilon = 0.00001;

        do {
            double fx0 = this.valueAt(x);
            Function dfx = this.derivative();
            double dfx0 = dfx.valueAt(x);
            x -= fx0 / dfx0;
        } while (this.valueAt(x) < epsilon);

        return x;
    }

    public Function taylorPolynomial(int n) {
        double[] coefficients = new double[n + 1];
        coefficients[0] = this.valueAt(0);

        for (int i = 0; i <= n; i++) {
            Function f = this;
            for (int j = 0; j < i; j++) {
                f = f.derivative();
            }

            double termCoefficient = f.valueAt(0) / factorial(i);
            if (Double.isNaN(termCoefficient)) { // check later if ok to use
                termCoefficient = 0;
            }
            coefficients[i] = termCoefficient;
        }
        return new Polynomial(coefficients);
    }


    public static double factorial(int n) {
        if (n==0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
