<?php
require_once '../core/init.php';


//-----------------
// в этот код необходимо ЗАВЕРНУТЬ код лог ина что бы сработала проверка на ТОКЕН и на ВАЛИДНОСТЬ
//-----------------
//if (Input::exists()) {
//if (Token::check(Input::get('token'))) {
//
//    $validate = new Validation();
//    $validation = $validate->check();
//}
//
//if ($validate->passed()) {
//
//$user = new User();}
//else {
//        foreach ($validation->errors() as $error) {
//            echo $error, '<br>';
//        }
//    }
//}
//-----------------
if (Input::exists()) {
    if (Token::check(Input::get('token'))) {

        $validate = new Validation();
        $validation = $validate->check($_POST, array(
            'username' => array('required' => true),
            'password' => array('required' => true)
        ));


    if ($validate->passed()) {

        $user = new User();

        $remember = (Input::get('remember') == 'on')?true: false;

        $login = $user->login(Input::get('username'), Input::get('password'),$remember);

        if ($login) {
            Redirect::to('index.php');
        } else {
            Redirect::to('index.php');
//            echo'LOGIN FAILED';}// в ЮЗЕРЕ возврат тру- приводит это к функционированию
        }
    } else {
        foreach ($validation->errors() as $error) {
            echo "<br>", $error;
        }
    }
}}

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LoginPage_TUT</title>
</head>
<body>
<h2><a href="https://www.youtube.com/playlist?list=PLfdtiltiRHWF5Rhuk7k4UAU1_yLAZzhWc">11/27</a>

    <h1>Log in</h1>
    <form method="post">

        <div class="field">
            <label for="username">User Nick</label>
            <input type="text" name="username" autocomplete="off">
        </div>
        <div class="field">
            <label for="password">password</label>
            <input type="text" name="password" id="password" autocomplete="off">
        </div>
        <div class="field">
            <label for="remember">
            <input type="checkbox" name="remember" id="remember" autocomplete="off">Remember me
            </label>
        </div>

        <input type="submit" value="Log In">
        <input type="hidden" name="token" value="<?php echo Token::generate() ?>">



    </form>


</body>
</html>


