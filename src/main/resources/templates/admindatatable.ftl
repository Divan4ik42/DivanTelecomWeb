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
<#--                private String id;-->
<#--                private String name;-->
<#--                private String lastName;-->
<#--                private LocalDate dateOfBirth;-->
<#--                private String operatorCode;-->
<#--                private String userNumber;-->
<#--                private int balance;-->
<#--                private String description;-->
<#--                private LocalDateTime created_at;-->
<#--                private LocalDateTime lastLogin_at;-->

                <th>id</th>
                <th>name</th>
                <th>lastName</th>
<#--                <th>Age</th>-->
                <th>operatorCode</th>
                <th>userNumber</th>
                <th>balance</th>
                <th>description</th>
                <th>created_at</th>
                <th>lastLogin_at</th>
            </tr>
            <#list subscribers as element> <!--цикл по всем айтемам -->
            <#--      для каждого айтем каторый мы получили из контроллера-->
                <tr>
                    <td>${element.id}</td>
                    <td>${element.name}</td>
                    <td>${element.lastName}</td>
                    <td>${element.age}</td>
                    <td>${element.operatorCode}</td>
                    <td>${element.userNumber}</td>
                    <td>${element.balance}</td>
                    <td>${element.description}</td>
                    <td>${element.created_at}</td>
                    <td>${element.lastLogin_at}</td>
                    <td><a href="/web/item/delete/${element.id}"><button type="button" class="btn btn-light">delete</button></a> </td>
                    <td><a href="/web/item/update/${element.id}"><button type="button" class="btn btn-info">edit</button></a> </td>


                </tr>
            </#list>
        </table>

    </div>
</div>
<div class="main-text-box">
    <a class="btn btn-full" href="/"> Home page </a>
    <a class="btn btn-ghost" href="/Contacts.html"> User page </a>
</div>
</body>

</html>
