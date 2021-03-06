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

package io.vertx.scala.core.streams

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.streams.{StreamBase => JStreamBase}
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  *
  * Represents a stream of data that can be written to.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.scala.core.streams.Pump]] to pump data from a `ReadStream`
  * to it.
  */
trait WriteStream[T]
    extends  StreamBase {

  def asJava: java.lang.Object

  /**
    * Set an exception handler on the write stream.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  override def exceptionHandler(handler: Handler[Throwable]): WriteStream[T]

  /**
    * Write some data to the stream. The data is put on an internal write queue, and the write actually happens
    * asynchronously. To avoid running out of memory by putting too much on the write queue,
    * check the [[io.vertx.scala.core.streams.WriteStream#writeQueueFull]] method before writing. This is done automatically if using a [[io.vertx.scala.core.streams.Pump]].
    * @param data the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(data: T): WriteStream[T]

  /**
    * Ends the stream.
    * 
    * Once the stream has ended, it cannot be used any more.
    */
  def end(): Unit

  /**
    * Same as [[io.vertx.scala.core.streams.WriteStream#end]] but writes some data to the stream before ending.
    */
  def end(t: T): Unit

  /**
    * Set the maximum size of the write queue to `maxSize`. You will still be able to write to the stream even
    * if there is more than `maxSize` items in the write queue. This is used as an indicator by classes such as
    * `Pump` to provide flow control.
    * <p/>
    * The value is defined by the implementation of the stream, e.g in bytes for a
    * [[io.vertx.scala.core.net.NetSocket]], the number of [[io.vertx.scala.core.eventbus.Message]] for a
    * [[io.vertx.scala.core.eventbus.MessageProducer]], etc...
    * @param maxSize the max size of the write stream
    * @return a reference to this, so the API can be used fluently
    */
  def setWriteQueueMaxSize(maxSize: Int): WriteStream[T]

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.streams.WriteStream#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean

  /**
    * Set a drain handler on the stream. If the write queue is full, then the handler will be called when the write
    * queue is ready to accept buffers again. See [[io.vertx.scala.core.streams.Pump]] for an example of this being used.
    * <p/>
    * The stream implementation defines when the drain handler, for example it could be when the queue size has been
    * reduced to `maxSize / 2`.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def drainHandler(handler: Handler[Unit]): WriteStream[T]

}

object WriteStream {
  def apply[T: TypeTag](asJava: JWriteStream[_]): WriteStream[T] = new WriteStreamImpl[T](asJava)
    private class WriteStreamImpl[T: TypeTag](private val _asJava: Object) extends WriteStream[T] {

      def asJava = _asJava

  /**
    * Set an exception handler on the write stream.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  override def exceptionHandler(handler: Handler[Throwable]): WriteStream[T] = {
    asJava.asInstanceOf[JWriteStream[Object]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  /**
    * Write some data to the stream. The data is put on an internal write queue, and the write actually happens
    * asynchronously. To avoid running out of memory by putting too much on the write queue,
    * check the [[io.vertx.scala.core.streams.WriteStream#writeQueueFull]] method before writing. This is done automatically if using a [[io.vertx.scala.core.streams.Pump]].
    * @param data the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(data: T): WriteStream[T] = {
    asJava.asInstanceOf[JWriteStream[Object]].write(toJava[T](data))
    this
  }

  /**
    * Set the maximum size of the write queue to `maxSize`. You will still be able to write to the stream even
    * if there is more than `maxSize` items in the write queue. This is used as an indicator by classes such as
    * `Pump` to provide flow control.
    * <p/>
    * The value is defined by the implementation of the stream, e.g in bytes for a
    * [[io.vertx.scala.core.net.NetSocket]], the number of [[io.vertx.scala.core.eventbus.Message]] for a
    * [[io.vertx.scala.core.eventbus.MessageProducer]], etc...
    * @param maxSize the max size of the write stream
    * @return a reference to this, so the API can be used fluently
    */
  def setWriteQueueMaxSize(maxSize: Int): WriteStream[T] = {
    asJava.asInstanceOf[JWriteStream[Object]].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Set a drain handler on the stream. If the write queue is full, then the handler will be called when the write
    * queue is ready to accept buffers again. See [[io.vertx.scala.core.streams.Pump]] for an example of this being used.
    * <p/>
    * The stream implementation defines when the drain handler, for example it could be when the queue size has been
    * reduced to `maxSize / 2`.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def drainHandler(handler: Handler[Unit]): WriteStream[T] = {
    asJava.asInstanceOf[JWriteStream[Object]].drainHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Same as [[io.vertx.scala.core.streams.WriteStream#end]] but writes some data to the stream before ending.
    */
  def end(t: T): Unit = {
    asJava.asInstanceOf[JWriteStream[Object]].end(toJava[T](t))
  }

  /**
    * Ends the stream.
    * 
    * Once the stream has ended, it cannot be used any more.
    */
  def end(): Unit = {
    asJava.asInstanceOf[JWriteStream[Object]].end()
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.streams.WriteStream#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    asJava.asInstanceOf[JWriteStream[Object]].writeQueueFull().asInstanceOf[Boolean]
  }

}
}
