# Felt
本项目的命字取自[Re：从零开始的异世界生活](https://baike.baidu.com/item/Re%EF%BC%9A%E4%BB%8E%E9%9B%B6%E5%BC%80%E5%A7%8B%E7%9A%84%E5%BC%82%E4%B8%96%E7%95%8C%E7%94%9F%E6%B4%BB/16684334?fr=aladdin#3)
里的角色Felt。得到的风之加护，发信件速速肯定嗖嗖的。

[Felt](https://baike.baidu.com/item/%E8%8F%B2%E9%B2%81%E7%89%B9 "link")
，中文名非鲁特。图片如下：

![avatar](./doc/pic/felt.jpg)

## core模块的功能
在项目中引入repository和dependency
```xml
    <repositories>
        <repository>
            <id>maven-repo-master</id>
            <url>https://raw.github.com/goldarowana/maven-repo/master/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
    <dependencies>
        <dependency>
            <groupId>com.aries.email</groupId>
            <artifactId>felt-core</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
```


简单的几行代码即可实现发送邮件的功能
```
// 指定发件人的账号密码。
MailAccount account = MailAccount.builder()
        .address("18511012947@163.com")
        .loginName("18511012947@163.com")
        .password("password")
        .build();

// 创建邮件，并制定好邮件标题
MimeMail mail = MailUtils.createMessage("邮件主题");
        
//填写邮件内容
mail.setContent("这里是邮件正文！！！", TEXT_HTML);
        
// 呼叫邮递员
Postman postman = MailUtils.callPostman(Protocol.SMTP, SMTP_163, account);
        
// 把信件交给邮递员，并指定收件人（可以指定多个收件人）。然后让邮递员进行派件。
postman.mail(mail).receiver("18511012947@163.com", "18511012947@163.com").deliverNow();
```
这个目录有直接可以运行的测试代码：

felt-core/src/test/java/com/aries/email/felt/core/SendMailTest.java