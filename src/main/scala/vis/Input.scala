package vis

import javafx.event.ActionEvent

import sort._

import scala.util.Random
import scalafx.scene.control.Button
import scalafx.scene.layout.{BorderPane, HBox}
import scalafx.scene.text.Font

//直したい。。
case class Input(core: Core,info: Info) extends BorderPane{
  var step = Step(core.now_arr,core)
  var button_list = List[Button]()

  val bubble = new Button("bubble")
  val insertion = new Button("Insertion")
  val merge = new Button("Merge")
  val quick = new Button("Quick")
  val selection = new Button("Selection")
  val shell = new Button("Shell")

  val start = new Button("Start")
  val stop = new Button("Stop")
  val reset = new Button("Reset")

  bubble.onAction = (event: ActionEvent) =>  {
    Bubble.sort(step)
  }
  insertion.onAction = (event: ActionEvent) =>  {
    Insertion.sort(step)
  }
  merge.onAction = (event: ActionEvent) =>  {
    Merge.sort(step)
  }
  quick.onAction = (event: ActionEvent) =>  {
    Quick.sort(step)
  }
  selection.onAction = (event: ActionEvent) =>  {
    Selection.sort(step)
  }
  shell.onAction = (event: ActionEvent) =>  {
    Shell.sort(step)
  }
  start.onAction = (event:ActionEvent) => {
    core.anim.start()
    println("start")
    println(core.action.size)
  }
  stop.onAction = (event:ActionEvent) => {
    core.anim.stop()
    println("stop")
  }
  reset.onAction = (event:ActionEvent) => {
    for(i<- 0 until core.action.size ){
      core.action.dequeue()
    }
    for(i<- 0 until core.circle_seq.size ){
      val arr = Random.shuffle(0 to info.NUM-1).toArray
      core.init(arr)
      step = Step(arr,core)
    }
  }

  bubble.setFont(new Font(20))
  insertion.setFont(new Font(20))
  merge.setFont(new Font(20))
  quick.setFont(new Font(20))
  selection.setFont(new Font(20))
  shell.setFont(new Font(20))
  start.setFont(new Font(20))
  stop.setFont(new Font(20))
  reset.setFont(new Font(20))

  val hBox = new HBox()
  hBox.getChildren().addAll(bubble,insertion,merge,quick,selection,shell)
  val hBox2 = new HBox()
  hBox2.getChildren().addAll(start,stop,reset)
  left  = hBox
  right = hBox2
}
