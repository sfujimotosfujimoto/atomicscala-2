package com.atomicscala.reporterr

import scala.util.Failure
import scala.util.control.NoStackTrace

/* com.atomicscala / sfujimoto: 2017/07/03 19:17 */

class FailMsg(val msg:String) extends Throwable with NoStackTrace {
  override def toString = msg

}

object Fail {
  def apply(msg:String) =
    Failure(new FailMsg(msg))
}