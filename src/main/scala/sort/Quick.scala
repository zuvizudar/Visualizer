package sort
import vis.Step

object Quick extends Sort{
  override def sort(data: Step): Unit ={
    quickSort(data, 0, data.length-1)
  }

  def quickSort(data: Step, startIndex: Int, endIndex:Int):Step={
  if (startIndex >= endIndex)
      return data

    val middleValue = data(startIndex)
    var i = startIndex
    var j = endIndex

    while(i != j){
      while (i < j && data(j) >= middleValue){
        j -= 1
      }
      data(i) = data(j)
      while (i < j && data(i) <= middleValue){
        i += 1
      }
      data(j) = data(i)
    }
    data(i) = middleValue
    quickSort(data, startIndex, i-1)
    quickSort(data, j+1, endIndex)
    data
  }
}