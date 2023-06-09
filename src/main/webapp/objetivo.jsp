<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <link rel="stylesheet" href="resources/css/fintech.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Fintech Economize</title>
    <meta property="og:title" content="Economize com nossa solução">
</head>

<body>
<div>
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
    <div class="d-grid gap-4 col-2 mx-auto">
        <h1 class="title">Criar Objetivo</h1>

        <p>
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#multiCollapseExample1"
                    aria-expanded="false" aria-controls="multiCollapseExample1">Novo Objetivo</button>
        </p>
        <div class="row mb-4">
            <div class="col-8">
                <div class="collapse multi-collapse" id="multiCollapseExample1">
                    <div class="card card-body">
                        <form class="row g-3 needs-validation was-validated" novalidate=""
                              action="objetivo-servlet"  method="post">

                            <div class="d-grid gap-4 mb-3">
                                <input type="text" name="nome" class="form-control" placeholder="Nome">
                                <div class="invalid-feedback">
                                    Nome do Objetivo
                                </div>
                            </div>
                            <div class="d-grid gap-4 mb-3">
                                <input type="number" name="valor" class="form-control" placeholder="Valor">
                                <div class="invalid-feedback">
                                    Valor do Objetivo
                                </div>
                            </div>

                            <div class="d-grid gap-4">
                                <button type="submit" class="btn btn-success btn-lg" >Cadastrar</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-8">

                <div class="d-grid gap-4 col-3 mx-auto m-5">
                    <h4 class="title">Meus Objetivos</h4>
                    <table class="table table-striped table-bordered table-gray">
                        <tr>
                            <th colspan="2" class="table-active">Id</th>
                            <th colspan="2" class="table-active">Descrição</th>
                            <th colspan="2" class="table-active">Valor</th>
                        </tr>
                        <c:forEach var="objetivo" items="${ listaObjetivos }">
                            <tr>
                                <td colspan="2" class="table-active">${objetivo.codigo}</td>
                                <td colspan="2" class="table-active">${objetivo.descricao}</td>
                                <td colspan="2" class="table-active">${objetivo.valor}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

    </div>

    <script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>