<%@ page isELIgnored="false" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
            integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
            crossorigin="anonymous"
        />
        <style>
            body {
                margin: 20px;
            }
        </style>
        <title>Detail Mahasiswa</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <h2>Detail Mahasiswa</h2>
        </div>
        <hr />

        <div class="container w-50 mx-0">
            <div class="row">
                <div class="col-sm">NIM</div>
                <div class="col-sm-8">${mhs.mhsnim}</div>
            </div>
            <div class="row">
                <div class="col-sm">Nama</div>
                <div class="col-sm-8">${mhs.mhsnm}</div>
            </div>
            <div class="row">
                <div class="col-sm">Alamat</div>
                <div class="col-sm-8">${mhs.mhsaddr}</div>
            </div>
            <div class="row">
                <div class="col-sm">Program Studi</div>
                <div class="col-sm-8">${mhs.prodnm}</div>
            </div>
            <div class="row">
                <div class="col-sm">Fakultas</div>
                <div class="col-sm-8">${mhs.faknm}</div>
            </div>
        </div>

        <hr />

        <a href="/springmvc" class="btn btn-secondary">Back</a>
        <%-- Bootstrap --%>
        <script
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
