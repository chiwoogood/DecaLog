<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cpath" value="${pageContext.request.contextPath}" />  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-kenU1KFdBI9g0DRqhc9sRkqTg6et3izuKYo2iJj5b0v4JMcKY9i5fNQd5A1EcPZX" crossorigin="anonymous">
    <style>
    body {
        padding-top: 56px; /* 네비게이션 바 높이만큼 상단 패딩 추가 */
    }
    .navbar-custom {
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        background-color: transparent; /* 배경색을 완전히 투명하게 설정 */
        backdrop-filter: blur(10px); /* 배경 흐리게 처리 */
        z-index: 1030;
        height: 56px; /* 네비게이션 바의 높이 */
    }
    
    /* 네비게이션 바의 링크 및 브랜드 색상 */
    .navbar-custom .navbar-brand,
    .navbar-custom .nav-link {
        color: #fff; /* 텍스트 색상 변경 */
    }
    .navbar-custom .nav-link:hover {
        color: #ddd; /* 호버 텍스트 색상 변경 */
    }
    </style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light navbar-custom">
	    <div class="container-fluid justify-content-end">
	        <a class="navbar-brand" href="#">Navbar</a>
	        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
	            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse ms-auto" id="navbarNav">
	            <ul class="navbar-nav">
	                <li class="nav-item">
	                    <a class="nav-link" href="${cpath}/board/list">Home</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="#">Features</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="${cpath}/board/list">Mypage</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="${cpath}/board/list">Other</a>
	                </li>
	            </ul>
	        </div>
	    </div>
	</nav>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBI9g0DRqhc9sRkqTg6et3izuKYo2iJj5b0v4JMcKY9i5fNQd5A1EcPZX" crossorigin="anonymous"></script>
</body>
</html>
