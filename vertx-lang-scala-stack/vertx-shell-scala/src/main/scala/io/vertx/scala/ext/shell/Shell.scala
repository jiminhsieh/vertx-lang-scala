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

package io.vertx.scala.ext.shell

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.shell.system.Job
import io.vertx.scala.ext.shell.system.JobController
import io.vertx.scala.ext.shell.cli.CliToken
import io.vertx.scala.ext.shell.session.Session

/**
  * An interactive session between a consumer and a shell.
  */
class Shell(private val _asJava: io.vertx.ext.shell.Shell) {

  def asJava: io.vertx.ext.shell.Shell = _asJava

  /**
    * Create a job, the created job should then be executed with the [[io.vertx.scala.ext.shell.system.Job#run]] method.
    * @param line the command line creating this job
    * @return the created job
    */
  def createJob(line: scala.collection.mutable.Buffer[io.vertx.scala.ext.shell.cli.CliToken]): io.vertx.scala.ext.shell.system.Job = {
    Job.apply(_asJava.createJob(line.map(x => if (x == null) null else x.asJava).asJava))
  }

  /**
    * See [[io.vertx.scala.ext.shell.Shell#createJob]]
    */
  def createJob(line: String): io.vertx.scala.ext.shell.system.Job = {
    Job.apply(_asJava.createJob(line))
  }

  /**
    * @return the shell's job controller
    */
  def jobController(): io.vertx.scala.ext.shell.system.JobController = {
    if (cached_0 == null) {
      cached_0=    JobController.apply(_asJava.jobController())
    }
    cached_0
  }

  /**
    * @return the current shell session
    */
  def session(): io.vertx.scala.ext.shell.session.Session = {
    if (cached_1 == null) {
      cached_1=    Session.apply(_asJava.session())
    }
    cached_1
  }

  /**
    * Close the shell.
    */
  def close(): Unit = {
    _asJava.close()
  }

  private var cached_0: io.vertx.scala.ext.shell.system.JobController = _
  private var cached_1: io.vertx.scala.ext.shell.session.Session = _
}

object Shell {

  def apply(_asJava: io.vertx.ext.shell.Shell): io.vertx.scala.ext.shell.Shell =
    new io.vertx.scala.ext.shell.Shell(_asJava)

}
