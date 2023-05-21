<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <link rel="stylesheet" href="resouces/css/fintech_index.css">
  <title>Fintech Economize</title>

  <meta property="og:title" content="Economize com nossa solução">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>


<body style="background-color:hsla(142, 56%, 72%, 0.944);">

  <div class="d-grid gap-4 col-3 mx-auto m-5">
    <div class="d-grid gap-4">
      <img src="resources/img/logo_fintech.png">
    </div>
    <form>
      <div class="mb-3 row">

        <div class="d-grid gap-4">
          <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="E-mail">
        </div>
      </div>
      <div class="mb-3 row">

        <div class="d-grid gap-4">
          <input type="password" class="form-control" id="inputPassword" placeholder="Senha">
        </div>
      </div>
      <div class="d-flex justify-content-between mb-5">
        <a href="cadastro-servlet"><label for="staticEmail">Cadastre-se</label></a>
        <a href="#"><label for="staticEmail">Esqueci Senha</label></a>
      </div>

      <div class="d-grid gap-4">
        <button type="button" class="btn btn-success btn-lg">Acessar</button>
      </div>

    </form>
  </div>

  <div class="d-flex justify-content-center ">
<%--    <img class="img-social" src="resources/img/face.png">--%>
<%--    <img class="img-social" src="resources/img/insta.png">--%>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</body>

</html>