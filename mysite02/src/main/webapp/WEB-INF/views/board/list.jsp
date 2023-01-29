<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="${pageContext.request.contextPath }/board" method="post">
					<input type="hidden" name="a" value="search">
					<input type="text" id="kwd" name="kwd" value=""> 
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach items="${list }" var="vo" varStatus="status">
						<tr>
							<%-- <td>${vo.no }</td>
							<td style="text-align:left; padding-left:${(vo.depth)*15}px">
								<c:choose>
									<c:when test='${vo.depth > 0 }'>
										<img
											src="${pageContext.request.contextPath }/assets/images/reply.png" />
									</c:when>
								</c:choose> <a href="${pageContext.request.contextPath }/board?a=view&no=${vo.no}">${vo.title }</a>
							</td>
							
							
							<td>${vo.userName }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td> --%>
							
							<td>${boardCnt - 5 * (page-1)-status.index}</td>
							<td style="text-align:left; padding-left:${vo.depth*20}px">
							<c:if test="${vo.depth>0 }">
								<img src="${pageContext.request.contextPath }/assets/images/reply.png">
							</c:if>
								<a href="${pageContext.request.contextPath }/board?a=view&no=${vo.no}">${vo.title}</a></td>
							<td>${vo.userName }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>
							
							<c:choose>
								<c:when test="${authUser.no == vo.userNo }">
									<td><a href="${pageContext.request.contextPath }/board?a=delete&no=${vo.no}" class="del"> <img src="${pageContext.request.contextPath }/assets/images/recycle.png" /></a></td>
								</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</table>

				<%-- <!-- pager 추가 -->
				<div class="pager">
					<ul>
					<c:choose>
						<c:when test="${firstpage == 1 }">
							<li class="disabled">◀</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath }/board?page=${firstpage-1 }">◀</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach var="firstnum" begin="1" end="${totalcount }" step="1">
						<li><a href="${pageContext.request.contextPath }/board?page=${firstpage }">${firstpage }</a></li>
					</c:forEach>
					<c:choose>
						<c:when test="${firstpage == totalcount }">
							<li class="disabled">▶</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath }/board?page=${firstpage+1 }">▶</a></li>
						</c:otherwise>
					</c:choose>
					</ul>
				</div>		
				<!-- pager 추가 --> --%>
				
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li>
						<c:choose>
							<c:when test="${page-1 >0}">
								<a href="${pageContext.request.contextPath }/board?a=list&page=${page-1}">◀</a>
							</c:when>
							<c:otherwise>
								<p>◀</p>
							</c:otherwise>
						</c:choose>
						</li>
						<c:choose>
							<c:when test="${boardCnt%5==0 }">
								<c:set var="end" value="${boardCnt/5 }"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="end" value="${boardCnt/5+1 }"></c:set>
							</c:otherwise>
						</c:choose>
						<c:forEach var="i" begin="1" end="${end }" step="1">
							<c:choose>
								<c:when test="${page ==i}">
									<li class="selected">${i }</li>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/board?a=list&page=${i}">${i }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<li>
							<c:choose>
									<c:when test="${page+1 <boardCnt/5+1}">
									<a href="${pageContext.request.contextPath }/board?a=list&page=${page+1}">▶</a>
								</c:when>
								<c:otherwise>
									<p>▶</p>
								</c:otherwise>
							</c:choose>
						</li>
					</ul>
				</div>					
				<!-- pager 추가 -->
				

				<div class="bottom">
					<c:choose>
						<c:when test="${not empty authUser  }">
							<a
						href="${pageContext.request.contextPath }/board?a=writeform&no=${vo.no}"
						id="new-book">글쓰기</a>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>