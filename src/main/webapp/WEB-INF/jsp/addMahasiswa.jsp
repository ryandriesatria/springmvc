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
        <title>Add Mahasiswa</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <h2>Add Mahasiswa</h2>
        </div>
        <hr />
        <div class="">
            <div class="d-flex justify-content-center">
                <form action="./addMahasiswa" method="post" class="w-75">
                    <div class="form-group">
                        <label for="mhsnm">Nama</label>
                        <input
                            type="text"
                            class="form-control"
                            id="mhsnm"
                            name="mhsnm"
                            placeholder="Nama"
                            required
                        />
                    </div>
                    <div class="form-group">
                        <label for="mhsaddr">Alamat</label>
                        <input
                            type="text"
                            class="form-control"
                            id="mhsaddr"
                            name="mhsaddr"
                            placeholder="Alamat"
                            required
                        />
                    </div>
                    <div class="form-group">
                        <label for="prodnm">Fakultas & Program Studi</label>
                        <select class="form-control" id="prodnm" name="prodnm">
                            <c:forEach var="fak" items="${fakultas}">
                                <optgroup label="Fakultas ${fak.faknm}">
                                    <c:forEach var="prod" items="${fak.prodi}">
                                        <option>${prod.prodnm}</option>
                                    </c:forEach>
                                </optgroup>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">
                        Submit
                    </button>
                </form>
            </div>
        </div>

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
