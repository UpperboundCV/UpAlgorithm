package up.findingPrime

import org.scalatest.FunSuite
import up.findingPrime.FindingPrime.{factorial, findPrime, isPrime}


class FindingPrimeSuite extends FunSuite{
  test("factorial return result as expected") {
    assert(factorial(3)===6)
  }
  test("isPrime return true if input is prime number"){
    assert(isPrime(11)===true)
  }
  test("findPrime return None if there is no prime in range"){
    assert(findPrime(20,22).isEmpty)
  }
  test("findPrime return prime numbers if there are prime numbers in range"){
    assert(findPrime(2,10)===Seq(2,3,5,7))
  }
}
