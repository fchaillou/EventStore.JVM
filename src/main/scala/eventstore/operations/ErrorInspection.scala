package eventstore
package operations

import Inspection.Decision.Stop

import scala.reflect.ClassTag
import scala.util.{ Failure, Success }

private[eventstore] abstract class ErrorInspection[I <: In, E](implicit val in: ClassTag[I], error: ClassTag[E])
    extends Inspection {

  def expected = in.runtimeClass

  def pf = {
    case Success(in(_))    => Stop
    case Failure(error(x)) => decision(x)
  }

  def decision(error: E): Inspection.Decision
}