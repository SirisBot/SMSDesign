package com.example.android.smsappempty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

class Person implements Listener {
    int id;
    String name;
    List<String> messages;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
        messages = new ArrayList<String>();
    }

    @Override
    public void onReceiveMessage(String message) {
        messages.add(message);
    }
}

class SMSApp {
    // Design the SMSApp, data structure and the following 3 methods.
    // Each person subscribes to listeners to receive the messages that will be sent to them.
    // Once a listener triggers to receive message, the person who has subscribed the listeners can receive the messages.

    private HashMap<Listener, HashSet<Person>> listenerMap = new HashMap<>();

    public void subscribe(Person person, Listener l) {
        HashSet<Person> personSet = new HashSet<Person>();
        personSet.add(person);
        listenerMap.put(l, personSet);
    }

    public void unsubscribe(Person person, Listener l){
        listenerMap.remove(person);
    }

    public void sendMessage(Listener l, String message){
        l.onReceiveMessage(message);
    }
}

interface Listener{
    void onReceiveMessage(String message);
}
