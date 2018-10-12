environments {
    development { // 开发环境
        database {
            driverClassName = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://193.112.29.110:3306/measite?useUnicode=true&amp;characterEncoding=UTF-8'
            username = 'kuaiyu'
            password = 'kuaiyu'
        }
    }

    production { // 线上环境
        database {
            driverClassName = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://localhost:3306/survey?useUnicode=true&amp;characterEncoding=UTF-8'
            username = 'root'
            password = 'wxyz'
        }
    }
}