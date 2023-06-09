public class Polynomial extends Function {
    private final double[] coefficients;

    public Polynomial(double... coefficientsSet) {
        int length = coefficientsSet.length;
        this.coefficients = new double[length];
        for (int i = 0; i < length; i++) {
            this.coefficients[i] = coefficientsSet[i];
        }
    }


    @Override
    public double valueAt(double x) {
        double value = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            value += coefficients[i] * Math.pow(x, i);
        }
        return value;
    }


    @Override
    public String toString() {
        String[] terms = new String[coefficients.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] == 0.0) {
                continue;
            } else if (coefficients[i] == 1.0) {
                terms[i] = "x^" + i;
            } else if (coefficients[i] == -1.0) {
                terms[i] = "-x^" + i;
            } else if (coefficients[i] == (int) coefficients[i]) {
                terms[i] = (int) coefficients[i] + "x^" + i;
            }
            sb.append(coefficients[i]);
            if (coefficients[i] < 0) {
                sb.append("+");
            } else {
                sb.append("-");
            }
        }
        return sb.toString();
    }


    @Override
    public Function derivative() {
        double[] derivativeCoefficent = new double[coefficients.length];
        derivativeCoefficent[0] = 0.0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < coefficients.length; i++) {
            derivativeCoefficent[i] = coefficients[i] * i;
            sb.append(derivativeCoefficent[i]);
            if (coefficients[i] < 0) {
                sb.append("+");
            } else {
                sb.append("-");
            }
        }
        String derivativeString = sb.toString(); // need to change to return new polynomial
    }

}
