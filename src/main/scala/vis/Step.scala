package vis
case class Step(arr: Array[Int],core:Core) extends collection.Seq[Int] {
  val length = arr.length
  def apply(index: Int) = {
    arr(index)
  }
  def update(index: Int, value: Int) = {
    //arr[index]にvalueが代入
    core.update(index,value)
    arr(index) = value
  }
  def iterator: Iterator[Int] = arr.iterator
}