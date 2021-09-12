<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看提交</title>
</head>
<body>
<h1>${collect.collectname} 项目的信息收集</h1>

<p>您的姓名：<input type="text" id="input_field" value="${item.value}"/></p>

<table border="1">
<tr>
<th>提交编号</th><th>详细介绍</th>
<th>列</th><th>行</th>
<th>完成时间</th><th>提交人</th>
<th>删除</th>
</tr>
<c:forEach var="submit" items="${submits}">
<tr>
<td>${submit.submitid}</td><td>${submit.details}</td>
<td>${submit.col}</td><td>${submit.row}</td>
<td>${submit.finishedtime}</td><td>${submit.submitter}</td>
<td><a href="delete_submit?submitId=${submit.submitid}&collectId=${collect.collectid}">删除</a></td>
</tr>
</c:forEach>
</table>


<p></p>
<h3>提交结果</h3>
<h5>填写好信息后可直接点击表格链接提交</h5>
<table border="1">
    <thead>
        <tr>
        <th>${submitTable.getTableName()}</th>
        <c:forEach var="i" begin="0" end="${submitTable.getColLen()-1}">
            <th>${submitTable.getColNames()[i]}列</th>
        </c:forEach>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="i" begin="0" end="${submitTable.getRowLen()-1}">
		<tr>
			<td>${submitTable.getRowNames()[i]}</td>
            <c:forEach var="j" begin="0" end="${submitTable.getColLen()-1}">
            <td>
<c:choose>
    <c:when test="${forbidTable.getMatrix()[i][j]=='已禁止'}"><!-- 被禁选了 -->
				${submitTable.getMatrix()[i][j]}
    </c:when>
    <c:when test="${collect.getUniqueflag() && submitTable.getMatrix()[i][j]>0}"><!-- 不可重复表且被选了 -->
				${submitTable.getMatrix()[i][j]}
    </c:when>
    <c:otherwise>
	<a href='' onclick="this.href='add_submit?collectid=${collect.collectid}&row=${i+1}&col=${j+1}&submitter='+document.getElementById('input_field').value">
        ${submitTable.getMatrix()[i][j]}
	</a>
    </c:otherwise>
</c:choose>
            </td>
            </c:forEach>
        </tr>
        </c:forEach>
    </tbody>
</table>
<p></p>

<p></p>
<h3><a href="homepage">返回首页</a></h3>
<h3><a href="collect">返回信息收集页面</a></h3>

</body>
</html>