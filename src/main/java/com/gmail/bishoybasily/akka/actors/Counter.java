package com.gmail.bishoybasily.akka.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import lombok.Data;

public class Counter extends AbstractLoggingActor {

    private int count;

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Message.class, this::handle).build();
    }

    @Data
    static class Message {

        private int value;

    }

    private void handle(Message message) {
        count += message.value;
    }

    public static ActorRef ref(String key) {
        return ActorSystem.create().actorOf(Props.create(Counter.class), key);
    }

}
