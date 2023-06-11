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
                terms[i] = "";
            } else if (i == 0) {
                if (coefficients[i] == (int) coefficients[i]) {
                    terms[i] = String.valueOf((int) coefficients[i]);
                } else {
                    terms[i] = String.valueOf(coefficients[i]);
                }
            } else if (coefficients[i] == 1.0) {
                terms[i] = "x^" + i;
            } else if (coefficients[i] == -1.0) {
                terms[i] = "-x^" + i;
            } else if (coefficients[i] == (int) coefficients[i]) {
                terms[i] = (int) coefficients[i] + "x^" + i;
            }

            if (coefficients[i] > 0 && i > 1) {
                sb.append("+");
            } else if (coefficients[i] < 0 && i > 1){
                sb.append("-");
            }

            sb.append(terms[i]);
        }
        return sb.toString();
    }


    @Override
    public Function derivative() {
        if (coefficients.length == 0) {
            return new Constant(0);
        }

        double[] derivativeCoefficient = new double[coefficients.length - 1];
        for (int i = 0; i < coefficients.length - 1; i++) {
            derivativeCoefficient[i] = coefficients[i + 1] * (i + 1);
        }

        return new Polynomial(derivativeCoefficient);
    }

}
