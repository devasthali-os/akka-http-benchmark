import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import com.typesafe.config.{Config, ConfigFactory}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

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
  } ~
    path("chat-non-blocking") {
      get {
        complete {

          Future {
            val starts = System.currentTimeMillis()

            val resp = HttpEntity(ContentTypes.`application/json`,
              """{"data": "Hi, How can i help you?"}""".stripMargin)

            //println("timeTakenMillis:" + (System.currentTimeMillis() - starts))

            resp
          }
        }
      }
    }

}

class Server extends HttpRoutes {

  val config: Config = ConfigFactory.load()

//  implicit val nluSystem = akka.actor.typed.ActorSystem(Behaviors.empty, "rest-api-benchmark")
  implicit val nluSystem: ActorSystem = ActorSystem("rest-api-benchmark", config.getConfig("actor-system-dev"))
  implicit val actorExecutor: ActorMaterializer = ActorMaterializer()

  def startServer(address: String, port: Int): Unit = {
    val b = Http().newServerAt(address, port).bind(route)

    //b.flatMap(_.unbind()).onComplete(_ => nluSystem.terminate())

  }

}

object Server {

  def main(args: Array[String]) {

    new Server().startServer("localhost", 9191)

  }
}
