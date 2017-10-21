package com.brokencranium.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vicky on 10/21/17.
 */
public class ItemActorTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void placeAndReadItem(){
        TestActorRef<ItemActor> actorRef = TestActorRef.create(system, Props.create(ItemActor.class));
        actorRef.tell(new ItemMessage(12345, "test item", 5, 10), ActorRef.noSender());

        ItemActor itemActor = actorRef.underlyingActor();
        assertEquals(itemActor.getMessage().getItemNumber(), Integer.valueOf(12345));
    }

}
