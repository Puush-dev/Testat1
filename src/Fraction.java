public class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator){
        this(numerator, 1);
    }

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction multiply(int factor){
        return new Fraction(numerator * factor,denominator);
    }

    public Fraction multiply(Fraction factor){
        return new Fraction(numerator * factor.numerator, denominator * factor.denominator);
    }

    public Fraction divide(Fraction divisor){
        return new Fraction(numerator * divisor.denominator, denominator * divisor.numerator);
    }

    public Fraction multiply(Fraction... factors){
        int newNumerator = this.numerator, newDenominator = this.denominator;
        for(int i = 0;i < factors.length; i++){
            newNumerator *= factors[i].numerator;
            newDenominator *= factors[i].denominator;
        }
        return new Fraction(newNumerator, newDenominator);
    }

    public String toString(){
       return numerator + "/" + denominator;
    }

}
