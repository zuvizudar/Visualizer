package vis

import scala.util.Random
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.layout._
import scalafx.scene.paint.Color


object visualize extends JFXApp {
  val info = Info(1200,900,400)
  val arr = Random.shuffle(0 to info.NUM-1).toArray
  val core = Core(arr,info)
  val button = Input(core,info)

  var screen = new Scene(info.WIDTH,info.HEIGHT){
    fill = Color.Black
    content = new BorderPane{
      center = core
      bottom = button
    }
  }

  stage = new JFXApp.PrimaryStage() {
    title = "Sort Visualizer"
    scene = screen
  }
}
