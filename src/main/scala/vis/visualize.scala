package vis


import scala.util.Random
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.layout._
import scalafx.scene.paint.Color


object visualize extends JFXApp {
  val info = Info(1200,900,200)

  val arr = Random.shuffle(0 to info.NUM-1).toArray
  val sort_vis = Core(arr,info)

  val button = Input(sort_vis,info)
  println("A")
  val layout = new BorderPane{
    center = sort_vis
    bottom = button
  }

  var screen = new Scene(info.WIDTH,info.HEIGHT){
    fill = Color.Black
    content = layout
  }

  stage = new JFXApp.PrimaryStage() {
    title = "Sort Visualizer"
    scene = screen
  }
}
