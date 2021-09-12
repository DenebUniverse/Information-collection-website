<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看禁选项</title>
</head>
<body>
<h1>${collect.collectname} 项目的禁选项</h1>

<p>详细信息：<input type="text" id="input_field" value="${item.value}"/></p>

<table border="1">
<tr>
<th>禁止编号</th><th>详细信息</th>
<th>列</th><th>行</th>
<th>删除</th>
</tr>
<c:forEach var="forbid" items="${forbids}">
<tr>
<td>${forbid.forbidid}</td><td>${forbid.details}</td>
<td>${forbid.col}</td><td>${forbid.row}</td>
<td><a href="delete_forbid?forbidId=${forbid.forbidid}&collectId=${collect.collectid}">删除</a></td>
</tr>
</c:forEach>
</table>

<c:set var="forbidString" value="未禁止"/>
<p></p>
<h3>禁止提交的单元格</h3>
<h5>填写好信息后可直接点击表格链接提交</h5>
<table border="1">
    <thead>
        <tr>
        <th>${mytable.getTableName()}</th>
        <c:forEach var="i" begin="0" end="${mytable.getColLen()-1}">
            <th>Column ${mytable.getColNames()[i]}</th>
        </c:forEach>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="i" begin="0" end="${mytable.getRowLen()-1}">
		<tr>
			<td>Row ${mytable.getRowNames()[i]}</td>
            <c:forEach var="j" begin="0" end="${mytable.getColLen()-1}">
            <td>
				<c:choose>
    				<c:when test="${mytable.getMatrix()[i][j]==forbidString}">
						<a href='' onclick="this.href='add_forbid?collectid=${collect.collectid}&row=${i+1}&col=${j+1}&submitter='+document.getElementById('input_field').value">
							${mytable.getMatrix()[i][j]}
						</a>
			    </c:when>
			    <c:otherwise>
			        ${mytable.getMatrix()[i][j]}
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