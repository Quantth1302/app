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

//        double[] x = new double [NUM_INSTANCES];
//        double[] y = new double [NUM_INSTANCES];
//        double[] z = new double [NUM_INSTANCES];
//        double[] t = new double [NUM_INSTANCES];
//        int[] outputs = new int [NUM_INSTANCES];
//
//        //fifty random points of class 1
//        for(int i = 0; i < NUM_INSTANCES/2; i++){
//            x[i] = randomNumber(5 , 10);
//            y[i] = randomNumber(4 , 8);
//            z[i] = randomNumber(2 , 9);
//            t[i] = randomNumber(2 , 7);
//            outputs[i] = 1;
//            System.out.println(x[i]+"\t"+y[i]+"\t"+z[i]+"\t"+t[i]+"\t"+outputs[i]);
//        }
//
//        //fifty random points of class 0
//        for(int i = 50; i < NUM_INSTANCES; i++){
//            x[i] = randomNumber(-1 , 3);
//            y[i] = randomNumber(-4 , 2);
//            z[i] = randomNumber(-3 , 5);
//            t[i] = randomNumber(-2 , 3);
//            outputs[i] = 0;
//            System.out.println(x[i]+"\t"+y[i]+"\t"+z[i]+"\t"+outputs[i]);
//        }

//        double[] k = plaAlgorithm(x,y,z,t,outputs);

        String[] annotators = {"wseg", "pos", "ner", "parse"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);
        List<Word> words = annotation.getWords();

        String d1 = "bạn muốn mua bao nhiêu chiếc pizza";
        String d4 = "mua thôi chứ còn gì nữa";
        String d5 = "mua loại rẻ hay đắt";
        String d01 = "Chiếc pizza loại a1 đang giảm giá, bạn có muốn mua nó k";
        String d02 = "Chiếc pizza loại a2 đang giảm giá, muốn mua nó kh";
        String d03 = "Chiếc pizza loại a3 đang giảm giá, bạn có muốn mua nó nh";
        String d04 = "Chiếc pizza loại a4 đang giảm giá, bạn có muốn mua nó kh";
        String d05 = "Chiếc pizza loại a5 đang giảm giá, mua ";
        String d06 = "Chiếc pizza loại a6 đang giảm giá, bạn có muốn mua nó nhá";
        String d07 = "Chiếc pizza loại a7 đang giảm giá, bạn có muốn mua nó kh";
        String d08 = "Chiếc pizza loại a8 đang giảm giá, bạn có muốn mua nó kh";
        String d09 = "Chiếc pizza loại a9 đang giảm giá, bạn có muốn mua nó kh";
        String d10 = "Chiếc pizza loại a10 đang giảm giá, bạn có muốn mua nó kh";
        String d11 = "Chiếc pizza loại a11 đang giảm giá, bạn có muốn mua nó kh";
        String d12 = "Chiếc pizza loại a12 đang giảm giá, bạn có muốn mua nó kh";
        String d13 = "Chiếc pizza loại a13 đang giảm giá, bạn có muốn mua nó kh";
        String d14 = "Chiếc pizza loại a14 đang giảm giá, bạn có muốn mua nó kh";
        String d15 = "Chiếc pizza loại a15 đang giảm giá, bạn có muốn mua nó kh";
        String d16 = "Chiếc pizza loại a16 đang giảm giá, bạn có muốn mua nó kh";
        String d17 = "Chiếc pizza loại a17 đang giảm giá, bạn có muốn mua nó kh";
        String d18 = "Chiếc pizza loại a18 đang giảm giá, bạn có muốn mua nó kh";
        String d19 = "Chiếc pizza loại a19 đang giảm giá, bạn có muốn mua nó kh";
        String d20 = "Chiếc pizza loại a20 đang giảm giá, bạn có muốn mua nó kh";
        String d21 = "Chiếc pizza loại a21 đang giảm giá, bạn có muốn mua nó kh";
        String d22 = "Chiếc pizza loại a22 đang giảm giá, bạn có muốn mua nó kh";
        String d23 = "Chiếc pizza loại a23 đang giảm giá, bạn có muốn mua nó kh";
        String d24 = "Chiếc pizza loại a24 đang giảm giá, bạn có muốn mua nó kh";
        String d25 = "Chiếc pizza loại a25 đang giảm giá, bạn có muốn mua nó kh";
        String d26 = "Chiếc pizza loại a26 đang giảm giá, bạn có muốn mua nó kh";
        String d27 = "Chiếc pizza loại a27 đang giảm giá, bạn có muốn mua nó kh";
        String d28 = "Chiếc pizza loại a28 đang giảm giá, bạn có muốn mua nó kh";
        String d29 = "Chiếc pizza loại a29 đang giảm giá, bạn có muốn mua nó kh";
        String d30 = "Chiếc pizza loại A30 đang giảm giá, bạn có muốn mua nó kh";
        String d31 = "Chiếc pizza loại A31 đang giảm giá, bạn có muốn mua nó kh";
        String d32 = "Chiếc pizza loại A32 đang giảm giá, bạn có muốn mua nó kh";
        String d33 = "Chiếc pizza loại A33 đang giảm giá, bạn có muốn mua nó kh";
        String d34 = "Chiếc pizza loại A34 đang giảm giá, bạn có muốn mua nó kh";
        String d35 = "Chiếc pizza loại A35 đang giảm giá, bạn có muốn mua nó kh";
        String d36 = "Chiếc pizza loại A36 đang giảm giá, bạn có muốn mua nó kh";
        String d37 = "Chiếc pizza loại A37 đang giảm giá, bạn có muốn mua nó kh";
        String d38 = "Chiếc pizza loại A38 đang giảm giá, bạn có muốn mua nó kh";
        String d39 = "Chiếc pizza loại A39 đang giảm giá, bạn có muốn mua nó kh";
        String d40 = "Chiếc pizza loại A40 đang giảm giá, bạn có muốn mua nó kh";
        String d41 = "Chiếc pizza loại A41 đang giảm giá, bạn có muốn mua nó kh";
        String d42 = "Chiếc pizza loại A42 đang giảm giá, bạn có muốn mua nó kh";
        String d43 = "Chiếc pizza loại A43 đang giảm giá, bạn có muốn mua nó kh";
        String d44 = "Chiếc pizza loại A44 đang giảm giá, bạn có muốn mua nó kh";
        String d45 = "Chiếc pizza loại A45 đang giảm giá, bạn có muốn mua nó kh";
        String d46 = "Chiếc pizza loại A46 đang giảm giá, bạn có muốn mua nó kh";
        String d47 = "Chiếc pizza loại A47 đang giảm giá, bạn có muốn mua nó kh";
        String d48 = "Chiếc pizza loại A48 đang giảm giá, bạn có muốn mua nó kh";
        String d49 = "Chiếc pizza loại A49 đang giảm giá, bạn có muốn mua nó kh";
        String d50 = "Chiếc pizza loại A50 đang giảm giá, bạn có muốn mua nó kh";
        String d6 = "cảm ơn vì ghé thăm của hàng";
        String d7 = "Thôi Không mua nữa";
        String d8 = "goodbye";
        String d010 = "Thế ha";
        String d011 = "lần sau đến nhé";
        String d012 = "lần sau đến nhé";
        String d013 = "buồn th";
        String d014 = "buồn v";
        String d015 = "không mua thì ra chỗ kh";
        String d016= "a";
        String d017 = "bye";
        String d018= "Bạn muốn hỗ trợ thêm gì kh";
        String d0110 = "k";
        String d0111 = "tuityui";
        String d0112 = "qwerrt";
        String d0113 = "qwer";
        String d0114 = "iyuio";
        String d0115 = "hjklé";
        String d0116 = "uioyu";
        String d0118 = "ghjfghj";
        String d0119 = "m,bnm,";
        String d0120 = "bnm,";
        String d0121 = "ghjdfg";
        String d0122 = "trthdfg";
        String d0123 = "vbncvbc";
        String d0124 = "cvbnc";
        String d0125 = "sfsdfgsdf";
        String d0126 = "ooooooo";
        String d0127 = "pppppp";
        String d0128 = "ooooo";
        String d0129 = "xcvzxcz";
        String d0130 = "cvcvcvdf";
        String d0131 = "sdfsdfs";
        String d0132 = "hijiij";
        String d0133 = "xcvxcvxvsdf";
        String d0134 = "bncvnc";
        String d0135 = "ghkghk";
        String d0136 = "mnbnmbnm";
        String d0137 = "bnmcgh";
        String d0138 = "fdghdfgh";
        String d0139 = "thdfghdfgnhé";
        String d0140 = "thdfghdfghnhé";
        String d0141 = "thdfgdhcbnnhé";
        String d0142 = "thcvbncvbnđến";
        String d0143 = "thế à, lầcbncbn";
        String d0144 = "thếaaaaaan nhé";
        String d0145 = "thếsdfgsdfghé";
        String d0146 = "thsdfgsdfsdfhé";
        String d0147 = "thếerwesdfsến nhé";
        String d0148 = "th245234n n2hé";
        String d0149 = "t23 sau đến nhé";
        String d0150 = "th234234345đến nhé";

        List<String> d = Arrays.asList(d1, d4, d5, d6, d7, d8, d10, d01, d02,d03,d04,d05,d06,d07,d08,d09,d11,d12,d13,d14,d15,d16,d17,d18,d19,
                d20,d21,d22,d23,d24,d25,d26,d27,d28,d29,d30,d31,d32,d33,d34,d35,d36,d37,d38,d39,d40,d41,d42,d43,d44,d45,d46,d47,d48,d49,
                d010,d011,d012,d013,d014,d015,d016,d017,d018,d0110,d0111,d0112,d0113,d0114,d0115,d0116,d0118,d0119,d0120,d0121,d0122,d0123,d0124,d0125,d0126,d0127,d0128,d0129,
                d0130,d0131,d0132,d0133,d0134,d0135,d0136,d0137,d0138,d0139,d0140,d0141,d0142,d0143,d0144,d0145,d0146,d0147,d0148,d0149,d0150);
        List<List<String>> documents = extract(d);

        List<List<String>> docAfter = new ArrayList<>();

        for (List<String> element : documents) {
        }
//        List<String> doc1 = Arrays.asList("Lorem", "lk", "dolor", "ipsum", "sit", "mua");
//        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "mua", "pro", "quo");
//        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "mua");
//        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);

        List<String> wordSeperation = new ArrayList<String>();

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

        if (i-1 < 3){
            for (int j = i; j < 3; j++){
                vectorClient[j] = 0;
            }
        }

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

//    private double[] plaAlgorithm(double[] x, double[] y, double[] z, double[] t, int[] outputs){
//
//        double[] weights = new double[5];// 3 for input variables and one for bias
//        double localError, globalError;
//        int i, p, iteration, output;
//
//        weights[0] = randomNumber(0,1);// w1
//        weights[1] = randomNumber(0,1);// w2
//        weights[2] = randomNumber(0,1);// w3
//        weights[3] = randomNumber(0,1);// w3
//        weights[4] = randomNumber(0,1);// this is the bias
//
//        iteration = 0;
//        do {
//            iteration++;
//            globalError = 0;
//            //loop through all instances (complete one epoch)
//            for (p = 0; p < NUM_INSTANCES; p++) {
//                // calculate predicted class
//                output = calculateOutput(theta,weights, x[p], y[p], z[p], t[p]);
//                // difference between predicted and actual class values
//                localError = outputs[p] - output;
//                //update weights and bias
//                weights[0] += LEARNING_RATE * localError * x[p];
//                weights[1] += LEARNING_RATE * localError * y[p];
//                weights[2] += LEARNING_RATE * localError * z[p];
//                weights[3] += LEARNING_RATE * localError * t[p];
//                weights[4] += LEARNING_RATE * localError;
//                //summation of squared error (error value for all instances)
//                globalError += (localError*localError);
//            }
//
//            /* Root Mean Squared Error */
//            System.out.println("Iteration "+iteration+" : RMSE = "+Math.sqrt(globalError/NUM_INSTANCES));
//        } while (globalError != 0 && iteration<=MAX_ITER);
//
//        System.out.println("\n=======\nDecision boundary equation:");
//        System.out.println(weights[0] +"*x + "+weights[1]+"*y +  "+weights[2]+"*z + "+weights[3]+"*t "+weights[4]+ " = 0");
//
//        return weights;
//    }

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
            result = -1;
        }
//        double e = Math.log(dataSet.size()/result);
        return Math.log(dataSet.size()/result);
    }

//    private static double randomNumber(int min , int max) {
//        DecimalFormat df = new DecimalFormat("#.####");
//        double d = min + Math.random() * (max - min);
//        String s = df.format(d);
//        double x = Double.parseDouble(s);
//        return x;
//    }

//    static int calculateOutput(int theta, double weights[], double x, double y, double z, double t)
//    {
//        double sum = x * weights[0] + y * weights[1] + z * weights[2] + t * weights[3] + weights[4];
//        return (sum >= theta) ? 1 : 0;
//    }
//
//    static int calculate(int theta, double weights[], double data[])
//    {
//        double sum = data[0] * weights[0] + data[1] * weights[1] + data[2] * weights[2] + data[3] * weights[3] + weights[4];
//        return (sum >= theta) ? 1 : 0;
//    }

}
