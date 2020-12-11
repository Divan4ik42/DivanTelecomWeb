<?php
require_once '../core/init.php';

//if (Input::exists()) {
//    if (Token::check(Input::get('token'))) {
//
//        $validate = new Validation();
//        $validation = $validate->check($_POST, array(
//            'username' => array('required' => true),
//            'password' => array('required' => true)
//        ));
//
//
//    if ($validate->passed()) {
//
//        $user = new User();
//
//        $remember = (Input::get('remember') == 'on')?true: false;
//
//        $login = $user->login(Input::get('username'), Input::get('password'),$remember);
//
//        if ($login) {
//            Redirect::to('index.php');
//        } else {
//            Redirect::to('index.php');
////            echo'LOGIN FAILED';}// в ЮЗЕРЕ возврат тру- приводит это к функционированию
//        }
//    } else {
//        foreach ($validation->errors() as $error) {
//            echo "<br>", $error;
//        }
//    }
//}}
// -------

//может нужно удалить

$user = new User();
if (!$user->isLoggedIn()) {
    Redirect::to('index.php');
}
if (Input::exists()) {
    if (Token::check(Input::get('token'))) {
//        echo 'ok ';

        $validate = new Validation();
        $validation = $validate->check($_POST, array(
            'password_current' => array(
                'required' => true,
                'min' => 1
            ),
            'new_password' => array(
                'required' => true,
                'min' => 6
            ),
            'new_password_again' => array(
                'required' => true,
                'min' => 6,
                'matches' => 'new_password'
            )

        ));
        if ($validation->passed()) {


            //  проверка  на то ли правельно введен старый пароль
            if (Hash::make(Input::get('password_current'), $user->data()->salt) !== $user->data()->password) {
                echo 'Your current password i WRONG';
            } else {
                $salt = Hash::salt(32);
                $user->update(array(
                    'password' => Hash::make(Input::get('new_password'), $salt),
                    'salt' => $salt
                ));
                Session::flash('home', 'Your password UPDATED');
                Redirect::to('Index.php');
//                echo 'ok';}
            }
        } else {
            foreach ($validation->errors() as $error) {
                echo $error, '<br>';// этот способ покрасивше

            }

        }
    }
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LoginPage_TUT</title>
</head>
<body>
<h2><a href="https://www.youtube.com/playlist?list=PLfdtiltiRHWF5Rhuk7k4UAU1_yLAZzhWc">11/27</a>

    <h1>Update PASSWORD</h1>
    <form method="post">
        <div class="field">

            <label for="password_current">Current password</label>
            <input type="text" name="password_current" id="password_current" autocomplete="off">
        </div>
        <div class="field">

            <label for="new_password">New password</label>
            <input type="text" name="new_password" id="new_password" autocomplete="off">
        </div>

        <div class="field">

            <label for="new_password_again">New password again</label>
            <input type="text" name="new_password_again" id="new_password_again" autocomplete="off">
        </div>


        <input type="submit" value="Change it faster ">
        <input type="hidden" name="token" value="<?php echo Token::generate() ?>">


    </form>


</body>
</html>


