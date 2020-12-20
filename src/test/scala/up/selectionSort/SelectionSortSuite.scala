package up.selectionSort

import org.scalatest.FunSuite
import up.selectionSort.SelectionSort.{SequenceUtil, selectionSort}

class SelectionSortSuite extends FunSuite {
  test("SwapElement switch first and last element correctly") {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7)
    val index1 = 0
    val index2 = numbers.size - 1
    val newNumbers = numbers.swapElement(index1, index2)
    assert(newNumbers === Seq(7, 2, 3, 4, 5, 6, 1))
  }
  test("SwapElement switch tail and other element after head correctly") {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7)

    val index1 = 2
    val index2 = numbers.size - 1
    val newNumbers = numbers.swapElement(index1, index2)

    assert(newNumbers === Seq(1, 2, 7, 4, 5, 6, 3))
  }
  test("SwapElement switch tail and adjacent one correctly") {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7)

    val index1 = numbers.size - 2
    val index2 = numbers.size - 1
    val newNumbers = numbers.swapElement(index1, index2)

    assert(newNumbers === Seq(1, 2, 3, 4, 5, 7, 6))
  }
  test(
    "SwapElement switch head and other element before last element correctly"
  ) {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7)

    val index1 = 0
    val index2 = 4
    val newNumbers = numbers.swapElement(index1, index2)

    assert(newNumbers === Seq(5, 2, 3, 4, 1, 6, 7))
  }
  test("SwapElement switch head and adjacent one correctly") {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7)

    val index1 = 0
    val index2 = 1
    val newNumbers = numbers.swapElement(index1, index2)

    assert(newNumbers === Seq(2, 1, 3, 4, 5, 6, 7))
  }
  test("SwapElement switch element in between head and tail correctly") {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7)

    val index1 = 2
    val index2 = 4
    val newNumbers = numbers.swapElement(index1, index2)

    assert(newNumbers === Seq(1, 2, 5, 4, 3, 6, 7))
  }
  test(
    "SwapElement switch two adjacent elements in between head and tail correctly"
  ) {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7)

    val index1 = 3
    val index2 = 4
    val newNumbers = numbers.swapElement(index1, index2)

    assert(newNumbers === Seq(1, 2, 3, 5, 4, 6, 7))
  }

  test("selectSort sort correctly") {
    val numbers: Seq[Int] = Seq(1, 2, 3, 5, 4, 6, 7)
    println(numbers.mkString(", "))
    val result = selectionSort(numbers)
    println(result.mkString(", "))
  }
}
