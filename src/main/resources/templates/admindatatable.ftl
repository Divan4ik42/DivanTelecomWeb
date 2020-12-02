<#import "/spring.ftl" as spring/>

<!DOCYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="resources/css/Style.css"> <!-- Styles should be the LAST -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,300;0,400;1,300&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title> DivanTelecom Admin</title>
</head>

<body>

<header>
    <nav>
<#--            <img src="../static/resources/img/logo.png" alt="DivanTelecom logo" class="logo">-->
            <ul class="nav nav-tabs">
                <li class="nav-item"><a class="nav-link " href="/Index.html">Home</a></li>
                <li class="nav-item"><a class="nav-link active" href="/web/subscriber/list">Admin</a></li>
                <li class="nav-item"> <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                                              aria-haspopup="true" aria-expanded="false">
                        Sort by
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

                        <button class="btn dropdown-item" onclick="window.location.href='/web/subscriber/list/sortbyid'">ID</button>
                        <button class="btn dropdown-item" onclick="window.location.href='/web/subscriber/list/sort'">Name</button>
                        <button class="btn dropdown-item" onclick="window.location.href='/web/subscriber/list/sortbydate'">Modified</button>
                    </div></li>
                <div>
                    <fieldset>
                        <form name="subscriber" action="" method="POST">
                            Search:<@spring.formInput "search.name" "" "text"/>
                            <input type="submit" value="Search"/>
                        </form>
                    </fieldset>
                </div>
            </ul>

    </nav>

</header>
<div>
    <div>
        <br>
    </div>
    <div>
        <#--<a href="http://localhost:8080/">Create</a>-->
        <table class="table">
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
<#--                <th>age</th>-->
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
<#--                    <td>${element.age}</td>-->
                    <td>${element.operatorCode}</td>
                    <td>${element.userNumber}</td>
                    <td>${element.balance}</td>
                    <td>${element.description}</td>
                    <td>${element.created_at}</td>
                    <td>${element.lastLogin_at}</td>
                    <td><a href="/web/subscriber/delete/${element.id}"><button type="button" class="btn btn-light">delete</button></a> </td>
                    <td><a href="/web/subscriber/update/${element.id}"><button type="button" class="btn btn-info">edit</button></a> </td>


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
