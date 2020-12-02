<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>Add Subscriber</legend>
        <form name="subscriber" action="" method="POST">
            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            lastName:<@spring.formInput "form.lastName" "" ""/>
            <br>
            operatorCode:<@spring.formInput "form.operatorCode" "" "text"/>
            <br>
            userNumber:<@spring.formInput "form.userNumber" "" "text"/>
            <br>
            balance:<@spring.formInput "form.balance" "" "text"/>
            <br>
            description:<@spring.formInput "form.description" "" "text"/>
            <br>

            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>