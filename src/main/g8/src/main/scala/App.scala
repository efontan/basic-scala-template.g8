package $organization$.$name$
import com.typesafe.config.ConfigFactory

object HelloWorld extends App {
  val message: String = ConfigFactory.load().getString("example-message")
  
  println(message)
}
