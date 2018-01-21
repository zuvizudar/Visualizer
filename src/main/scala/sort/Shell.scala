package sort
import vis.Step
object Shell extends Sort{

  override def sort(data :Step):Unit= {
    val N = data.length
    var k:Int = 1
    while (k < N / 3) {
      k = 3 * k + 1
    }

    while (k >= 1) {
      for (i <- k until  N) {
        var j = i
        while (j >=k && data(j) < data(j-k)) {
          swap(data, j, j-k)
          j -= k
        }
      }
      k = k/3
    }
    data
  }
}