import scala.io.StdIn

class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be non-zero")
  
  // Greatest common divisor function for simplifying the fraction
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(n.abs, d.abs)
  
  // Numerator and denominator after simplification
  val numer: Int = n / g
  val denom: Int = d / g
  
  // Method to negate the rational number
   def unary_- : Rational = new Rational(-numer, denom)

  def -(that: Rational): Rational = {
    // Formula for subtracting fractions: a/b - c/d = (a*d - b*c) / (b*d)
    val newNumer = this.numer * that.denom - this.denom * that.numer
    val newDenom = this.denom * that.denom
    new Rational(newNumer, newDenom)
  }
  
  override def toString: String = s"$numer/$denom"
}


@main def main() = {
println("Enter numerator:")
  val numerator = StdIn.readInt()
  
  println("Enter denominator:")
  val denominator = StdIn.readInt()
  
  // Create a new Rational number
  val rational = new Rational(numerator, denominator)
  
  // Print the Rational number
  println(s"Rational number: $rational")
  
  // Negate and print the negated version
  val negatedRational = -rational;
  println(s"Negated Rational number: $negatedRational")


  val x = new Rational(3, 4)  // 3/4
  val y = new Rational(5, 8)  // 5/8
  val z = new Rational(2, 7)  // 2/7

  println(s"x = $x")
  println(s"y = $y")
  println(s"z = $z")

  val sub = x - y - z;
  println(s"x - y- z = $sub")
  

}