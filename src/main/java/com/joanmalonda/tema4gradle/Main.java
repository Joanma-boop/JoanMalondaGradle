package com.joanmalonda.tema4gradle;

import dev.langchain4j.data.message.*;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        var model = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("demo")
                .modelName("llama3.1:8b")
                .build();

        List<ChatMessage> history = new ArrayList<>();

        history.add(new UserMessage("Hola, soy Carlos"));
        AiMessage r1 = model.chat(history).aiMessage();
        history.add(r1);

        history.add(new UserMessage("¿Cómo me llamo?"));
        AiMessage r2 = model.chat(history).aiMessage();

        System.out.println(r2.text());

        var modelA = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("demo")
                .modelName("llama3.1:8b")
                .build();

        var modelB = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("demo")
                .modelName("llama3.1:8b")
                .build();

        String pregunta = modelA.chat("Haz una pregunta interesante sobre programación Java");

        System.out.println("IA A pregunta:");
        System.out.println(pregunta);

        String respuesta = modelB.chat(pregunta);

        System.out.println("\nIA B responde:");
        System.out.println(respuesta);

    }
}
