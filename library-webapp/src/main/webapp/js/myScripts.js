$('.createOrEditBook').val($.trim($(".createOrEditBook").val()))

window.onload = function () {
    var pageSelected = getParameter("page");
    var d = document.getElementById("page_"+pageSelected);
    d.className += " active";
}

function showAlert() {
    document.getElementById("mainTableAlert").setAttribute("style", "display: block;")
}

function getNotificationPermission() {
    if (!("Notification" in window)) {
        alert('Ваш браузер не поддерживает HTML Notifications, его необходимо обновить.');
    } else if (Notification.permission !== "granted") {
        Notification.requestPermission(function (permission) {
            if (permission !== "granted") {
                alert('Вы запретили показывать уведомления');
                return false;
            } else {
                return true;
            }
        });
    }
}

function spawnNotification(title) {
    var n = new Notification(title);
    setTimeout(n.close.bind(n), 4000);
}

function sendNotification(title) {
    if (Notification.permission === "granted") {
        spawnNotification(title);
    } else {
        var permission = getNotificationPermission();
        if (permission === true) {
            spawnNotification(title);
        }
    }
}

function paginationMoveLeft() {
    var pageNumber = parseInt(window.location.href.charAt(window.location.href.length - 1));
    var ctx = window.location.href.substring(0, window.location.href.length - 1);
    if (pageNumber > 1) {
        pageNumber = pageNumber - 1;
        window.location.href = ctx + (pageNumber);
    }
}

function paginationMoveRight(max) {
    var pageNumber = parseInt(window.location.href.charAt(window.location.href.length - 1));
    var ctx = window.location.href.substring(0, window.location.href.length - 1);
    if (pageNumber < max) {
        pageNumber = pageNumber + 1;
        window.location.href = ctx + (pageNumber);
    }
}

function getParameter(name){
    if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
        return decodeURIComponent(name[1]);
}



/*function makeActive(elemId){
   var d = document.getElementById(elemId);
   d.className += " active";
}*/
