<%@ page isELIgnored="false" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
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
        <title>Tabel Mahasiswa</title>
    </head>

    <body>
        <div class="d-flex justify-content-center">
            <h1>Tabel Mahasiswa</h1>
        </div>
        <hr />
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">NIM</th>
                    <th scope="col">Nama</th>
                    <th scope="col">Alamat</th>
                    <th scope="col">Program Studi</th>
                    <th scope="col">Fakultas</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mhs" items="${mahasiswa}" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.count}</th>
                        <td>${mhs.mhsnim}</td>
                        <td>${mhs.mhsnm}</td>
                        <td>${mhs.mhsaddr}</td>
                        <td>${mhs.prodnm}</td>
                        <td>${mhs.faknm}</td>
                        <td>
                            <div class="row justify-content-around">
                                <a
                                    class="btn btn-primary"
                                    href="./${mhs.mhsnim}"
                                >
                                    Detail
                                </a>
                                <a
                                    class="btn btn-info"
                                    href="./${mhs.mhsnim}/update"
                                >
                                    Update
                                </a>
                                <a
                                    class="btn btn-danger"
                                    href="./${mhs.mhsnim}/delete"
                                >
                                    Delete
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <hr />

        <a href="./addMahasiswa" class="btn btn-primary">Add Mahasiswa</a>

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
