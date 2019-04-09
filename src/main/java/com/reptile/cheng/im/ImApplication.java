package com.reptile.cheng.im;

import com.reptile.cheng.im.message.Reponse;
import com.reptile.cheng.im.server.ImServer;
import com.reptile.cheng.im.session.SessionManager;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class ImApplication implements CommandLineRunner {

    @Value("${im.server.port}")
    private int port;


    public static void main(String[] args) {
        SpringApplication.run(ImApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(port);
        ImServer.run(port);
        getInput();
    }

    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String next = scanner.nextLine();
            Reponse reponse = new Reponse();
            reponse.setMessage(next);
            Channel channel = SessionManager.getChannel(123456L);
            channel.writeAndFlush(reponse);
        }
    }
}
