<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OCR Converter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://unpkg.com/@dotlottie/player-component@latest/dist/dotlottie-player.mjs" type="module"></script> 
    <script src="https://kit.fontawesome.com/62c3fb1ceb.js" crossorigin="anonymous"></script>
</head>
<body class="container-fluid bg-warning">
    <div class="row justify-content-center border-bottom border-4 border-dark" style="background-color: #674019">
        <h1 class="col-3 text-center align-self-center">
            <img src="logo.png" class="col-4"/>
            <span class="text-danger">X</span>eon 
            <span class="text-info">O</span>
            <span class="text-secondary">C</span>
            <span class="text-success">R</span>
        </h1>
    </div>
    <div class="row mt-5 justify-content-evenly">
        <div class="col-6">
            <h1 class="col-12 h1 display-1 "><b>Convert Your Image Text to Text using OCR Technology</b></h1>
        </div>
        <dotlottie-player src="https://lottie.host/db9b361a-5cd4-4672-b3af-f33b8f08c1de/ptvIWMIZAe.json" background="transparent" speed="1" class="col-3" loop autoplay></dotlottie-player>
    </div>
    <div class="row justify-content-center m-5">
        <form action="ocr" method="post" class="col-8 bg-danger p-5 rounded-2" enctype="multipart/form-data" >
            <div class="col-12 input-group">
                <label for="imgFile" class="input-group-text">Choose Image File</label>
                <input type="file" class="form-control" id="file" name="file" accept=".png,.jpg,.jpeg" required/>
                <button type="reset" class="btn btn-danger input-group-text"><i class="fas fa-trash" ></i></button>
            </div>
            <button type="submit" class="btn btn-success d-flex mx-auto mt-3 text-center">Convert</button>
        </form>
    </div>
</body>
</html>
