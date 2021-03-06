package eventstore.examples

import eventstore.{ EventStream, ReadEvent, EventStoreExtension }
import akka.actor.ActorSystem

object EventStoreExtensionExample {
  val system = ActorSystem()

  EventStoreExtension(system).actor ! ReadEvent(EventStream.Id("stream"))
  EventStoreExtension(system).connection.future(ReadEvent(EventStream.Id("stream")))
}
