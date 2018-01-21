package sort
import vis.Step
object Bubble extends Sort {
  override def sort(data: Step): Unit = {
    println("buble")
    for (i <- 0 to  data.size-2) {
      for (j <- 1 until  data.size-i ) {
        if (data(j) < data(j-1)) {
          swap(data,j,j-1)
        }
      }
    }
  }
}