def Question1_2() = {
    var  k: Int = 2
    var  i: Int = 2
    var  j: Int = 2
    var  m: Int = 5
    var  n: Int = 5
    var f: Float = 12.0f
    var g: Float = 4.0f
    var c: Char = 'X'
    printf(" k + 12 * m = %d\n",  k + 12 * m)
    printf("m / j = %d\n", m / j )
    printf("n %% j = %d\n", n % j)
    printf("m / j * j = %d\n", m / j * j)
    printf(" f + 10*5 +g = %f\n",  f + 10*5 +g)
    // printf("++i * n = %f", ++i * n)
    printf("++i * n = This results in a syntax error since scala doesn't have an increment operator even though java does\n" )
};

def Question2_2() = {
    var a: Int = 2
    var b: Int = 3
    var c: Int = 4
    var d: Int = 5
    var k: Float = 4.3f

    b = b - 1
    printf("--b * a + c * d-- =%d\n ", b * a + c * d)
    d = d - 1
    
    printf("a++ = %d\n", a);
    a = a + 1

    // printf("-2 * ( g - k ) +c = %d", -2 * ( g - k ) +c);
    // g is not defined

    printf("c=c++ = %d\n", c)
    c = c + 1

    c = c + 1
    c = c * a
    printf("c = ++c * a++ = %d\n", c )
    a = a + 1
};
def Question3_2(workingHours: Int, OThours: Int) = {
    val OTHourRate = 85 
    val workinglHourRate = 250
    val taxRate = 0.12
    def calculateGrossSalary(): Int = workingHours* workinglHourRate + OThours * OTHourRate

    def calculateTax(grossSalary: Int): Double = grossSalary * taxRate
    val grossSalary = calculateGrossSalary()
    printf("Salary = %f\n", grossSalary - calculateTax(grossSalary))


}

def Question4_2(ticketPrice: Int) =  {
    def numPeople(): Int = 120 - (ticketPrice - 15) / 5 * 20
    def cost(numberofPeople: Int) = 500 + numberofPeople * 3
    val numberofPeople = numPeople()
    printf("The profit when ticket price is %d = %d\n", ticketPrice, ticketPrice * numberofPeople - cost(numberofPeople))
}

@main def main = {
    Question1_2()
    println()
    println("_____________________________________________________________________________")
    Question2_2()
    println()
    println("_____________________________________________________________________________")
    Question3_2(40, 30)
    println()
    println("_____________________________________________________________________________")
    Question4_2(15)
    Question4_2(20)
}