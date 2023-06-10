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
            sb.append(terms[i]);
            if (coefficients[i] > 0) {
                sb.append("+");
            } else {
                sb.append("-");
            }
        }
        return sb.toString();
    }


    @Override
    public Function derivative() {
        double[] derivativeCoefficient = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            derivativeCoefficient[i] = coefficients[i] * i;
        }

        Function[] derivativeBase = new Function[coefficients.length];
        for (int i = 1; i < coefficients.length; i++) {
            derivativeBase[i] = new Power(new Polynomial(1), i-1);
        }

        Function[] derivativeFunction = new Function[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            derivativeFunction[i] = new Product(new Constant(derivativeCoefficient[i]), derivativeBase[i]);
        }

        return new MultiSum(derivativeFunction);
    }

}
