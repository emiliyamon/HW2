public class Polynomial extends Function {
    private final double[] coefficients;

    public Polynomial(double... coefficientsSet) {
        this.coefficients = new double[coefficientsSet.length];
        for (int i = 0; i < coefficientsSet.length; i++) {
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
        sb.append("(");

        if (coefficients.length == 1 && coefficients[0] == 0) {
            sb.append("0)");
            return sb.toString();
        }

        boolean allZero = true;
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            sb.append("0)");
            return sb.toString();
        }

        for (int i = 0; i < coefficients.length; i++) {
            double coefficient = Math.abs(coefficients[i]);

            if (coefficients[i] == 0.0) {
                terms[i] = "";
            } else if (i == 0) {
                if (coefficients[i] == (int) coefficients[i]) {
                    terms[i] = String.valueOf((int) coefficients[i]);
                } else {
                    terms[i] = String.valueOf(coefficients[i]);
                }
            } else if (i == 1) {
                if (coefficients[i] == (int) coefficients[i]) {
                    terms[i] = (int) coefficient + "x";
                } else {
                    terms[i] = coefficient + "x";
                }
            } else if (coefficients[i] == 1.0 || coefficients[i] == -1.0) {
                terms[i] = "x^" + i;
            } else if (coefficients[i] == (int) coefficients[i]) {
                terms[i] = (int) coefficient + "x^" + i;
            } else {
                terms[i] = coefficient + "x^" + i;
            }

            if (coefficients[i] == 0 || i == 0) {
                sb.append("");
            } else if (coefficients[i] > 0) {
                if (sb.length() > 1) {
                    sb.append(" + ");
                } else {
                    sb.append("");
                }
            } else if (coefficients[i] < 0) {
                if (sb.length() > 1) {
                    sb.append(" - ");
                } else {
                    sb.append("");
                }
            }
            sb.append(terms[i]);
        }
        sb.append(")");

        return sb.toString();
    }


    @Override
    public Function derivative() {
        if (coefficients.length == 0 || coefficients.length == 1) {
            return new Constant(0);
        }

        double[] derivativeCoefficient = new double[coefficients.length - 1];
        for (int i = 0; i < coefficients.length - 1; i++) {
            derivativeCoefficient[i] = coefficients[i + 1] * (i + 1);
        }

        return new Polynomial(derivativeCoefficient);
    }

}
