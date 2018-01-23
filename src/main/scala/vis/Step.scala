package vis
case class Step(arr: Array[Int],core:Core) extends Seq[Int] {

  def update(idx: Int, elem: Int): Unit = {
    //arr[idx]にelem代入
    core.update(idx, elem)
    arr(idx) = elem
  }

  override def length: Int = arr.length

  override def apply(idx: Int): Int = {
    arr(idx)
  }

  override def iterator: Iterator[Int] = arr.iterator
}