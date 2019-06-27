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
### 4.关于ajax提交的问题：如果ajax交互的过程中涉及到数据库操作，建议将参数async设置为false（即将异步设置为同步），否则会出很神奇的bug；原因猜想如下：当ajax操作为异步时，前台接收后台操作的返回参数时有一个时间限定，因为是执行数据库操作，后台需要时间较长，此时前台等待一定时间未接受到后台的返回值，就放弃执行接收返回值后ajax代码，造成你的ajax调用既没有失败，也没有成功，就很神奇。
### 5.谷歌浏览器关于一次ajax请求进入两次servlet的问题，解决办法：async:false