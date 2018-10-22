package com.zhu.zevolve.codegen.util;

import com.zhu.zevolve.common.util.ZStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
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
        schema = schema.toLowerCase();
        tableName = tableName.toLowerCase();
        module = module.toLowerCase();
        log.debug("---准备在模块{}中生成表{}.{}对应代码---",module,schema,tableName);

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();

        Context context = new Context(ModelType.FLAT);
        context.setId("Mysql");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty("javaFileEncoding","UTF-8");
        context.setJdbcConnectionConfiguration(getJDBCConnectionConfig(schema));

        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.setConfigurationType("com.zhu.zevolve.codegen.ZJavaTypeResolver");
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);

        // 添加模板插件
        context.addPluginConfiguration(getMapperPlugin());
        context.addPluginConfiguration(getMapperTemplatePlugin(module, ZStringUtils.toUpperCamel(tableName)));      //添加Dao
        context.addPluginConfiguration(getServiceTemplatePlugin(module, ZStringUtils.toUpperCamel(tableName)));     //添加Service
        context.addPluginConfiguration(getServiceImplTemplatePlugin(module, ZStringUtils.toUpperCamel(tableName)));  //添加ServiceImpl
        context.addPluginConfiguration(getControllerTemplatePlugin(module, ZStringUtils.toUpperCamel(tableName)));  //添加Controller
        context.addPluginConfiguration(getTestTemplatePlugin(module,""));

        // 添加生成项
        context.setJavaModelGeneratorConfiguration(getJavaModelGeneratorConfig(module));
        context.setSqlMapGeneratorConfiguration(getsqlMapGeneratorConfig(module));
        context.setJavaClientGeneratorConfiguration(getJavaClientGeneratorConfig(module));


        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        tableConfiguration.setSchema(schema);
        tableConfiguration.addIgnoredColumn(new IgnoredColumn("create_time"));
        tableConfiguration.addIgnoredColumn(new IgnoredColumn("update_time"));
        tableConfiguration.addIgnoredColumn(new IgnoredColumn("create_user_id"));
        tableConfiguration.addIgnoredColumn(new IgnoredColumn("update_user_id"));
        tableConfiguration.addIgnoredColumn(new IgnoredColumn("del_flag"));
        tableConfiguration.addIgnoredColumn(new IgnoredColumn("status"));
        tableConfiguration.addIgnoredColumn(new IgnoredColumn("remark"));
        GeneratedKey generatedKey=new GeneratedKey("id","MySql",true,null);
        tableConfiguration.setGeneratedKey(generatedKey);
        context.addTableConfiguration(tableConfiguration);

        config.addContext(context);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for (String warning : warnings) {
            log.warn(warning);
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
        javaModelGeneratorConfiguration.addProperty("rootClass","com.zhu.zevolve.common.base.model.BaseEntity");

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
    private PluginConfiguration getTestTemplatePlugin(String module,String className){
        return getTemplatePlugin("generator/test-one.ftl","test.txt",module,"");
    }
    private PluginConfiguration getMapperTemplatePlugin(String module, String className){
        return getTemplatePlugin("templates/mapper.ftl",className+"Mapper.java",module,"mapper");
    }
    private PluginConfiguration getControllerTemplatePlugin(String module, String className){
        return getTemplatePlugin("templates/controller.ftl",className+"Controller.java",module,"controller");
    }
    private PluginConfiguration getServiceTemplatePlugin(String module, String className){
        return getTemplatePlugin("templates/service.ftl",className+"Service.java",module,"service");
    }
    private PluginConfiguration getServiceImplTemplatePlugin(String module, String className){
        return getTemplatePlugin("templates/serviceImpl.ftl",className+"ServiceImpl.java",module,"service.serviceImpl");
    }

    private PluginConfiguration getTemplatePlugin(String templatePath,String fileName,String module,String subPackage){
        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.TemplateFilePlugin");
        pluginConfiguration.addProperty("targetProject",targetSrcPath);
        pluginConfiguration.addProperty("targetPackage",String.format("%s.%s.%s",targetPackage,module,subPackage));
        pluginConfiguration.addProperty("modulePackage",String.format("%s.%s",targetPackage,module));
        pluginConfiguration.addProperty("templatePath",templatePath);
        pluginConfiguration.addProperty("fileName",fileName);
        return  pluginConfiguration;
    }
}
