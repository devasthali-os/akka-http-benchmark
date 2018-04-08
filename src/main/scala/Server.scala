import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext.Implicits.global

trait HttpRoutes {

  val route: Route = path("chat") {
    get {
      complete {

        val starts = System.currentTimeMillis()

        val resp = HttpEntity(ContentTypes.`application/json`,
          """{"data": "Hi, How can i help you?"}""".stripMargin)

        //println("timeTakenMillis:" + (System.currentTimeMillis() - starts))

        resp
      }
    }
  }

}

class Server extends HttpRoutes {

  implicit val nluSystem: ActorSystem = ActorSystem("api-benchs")
  implicit val actorExecutor: ActorMaterializer = ActorMaterializer()

  def startServer(address: String, port: Int): Unit = {
    val b = Http().bindAndHandle(route, address, port)

    //b.flatMap(_.unbind()).onComplete(_ => nluSystem.terminate())

  }

}

object Server {

  def main(args: Array[String]) {

    new Server().startServer("localhost", 9191)

  }
}
