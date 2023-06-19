package com.test.cases.testCase2.populator;

import com.test.cases.testCase2.model.AcademicProgram;
import com.test.cases.testCase2.model.Graph;

public interface ProgramConvertor {
    void populate(AcademicProgram source, Graph target);
}
