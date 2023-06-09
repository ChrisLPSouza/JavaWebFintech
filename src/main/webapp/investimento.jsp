<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Fintech Economize</title>
    <meta property="og:title" content="Economize com nossa solução">
</head>

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


<div class="d-grid gap-4 col-3 mx-auto">
    <h1 class="title">Criar Investimento</h1>

    <!-- BUTTON VOLTA PARA HOME -->
    <p>
        <a class="btn btn-success" href="home-servlet" role="button">Home</a>
    </p>

    <!-- BUTTON CHAMA MODAL -->
    <p>
        <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#multiCollapseExample1"
                aria-expanded="false" aria-controls="multiCollapseExample1">Novo Investimento
        </button>
    </p>

    <!-- MODAL -->
    <div class="collapse multi-collapse" id="multiCollapseExample1">
        <div class="card card-body">
            <form class="row g-3 needs-validation was-validated" novalidate=""
                  action="despesa-servlet" method="post">

                <div class="d-grid gap-4 mb-3">
                    <input type="text" name="nome" class="form-control" placeholder="Nome">
                    <div class="invalid-feedback">
                        Nome do investimento
                    </div>
                </div>
                <div class="d-grid gap-4 mb-3">
                    <input type="number" name="valor" class="form-control" placeholder="Valor">
                    <div class="invalid-feedback">
                        Valor do investimento
                    </div>
                </div>

                <div class="d-grid gap-4">
                    <button type="submit" class="btn btn-success btn-lg">Cadastrar</button>
                </div>

            </form>
        </div>
    </div>
    <!-- FIM MODAL -->
</div>

<div class="d-grid gap-4 col-3 mx-auto mt-4">
    <h4 class="title">Meus Investimentos</h4>
    <table class="table table-striped table-bordered table-gray">
        <tr>
            <th colspan="2" class="table-active">Id</th>
            <th colspan="2" class="table-active">Nome</th>
            <th colspan="2" class="table-active">Valor</th>
        </tr>
        <c:forEach var="invest" items="${ listaInvestimentos }">
            <tr>
                <td colspan="2" class="table-active">${invest.cdInvestimento}</td>
                <td colspan="2" class="table-active">${invest.nome}</td>
                <td colspan="2" class="table-active">${invest.vlInvestimento}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>