package com.zhu.zevolve.codegen.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CodeGenUtil {
    private String targetProject = "src/main/java";

    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.driverClassName}")
    private String jdbcDriver;
    @Value("${spring.datasource.username}")
    private String jdbcUser;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    public void gen() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();

        Context context = new Context(ModelType.FLAT);
        context.setId("Mysql");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty("javaFileEncoding","UTF-8");

        JDBCConnectionConfiguration jdbcConfig = new JDBCConnectionConfiguration();
        jdbcConfig.setConnectionURL(jdbcUrl);
        jdbcConfig.setDriverClass(jdbcDriver);
        jdbcConfig.setUserId(jdbcUser);
        jdbcConfig.setPassword(jdbcPassword);
        context.setJdbcConnectionConfiguration(jdbcConfig);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.TemplateFilePlugin");
        pluginConfiguration.addProperty("targetProject",targetProject);
        pluginConfiguration.addProperty("targetPackage","com.zhu.zevolve.codegen.model");
        pluginConfiguration.addProperty("templatePath","generator/test-one.ftl");
        pluginConfiguration.addProperty("mapperSuffix","Dao");
        pluginConfiguration.addProperty("fileName","Test.txt");
        context.addPluginConfiguration(pluginConfiguration);

        PluginConfiguration pluginConfiguration1 = new PluginConfiguration();
        pluginConfiguration1.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration1.addProperty("mappers","com.zhu.zevolve.common.base.mapper.BaseMapper");
        pluginConfiguration1.addProperty("caseSensitive","true");
        pluginConfiguration1.addProperty("forceAnnotation","true");
        pluginConfiguration1.addProperty("beginningDelimiter","`");
        pluginConfiguration1.addProperty("endingDelimiter","`");
        context.addPluginConfiguration(pluginConfiguration1);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName("sys_user");
        tableConfiguration.setSchema("measite");
        context.addTableConfiguration(tableConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage("com.zhu.zevolve.codegen.model");
        javaModelGeneratorConfiguration.setTargetProject(targetProject);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage("com.zhu.zevolve.codegen.mapper");
        sqlMapGeneratorConfiguration.setTargetProject(targetProject);
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetPackage("com.zhu.zevolve.codegen.mapper");
        javaClientGeneratorConfiguration.setTargetProject(targetProject);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        config.addContext(context);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for (String warning : warnings) {
            System.out.println(warning);
        }
    }


    private void addServiceTemplate(Context context){
        addTemplate(context,"generator/test-one.ftl");
    }

    private void addTemplate(Context context,String templatePath){
        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.TemplateFilePlugin");
        pluginConfiguration.addProperty("targetProject",targetProject);
        pluginConfiguration.addProperty("targetPackage","com.zhu.zevolve.codegen.model");
        pluginConfiguration.addProperty("templatePath",templatePath);
        pluginConfiguration.addProperty("fileName","Test.txt");
        context.addPluginConfiguration(pluginConfiguration);
    }


}
