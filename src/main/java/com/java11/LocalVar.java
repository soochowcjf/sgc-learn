package com.java11;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author cjf on 2020/2/28 19:52
 */
public class LocalVar {

    public static void main(String[] args) {
        Arrays.asList("Java", "Python", "Ruby")
                .forEach((var s) -> {
                    System.out.println("Hello, " + s);
                });

    }

    @Test
    public void fun() {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.qq.com/")).GET().build();
        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, bodyHandler);
        future.thenApply(HttpResponse::body).thenAccept(System.out::println).join();
    }

    @Test
    public void fun2() {
        List<String> list = List.of("Java", "Python", "Ruby");
        // 旧的方法:传入String[]:
        String[] oldway = list.toArray(new String[0]);

        // 新的方法:传入IntFunction:
        String[] newway = list.toArray(String[]::new);

    }

    @Test
    public void fun3() {
        String s = " Hello, JDK11!\u3000\u3000";
        System.out.println("     original: [" + s + "]");
        System.out.println("         trim: [" + s.trim() + "]");
        System.out.println("        strip: [" + s.strip() + "]");
        System.out.println(" stripLeading: [" + s.stripLeading() + "]");
        System.out.println("stripTrailing: [" + s.stripTrailing() + "]");


        // 由一个空格和一个中文空格构成
        String s1 = " \u3000";
        System.out.println(s1.isEmpty());
        System.out.println(s1.isBlank());


        String s2 = "Java\nPython\nRuby";
        s2.lines().forEach(System.out::println);


        System.out.println("-".repeat(10));
    }

    @Test
    public void fun4() throws IOException {
        Files.writeString(
                Path.of("./", "tmp.txt"),
                "hello, jdk11 files api",
                StandardCharsets.UTF_8);
        String s = Files.readString(
                Paths.get("./tmp.txt"),
                StandardCharsets.UTF_8);
    }
}
