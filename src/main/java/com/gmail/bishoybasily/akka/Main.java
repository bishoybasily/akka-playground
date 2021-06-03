package com.gmail.bishoybasily.akka;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.gmail.bishoybasily.akka.actors.Counter;
import lombok.Data;

public class Main {

    public static void main(String[] args) {
//        Counter.ref("counter").tell(null, ActorRef.noSender());

        var ref1 = ActorSystem.create().actorOf(Props.create(Counter.class), "key");
        var ref2 = ActorSystem.create().actorOf(Props.create(Counter.class), "key");

        System.out.printf("%s, %s%n", ref1, ref2);

    }

}
