# RuiDaoExam
共同富裕组——睿道项目二
# 共同规约
### 1.类命名规则：按照已给的项目模板来，类单词首字母大写
### 2.勤注释，方便别人阅读
### 3.代码push到github前记得先备份一下自己本地的
### 4.开启项目记得改application.properties里的相关配置，启动application前记得打开activemq.bat和mybatis的startup.bat
### 5.application.properties如果有模板语句报错，点击小红叉的ignore即可，如果自己注释掉了，就不要上传这个文件，防止其他人pull下来出错
### 6.在controller包下的PageJumpController写页面跳转的功能
# 笔记
### 1.记得在逆向生成后添加mapper注解
### 2.ajax如果只通过post传递参数,dataType:'json',而不能加contentType:’application/json;charset=UTF-8’，不然后台接收的数据为空，参考examEntrance.html
### 3.一个类中同时只能引入一个criteria类，无法同时引入两个（即逆向生成的数据库xml代码的数据库操作只有在执行单表查询时才能使用，联合查询无法使用，虽然example类强大，但是仅能用于单表查询），应该是由于criteria类是example类的静态内部类的原因，具体不清楚。