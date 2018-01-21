package sort
import vis.Step

object Selection extends Sort{

  override def sort(data: Step): Unit = {
    val end_index = data.length - 1
    for (i <- 0 to end_index) {
      val start_index = i + 1
      var min_value = data.apply(i)
      var min_index = i
      for (j <- start_index to end_index) {
        if (data(j).compareTo(min_value) < 0) {
          min_value = data.apply(j)
          min_index = j
        }
      }
      if (min_index != i) {
        swap(data, min_index, i)
      }
    }
  }
}