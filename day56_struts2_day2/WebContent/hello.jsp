<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OGNL表达式</title>
</head>
<body>
ognl表达式:<s:property value="%{'hello'}"/><br/>

OGNL表达式看成一个字符串查看长度:<s:property value="'helloworld'.length()"/><br>
OGNL表达式看成一个字符串查看转大写:<s:property value="'helloworld'.toUpperCase()"/><br>
list输出性别选择:<s:radio name="gender" list="{'男','女'}" label="性别"></s:radio><br/>
 map输出性别选择:<s:radio name="gender" list="#{'male':'男','famale':'女'}" label="性别"></s:radio>

</body>
</html>