package com.fr.function;

import com.fr.report.cell.DefaultTemplateCellElement;
import com.fr.report.cell.TemplateCellElement;
import com.fr.script.AbstractFunction;

import java.util.ArrayList;
import java.util.List;

public class Testfunction1 extends AbstractFunction {
    @Override
    public Object run(Object[] objects) {
        Integer col = (Integer) objects[0];
        Integer row = (Integer) objects[1];
        TemplateCellElement cell = new DefaultTemplateCellElement(col,row);
        return cell.getValue().toString();
    }

    public static void main(String[] args) {
    }
}
