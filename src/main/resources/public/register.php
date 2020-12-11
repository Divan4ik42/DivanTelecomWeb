<?php
include_once '../core/init.php';


//var_dump(Token::check(Input::get('token')));

if (Input::exists()) {
    if (Token::check(Input::get('token'))) {

//        echo "мнея запустили ";


        $validate = new Validation(); // ссылка на php файл
        $validation = $validate->check($_POST, array(
            'username' => array(
                'required' => true,
                'min' => 2,
                'max' => 20,
                'unique' => 'users'
            ),
            'password' => array(
                'required' => true,
                'min' => 1,
            ),
            'password_again' => array(
                'required' => true,
                'matches' => 'password'
            ),
            'name' => array(
                'required' => true,
                'min' => 2,
                'max' => 50
            )

        ));

        if ($validate->passed()) {

            $user = new User();
            $salt = Hash::salt(32);


            try {
                $user->create(array(
                    'username' => Input::get('username'),
                    'password' => Hash::make(Input::get('password'), $salt),
                    'salt' => $salt,
                    'name' => Input::get('name'),
                    'joined' => date('Y-m-d H:i:s'),
                    'permission' => 1
                ));

                Session::flash('home', 'You registered successfully');
                Redirect::to('index.php');

//                header('Location: index.php');

            } catch (Exception $e) {
                die($e->getMessage());
            }

//            echo 'passed';
//Session::flash('success','You registered successfully');
//header('Location: index.php');

        } else {
            foreach ($validation->errors() as $error) {
                echo $error, '<br>';// этот способ покрасивше

            }
//    else {print_r($validate->errors());}

        }
    }
}


?>






    <form method="post">

        <div class="field">
            <label for="username">User Nick</label>
            <input type="text" name="username" id="username" value="<?php echo escape(Input::get('username')) ?>"
                   autocomplete="off">
        </div>
        <div class="field">
            <label for="password">Type your PASSWORD here</label>
            <input type="password" name="password" id="password">
        </div>
        <div class="field">
            <label for="password_again">Repeat your PASSWORD here</label>
            <input type="password" name="password_again" id="password_again">
        </div>

        </div>
        <div class="field">
            <label for="name">User real name</label>
            <input type="text" name="name" id="name" value="<?php echo escape(Input::get('name')) ?>">
        </div>

        <input type="submit" value="Register">
        <input type="hidden" name="token" value="<?php echo Token::generate() ?>">


    </form>

