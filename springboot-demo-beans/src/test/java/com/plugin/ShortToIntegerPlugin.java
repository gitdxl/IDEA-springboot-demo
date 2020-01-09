package com.plugin;

import com.jdrx.generator.annotation.PluginAdaptor;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

/*
 * 项目名  jdrx-smartyu-warning-app
 * Created by zhongdev.
 * Created at 2019-07-25
 * 将PO类中Short类型换成Integer类型
 */


@PluginAdaptor
public class ShortToIntegerPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        String typeName = field.getType().getShortName();
        if (typeName.equals("Short")) {
            FullyQualifiedJavaType type = new FullyQualifiedJavaType("java.lang.Integer");
            field.setType(type);
        }
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        String typeName = method.getReturnType().getShortName();
        if (typeName.equals("Short")) {
            FullyQualifiedJavaType type = new FullyQualifiedJavaType("java.lang.Integer");
            method.setReturnType(type);
        }
        return super.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        List<Parameter> parameters = method.getParameters();
        if (parameters.size() == 1) {
            Parameter parameter = parameters.get(0);
            FullyQualifiedJavaType type = parameter.getType();
            String typeName = type.getShortName();
            if (typeName.equals("Short")) {
                FullyQualifiedJavaType intType = new FullyQualifiedJavaType("java.lang.Integer");
                Parameter intParameter = new Parameter(intType, parameter.getName(), parameter.isVarargs());
                parameters.clear();
                parameters.add(intParameter);
            }
        }
        return super.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }
}
