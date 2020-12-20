package up.selectionSort

import scala.annotation.tailrec

object SelectionSort {

  implicit class SequenceUtil(numbers: Seq[Int]) {
    def swapElement(index1: Int, index2: Int): Seq[Int] = {
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
        (((numbers.slice(0, index1) :+ numbers(index2)) ++ numbers.slice(
          index1 + 1,
          index2
        )) :+ numbers(index1)) ++ numbers.slice(index2 + 1, numbers.size)
      }
    }

    def indexMinValue(minIndex: Int): Int = {
      val (_, index) = numbers.slice(minIndex, numbers.size).zipWithIndex.min
      index
    }
  }

  def selectionSort(numbers: Seq[Int]): Seq[Int] = {
    import up.selectionSort.SelectionSort.SequenceUtil
    val lastIndex: Int = numbers.size - 1

    @tailrec
    def sort(sortedNumbers: Seq[Int], firstIndex: Int): Seq[Int] = {
      if (firstIndex == lastIndex - 1) sortedNumbers
      else {
        val minValueIndex = sortedNumbers.indexMinValue(firstIndex)
        val swappedNumbers =
          sortedNumbers.swapElement(firstIndex, minValueIndex)
        sort(swappedNumbers, firstIndex + 1)
      }
    }

    sort(numbers, 0)
  }

  def main(): Unit = {}
}
