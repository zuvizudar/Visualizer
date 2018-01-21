package sort

import vis.Step

object Merge extends Sort{

  override def sort(data: Step): Unit = {
    sort(data, 0, data.length-1)
  }

  def sort(data: Step, lo:Int, hi:Int): Unit = {
    if (lo >= hi){
      return
    }
    val mid = lo + (hi - lo) / 2
    sort(data, lo, mid)
    sort(data, mid+1, hi)
    merge(data, lo, mid, hi)
  }

  def merge(data: Step, lo:Int, mid:Int, hi:Int):Unit = {
    var i = lo
    var j = mid + 1
    val size = hi - lo + 1
    val values = Array.ofDim[Int](size)
    for (cursor <- 0 until size) {
      if (i > mid || ( j<= hi && data(j) < data(i) ) ){
        values(cursor) = data(j)
        j += 1
      } else if (j > hi || data(i) < data(j)) {
        values(cursor) = data(i)
        i += 1
      }
    }
    for (cursor <- 0 until  size) {
      data(lo + cursor) = values(cursor)
    }
  }

}