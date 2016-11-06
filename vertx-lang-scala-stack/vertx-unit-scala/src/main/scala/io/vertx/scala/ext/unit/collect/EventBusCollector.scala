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

package io.vertx.scala.ext.unit.collect

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.unit.report.TestSuiteReport
import io.vertx.scala.core.Vertx
import io.vertx.core.Handler
import io.vertx.scala.core.eventbus.MessageConsumer
import io.vertx.ext.unit.report.ReportingOptions

/**
  * The event bus collector listen to events on the Vert.x event bus and translate them
  * into reports.
  */
class EventBusCollector(private val _asJava: io.vertx.ext.unit.collect.EventBusCollector) {

  def asJava: io.vertx.ext.unit.collect.EventBusCollector = _asJava

  /**
    * Register the collector as a consumer of the event bus with the specified address.
    * @param address the registration address
    * @return the subscribed message consumer
    */
  def register(address: String): io.vertx.scala.core.eventbus.MessageConsumer = {
    MessageConsumer.apply(_asJava.register(address))
  }

}

object EventBusCollector {

  def apply(_asJava: io.vertx.ext.unit.collect.EventBusCollector): io.vertx.scala.ext.unit.collect.EventBusCollector =
    new io.vertx.scala.ext.unit.collect.EventBusCollector(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.unit.report.ReportingOptions): io.vertx.scala.ext.unit.collect.EventBusCollector = {
    EventBusCollector.apply(io.vertx.ext.unit.collect.EventBusCollector.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

  def create(vertx: io.vertx.scala.core.Vertx, reporter: io.vertx.scala.ext.unit.report.TestSuiteReport => Unit): io.vertx.scala.ext.unit.collect.EventBusCollector = {
    EventBusCollector.apply(io.vertx.ext.unit.collect.EventBusCollector.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], funcToMappedHandler(TestSuiteReport.apply)(reporter)))
  }

}