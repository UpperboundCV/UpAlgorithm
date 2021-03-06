package up.findingPrime

object FindingPrime {
  def factorial(number: Int): Int = {
    (1 to number).product
  }

  def isPrime(number: Int): Boolean = {
    ((factorial(number-1)+1)%number) == 0
  }

  def findPrime(fromNumber: Int, toNumber: Int): Seq[Int]={
    (fromNumber to toNumber).filter{isPrime}
  }

  def main(): Unit = {
    println(findPrime(3,11))
  }
}
