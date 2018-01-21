package sort

import vis.Step

object Insertion extends Sort{

  override def sort(data: Step): Unit = {
    val max_index = data.length - 1
    for (i <- 1 to max_index){
      val start_index = i
      for (j <- start_index to 1 by -1){
        if (data(j) < data(j-1)){
          swap(data, j, j-1)
        }
      }
    }
  }
}