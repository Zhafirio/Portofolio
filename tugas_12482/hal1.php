<?php
session_start();
$datapc = array(
    array("Mouse PRO X SUPERLIGHT", "foto/log1.jpg", 2399000),
    array("Keyboard PRO X", "foto/log2.jpg", 2290000),
    array("MousePad G640", "foto/log3.jpg", 599000),
    array("Headset PRO-HEADSET ", "foto/log4.jpg", 1699000),
    array("Webcam HD PRO C920 ", "foto/log5.jpg", 2049000),
    array("Racing Wheel G29", "foto/log6.jpg", 6699000),
);

$_SESSION["pc"] = $datapc;
?>
<!DOCTYPE html>

<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .card {
            border-radius: 50px  20px;
        }
    </style>
</head>

<body>

    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h2 class="text-center">Perlengkapan Gaming</h2>
            <h2 class="text-center">BrayGAMING.Shop</h2>
            <hr class="my-4">
            <div class="row">
                <?php foreach ($_SESSION["pc"] as $key => $value) { ?>
                    <div class="col-md-4 mt-2">
                        <a href="hal2.php?b=<?= $key ?>">
                            <div class="card">
                                <img class="card-img-top" src="<?= $value[1] ?>" alt="Card image" width="100" height="230">
                                <div class="card-body">
                                    <h4 class="card-title"><?= $value[0] ?></h4>
                                    <p class="card-text"><?= number_format($value[2]) ?></p>
                                </div>
                            </div>
                        </a>
                    </div>
                <?php } ?>
            </div>
        </div>
    </div>

</body>

</html>