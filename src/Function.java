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
        int count = n;
        Function f = this;
        Function term = this;

        if (n==0) {
            return f;
        } else {
            while (count < n+1) {
                Function nthDerivative = f.derivative();
                double factorial = factorial(n);
                Function factorialFunction = new Constant(1/factorial);
                Function nthTerm = nthDerivative * factorialFunction;
                term = nthTerm.sum(nthDerivative);
                count ++;
            }
        }
        return term;
    }


    public static double factorial(int n) {
        if (n==0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
