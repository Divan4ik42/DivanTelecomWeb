<#import "/spring.ftl" as spring/>

<!DOCYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="resources/css/Style.css"> <!-- Styles should be the LAST -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,300;0,400;1,300&display=swap" rel="stylesheet">

    <title> DivanTelecom Admin</title>
</head>

<body>

<header>
    <nav>
        <div class="row">
            <img src="resources/img/logo.png" alt="DivanTelecom logo" class="logo">
            <ul class="main-nav">
                <li><a href="/Index.html">hello</a></li>
                <li><a href="/Gallery.html">Выбиралка</a></li>
                <li><a href="/About.html">Почемушка</a></li>
                <li><a href="/Contacts.html">Звонилка</a></li>
            </ul>
        </div>
    </nav>

</header>
<div>
    <div>
        <#--<a href="http://localhost:8080/">Create</a>-->
        <table class="table table-dark">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <th>created</th>
                <th>modified</th>
                <th>delete</th>
                <th>edit</th>
            </tr>
            <#list Items as element> <!--цикл по всем айтемам -->
            <#--      для каждого айтем каторый мы получили из контроллера-->
                <tr>
                    <td>${element.id}</td>
                    <td>${element.name}</td>
                    <td>${element.description}</td>
                    <td>${element.created_at}</td>
                    <td>${element.modified_at}</td>
                    <td><a href="/web/item/delete/${element.id}"><button type="button" class="btn btn-light">delete</button></a> </td>
                    <td><a href="/web/item/update/${element.id}"><button type="button" class="btn btn-info">edit</button></a> </td>


                </tr>
            </#list>
        </table>

    </div>
</div>
<div class="main-text-box">
    <a class="btn btn-full" href="/Gallery.html"> Admin page </a>
    <a class="btn btn-ghost" href="/Contacts.html"> User page </a>
</div>
</body>

</html>
