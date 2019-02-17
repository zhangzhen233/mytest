<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="box-footer">
    <div class="pull-left">
        <div class="form-group form-inline">
            总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。
            每页
            <select class="form-control" onchange="gotoPage(1,this.value)">
                <c:forEach var="num" begin="1" end="10" step="1">
                    <option value="${num}" ${pageInfo.pageSize==num?'selected':''}>${num}</option>
                </c:forEach>
            </select>
            条
        </div>
    </div>

    <div class="box-tools pull-right">
        <ul class="pagination">
            <li><a href="javascript:gotoPage(1,'${pageInfo.pageSize}')" aria-label="Previous">首页</a></li>
            <li><a href="javascript:gotoPage('${pageInfo.prePage}','${pageInfo.pageSize}')">上一页</a></li>

            <c:forEach var="num"
                       begin="${pageInfo.pageNum-5>0?pageInfo.pageNum-5:1}"
                       end="${pageInfo.pageNum+5<pageInfo.pages?pageInfo.pageNum+5:pageInfo.pages}">
                <li>
                    <a href="javascript:gotoPage('${num}','${pageInfo.pageSize}')">
                        <c:choose>
                            <c:when test="${pageInfo.pageNum==num}">
                                <span style="color: red">${num}</span>
                            </c:when>
                            <c:otherwise>
                                ${num}
                            </c:otherwise>
                        </c:choose>

                    </a>
                </li>
            </c:forEach>

            <li><a href="javascript:gotoPage('${pageInfo.nextPage}','${pageInfo.pageSize}')">下一页</a></li>
            <li><a href="javascript:gotoPage('${pageInfo.pages}','${pageInfo.pageSize}')" aria-label="Next">尾页</a></li>
        </ul>
    </div>


    <script type="text/javascript">
        // 换页的方法
        // 参数1：当前页
        // 参数2：页大小
        function gotoPage(pageNum,pageSize){
            // 给表单元素赋值
            $("#pageNum").val(pageNum);
            $("#pageSize").val(pageSize);
            // 提交表单: document.forms[0] 表示获取页面的第一个表单
            document.forms[0].submit();
        }
    </script>

</div>
