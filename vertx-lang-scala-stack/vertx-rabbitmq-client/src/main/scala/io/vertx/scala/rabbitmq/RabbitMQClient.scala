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

package io.vertx.scala.rabbitmq

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.rabbitmq.{RabbitMQClient => JRabbitMQClient}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  */
class RabbitMQClient(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Acknowledge one or several received messages. Supply the deliveryTag from the AMQP.Basic.GetOk or AMQP.Basic.Deliver
    * method containing the received message being acknowledged.
    */
  def basicAck(deliveryTag: Long, multiple: Boolean, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].basicAck(deliveryTag.asInstanceOf[java.lang.Long], multiple.asInstanceOf[java.lang.Boolean], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Reject one or several received messages.
    */
  def basicNack(deliveryTag: Long, multiple: Boolean, requeue: Boolean, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].basicNack(deliveryTag.asInstanceOf[java.lang.Long], multiple.asInstanceOf[java.lang.Boolean], requeue.asInstanceOf[java.lang.Boolean], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Retrieve a message from a queue using AMQP.Basic.Get
    */
  def basicGet(queue: String, autoAck: Boolean, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].basicGet(queue.asInstanceOf[java.lang.String], autoAck.asInstanceOf[java.lang.Boolean], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Start a non-nolocal, non-exclusive consumer, with auto acknowledgement and a server-generated consumerTag.
    */
  def basicConsume(queue: String, address: String, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].basicConsume(queue.asInstanceOf[java.lang.String], address.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Start a non-nolocal, non-exclusive consumer, with a server-generated consumerTag.
    */
  def basicConsume(queue: String, address: String, autoAck: Boolean, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].basicConsume(queue.asInstanceOf[java.lang.String], address.asInstanceOf[java.lang.String], autoAck.asInstanceOf[java.lang.Boolean], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Publish a message. Publishing to a non-existent exchange will result in a channel-level protocol exception,
    * which closes the channel. Invocations of Channel#basicPublish will eventually block if a resource-driven alarm is in effect.
    */
  def basicPublish(exchange: String, routingKey: String, message: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].basicPublish(exchange.asInstanceOf[java.lang.String], routingKey.asInstanceOf[java.lang.String], message, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Request specific "quality of service" settings, Limiting the number of unacknowledged messages on
    * a channel (or connection). This limit is applied separately to each new consumer on the channel.
    */
  def basicQos(prefetchCount: Int, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].basicQos(prefetchCount.asInstanceOf[java.lang.Integer], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Declare an exchange.
    */
  def exchangeDeclare(exchange: String, `type`: String, durable: Boolean, autoDelete: Boolean, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].exchangeDeclare(exchange.asInstanceOf[java.lang.String], `type`.asInstanceOf[java.lang.String], durable.asInstanceOf[java.lang.Boolean], autoDelete.asInstanceOf[java.lang.Boolean], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Declare an exchange with additional parameters such as dead lettering or an alternate exchnage.
    */
  def exchangeDeclare(exchange: String, `type`: String, durable: Boolean, autoDelete: Boolean, config: scala.collection.mutable.Map[String, String], resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].exchangeDeclare(exchange.asInstanceOf[java.lang.String], `type`.asInstanceOf[java.lang.String], durable.asInstanceOf[java.lang.Boolean], autoDelete.asInstanceOf[java.lang.Boolean], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Delete an exchange, without regard for whether it is in use or not.
    */
  def exchangeDelete(exchange: String, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].exchangeDelete(exchange.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Bind an exchange to an exchange.
    */
  def exchangeBind(destination: String, source: String, routingKey: String, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].exchangeBind(destination.asInstanceOf[java.lang.String], source.asInstanceOf[java.lang.String], routingKey.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Unbind an exchange from an exchange.
    */
  def exchangeUnbind(destination: String, source: String, routingKey: String, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].exchangeUnbind(destination.asInstanceOf[java.lang.String], source.asInstanceOf[java.lang.String], routingKey.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Actively declare a server-named exclusive, autodelete, non-durable queue.
    */
  def queueDeclareAuto(resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].queueDeclareAuto({x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Declare a queue
    */
  def queueDeclare(queue: String, durable: Boolean, exclusive: Boolean, autoDelete: Boolean, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].queueDeclare(queue.asInstanceOf[java.lang.String], durable.asInstanceOf[java.lang.Boolean], exclusive.asInstanceOf[java.lang.Boolean], autoDelete.asInstanceOf[java.lang.Boolean], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Delete a queue, without regard for whether it is in use or has messages on it
    */
  def queueDelete(queue: String, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].queueDelete(queue.asInstanceOf[java.lang.String], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Delete a queue
    */
  def queueDeleteIf(queue: String, ifUnused: Boolean, ifEmpty: Boolean, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].queueDeleteIf(queue.asInstanceOf[java.lang.String], ifUnused.asInstanceOf[java.lang.Boolean], ifEmpty.asInstanceOf[java.lang.Boolean], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Bind a queue to an exchange
    */
  def queueBind(queue: String, exchange: String, routingKey: String, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].queueBind(queue.asInstanceOf[java.lang.String], exchange.asInstanceOf[java.lang.String], routingKey.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Returns the number of messages in a queue ready to be delivered.
    */
  def messageCount(queue: String, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].messageCount(queue.asInstanceOf[java.lang.String], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  /**
    * Start the rabbitMQ client. Create the connection and the chanel.
    */
  def start(resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].start({x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Stop the rabbitMQ client. Close the connection and its chanel.
    */
  def stop(resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQClient].stop({x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Check if a connection is open
    * @return true when the connection is open, false otherwise
    */
  def isConnected(): Boolean = {
    asJava.asInstanceOf[JRabbitMQClient].isConnected().asInstanceOf[Boolean]
  }

  /**
    * Check if a channel is open
    * @return true when the connection is open, false otherwise
    */
  def isOpenChannel(): Boolean = {
    asJava.asInstanceOf[JRabbitMQClient].isOpenChannel().asInstanceOf[Boolean]
  }

 /**
   * Acknowledge one or several received messages. Supply the deliveryTag from the AMQP.Basic.GetOk or AMQP.Basic.Deliver
   * method containing the received message being acknowledged.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def basicAckFuture(deliveryTag: Long, multiple: Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRabbitMQClient].basicAck(deliveryTag.asInstanceOf[java.lang.Long], multiple.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Reject one or several received messages.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def basicNackFuture(deliveryTag: Long, multiple: Boolean, requeue: Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRabbitMQClient].basicNack(deliveryTag.asInstanceOf[java.lang.Long], multiple.asInstanceOf[java.lang.Boolean], requeue.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Retrieve a message from a queue using AMQP.Basic.Get
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def basicGetFuture(queue: String, autoAck: Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRabbitMQClient].basicGet(queue.asInstanceOf[java.lang.String], autoAck.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Start a non-nolocal, non-exclusive consumer, with auto acknowledgement and a server-generated consumerTag.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def basicConsumeFuture(queue: String, address: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].basicConsume(queue.asInstanceOf[java.lang.String], address.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Start a non-nolocal, non-exclusive consumer, with a server-generated consumerTag.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def basicConsumeFuture(queue: String, address: String, autoAck: Boolean): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].basicConsume(queue.asInstanceOf[java.lang.String], address.asInstanceOf[java.lang.String], autoAck.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Publish a message. Publishing to a non-existent exchange will result in a channel-level protocol exception,
   * which closes the channel. Invocations of Channel#basicPublish will eventually block if a resource-driven alarm is in effect.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def basicPublishFuture(exchange: String, routingKey: String, message: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].basicPublish(exchange.asInstanceOf[java.lang.String], routingKey.asInstanceOf[java.lang.String], message, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Request specific "quality of service" settings, Limiting the number of unacknowledged messages on
   * a channel (or connection). This limit is applied separately to each new consumer on the channel.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def basicQosFuture(prefetchCount: Int): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].basicQos(prefetchCount.asInstanceOf[java.lang.Integer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Declare an exchange.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def exchangeDeclareFuture(exchange: String, `type`: String, durable: Boolean, autoDelete: Boolean): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].exchangeDeclare(exchange.asInstanceOf[java.lang.String], `type`.asInstanceOf[java.lang.String], durable.asInstanceOf[java.lang.Boolean], autoDelete.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Declare an exchange with additional parameters such as dead lettering or an alternate exchnage.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def exchangeDeclareFuture(exchange: String, `type`: String, durable: Boolean, autoDelete: Boolean, config: scala.collection.mutable.Map[String, String]): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].exchangeDeclare(exchange.asInstanceOf[java.lang.String], `type`.asInstanceOf[java.lang.String], durable.asInstanceOf[java.lang.Boolean], autoDelete.asInstanceOf[java.lang.Boolean], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Delete an exchange, without regard for whether it is in use or not.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def exchangeDeleteFuture(exchange: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].exchangeDelete(exchange.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Bind an exchange to an exchange.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def exchangeBindFuture(destination: String, source: String, routingKey: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].exchangeBind(destination.asInstanceOf[java.lang.String], source.asInstanceOf[java.lang.String], routingKey.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Unbind an exchange from an exchange.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def exchangeUnbindFuture(destination: String, source: String, routingKey: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].exchangeUnbind(destination.asInstanceOf[java.lang.String], source.asInstanceOf[java.lang.String], routingKey.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Actively declare a server-named exclusive, autodelete, non-durable queue.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def queueDeclareAutoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRabbitMQClient].queueDeclareAuto(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Declare a queue
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def queueDeclareFuture(queue: String, durable: Boolean, exclusive: Boolean, autoDelete: Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRabbitMQClient].queueDeclare(queue.asInstanceOf[java.lang.String], durable.asInstanceOf[java.lang.Boolean], exclusive.asInstanceOf[java.lang.Boolean], autoDelete.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Delete a queue, without regard for whether it is in use or has messages on it
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def queueDeleteFuture(queue: String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRabbitMQClient].queueDelete(queue.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Delete a queue
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def queueDeleteIfFuture(queue: String, ifUnused: Boolean, ifEmpty: Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRabbitMQClient].queueDeleteIf(queue.asInstanceOf[java.lang.String], ifUnused.asInstanceOf[java.lang.Boolean], ifEmpty.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Bind a queue to an exchange
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def queueBindFuture(queue: String, exchange: String, routingKey: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].queueBind(queue.asInstanceOf[java.lang.String], exchange.asInstanceOf[java.lang.String], routingKey.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Returns the number of messages in a queue ready to be delivered.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def messageCountFuture(queue: String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JRabbitMQClient].messageCount(queue.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Start the rabbitMQ client. Create the connection and the chanel.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def startFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].start(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Stop the rabbitMQ client. Close the connection and its chanel.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
  def stopFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQClient].stop(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RabbitMQClient {
  def apply(asJava: JRabbitMQClient) = new RabbitMQClient(asJava)  
  def create(vertx: Vertx, config: io.vertx.core.json.JsonObject): RabbitMQClient = {
    RabbitMQClient(JRabbitMQClient.create(vertx.asJava.asInstanceOf[JVertx], config))
  }

}
