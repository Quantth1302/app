package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.pipeline.Annotation;
import vn.pipeline.Sentence;
import vn.pipeline.VnCoreNLP;

import java.io.IOException;
import java.io.PrintStream;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/botreply")
    public @ResponseBody String botReply(@RequestBody String text) throws IOException {

        String[] annotators = {"wseg", "pos", "ner", "parse"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);

        System.out.println(annotation);

        return "ok";
//        String greet = "hello";
//        String rep;
//        if (text.equals(greet)){
//            rep = "hello";
//        }else rep = "I dont understand you =))";
//        return rep;
    }
}
