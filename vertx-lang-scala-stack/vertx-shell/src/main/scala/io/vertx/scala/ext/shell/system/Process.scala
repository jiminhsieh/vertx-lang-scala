/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.shell.system

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.shell.system.ExecStatus
import io.vertx.ext.shell.term.{Tty => JTty}
import io.vertx.scala.ext.shell.session.Session
import io.vertx.scala.ext.shell.term.Tty
import io.vertx.ext.shell.system.{Process => JProcess}
import io.vertx.core.Handler
import io.vertx.ext.shell.session.{Session => JSession}

/**
  * A process managed by the shell.
  */
class Process(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Option[Tty] = None
  private var cached_1: Option[Session] = None

  /**
    * @return the process tty
    */
  def getTty(): Tty = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JProcess].getTty()
      cached_0 = Some(Tty(tmp))
    }
    cached_0.get
  }

  /**
    * @return the process session
    */
  def getSession(): Session = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JProcess].getSession()
      cached_1 = Some(Session(tmp))
    }
    cached_1.get
  }

  /**
    * Set the process tty.
    * @param tty the process tty
    * @return this object
    */
  def setTty(tty: Tty): Process = {
    asJava.asInstanceOf[JProcess].setTty(tty.asJava.asInstanceOf[JTty])
    this
  }

  /**
    * Set the process session
    * @param session the process session
    * @return this object
    */
  def setSession(session: Session): Process = {
    asJava.asInstanceOf[JProcess].setSession(session.asJava.asInstanceOf[JSession])
    this
  }

  /**
    * Set an handler for being notified when the process terminates.
    * @param handler the handler called when the process terminates.
    * @return this object
    */
  def terminatedHandler(handler: Handler[Int]): Process = {
    asJava.asInstanceOf[JProcess].terminatedHandler({x: java.lang.Integer => handler.handle(x.asInstanceOf[Int])})
    this
  }

  /**
    * Run the process.
    *
    */
  def run(): Unit = {
    asJava.asInstanceOf[JProcess].run()
  }

  /**
    * Attempt to interrupt the process.
    * @return true if the process caught the signal
    */
  def interrupt(): Boolean = {
    asJava.asInstanceOf[JProcess].interrupt().asInstanceOf[Boolean]
  }

  /**
    * Suspend the process.
    */
  def resume(): Unit = {
    asJava.asInstanceOf[JProcess].resume()
  }

  /**
    * Suspend the process.
    */
  def resume(foreground: Boolean): Unit = {
    asJava.asInstanceOf[JProcess].resume(foreground.asInstanceOf[java.lang.Boolean])
  }

  /**
    * Suspend the process.
    * @param completionHandler handler called after resume callback
    */
  def resume(completionHandler: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JProcess].resume({x: Void => completionHandler.handle(x)})
  }

  /**
    * Resume the process.
    */
  def suspend(): Unit = {
    asJava.asInstanceOf[JProcess].suspend()
  }

  /**
    * Terminate the process.
    */
  def terminate(): Unit = {
    asJava.asInstanceOf[JProcess].terminate()
  }

  /**
    * Set the process in background.
    */
  def toBackground(): Unit = {
    asJava.asInstanceOf[JProcess].toBackground()
  }

  /**
    * Set the process in foreground.
    */
  def toForeground(): Unit = {
    asJava.asInstanceOf[JProcess].toForeground()
  }

  /**
    * @return the current process status
    */
  def status(): io.vertx.ext.shell.system.ExecStatus = {
    asJava.asInstanceOf[JProcess].status()
  }

  /**
    * @return the process exit code when the status is ExecStatus#TERMINATED otherwise `null`
    */
  def exitCode(): Int = {
    asJava.asInstanceOf[JProcess].exitCode().asInstanceOf[Int]
  }

  /**
    * Run the process.
    *
    */
  def run(foregraound: Boolean): Unit = {
    asJava.asInstanceOf[JProcess].run(foregraound.asInstanceOf[java.lang.Boolean])
  }

  /**
    * Attempt to interrupt the process.
    * @param completionHandler handler called after interrupt callback
    * @return true if the process caught the signal
    */
  def interrupt(completionHandler: Handler[Unit]): Boolean = {
    asJava.asInstanceOf[JProcess].interrupt({x: Void => completionHandler.handle(x)}).asInstanceOf[Boolean]
  }

  /**
    * Suspend the process.
    * @param completionHandler handler called after resume callback
    */
  def resume(foreground: Boolean, completionHandler: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JProcess].resume(foreground.asInstanceOf[java.lang.Boolean], {x: Void => completionHandler.handle(x)})
  }

  /**
    * Resume the process.
    * @param completionHandler handler called after suspend callback
    */
  def suspend(completionHandler: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JProcess].suspend({x: Void => completionHandler.handle(x)})
  }

  /**
    * Terminate the process.
    * @param completionHandler handler called after end callback
    */
  def terminate(completionHandler: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JProcess].terminate({x: Void => completionHandler.handle(x)})
  }

  /**
    * Set the process in background.
    * @param completionHandler handler called after background callback
    */
  def toBackground(completionHandler: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JProcess].toBackground({x: Void => completionHandler.handle(x)})
  }

  /**
    * Set the process in foreground.
    * @param completionHandler handler called after foreground callback
    */
  def toForeground(completionHandler: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JProcess].toForeground({x: Void => completionHandler.handle(x)})
  }

}

object Process {
  def apply(asJava: JProcess) = new Process(asJava)  
}
