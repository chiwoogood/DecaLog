<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cpath" value="${pageContext.request.contextPath}" />  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="${cpath}/resources/css/login.css">

</head>
<body>
    <div class="login-wrapper">
        <h2>Join us</h2>
        <form method="post" action="${cpath}/member/join" id="login-form">
            <input type="text" name="username" placeholder="ID">
            <input type="password" name="password" placeholder="Password">
            <input type="password" name="passwordConfirm" placeholder="Password Confirm">
            <input type="text" name="name" placeholder="Name">
            <input type="text" name="nickname" placeholder="Nickname">
            <input type="email" name="email" placeholder="Email">
            <label for="remember-check">
                <a class="underlineHover" href="${cpath}/member/join">Join us</a>
            </label>
            <input type="submit" value="Join us">
        </form>
    </div>
</body>
</html>
