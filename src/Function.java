abstract class Function {

    public abstract double valueAt(double x);

    public abstract String toString();

    public abstract String derivative();

    public double bisectionMethod(double a, double b, double epsilon) {
        // assumptions:
        // function is continuous in [a,b]
        // f(a)*f(b)<0
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

    }

    public double newtonRaphsonMethod(double a) {

    }

    public Function taylorPolynomial(int n) {

    }

}
