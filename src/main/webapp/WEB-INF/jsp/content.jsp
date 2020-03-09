<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Content</title>
    <%@include file="common/head.jsp" %>

</head>
<body style="background: url(https://images.pexels.com/photos/158056/water-mountain-moon-river-158056.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940) no-repeat center center fixed; background-size: 100%;">

<div class="modal-dialog" style="margin-top: 5%;">
    <div class="modal-content" style="filter:alpha(Opacity=80);-moz-opacity:0.5;opacity: 0.85; height: 650px">

        <div class="header-panel text-center" style="text-align:center; margin: auto; width:400px; height:50px">
            <h2>Login Records</h2>
        </div>

        <div class="panel-body" style="margin:auto; width:405px; height:500px; text-align:center">
            <table class="table table-hover">
                <thead style="text-align:center">
                <tr>
                    <th>recordID</th>
                    <th>userName</th>
                    <th>loginTime</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="pi" items="${pageInfo.list}">
                    <tr>
                        <td>${pi.recordID}</td>
                        <td>${pi.userName}</td>
                        <td><fmt:formatDate value="${pi.loginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="header-panel text-center" style="text-align:center; margin: auto; width:400px; height:50px">
                <nav aria-label="...">
                    <ul class="pagination">

                        <c:if test="${1 == pageInfo.pageNum}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/supervision/content?pageNo=${pageInfo.pageNum}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${1 < pageInfo.pageNum && pageInfo.pageNum <= pageInfo.pages}">
                            <li>
                                <a href="${pageContext.request.contextPath}/supervision/content?pageNo=${pageInfo.pageNum - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach var="i" begin="1" end="${pageInfo.pages}">
                            <c:if test="${pageInfo.pageNum == i}">
                                <li class="active">
                                    <span>
                                        <a href="${pageContext.request.contextPath}/supervision/content?pageNo=${i}" style="text-decoration:none; color:white"> ${i} </a>
                                        <span class="sr-only">(current)</span>
                                    </span>
                                </li>
                            </c:if>

                            <c:if test="${pageInfo.pageNum != i}">
                                <li class="">
                                    <span>
                                        <a href="${pageContext.request.contextPath}/supervision/content?pageNo=${i}" style="text-decoration:none"> ${i} </a>
                                        <span class="sr-only">(current)</span>
                                    </span>
                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/supervision/content?pageNo=${pageInfo.pageNum}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${1 <= pageInfo.pageNum && pageInfo.pageNum < pageInfo.pages}">
                            <li>
                                <a href="${pageContext.request.contextPath}/supervision/content?pageNo=${pageInfo.pageNum + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>

                <p>现第 <span style="color: #db882c">${pageInfo.pageNum }</span> 页 ，
                    共 <span style="color: #e4902b">${pageInfo.pages }</span> 页 ，
                    所有记录 <span style="color: #e4902b">${pageInfo.total }</span> 条 。
                </p>

            </div>
        </div>
    </div>
</div>
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>