package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.pipeline.Annotation;
import vn.pipeline.VnCoreNLP;
import vn.pipeline.Word;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    private static final int NUM_INSTANCES = 100;
    private static final int MAX_ITER = 100;
    private static final double LEARNING_RATE = 0.1;
    private static final int theta = 0;

    @RequestMapping("/botreply")
    public @ResponseBody String botReply(@RequestBody String text) throws IOException {

        double[] x = new double [NUM_INSTANCES];
        double[] y = new double [NUM_INSTANCES];
        double[] z = new double [NUM_INSTANCES];
        double[] t = new double [NUM_INSTANCES];
        int[] outputs = new int [NUM_INSTANCES];

        //fifty random points of class 1
        for(int i = 0; i < NUM_INSTANCES/2; i++){
            x[i] = randomNumber(5 , 10);
            y[i] = randomNumber(4 , 8);
            z[i] = randomNumber(2 , 9);
            t[i] = randomNumber(2 , 7);
            outputs[i] = 1;
            System.out.println(x[i]+"\t"+y[i]+"\t"+z[i]+"\t"+t[i]+"\t"+outputs[i]);
        }

        //fifty random points of class 0
        for(int i = 50; i < NUM_INSTANCES; i++){
            x[i] = randomNumber(-1 , 3);
            y[i] = randomNumber(-4 , 2);
            z[i] = randomNumber(-3 , 5);
            t[i] = randomNumber(-2 , 3);
            outputs[i] = 0;
            System.out.println(x[i]+"\t"+y[i]+"\t"+z[i]+"\t"+outputs[i]);
        }

        double[] k = plaAlgorithm(x,y,z,t,outputs);

        String[] annotators = {"wseg", "pos", "ner", "parse"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);
        List<Word> words = annotation.getWords();

        List<String> wordSeperation = new ArrayList<String>();

        String d1 = "bạn muốn mua bao nhiêu chiếc pizza";
        String d4 = "mua thôi chứ còn gì nữa";
        String d5 = "mua loại rẻ hay đắt";
        String d6 = "cảm ơn vì ghé thăm của hàng";
        String d7 = "Thôi Không mua nữa";
        String d8 = "goodbye";
        String d10 = "thế à, lần sau đến mua nhé";

        List<String> d = Arrays.asList(d1, d4, d5, d6, d7, d8, d10);
        List<List<String>> documents = extract(d);



//        List<String> doc1 = Arrays.asList("Lorem", "lk", "dolor", "ipsum", "sit", "mua");
//        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "mua", "pro", "quo");
//        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "mua");
//        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);

        String[] featured = {"N", "Np", "V", "M"};
        for (Word word: words) {
            if (Arrays.asList(featured).contains(word.getPosTag())){
                wordSeperation.add(word.getForm());
            }
        }

        double[] vectorClient = new double[5];
        int i = 0;
        for (String str : wordSeperation){
            System.out.println(str + "   " + extractFeaturedUseTfIdfAlgorithm(wordSeperation, documents, str));
            vectorClient[i] = extractFeaturedUseTfIdfAlgorithm(wordSeperation, documents, str);
            i++;
        }

        int check = calculate(theta, k, vectorClient);

        System.out.println(annotation);
        System.out.println(wordSeperation);

        return "ok";
    }

    private List<List<String>> extract(List<String> string) throws IOException {
        List<List<String>> lists = new ArrayList<List<String>>();
        String[] annotators = {"wseg", "pos", "ner", "parse"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);
        for (String str: string) {
            Annotation annotation = new Annotation(str);
            pipeline.annotate(annotation);
            List<Word> words = annotation.getWords();

            List<String> list = new ArrayList<String>();
            String[] featured = {"N", "Np", "V", "M"};
            for (Word word: words) {
                if (Arrays.asList(featured).contains(word.getPosTag())){
                    list.add(word.getForm());
                }
            }

            lists.add(list);
        }

        return lists;
    }

    private double[] plaAlgorithm(double[] x, double[] y, double[] z, double[] t, int[] outputs){

        double[] weights = new double[5];// 3 for input variables and one for bias
        double localError, globalError;
        int i, p, iteration, output;

        weights[0] = randomNumber(0,1);// w1
        weights[1] = randomNumber(0,1);// w2
        weights[2] = randomNumber(0,1);// w3
        weights[3] = randomNumber(0,1);// w3
        weights[4] = randomNumber(0,1);// this is the bias

        iteration = 0;
        do {
            iteration++;
            globalError = 0;
            //loop through all instances (complete one epoch)
            for (p = 0; p < NUM_INSTANCES; p++) {
                // calculate predicted class
                output = calculateOutput(theta,weights, x[p], y[p], z[p], t[p]);
                // difference between predicted and actual class values
                localError = outputs[p] - output;
                //update weights and bias
                weights[0] += LEARNING_RATE * localError * x[p];
                weights[1] += LEARNING_RATE * localError * y[p];
                weights[2] += LEARNING_RATE * localError * z[p];
                weights[3] += LEARNING_RATE * localError * t[p];
                weights[4] += LEARNING_RATE * localError;
                //summation of squared error (error value for all instances)
                globalError += (localError*localError);
            }

            /* Root Mean Squared Error */
            System.out.println("Iteration "+iteration+" : RMSE = "+Math.sqrt(globalError/NUM_INSTANCES));
        } while (globalError != 0 && iteration<=MAX_ITER);

        System.out.println("\n=======\nDecision boundary equation:");
        System.out.println(weights[0] +"*x + "+weights[1]+"*y +  "+weights[2]+"*z + "+weights[3]+"*t "+weights[4]+ " = 0");

        return weights;
    }

    private double extractFeaturedUseTfIdfAlgorithm(List<String> wordSeperation, List<List<String>> dataSet, String word) {
        return tf(wordSeperation, word) * idf(dataSet, word);
    }

    private double tf(List<String> list, String word) {
        double result = 0;
        for (String data : list) {
            if (word.equalsIgnoreCase(data)){
                result++;
            }
        }
        return result/list.size();
    }

    private double idf(List<List<String>> dataSet, String word) {
        double result = 0;
        for (List<String> list: dataSet) {
            for (String data : list) {
                if (word.equalsIgnoreCase(data)) {
                    result++;
                    break;
                }
            }
        }
        if (result == 0){
            result = 1;
        }
        double e = Math.log(dataSet.size()/result);
        return Math.log(dataSet.size()/result);
    }

    private static double randomNumber(int min , int max) {
        DecimalFormat df = new DecimalFormat("#.####");
        double d = min + Math.random() * (max - min);
        String s = df.format(d);
        double x = Double.parseDouble(s);
        return x;
    }

    static int calculateOutput(int theta, double weights[], double x, double y, double z, double t)
    {
        double sum = x * weights[0] + y * weights[1] + z * weights[2] + t * weights[3] + weights[4];
        return (sum >= theta) ? 1 : 0;
    }

    static int calculate(int theta, double weights[], double data[])
    {
        double sum = data[0] * weights[0] + data[1] * weights[1] + data[2] * weights[2] + data[3] * weights[3] + weights[4];
        return (sum >= theta) ? 1 : 0;
    }

}
