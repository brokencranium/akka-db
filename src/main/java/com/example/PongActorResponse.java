package com.example;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;

public class PongActorResponse extends AbstractActor {

  public PartialFunction receive() {
    return ReceiveBuilder.
        match(PongActorResponse.PongMessage.class, pongMessage -> {
          sender().tell(new PongActorResponse.PongMessage("Pong"), ActorRef.noSender());
        }).
        matchAny(x -> sender().tell(new Status.Failure(new Exception("uknown message")), self())).
        build();
  }

  public static class PongMessage {

    private final String text;

    public PongMessage(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }
  }
}
