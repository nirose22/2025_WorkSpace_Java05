package com.lambda_example;
@FunctionalInterface
public interface StringAnalyzer {
    public boolean analyze(String target, String searchStr);
}
