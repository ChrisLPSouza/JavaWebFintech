<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<%--    <link rel="stylesheet" href="resources/css/fintech.css">--%>
    <title>Fintech Economize</title>
    <meta property="og:title" content="Economize com nossa solução">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<c:if test="${not empty msg }">

    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>${ nameAttr }</strong> ${ msg }
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<c:if test="${not empty msgErr }">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>${ msgErr }</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>
<%--<header>--%>
<%--    <main>--%>
<%--        <article>--%>
<%--        </article>--%>
<%--        <section>--%>
<%--        </section>--%>
<%--    </main>--%>
<%--</header>--%>

<div class="d-grid gap-4 col-3 mx-auto">
    <h1 class="title">Bem vindo a Economize!</h1>
    <p class="subtitle">Seu controle financeiro na palma <br>da sua mão</p>
    <a class="btn btn-success btn-lg" href="conta-servlet" role="button">Conta</a>
    <a class="btn btn-success btn-lg" href="despesa-servlet" role="button">Despesas</a>
    <a class="btn btn-success btn-lg" href="investimento-servlet" role="button">Investimentos</a>
    <a class="btn btn-success btn-lg" href="receita-servlet" role="button">Receitas</a>
    <a class="btn btn-success btn-lg" href="objetivo-servlet" role="button">Objetivos</a>
</div>
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>