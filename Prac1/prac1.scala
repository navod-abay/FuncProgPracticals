def areaDisk(r:Int) = math.Pi * r * r;

def convertCelcius(cel: Double): Double = 1.8 * cel+ 32;

def VolumeSphere(r: Double): Double = 4 * math.Pi * r * r * r / 3;

def Q4 (numBooks: Int) :Double= {
    def totPrice():Double = numBooks * 24.95;
    def discount():Double = numBooks * 24.95 * 0.4;
    def shippingCost() :Double= if( numBooks> 50) 3 * 50 + 0.75 * (numBooks - 50) else numBooks * 3;
    totPrice() - discount() + shippingCost()
}

def Q5(easy1:Int, tempo:Int, easy2:Int) : Double = {
    def easyPace(easy : Int) : Double = easy * 8
    def tempoPace() : Double = tempo * 7
    easyPace(easy1) + tempoPace() + easyPace(easy2) 
}
@main def main = {
    println(areaDisk(5)); 
    println(convertCelcius(35))
    println(VolumeSphere(5))
    println(Q4(60))
    println(Q5(2, 3, 2))
}