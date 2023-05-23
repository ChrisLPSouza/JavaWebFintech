<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <link rel="stylesheet" href="css/fintech_cadastro.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Fintech Economize</title>
    <meta property="og:title" content="Economize com nossa solução">
</head>
<header>

    <main>
        <article>

        </article>

    </main>
</header>

<body>
<c:if test="${not empty msg }">

    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>${ nameAttr }</strong> ${ msg }
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<c:if test="${not empty err }">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>${ err }</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>
<div class="d-grid gap-4 col-3 mx-auto m-5">
    <h1 class="title">Despesas</h1>
    <table class="table table-striped">
        ...
    </table>


</div>


<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>