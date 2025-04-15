package com.lambda_example;

public class LambdaTest {

    public static void main(String[] args) {
        String[] strList01 = {"tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"};

        AnalyzerTool stringTool = new AnalyzerTool();
        String searchStr = "to";

        System.out.println("Searching for: " + searchStr);

        System.out.println("==Contains==");
        stringTool.showResult(strList01, searchStr, new StringAnalyzer() {
            @Override
            public boolean analyze(String target, String searchStr) {
                return target.contains(searchStr);
            }
        });


        System.out.println("==Starts With==");
        //stringTool.showResult(strList01, searchStr, (t1, t2) -> t1.startsWith(t2));
        stringTool.showResult(strList01, searchStr, String::startsWith);

        System.out.println("==Equals==");
        stringTool.showResult(strList01, searchStr, String::equals);

        System.out.println("==Ends With==");
        stringTool.showResult(strList01, searchStr, String::endsWith);

        System.out.println("==Less than 5==");
        stringTool.showResult(strList01, searchStr, (t1, t2) -> t1.length() < 5);

        System.out.println("==Greater than 5==");
        stringTool.showResult(strList01, searchStr, (t1, t2) -> t1.length() > 5);
    }
    
}
