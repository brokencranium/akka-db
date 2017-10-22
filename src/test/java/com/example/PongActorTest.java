package com.example;
import akka.dispatch.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;
import org.junit.Test;
import scala.compat.java8.FutureConverters;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


/**
 * Created by vicky on 10/21/17.
 */
public class PongActorTest {
    ActorSystem actorSystem = ActorSystem.create();
    ActorRef actorRef = actorSystem.actorOf(Props.create(PongActor.class));

    @Test
    public void shouldReplyPingWithPong() throws Exception {
        Timeout timeout = new Timeout(Duration.create(5, "seconds"));


        Future<Object> future = Patterns.ask(actorRef, new PongActor.PongMessage("Ping"), timeout);
        Await.result(future, timeout.duration());
        //        CompletionStage<String> completionStage = FutureConverters.toJava(sFuture.);
//            CompletableFuture<String> jfuture = (CompletableFuture<String>) completionStage;
//            assert(jfuture.get(1000, TimeUnit.MILLISECONDS).equals("Pon"));
    }

}
