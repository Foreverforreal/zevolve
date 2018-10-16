package com.zhu.zevolve.codegen.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.generator.MapperPlugin;
import tk.mybatis.mapper.generator.TemplateFilePlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

        MapperPlugin mapperPlugin = new MapperPlugin();
        mapperPlugin.setContext(context);
        Properties properties = new Properties();
        properties.setProperty("mappers","com.zhu.zevolve.common.base.mapper.BaseMapper");
        properties.setProperty("caseSensitive","true");
        properties.setProperty("forceAnnotation","true");
        properties.setProperty("beginningDelimiter","`");
        properties.setProperty("endingDelimiter","`");
        mapperPlugin.setProperties(properties);

        TemplateFilePlugin mapperTemplateFilePlugin = new TemplateFilePlugin();
        mapperTemplateFilePlugin.setContext(context);
        Properties properties1 = new Properties();
        properties1.setProperty("targetProject",targetProject);
        properties1.setProperty("targetPackage","com.zhu.zevolve.codegen.model");
        properties1.setProperty("templatePath","src/resources/templates/model.ftl");
        properties1.setProperty("mapperSuffix","Dao");
        properties1.setProperty("fileName","Model.java");
        mapperTemplateFilePlugin.setProperties(properties1);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName("sys_user");
        tableConfiguration.setSchema("measite");

        config.addContext(context);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public void genModel(){

    }


}
