<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="user/findUserById">测试findById</a>
    <a href="user/findUserAll">测试findAll</a>

    <h3>测试包</h3>
    <form action="user/saveUser" method="post">
        <!-- 这里的name要和对应的实体类里面的属性名字一样 -->
        用户名：<input type="text" name="userName" /><br/>
        密  码：<input type="text" name="passWord" /><br/>
        注册时间：<input type="date" name="createtime" /><br/>
        更新时间：<input type="date" name="updatetime" /><br/>
        <input type="submit" value="注册">
    </form>
</body>
</html>
