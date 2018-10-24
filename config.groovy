environments {
    development { // 开发环境
        database {
            codeGenUrl = 'jdbc:mysql://193.112.29.110:3306/%s?useUnicode=true&amp;characterEncoding=UTF-8'
            driverClassName = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://193.112.29.110:3306/zevolve?useUnicode=true&amp;characterEncoding=UTF-8'
            username = 'kuaiyu'
            password = 'kuaiyu'
        }
    }

    production { // 线上环境
        database {
            driverClassName = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://193.112.29.110:3306/zevolve?useUnicode=true&amp;characterEncoding=UTF-8'
            username = 'kuaiyu'
            password = 'kuaiyu'
        }
    }
}