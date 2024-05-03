<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <title>Ввод слов</title>
</head>
<body>
<br> <br> <br><br><br> <br> <br> <br>
<div class="container">
    <h2>Определение сообщений с максимальным и минимальным числом гласных (введите 5 сообщений)</h2>
    <form action="http://localhost:8080/LR4-1.0-SNAPSHOT/messages" method="post">
        <div class="mb-3">
            <label for="message" class="form-label">Сообщение:</label>
            <input type="text" id="message" name="message" required class="form-control" MAXLENGTH="30ч">
            <button type="submit" class="btn btn-primary md-3" >Отправить</button>
        </div>

    </form>
</div>
</body>
</html>
