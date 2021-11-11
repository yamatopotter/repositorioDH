<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teste de Envio de Formulário</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }

        body{
            font-family: Arial, Helvetica, sans-serif;
            text-align: center;
        }

        h1{
            padding: 40px 0;
        }

        .line{
            padding: 10px 0;
        }

        .line p:first-child{
            display: inline-block;
            font-weight: bold;
            text-align: right;
            width:49%;
            border-right: 2px solid black;
            padding: 5px
        }

        .line p:last-child{
            display: inline-block;
            width: 49%;
            text-align: left;
            border-left: 2px solid black;
            padding: 5px
        }

        .t1{
            text-transform: uppercase;
        }

        .line:nth-child(odd){
            background-color: aquamarine;
        }

        .line:nth-child(even){
            background-color: beige;
        }

    </style>

    <?php
    $requestType = $_SERVER['REQUEST_METHOD'];
    ?>
</head>
<body>

    <main>
        <h1>Teste de envio de formulário</h1>
        <h2>Bem vindo a minha página de teste. Use e abuse dela!</h2>

        <section class="conteudo-form">
            <h1>Segue o conteúdo encontrado no envio do formulário</h1>

            <div class="line t1">
                <p>Método de envio</p>
                <p><?php echo $requestType; ?></p>
            </div>
            
            
            <?php

            switch ($requestType){
                case 'GET':
                    foreach ($_GET as $key => $val ){
                        echo "<div class='line'><p>$key</p><p>$val</p></div>\n";
                    }
                    break;
                case 'POST':
                    foreach ($_POST as $key => $val ){
                        echo "<div class='line'><p>$key</p><p>$val</p></div>\n";
                    }
                    break;
            }
            ?>
            
        </section>
    </main>


</body>
</html>
