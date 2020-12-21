package up.selectionSort

import scala.annotation.tailrec

object SelectionSort {

  def swapElement(numbers: Seq[Int], index1: Int, index2: Int): Seq[Int] = {
    val headIndex = 0
    val tailIndex = numbers.size - 1
    if (index1 == headIndex && index2 == tailIndex) {
      numbers(index2) +: numbers.slice(1, tailIndex) :+ numbers.head
    } else if (index1 == headIndex || index2 == tailIndex) {
      if (index2 == tailIndex) {
        ((numbers.slice(0, index1) :+ numbers(index2)) ++ numbers.slice(
          index1 + 1,
          tailIndex
        )) :+ numbers(index1)
      } else {
        ((numbers(index2) +: numbers.slice(
          index1 + 1,
          index2
        )) :+ numbers.head) ++ numbers.slice(index2 + 1, numbers.size)
      }
    } else {
      (((numbers.slice(headIndex, index1) :+ numbers(index2)) ++ numbers
        .slice(
          index1 + 1,
          index2
        )) :+ numbers(index1)) ++ numbers.slice(index2 + 1, numbers.size)
    }
  }

  def indexMinValue(numbers: Seq[Int], minIndex: Int): Int = {
    val (_, index) = numbers.slice(minIndex, numbers.size).zipWithIndex.min
    index + minIndex
  }

  def selectionSort(numbers: Seq[Int]): Seq[Int] = {

    val lastIndex: Int = numbers.size - 1

    @tailrec
    def sort(sortedNumbers: Seq[Int], firstIndex: Int): Seq[Int] = {

      if (firstIndex == lastIndex - 1) sortedNumbers
      else {
        val minValueIndex = indexMinValue(sortedNumbers, firstIndex)
        if (firstIndex != minValueIndex) {
          val swappedNumbers =
            swapElement(
              sortedNumbers,
              firstIndex,
              minValueIndex
            )

          sort(swappedNumbers, firstIndex + 1)
        } else { sort(sortedNumbers, firstIndex + 1) }
      }
    }

    sort(numbers, 0)
  }

  def main(): Unit = {}
}
