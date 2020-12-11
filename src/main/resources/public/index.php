<?php
declare(strict_types=1);

//require __DIR__ . '/vendor/autoload.php';
require_once '../core/init.php';
//require_once 'route.php';

//var_dump(Config::get('mysql/host'));

//---------


//$user = Db::getInstance()->get('users', array('username','=', 'Ira'));
//$user = Db::getInstance()->query("SELECT username FROM users WHERE username = ?", array('Alex'));
//$user = Db::getInstance()->query("select * from users");

//---------

//if(!$user->count()){
//    echo 'no user';
//}else {
//    echo $user->first()->username;
//    echo 'ok!';
//    foreach ($user->results() as $user) {
//        echo $user->username, '<br>';
//}

//---------
//$user = DB::getInstance()->insert("users",array(
//        'username' => "Alexeushka",
//        'password' => "42",
//        'salt' => "salt",
//    'name'=>' Alexey Sofiychuk'
//))
//var_dump($user);

//--------------
if (Session::exists('home')) {
    echo Session::flash('home');

}

//echo Session::get(Config::get('session/session_name'));// показвает в индексе порядковый номер зариси из БД - при условии успешного логина и открытой сессии (ЮЗЕР ЛАЙН 48)
$user = new User();

if ($user->isLoggedIn()) {
//    echo "User " .$user->data()->username . " is logged in NOW";
    ?>
    <h2><a href="https://www.youtube.com/playlist?list=PLfdtiltiRHWF5Rhuk7k4UAU1_yLAZzhWc">ресурс</a>
    </h2>
    <p> Hello <a href="profile.php?user=<?php echo escape($user->data()->username) ?>"><?php echo escape($user->data()->username) ?></a></p>
    <ul>
        <li><a href="logout.php">Log out</a></li>
        <br>


        <li><a href="update.php">Update profile</a>


        <li><a href="changePassword.php">Change password</a>


    </ul>
    <?php
    if ($user->hasPermission('admin')) {
        echo "<p>You are ADMINISTRATOR</p>";

    }

} else {

    echo "<p> please <a href='register.php'>REGISTER</a>  or <a href='login.php'>LOGIN </a>    first</p>";
    <h2><a href="index.html">link to java web</a>
}

?>

