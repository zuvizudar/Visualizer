package vis

import scala.collection.mutable.Queue
import scalafx.animation.AnimationTimer
import scalafx.scene.layout.Pane
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle

case class Core(now_arr:Array[Int],info:Info) extends  Pane{
  var circle_seq = Seq[Circle]()
  var action = Queue[Action]()
  init(now_arr)

  val anim = AnimationTimer((t: Long) => {
    for (i <- 0 to 1) {//ここでスピード変えたい
      if (action.nonEmpty) {
        val tmp = action.dequeue
        tmp.action.apply()
      }
    }
  })

  def init (arr:Array[Int]) ={
    var seq = Seq[Circle]()
    action.clear()
    val x_dis = info.WIDTH / info.NUM
    val y_dis = (info.HEIGHT-40)/info.NUM //40はボタン幅、直したい。。
    for (i <- 0 until  arr.length){
      val y = info.NUM-arr(i) //scalafxの仕様で画面上部が0、下方向が+となっているため
      val circle = Circle(i*x_dis,y*y_dis,4)
      circle.fill = Color.White
      seq :+= circle
    }
    circle_seq = seq
    children = seq
  }
  def update(index:Int,value:Int):Unit = {
    record_action{
      circle_seq(index).centerY.value = (info.NUM-value) * ((info.HEIGHT-40)/info.NUM)//40はボタン幅、直したい。。
    }
  }
  def record_action(op: => Unit):Unit = {
    val tmp = Action(()=> op )
    action.enqueue(tmp)
  }
}
