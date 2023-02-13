<?php
session_start();

if (!isset($_SESSION["cart"]) || isset($_GET["hapus"])) {
    $_SESSION["cart"] =  array();
} else {
    array_push($_SESSION["cart"], $_GET["b"]);
}


?>
<!DOCTYPE html>

<head>
    <title>Cart</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h2 class="text-center">Jumlah data <?= sizeof($_SESSION["cart"]) ?></h2>
            <a href="hal2.php?hapus=1">Hapus semua data</a>
            <a class="float-right" href="hal1.php?">Kembali ke menu</a>
            <hr class="my-4">
            <div class="row">
                <?php
                $j = 0;
                if (sizeof($_SESSION["cart"]) > 0) {
                    foreach ($_SESSION["cart"] as $key => $value) {
                        $j += $_SESSION["pc"][$value][2];
                 ?>
                        Nama barang : <?= $_SESSION["pc"][$value][0] ?> Jumlah : 1 Harga : <?= number_format($_SESSION["pc"][$value][2]) ?> <br>

                <?php }  ?>
                        Total               : <?= number_format($j) ?>
                <?php } ?>
            </div>
        </div>
    </div>

</body>