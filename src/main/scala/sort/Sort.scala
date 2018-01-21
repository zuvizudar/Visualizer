package sort
import vis.Step
trait Sort{
  def sort(data: Step)

  def swap(data:Step, i:Int, j:Int):Unit = {
    val temp = data(i)
    data(i) = data(j)
    data(j) = temp
  }
}
