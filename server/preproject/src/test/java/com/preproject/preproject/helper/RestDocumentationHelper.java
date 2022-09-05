package com.preproject.preproject.helper;

import org.springframework.restdocs.operation.preprocess.OperationPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.operation.preprocess.Preprocessors;

public class RestDocumentationHelper {

    public static OperationRequestPreprocessor prettyPrintRequest(){
        return Preprocessors.preprocessRequest(Preprocessors.prettyPrint());
    }

    public static OperationResponsePreprocessor prettyPrintResponse() {
        return Preprocessors.preprocessResponse(Preprocessors.prettyPrint());
    }

}
