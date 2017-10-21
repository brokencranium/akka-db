package com.brokencranium.akka;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

/**
 * Created by vicky on 10/21/17.
 */
public class ItemActor extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);

    protected ItemMessage item;

    public ItemActor() {
        receive(ReceiveBuilder.
                match(ItemMessage.class, message -> {
                    item = new ItemMessage(message.getItemNumber(), message.getDescription(), message.getThawTimeMinutes(), message.getShelfLife());
                    log.info("Item set to {} {}", item.getItemNumber(), item.getDescription());
                }).
                matchAny(o -> log.info("Unknow message type sent {}", o)).
                build()
        );
    }

    public ItemMessage getMessage(){
        return item;
    }
}
