package com.example;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.concurrent.Future;

import static akka.pattern.Patterns.ask;
import static org.junit.Assert.assertEquals;
import static scala.compat.java8.FutureConverters.toJava;

/**
 * Created by vicky on 10/21/17.
 */
public class PongActorTest {
  ActorSystem system = ActorSystem.create();
  ActorRef actorRef =
      system.actorOf(Props.create(PongActorResponse.class), "BruceWillis");

  @Test
  public void shouldReplyToPingWithPong() throws Exception {
    Future sFuture = ask(actorRef, new PongActorResponse.PongMessage("Ping"), 1000);
    final CompletionStage<PongActorResponse.PongMessage> cs = toJava(sFuture);
    final CompletableFuture<PongActorResponse.PongMessage> jFuture = (CompletableFuture<PongActorResponse.PongMessage>) cs;
    assertEquals("Pong", jFuture.get(1000, TimeUnit.MILLISECONDS).getText());
  }
}
