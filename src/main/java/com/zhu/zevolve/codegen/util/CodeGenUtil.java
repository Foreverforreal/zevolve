package com.zhu.zevolve.codegen.util;

import com.zhu.zevolve.common.util.ZStringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CodeGenUtil {
    private static final String templatePrefix = "";

    private String targetSrcPath = "src/main/java";
    private String targetResPath = "src/main/resources";
    private String targetPackage = "com.zhu.zevolve";

    @Value("${codeGen.datasource.formatUrl}")
    private String jdbcUrl;
    @Value("${codeGen.datasource.driverClassName}")
    private String jdbcDriver;
    @Value("${codeGen.datasource.username}")
    private String jdbcUser;
    @Value("${codeGen.datasource.password}")
    private String jdbcPassword;

    public void gen(String schema, String tableName,String module) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();

        Context context = new Context(ModelType.FLAT);
        context.setId("Mysql");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty("javaFileEncoding","UTF-8");
        context.setJdbcConnectionConfiguration(getJDBCConnectionConfig(schema));

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        tableConfiguration.setSchema(schema);
        GeneratedKey generatedKey=new GeneratedKey("id","MySql",true,null);
        tableConfiguration.setGeneratedKey(generatedKey);
        context.addTableConfiguration(tableConfiguration);

        // 添加插件
        context.addPluginConfiguration(getMapperPlugin());
        context.addPluginConfiguration(getServiceTemplatePlugin(ZStringUtils.toUpperCamel(tableName),module));
        context.addPluginConfiguration(getServiceImpTemplatePlugin(ZStringUtils.toUpperCamel(tableName),module));

        // 添加生成项
        context.setJavaModelGeneratorConfiguration(getJavaModelGeneratorConfig(module));
        context.setSqlMapGeneratorConfiguration(getsqlMapGeneratorConfig(module));
        context.setJavaClientGeneratorConfiguration(getJavaClientGeneratorConfig(module));

        config.addContext(context);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }

    private JDBCConnectionConfiguration getJDBCConnectionConfig(String schema){
        JDBCConnectionConfiguration jdbcConfig = new JDBCConnectionConfiguration();
        jdbcConfig.setConnectionURL(String.format(jdbcUrl,schema));
        jdbcConfig.setDriverClass(jdbcDriver);
        jdbcConfig.setUserId(jdbcUser);
        jdbcConfig.setPassword(jdbcPassword);
        return jdbcConfig;
    }
    private JavaModelGeneratorConfiguration getJavaModelGeneratorConfig(String module){
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage(String.format("%s.%s.%s",targetPackage,module,"model"));
        javaModelGeneratorConfiguration.setTargetProject(targetSrcPath);
        return javaModelGeneratorConfiguration;
    }
    private SqlMapGeneratorConfiguration getsqlMapGeneratorConfig(String module){
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage(String.format("%s.%s","mapper",module));
        sqlMapGeneratorConfiguration.setTargetProject(targetResPath);
        return sqlMapGeneratorConfiguration;
    }
    private JavaClientGeneratorConfiguration getJavaClientGeneratorConfig(String module){
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetPackage(String.format("%s.%s.%s",targetPackage,module,"mapper"));
        javaClientGeneratorConfiguration.setTargetProject(targetSrcPath);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        return javaClientGeneratorConfiguration;
    }
    private PluginConfiguration getMapperPlugin(){
        PluginConfiguration mapperPluginConfig = new PluginConfiguration();
        mapperPluginConfig.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        mapperPluginConfig.addProperty("mappers","com.zhu.zevolve.common.base.mapper.BaseMapper");
        mapperPluginConfig.addProperty("caseSensitive","true");
        mapperPluginConfig.addProperty("forceAnnotation","true");
        mapperPluginConfig.addProperty("beginningDelimiter","`");
        mapperPluginConfig.addProperty("endingDelimiter","`");
        return mapperPluginConfig;
    }

    private PluginConfiguration getServiceTemplatePlugin(String className,String module){
        return getTemplatePlugin("templates/Service.ftl",className+"Service.java","service",module);
    }
    private PluginConfiguration getServiceImpTemplatePlugin(String className,String module){
        return getTemplatePlugin("templates/ServiceImpl.ftl",className+"ServiceImpl.java","service.serviceImpl",module);
    }

    private PluginConfiguration getTemplatePlugin(String templatePath,String fileName,String subPackage,String module){
        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.TemplateFilePlugin");
        pluginConfiguration.addProperty("targetProject",targetSrcPath);
        pluginConfiguration.addProperty("targetPackage",String.format("%s.%s.%s",targetPackage,module,subPackage));

        pluginConfiguration.addProperty("templatePath",templatePath);
        pluginConfiguration.addProperty("fileName",fileName);
        return  pluginConfiguration;
    }

}
